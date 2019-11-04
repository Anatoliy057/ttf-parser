package stud.task.table.required;

import org.apache.log4j.Logger;
import stud.task.exception.FormatTableException;
import stud.task.exception.StreamOutOfFileException;
import stud.task.exception.TTFTableMismatchSizeException;
import stud.task.table.MainTable;
import stud.task.table.domain.HeadTable;
import stud.task.types.Int16;
import stud.task.types.Tag;
import stud.task.types.UInt16;
import stud.task.util.TTFInputStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.function.Function;

import static org.apache.log4j.Level.ERROR;

public class Loca extends MainTable {

    private static final Logger LOGGER = Logger.getLogger(Loca.class);
    public static final Tag TAG = new Tag(0x6C6F6361);

    private Int16 indexToLocFormat;
    private UInt16 numGlyphs;

    private Number[] offsets;

    private Function<Integer, Long> getOffset;

    public Loca(HeadTable headTable, Int16 indexToLocFormat, UInt16 numGlyphs) {
        super(headTable);
        this.indexToLocFormat = indexToLocFormat;
        this.numGlyphs = numGlyphs;
        offsets = new Number[numGlyphs.unsigned()+1];
    }

    @Override
    public void read(TTFInputStream in) throws IOException, TTFTableMismatchSizeException, FormatTableException {
        try {
            short version = indexToLocFormat.shortValue();
            long start = in.available();
            if (version == 0) {
                getOffset = integer -> offsets[integer].longValue() * 2;
                for (int i = 0; i < offsets.length; i++) {
                    offsets[i] = in.readOffSet16();
                }
            } else if (version == 1) {
                getOffset = integer -> offsets[integer].longValue();
                for (int i = 0; i < offsets.length; i++) {
                    offsets[i] = in.readOffSet32();
                }
            } else {
                throw new FormatTableException(String.format("Format loca: actually: %d, expect: 1 || 0", version));
            }
            long size = start - in.available();
            checkSize(size);
        } catch (StreamOutOfFileException e) {
            LOGGER.log(ERROR, e);
        }
    }

    public Number getOffset(int index) {
        return getOffset.apply(index);
    }
}
