package stud.task.encoding;

import javafx.util.Pair;
import stud.task.table.subtable.cmap.SegMap;
import stud.task.types.Int16;
import stud.task.types.UInt16;

import java.util.*;

public class EncodingFormat4 implements Encoding {

    private UInt16 format = new UInt16((short) 0x4);
    private Segment[] segments;
    private Int16[] idDelta;
    private UInt16[] glyphArray;
    private HashMap<Integer, Integer> rangeOffset;

    public EncodingFormat4(SegMap segMap) {
        int countSeg = segMap.getSegCount();
        segments = new Segment[countSeg];
        UInt16[] start =  segMap.getStartCode();
        UInt16[] end = segMap.getEndCode();
        glyphArray = segMap.getGlyphIdArray();
        for (int i = 0; i < segments.length; i++) {
            segments[i] = new Segment(start[i], end[i]);
        }
        idDelta = segMap.getIdDelta();
        UInt16[] idRangeOffset = segMap.getIdRangeOffset();
        List<Pair<Integer, Integer>> indexValueList = new ArrayList<>();
        for (int i = 0; i < idRangeOffset.length; i++) {
            if (idRangeOffset[i].unsigned() != 0) {
                indexValueList.add(new Pair<>(i, idRangeOffset[i].unsigned()));
            }
        }
        indexValueList.sort(Comparator.comparingInt(Pair::getValue));
        rangeOffset = new HashMap<>();
        int startGlyphArray = 0;
        for (Pair<Integer, Integer> p :
                indexValueList) {
            int size = segments[p.getKey()].size();
            rangeOffset.put(p.getKey(), startGlyphArray);
            startGlyphArray += size;
        }
        System.out.println(Arrays.toString(segments));
        System.out.println(Arrays.toString(idDelta));
    }

    @Override
    public int convertToIndexGlyph(UInt16 value) {
        int index = 0;
        for (int i = 0; i < segments.length; i++) {
            int comp = segments[i].isInside(value.unsigned());
            if (comp < -1) return 0;
            if (comp == 0) {
                index = i;
                break;
            }
        }
        Integer temp;
        if ((temp = rangeOffset.get(index)) == null) {
            return (value.unsigned() + idDelta[index].shortValue()) % UInt16.MAX_VALUE;
        } else {
            return glyphArray[
                    value.unsigned() - segments[index].start + temp
                    ].unsigned() + idDelta[index].intValue();
        }
    }

    @Override
    public UInt16 getFormat() {
        return format;
    }

    private class Segment implements Comparable<Segment> {
        private final int start;
        private final int end;

        public Segment(Number start, Number end) {
            this.start = start.intValue();
            this.end = end.intValue();
        }

        public int isInside(int position) {
            int temp = position - start;
            if (temp <= 0){
                return temp;
            } else {
                temp = position - end;
                if (temp <= 0) return 0;
                else return temp;
            }
        }

        public int size() {
            return end - start + 1;
        }

        @Override
        public int compareTo(Segment o) {
            return end - o.end;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Segment.class.getSimpleName() + "[", "]")
                    .add("start=" + start)
                    .add("end=" + end)
                    .toString();
        }
    }
}
