package stud.task.domain;

import stud.task.types.UInt16;
import stud.task.types.UInt32;

public class TTFHead {
    private UInt32 version;
    private UInt16 countTable;
    private UInt16 rangeSearch;
    private UInt16 enterSelect;
    private UInt16 shiftRange;

    public TTFHead(UInt32 version, UInt16 countTable, UInt16 rangeSearch, UInt16 enterSelect, UInt16 shiftRange) {
        this.version = version;
        this.countTable = countTable;
        this.rangeSearch = rangeSearch;
        this.enterSelect = enterSelect;
        this.shiftRange = shiftRange;
    }

    public TTFHead() {
    }

    public UInt32 getVersion() {
        return version;
    }

    public void setVersion(UInt32 version) {
        this.version = version;
    }

    public UInt16 getCountTable() {
        return countTable;
    }

    public void setCountTable(UInt16 countTable) {
        this.countTable = countTable;
    }

    public UInt16 getRangeSearch() {
        return rangeSearch;
    }

    public void setRangeSearch(UInt16 rangeSearch) {
        this.rangeSearch = rangeSearch;
    }

    public UInt16 getEnterSelect() {
        return enterSelect;
    }

    public void setEnterSelect(UInt16 enterSelect) {
        this.enterSelect = enterSelect;
    }

    public UInt16 getShiftRange() {
        return shiftRange;
    }

    public void setShiftRange(UInt16 shiftRange) {
        this.shiftRange = shiftRange;
    }

    @Override
    public String toString() {
        return "TTFHead{" +
                "version=" + version +
                ", countTable=" + countTable +
                ", rangeSearch=" + rangeSearch +
                ", enterSelect=" + enterSelect +
                ", shiftRange=" + shiftRange +
                '}';
    }
}
