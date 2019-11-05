package stud.task.table.required;

import org.apache.log4j.Logger;
import stud.task.exception.TTFTableFormatException;
import stud.task.exception.StreamOutOfFileException;
import stud.task.table.domain.HeadTable;
import stud.task.table.MainTable;
import stud.task.types.Int16;
import stud.task.types.Tag;
import stud.task.types.UInt16;
import stud.task.util.TTFInputStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.apache.log4j.Level.ERROR;

public class HMtx extends MainTable {

    private static final Logger LOGGER = Logger.getLogger(HMtx.class);
    public static final Tag TAG = new Tag(0x686D7478);

    private LongHorMetric[] longHorMetric;
    private Int16[] leftSideBearings;

    public HMtx(HeadTable headTable, HHea hhea, MaxP maxp) {
        super(headTable);
        int numberOfHMetrics = hhea.getNumberOfHMetrics().unsigned();
        int numGlyphs = maxp.getNumGlyphs().unsigned();
        longHorMetric = new LongHorMetric[numberOfHMetrics];
        leftSideBearings = new Int16[numGlyphs - numberOfHMetrics];
    }

    @Override
    public void read(TTFInputStream in) throws TTFTableFormatException, IOException {
        try {
            long start = in.available();
            for (int i = 0; i < longHorMetric.length; i++) {
                longHorMetric[i] = new LongHorMetric(in.readUInt16(), in.readInt16());
            }
            in.readInt16(leftSideBearings);
            checkSize(start - in.available());
        } catch (StreamOutOfFileException e) {
            LOGGER.log(ERROR, e);
        }
    }

    public LongHorMetric[] getLongHorMetric() {
        return longHorMetric;
    }

    public Int16[] getLeftSideBearings() {
        return leftSideBearings;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", HMtx.class.getSimpleName() + "[", "]")
                .add("longHorMetric=" + Arrays.toString(longHorMetric))
                .add("leftSideBearings=" + Arrays.toString(leftSideBearings))
                .toString();
    }

    public class LongHorMetric {
        private UInt16 advanceWidth;
        private Int16 lsb;

        public LongHorMetric(UInt16 advanceWidth, Int16 lsb) {
            this.advanceWidth = advanceWidth;
            this.lsb = lsb;
        }

        public UInt16 getAdvanceWidth() {
            return advanceWidth;
        }

        public Int16 getLsb() {
            return lsb;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", LongHorMetric.class.getSimpleName() + "[", "]")
                    .add("advanceWidth=" + advanceWidth)
                    .add("lsb=" + lsb)
                    .toString();
        }
    }
}
