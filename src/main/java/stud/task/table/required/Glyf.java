package stud.task.table.required;

import org.apache.log4j.Logger;
import stud.task.exception.StreamOutOfFileException;
import stud.task.exception.TTFTableFormatException;
import stud.task.model.Glyph;
import stud.task.table.MainTable;
import stud.task.table.subtable.glyf.SubTableGlyf;
import stud.task.table.domain.HeadTable;
import stud.task.table.subtable.glyf.SimpleGlyf;
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
                SubTableGlyf sbt = new SimpleGlyf(sizeGlyph, numberOfContours);
                sbt.read(in);
                glyphs[i] = sbt.getGlyph();
            }
            checkSize(start - in.available());
        } catch (StreamOutOfFileException e) {
            LOGGER.log(ERROR, e);
        }
    }

    public Glyph[] getGlyphs() {
        return glyphs;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Glyf.class.getSimpleName() + "[", "]")
                .add("glyphs=" + Arrays.toString(glyphs))
                .toString();
    }
}
