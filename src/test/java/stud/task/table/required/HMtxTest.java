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

class HMtxTest {

    private TTFInputStream in;
    private TTFHead ttfHead;
    private MaxP maxp;
    private HHea hhea;

    @BeforeEach
    void setUp() {
        assertDoesNotThrow( () -> {
            File ttf = ResLoader.getInstance().getFile("wendy.ttf");
            in = new TTFReader(ttf);
            in.mark(100000);
            ttfHead = new TTFHead();
            ttfHead.read(in);
            in.reset();

            HeadTable ht = ttfHead.getHeadTable(MaxP.TAG);
            in.mark((int) ht.getSize().unsigned());
            in.skip(ht.getOffSet().unsigned());
            maxp = new MaxP(ht);
            maxp.read(in);
            in.reset();

            ht = ttfHead.getHeadTable(HHea.TAG);
            in.mark((int) ht.getSize().unsigned());
            in.skip(ht.getOffSet().unsigned());
            hhea = new HHea(ht);
            hhea.read(in);
            in.reset();
        });
    }

    @Test
    void expectDoesNotThrowOnInit() {
        assertDoesNotThrow(() -> {
            HeadTable ht = ttfHead.getHeadTable(HMtx.TAG);
            in.skip(ht.getOffSet().unsigned());
            HMtx hmtx = new HMtx(ht, hhea, maxp);
            hmtx.read(in);
            System.out.println(hmtx);
        });
    }
}