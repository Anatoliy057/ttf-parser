package stud.task.model;

import stud.task.encoding.Encoding;

public class Font {
    private Encoding encoding;
    private Glyph[] glyphs;

    private int maxAdvance;

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
}
