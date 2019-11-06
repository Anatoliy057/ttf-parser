package stud.task.table.other;

import org.apache.log4j.Logger;
import stud.task.util.StreamOutOfFileException;
import stud.task.table.TTFTableFormatException;
import stud.task.table.MainTable;
import stud.task.table.Table;
import stud.task.table.domain.HeadTable;
import stud.task.types.*;
import stud.task.util.TTFInputStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.apache.log4j.Level.ERROR;

public class HDMx extends MainTable {

    private static final Logger LOGGER = Logger.getLogger(HDMx.class);
    public static final Tag TAG = new Tag(0x68646D78);

    private final UInt16 numGlyphs;

    private UInt16 version;
    private Int16 numRecords;
    private Int32 sizeDeviceRecord;
    private DeviceRecord[] deviceRecords;

    public HDMx(HeadTable headTable, UInt16 numGlyphs) {
        super(headTable);
        this.numGlyphs = numGlyphs;
    }

    @Override
    public void read(TTFInputStream in) throws TTFTableFormatException, IOException {
        try {
            long start = in.available();
            version = in.readUInt16();
            numRecords = in.readInt16();
            sizeDeviceRecord = in.readInt32();
            deviceRecords = new DeviceRecord[numRecords.shortValue() < 0 ? 0 : numRecords.shortValue()];
            for (int i = 0; i < deviceRecords.length; i++) {
                deviceRecords[i] = new DeviceRecord();
                deviceRecords[i].read(in);
            }
            checkSize(start - in.available());
        } catch (StreamOutOfFileException e) {
            LOGGER.log(ERROR, e);
        }
    }

    @Override
    public Tag tag() {
        return TAG;
    }

    public UInt16 getVersion() {
        return version;
    }

    public void setVersion(UInt16 version) {
        this.version = version;
    }

    public Int16 getNumRecords() {
        return numRecords;
    }

    public void setNumRecords(Int16 numRecords) {
        this.numRecords = numRecords;
    }

    public Int32 getSizeDeviceRecord() {
        return sizeDeviceRecord;
    }

    public void setSizeDeviceRecord(Int32 sizeDeviceRecord) {
        this.sizeDeviceRecord = sizeDeviceRecord;
    }

    public DeviceRecord[] getDeviceRecords() {
        return deviceRecords;
    }

    public void setDeviceRecords(DeviceRecord[] deviceRecords) {
        this.deviceRecords = deviceRecords;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", HDMx.class.getSimpleName() + "[", "]")
                .add("numGlyphs=" + numGlyphs)
                .add("version=" + version)
                .add("numRecords=" + numRecords)
                .add("sizeDeviceRecord=" + sizeDeviceRecord)
                .add("deviceRecords=" + Arrays.toString(deviceRecords))
                .toString();
    }

    public class DeviceRecord implements Table {

        private UInt8 pixelSize;
        private UInt8 maxWidth;
        private UInt8[] widths = new UInt8[numGlyphs.unsigned()];

        public void read(TTFInputStream in) {
            try {
                pixelSize = in.readUInt8();
                maxWidth = in.readUInt8();
                for (int i = 0; i < widths.length; i++) {
                    widths[i] = in.readUInt8();
                }
            } catch (StreamOutOfFileException | IOException e) {
               LOGGER.log(ERROR, e);
            }
        }

        public UInt8 getPixelSize() {
            return pixelSize;
        }

        public UInt8 getMaxWidth() {
            return maxWidth;
        }

        public UInt8[] getWidths() {
            return widths;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", DeviceRecord.class.getSimpleName() + "[", "]")
                    .add("pixelSize=" + pixelSize)
                    .add("maxWidth=" + maxWidth)
                    .add("widths=" + Arrays.toString(widths))
                    .toString();
        }
    }
}
