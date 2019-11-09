package stud.task.model;

import stud.task.encoding.Encoding;
import stud.task.types.UInt16;

import java.util.*;

public class Font {
    private final Encoding encoding;
    private final Glyph[] glyphs;
    private final Glyph empty;
    private final Glyph unsupported;

    private final int xMin, yMin, xMax, yMax;

    public Font(FontInfo fi) {
        encoding = fi.getEncoding();
        glyphs = Arrays.copyOf(fi.getGlyphs(), fi.getGlyphs().length);
        empty = new Glyph(0, 0, fi.getMaxAdvance(), 0, 0, fi.getMaxAdvance(), new LinkedList<>());
        unsupported = empty;
        xMin = fi.getxMin();
        yMin = fi.getyMin();
        xMax = fi.getxMax();
        yMax = fi.getyMax();
    }

    public int getxMin() {
        return xMin;
    }

    public int getyMin() {
        return yMin;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public Glyph getEmpty() {
        return empty;
    }

    public Glyph getUnsupported() {
        return unsupported;
    }

    public Glyph getGlyph(char a) {
        int index = encoding.convertToIndexGlyph(toUInt16(a));
        return atGlyph(index);
    }

    public List<Glyph> getGlyphs(char[] arr) {
        int[] indexes = encoding.convertToArrIndexGlyphs(toArrUInt16(arr));
        List<Glyph> glyphs = new ArrayList<>(arr.length);
        for (int index :
                indexes) {
            glyphs.add(atGlyph(index));
        }
        return glyphs;
    }

    public List<Glyph> getGlyphs(String text) {
        return getGlyphs(text.toCharArray());
    }

    private Glyph atGlyph(int index) {
        if (index < 0)
            return unsupported;
        return glyphs[index] == null ? empty : glyphs[index];
    }

    private UInt16 toUInt16(char a) {
        return new UInt16(a);
    }

    private UInt16[] toArrUInt16(char[] arr) {
        UInt16[] uInt16s = new UInt16[arr.length];
        for (int i = 0; i < arr.length; i++) {
            uInt16s[i] = toUInt16(arr[i]);
        }
        return uInt16s;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Font.class.getSimpleName() + "[", "]")
                .add("encoding=" + encoding)
                .add("glyphs=" + Arrays.toString(glyphs))
                .add("empty=" + empty)
                .add("unsupported=" + unsupported)
                .add("xMin=" + xMin)
                .add("yMin=" + yMin)
                .add("xMax=" + xMax)
                .add("yMax=" + yMax)
                .toString();
    }
}
