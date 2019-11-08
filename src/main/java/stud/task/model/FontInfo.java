package stud.task.model;

import stud.task.encoding.Encoding;

import java.util.Arrays;
import java.util.StringJoiner;

public class FontInfo {
    private Encoding encoding;
    private Glyph[] glyphs;
    private int maxAdvance;
    private int xMin, yMin, xMax, yMax;

    public Encoding getEncoding() {
        return encoding;
    }

    public void setEncoding(Encoding encoding) {
        this.encoding = encoding;
    }

    public Glyph[] getGlyphs() {
        return glyphs;
    }

    public void setGlyphs(Glyph[] glyphs) {
        this.glyphs = glyphs;
    }

    public int getMaxAdvance() {
        return maxAdvance;
    }

    public void setMaxAdvance(int maxAdvance) {
        this.maxAdvance = maxAdvance;
    }

    public int getxMin() {
        return xMin;
    }

    public void setxMin(int xMin) {
        this.xMin = xMin;
    }

    public int getyMin() {
        return yMin;
    }

    public void setyMin(int yMin) {
        this.yMin = yMin;
    }

    public int getxMax() {
        return xMax;
    }

    public void setxMax(int xMax) {
        this.xMax = xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public void setyMax(int yMax) {
        this.yMax = yMax;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FontInfo.class.getSimpleName() + "[", "]")
                .add("encoding=" + encoding)
                .add("glyphs=" + Arrays.toString(glyphs))
                .add("maxAdvance=" + maxAdvance)
                .toString();
    }
}
