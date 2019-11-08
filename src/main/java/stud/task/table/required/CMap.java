package stud.task.table.required;

import org.apache.log4j.Logger;
import stud.task.encoding.Encoding;
import stud.task.table.*;
import stud.task.util.StreamOutOfFileException;
import stud.task.model.FontInfo;
import stud.task.table.domain.HeadTable;
import stud.task.table.subtable.cmap.SegMap;
import stud.task.types.*;
import stud.task.util.TTFInputStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.apache.log4j.Level.ERROR;

@TTFTable(TypeTTFTable.CMAP)
public class CMap extends MainTable implements SetUpTable {

    private static final Logger LOGGER = Logger.getLogger(CMap.class);
    public static final Tag TAG = new Tag(0x636D6170);
    private static final int PRIORITY = 0;

    private UInt16 version;
    private UInt16 numTables;
    private EncodingRecord[] encodingRecords;

    private Encoding encoding;

    public CMap(HeadTable headTable) {
        super(headTable);
    }

    @Override
    public void read(TTFInputStream in) throws IOException, TTFTableFormatException {
        try {
            long start = in.available();
            version = in.readUInt16();
            numTables = in.readUInt16();
            encodingRecords = new EncodingRecord[numTables.unsigned()];
            for (int i = 0; i < encodingRecords.length; i++) {
                encodingRecords[i] = new EncodingRecord(
                        in.readUInt16(),
                        in.readUInt16(),
                        in.readOffSet32()
                );
            }
            long diff = start - in.available();
            Arrays.sort(encodingRecords);
            for (int i = 0; i < encodingRecords.length; i++) {
                if (encodingRecords[i].platformID.unsigned() == 3 &&
                        encodingRecords[i].encodingID.unsigned() == 1) {
                    in.skip(encodingRecords[i].offset.unsigned() - diff);
                    SegMap segMap = new SegMap(encodingRecords[i]);
                    segMap.read(in);
                    encoding = segMap.getEncoding();
                }
            }
        } catch (StreamOutOfFileException e) {
            LOGGER.log(ERROR, e);
        }
    }

    public Encoding getEncoding() {
        return encoding;
    }

    @Override
    public int priority() {
        return PRIORITY;
    }

    @Override
    public void setUp(FontInfo fontInfo) {
        fontInfo.setEncoding(encoding);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CMap.class.getSimpleName() + "[", "]")
                .add("version=" + version)
                .add("numTables=" + numTables)
                .add("encodingRecords=" + Arrays.toString(encodingRecords))
                .add("encoding=" + encoding)
                .toString();
    }

    public class EncodingRecord implements Comparable<EncodingRecord> {
        private UInt16 platformID;
        private UInt16 encodingID;
        private OffSet32 offset;

        public EncodingRecord(UInt16 platformID, UInt16 encodingID, OffSet32 offset) {
            this.platformID = platformID;
            this.encodingID = encodingID;
            this.offset = offset;
        }

        @Override
        public int compareTo(EncodingRecord o) {
            return offset.compareTo(o.offset);
        }

        public UInt16 getPlatformID() {
            return platformID;
        }

        public UInt16 getEncodingID() {
            return encodingID;
        }

        public OffSet32 getOffset() {
            return offset;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", EncodingRecord.class.getSimpleName() + "[", "]")
                    .add("platformID=" + platformID)
                    .add("encodingID=" + encodingID)
                    .add("offset=" + offset)
                    .toString();
        }
    }
}
