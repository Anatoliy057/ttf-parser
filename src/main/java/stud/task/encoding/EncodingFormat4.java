package stud.task.encoding;

import javafx.util.Pair;
import stud.task.table.subtable.cmap.SegMap;
import stud.task.types.Int16;
import stud.task.types.UInt16;

import java.util.*;

public class EncodingFormat4 implements Encoding {

    private UInt16 format = new UInt16((short) 0x4);
    private Map<Character, Integer> charToIndex;

    public EncodingFormat4(SegMap segMap) {
        Segment[] segments;
        Int16[] idDelta;
        UInt16[] glyphArray;
        Map<Integer, Integer> rangeOffset;

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
        charToIndex = new HashMap<>();

        int iSeg = 0;
        boolean last = false;
        for (int i = 0; i < Character.MAX_VALUE; i++) {
            if (segments[iSeg].isInside(i)) {
                last = true;
                charToIndex.put((char) i, calcIndex(i, iSeg, rangeOffset, segments, idDelta, glyphArray));
            } else if (last) {
                iSeg++;
                last = false;
                i--;
            }
        }
    }

    private int calcIndex(int i, int iSeg, Map<Integer, Integer> offset, Segment[] segments, Int16[] idDelta, UInt16[] glyphArray) {
        Integer temp;
        if ((temp = offset.get(iSeg)) == null) {
            return (i + idDelta[iSeg].shortValue()) % UInt16.MAX_VALUE ;
        } else {
            return glyphArray[
                    i - segments[iSeg].start + temp
                    ].unsigned() + idDelta[iSeg].intValue();
        }
    }

    @Override
    public int convertToIndexGlyph(UInt16 value) {
        Integer temp = charToIndex.get((char) value.unsigned());
        return temp == null ? -1 : temp;
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

        public boolean isInside(int position) {
            int temp = position - start;
            if (temp < 0){
                return false;
            } else {
                temp = position - end;
                if (temp <= 0) return true;
                else return false;
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
