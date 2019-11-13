package stud.task.table.required;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stud.task.encoding.Encoding;
import stud.task.service.ResLoader;
import stud.task.table.TTFHead;
import stud.task.table.domain.HeadTable;
import stud.task.types.UInt16;
import stud.task.util.TTFInputStream;
import stud.task.util.TTFReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CMapTest {

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
            HeadTable ht = ttfHead.getHeadTable(CMap.TAG);
            in.skip(ht.getOffSet().unsigned());
            CMap cmap = new CMap(ht);
            cmap.read(in);
        });
    }

    @Test
    void testEncodingFormat4_expectContinuousLine() {
        assertDoesNotThrow(() -> {
            HeadTable ht = ttfHead.getHeadTable(CMap.TAG);
            in.skip(ht.getOffSet().unsigned());
            CMap cmap = new CMap(ht);
            cmap.read(in);
            Encoding enc = cmap.getEncoding();
            List<Integer> indexList = new ArrayList<>();
            for (char c = 0; c < Character.MAX_VALUE; c++) {
                int index = enc.convertToIndexGlyph(new UInt16(c));
                if (index != -1) {
                    indexList.add(index);
                }
            }
            indexList.sort(Comparator.comparingInt(Integer::intValue));
            for (int i = 0; i < indexList.size() - 1; i++) {
                assertEquals(1, indexList.get(i+1) - indexList.get(i));
            }
        });
    }
}