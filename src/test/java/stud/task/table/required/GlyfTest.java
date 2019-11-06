package stud.task.table.required;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stud.task.model.Glyph;
import stud.task.service.ResLoader;
import stud.task.table.TTFHead;
import stud.task.table.domain.HeadTable;
import stud.task.util.TTFInputStream;
import stud.task.util.TTFReader;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class GlyfTest {

    private TTFInputStream in;
    private TTFHead ttfHead;
    private Loca loca;

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
            MaxP maxp = new MaxP(ht);
            maxp.read(in);
            in.reset();

            ht = ttfHead.getHeadTable(Head.TAG);
            in.mark((int) ht.getSize().unsigned());
            in.skip(ht.getOffSet().unsigned());
            Head head = new Head(ht);
            head.read(in);
            in.reset();

            ht = ttfHead.getHeadTable(Loca.TAG);
            in.mark((int) ht.getSize().unsigned());
            in.skip(ht.getOffSet().unsigned());
            loca = new Loca(ht, head, maxp);
            loca.read(in);
            in.reset();
        });
    }

    @Test
    void expectDoesNotThrowOnInit() {
        assertDoesNotThrow(() -> {
            HeadTable ht = ttfHead.getHeadTable(Glyf.TAG);
            in.skip(ht.getOffSet().unsigned());
            Glyf glyf = new Glyf(ht, loca);
            glyf.read(in);
        });
    }

}