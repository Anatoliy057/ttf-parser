package stud.task.table.required;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stud.task.TTFParser;
import stud.task.service.ResLoader;
import stud.task.table.TTFHead;
import stud.task.table.domain.HeadTable;
import stud.task.util.TTFInputStream;
import stud.task.util.TTFReader;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class LocaTest {

    private TTFInputStream in;
    private TTFHead ttfHead;
    private MaxP maxp;
    private Head head;

    @BeforeEach
    void setUp() {
        assertDoesNotThrow( () -> {
            File ttf = ResLoader.getInstance().getFile("wendy.ttf");
            TTFParser parser = new TTFParser(ttf);
            maxp = (MaxP) parser.getTable(MaxP.TAG);
            head = (Head) parser.getTable(Head.TAG);
            in = new TTFReader(ttf);
            ttfHead = new TTFHead();
            ttfHead.read(in);
        });
    }

    @Test
    void expectDoesNotThrowOnInit() {
        assertDoesNotThrow(() -> {
            HeadTable ht = ttfHead.getHeadTable(Loca.TAG);
            in.skip(ht.getOffSet().unsigned());
            Loca loca = new Loca(ht, head, maxp);
            loca.read(in);
        });
    }
}