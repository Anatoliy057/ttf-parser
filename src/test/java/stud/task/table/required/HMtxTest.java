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

class HMtxTest {

    private TTFInputStream in;
    private TTFHead ttfHead;
    private MaxP maxp;
    private HHea hhea;

    @BeforeEach
    void setUp() {
        assertDoesNotThrow( () -> {
            File ttf = ResLoader.getInstance().getFile("wendy.ttf");
            TTFParser parser = new TTFParser(ttf);
            maxp = (MaxP) parser.getTable(MaxP.TAG);
            hhea = (HHea) parser.getTable(HHea.TAG);
            in = new TTFReader(ttf);
            ttfHead = new TTFHead();
            ttfHead.read(in);
        });
    }

    @Test
    void expectDoesNotThrowOnInit() {
        assertDoesNotThrow(() -> {
            HeadTable ht = ttfHead.getHeadTable(HMtx.TAG);
            in.skip(ht.getOffSet().unsigned());
            HMtx hmtx = new HMtx(ht, hhea, maxp);
            hmtx.read(in);
        });
    }
}