package stud.task.encoding;

import stud.task.types.UInt16;

public interface Encoding {

    int convertToIndexGlyph(UInt16 a);

    default int[] convertToArrIndexGlyphs(UInt16[] arr) {
        int[] indexes = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indexes[i] = convertToIndexGlyph(arr[i]);
        }
        return indexes;
    }

    UInt16 getFormat();
}
