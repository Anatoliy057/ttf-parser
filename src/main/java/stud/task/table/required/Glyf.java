package stud.task.table.required;

import org.apache.log4j.Logger;
import stud.task.exception.StreamOutOfFileException;
import stud.task.exception.TTFTableFormatException;
import stud.task.table.MainTable;
import stud.task.table.domain.Glyph;
import stud.task.table.domain.HeadTable;
import stud.task.table.domain.SimpleGlyph;
import stud.task.types.Int16;
import stud.task.types.Tag;
import stud.task.util.TTFInputStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.apache.log4j.Level.ERROR;

public class Glyf extends MainTable {

    private static final Logger LOGGER = Logger.getLogger(Glyf.class);
    public static final Tag TAG = new Tag(0x676C7966);

    private Loca loca;
    private Glyph[] glyphs;

    public Glyf(HeadTable headTable, Loca loca) {
        super(headTable);
        this.loca = loca;
        glyphs = new Glyph[loca.getNumGlyphs().unsigned()];
    }

    @Override
    public void read(TTFInputStream in) throws IOException, TTFTableFormatException {
        try {
            long start = in.available();
            for (int i = 0; i < glyphs.length; i++) {
                long sizeGlyph = loca.getOffset(i+1).longValue() - loca.getOffset(i).longValue();
                if (sizeGlyph == 0) continue;
                Int16 numberOfContours = in.readInt16();
                if (numberOfContours.shortValue() < 0) {
                    in.skip(length-2);
                    continue;
                }
                glyphs[i] = new SimpleGlyph(sizeGlyph, numberOfContours);
                glyphs[i].read(in);
            }
            checkSize(start - in.available());
        } catch (StreamOutOfFileException e) {
            LOGGER.log(ERROR, e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(Glyf.class.getSimpleName());
        sb.append("[glyphs=[\n");
        for (int i = 0; i < glyphs.length-1; i++) {
            sb.append('\t');
            sb.append(glyphs[i]);
            sb.append(",\n");
        }
        sb.append('\t');
        sb.append(glyphs[glyphs.length-1]);
        sb.append('\n');
        sb.append("]]");
        return sb.toString();
    }
}
