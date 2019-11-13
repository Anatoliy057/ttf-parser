package stud.task.table;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stud.task.service.ResLoader;
import stud.task.util.TTFInputStream;
import stud.task.util.TTFReader;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class TTFHeadTest {

    private TTFInputStream in;

    @BeforeEach
    void setUp() {
        assertDoesNotThrow( () -> {
            File ttf = ResLoader.getInstance().getFile("wendy.ttf");
            in = new TTFReader(ttf);
        });
    }

    @Test
    void expectDoesNotThrowOnInit() {
        assertDoesNotThrow(() -> {
            long start = in.available();
            TTFHead ttfHead = new TTFHead();
            ttfHead.read(in);
            assertEquals(start, in.available());
        });
    }
}