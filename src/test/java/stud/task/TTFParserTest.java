package stud.task;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stud.task.service.ResLoader;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class TTFParserTest {

    private File ttfFile;

    @BeforeEach
    void setUp() {
        ttfFile = ResLoader.getInstance().getFile("wendy.ttf");
    }

    @Test
    void expectSuccessCreate() {
        assertDoesNotThrow(() -> {
            new TTFParser(ttfFile);
        });
    }

}