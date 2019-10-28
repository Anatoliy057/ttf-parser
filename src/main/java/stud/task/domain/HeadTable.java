package stud.task.domain;

import stud.task.types.OffSet32;
import stud.task.types.Tag;
import stud.task.types.UInt32;

import java.util.Objects;

public class HeadTable {
    private Tag id;
    private UInt32 checkSum;
    private OffSet32 offSet;
    private UInt32 size;

    public HeadTable(Tag id, UInt32 checkSum, OffSet32 offSet, UInt32 size) {
        this.id = id;
        this.checkSum = checkSum;
        this.offSet = offSet;
        this.size = size;
    }

    public HeadTable() {}

    public Tag getId() {
        return id;
    }

    public void setId(Tag id) {
        this.id = id;
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
        return Objects.equals(id, headTable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "HeadTable{" +
                "id=" + id +
                ", checkSum=" + checkSum +
                ", offSet=" + offSet +
                ", size=" + size +
                '}';
    }
}
