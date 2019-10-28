package stud.task;

import stud.task.domain.HeadTable;
import stud.task.domain.TTFHead;
import stud.task.types.Tag;
import stud.task.util.StreamOutOfFileException;
import stud.task.util.TTFReader;

import java.io.*;
import java.util.HashMap;

public class TTFParser {

    private final int sizeHead = 12;
    private final int sizeHeadTable = 16;

    private TTFReader io;

    private TTFHead head;
    private HashMap<Tag, HeadTable> tables;

    public TTFParser(File file) throws IOException {
        io = new TTFReader(new BufferedInputStream(
                new FileInputStream(file)
        ));
        readHead();
        readHeadTable();
        System.out.println(tables);
    }

    private void readHead() {
        try {
            io.mark(sizeHead);
            head = new TTFHead();
            head.setVersion(io.readUInt32());
            head.setCountTable(io.readUInt16());
            head.setRangeSearch(io.readUInt16());
            head.setEnterSelect(io.readUInt16());
            head.setShiftRange(io.readUInt16());
            io.reset();
        } catch (StreamOutOfFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readHeadTable() {
        try {
            tables = new HashMap<>();
            int countTable = head.getCountTable().unsigned();
            io.mark(head.getCountTable().unsigned() * sizeHeadTable);
            io.skip(sizeHead);
            for (int i = 0; i < countTable; i++) {
                HeadTable ht = new HeadTable();
                ht.setId(io.readTag());
                ht.setCheckSum(io.readUInt32());
                ht.setOffSet(io.readOffSet32());
                ht.setSize(io.readUInt32());
                tables.put(ht.getId(), ht);
            }
            io.reset();
        } catch (StreamOutOfFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
