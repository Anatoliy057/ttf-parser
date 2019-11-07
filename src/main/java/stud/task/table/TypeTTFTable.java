package stud.task.table;

import stud.task.table.other.HDMx;
import stud.task.table.required.*;
import stud.task.types.Tag;

public enum TypeTTFTable {
    CMAP(CMap.TAG),
    GLYF(Glyf.TAG),
    HEAD(Head.TAG),
    HHEA(HHea.TAG),
    HMTX(HMtx.TAG),
    LOCA(Loca.TAG),
    MAXP(MaxP.TAG),
    HDMX(HDMx.TAG);

    public final Tag TAG;

    TypeTTFTable(Tag tag) {
        TAG = tag;
    }
}
