package stud.task.table;

import org.apache.log4j.Logger;
import stud.task.util.StreamOutOfFileException;
import stud.task.table.domain.HeadTable;
import stud.task.types.Tag;
import stud.task.types.UInt16;
import stud.task.types.UInt32;
import stud.task.util.TTFInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import static org.apache.log4j.Level.ERROR;

public class TTFHead implements Table {

    private static final Logger LOGGER = Logger.getLogger(TTFHead.class);
    private final int SIZE_HEAD_TTF = 12;
    private final int SIZE_HEAD_TABLE = 16;

    private UInt32 version;
    private UInt16 countTable;
    private UInt16 rangeSearch;
    private UInt16 enterSelect;
    private UInt16 shiftRange;
    private Map<Tag, HeadTable> map;

    public void read(TTFInputStream in) throws IOException, TTFTableFormatException {
        try {
            long start = in.available();
            version = in.readUInt32();
            countTable = in.readUInt16();
            rangeSearch = in.readUInt16();
            enterSelect = in.readUInt16();
            shiftRange = in.readUInt16();
            map = new HashMap<>();
            for (int i = 0; i < countTable.unsigned(); i++) {
                HeadTable ht = new HeadTable(
                        in.readTag(),
                        in.readUInt32(),
                        in.readOffSet32(),
                        in.readUInt32()
                );
                map.put(ht.getTag(), ht);
            }
            long actuallySize = start - in.available();
            long expectSize =  SIZE_HEAD_TABLE*countTable.unsigned() + SIZE_HEAD_TTF;
            if (actuallySize != expectSize)
                throw new TTFTableFormatException(String.format("%s size does not match expected", getClass().getSimpleName()), actuallySize, expectSize);
        } catch (StreamOutOfFileException e) {
            LOGGER.log(ERROR, e);
        }
    }

    public UInt32 getVersion() {
        return version;
    }

    public UInt16 getCountTable() {
        return countTable;
    }

    public UInt16 getRangeSearch() {
        return rangeSearch;
    }

    public UInt16 getEnterSelect() {
        return enterSelect;
    }

    public UInt16 getShiftRange() {
        return shiftRange;
    }

    public HeadTable getHeadTable(Tag tag) {
        return map.get(tag);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TTFHead.class.getSimpleName() + "[", "]")
                .add("version=" + version)
                .add("countTable=" + countTable)
                .add("rangeSearch=" + rangeSearch)
                .add("enterSelect=" + enterSelect)
                .add("shiftRange=" + shiftRange)
                .add("map=" + map)
                .toString();
    }
}
