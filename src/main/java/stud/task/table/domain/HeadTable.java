package stud.task.table.domain;

import stud.task.types.OffSet32;
import stud.task.types.Tag;
import stud.task.types.UInt32;

import java.util.Objects;

public class HeadTable {
    private Tag tag;
    private UInt32 checkSum;
    private OffSet32 offSet;
    private UInt32 size;

    public HeadTable(Tag tag, UInt32 checkSum, OffSet32 offSet, UInt32 size) {
        this.tag = tag;
        this.checkSum = checkSum;
        this.offSet = offSet;
        this.size = size;
    }

    public HeadTable() {}

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public UInt32 getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(UInt32 checkSum) {
        this.checkSum = checkSum;
    }

    public OffSet32 getOffSet() {
        return offSet;
    }

    public void setOffSet(OffSet32 offSet) {
        this.offSet = offSet;
    }

    public UInt32 getSize() {
        return size;
    }

    public void setSize(UInt32 size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeadTable headTable = (HeadTable) o;
        return Objects.equals(tag, headTable.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag);
    }

    @Override
    public String toString() {
        return "HeadTable{" +
                "tag=" + tag +
                ", checkSum=" + checkSum +
                ", offSet=" + offSet +
                ", size=" + size +
                '}';
    }
}
