package stud.task.table.required;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stud.task.service.ResLoader;
import stud.task.table.TTFHead;
import stud.task.table.domain.HeadTable;
import stud.task.util.TTFInputStream;
import stud.task.util.TTFReader;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class MaxPTest {

    private TTFInputStream in;
    private TTFHead ttfHead;

    @BeforeEach
    void setUp() {
        assertDoesNotThrow( () -> {
            File ttf = ResLoader.getInstance().getFile("wendy.ttf");
            in = new TTFReader(ttf);
            ttfHead = new TTFHead();
            ttfHead.read(in);
        });
    }

    @Test
    void expectDoesNotThrowOnInit() {
        assertDoesNotThrow(() -> {
            HeadTable ht = ttfHead.getHeadTable(MaxP.TAG);
            in.skip(ht.getOffSet().unsigned());
            MaxP maxP = new MaxP(ht);
            maxP.read(in);
        });
    }
}