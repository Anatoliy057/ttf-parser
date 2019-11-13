package stud.task.table.required;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stud.task.TTFParser;
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
            TTFParser parser = new TTFParser(ttf);
            loca = (Loca) parser.getTable(Loca.TAG);
            in = new TTFReader(ttf);
            ttfHead = new TTFHead();
            ttfHead.read(in);
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