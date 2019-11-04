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

class CMapTest {

    private TTFInputStream in;
    private TTFHead ttfHead;

    @BeforeEach
    void setUp() {
        assertDoesNotThrow( () -> {
            File ttf = ResLoader.getInstance().getFile("wendy.ttf");
            in = new TTFReader(ttf);
            in.mark(100000);
            ttfHead = new TTFHead();
            ttfHead.read(in);
            in.reset();
        });
    }

    @Test
    void expectDoesNotThrowOnInit() {
        assertDoesNotThrow(() -> {
            HeadTable ht = ttfHead.getHeadTable(CMap.TAG);
            in.skip(ht.getOffSet().unsigned());
            CMap cmap = new CMap(ht);
            cmap.read(in);
        });
    }
}