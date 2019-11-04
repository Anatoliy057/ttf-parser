package stud.task.table.required;

import org.apache.log4j.Logger;
import stud.task.exception.StreamOutOfFileException;
import stud.task.exception.TTFTableMismatchSizeException;
import stud.task.table.MainTable;
import stud.task.table.domain.HeadTable;
import stud.task.types.Fixed;
import stud.task.types.Tag;
import stud.task.types.UInt16;
import stud.task.util.TTFInputStream;

import java.io.IOException;
import java.util.StringJoiner;

import static org.apache.log4j.Level.ERROR;

public class MaxP extends MainTable {

    private static final Logger LOGGER = Logger.getLogger(MaxP.class);
    public static final Tag TAG = new Tag(0x6D617870);

    private final Fixed VERSION_1 = new Fixed(0x00010000);

    private Fixed version;
    private UInt16 numGlyphs;
    private UInt16 maxPoints;
    private UInt16 maxContours;
    private UInt16 maxCompositePoints;
    private UInt16 maxCompositeContours;
    private UInt16 maxZones;
    private UInt16 maxTwilightPoints;
    private UInt16 maxStorage;
    private UInt16 maxFunctionDefs;
    private UInt16 maxInstructionDefs;
    private UInt16 maxStackElements;
    private UInt16 maxSizeOfInstructions;
    private UInt16 maxComponentElements;
    private UInt16 maxComponentDepth;

    public MaxP(HeadTable headTable) {
        super(headTable);
    }

    @Override
    public void read(TTFInputStream in) throws TTFTableMismatchSizeException, IOException {
        try {
            long start = in.available();
            version = in.readFixed();
            numGlyphs = in.readUInt16();
            if (version.compareTo(VERSION_1) >= 0) {
                maxPoints = in.readUInt16();
                maxContours = in.readUInt16();
                maxCompositePoints = in.readUInt16();
                maxCompositeContours = in.readUInt16();
                maxZones = in.readUInt16();
                maxTwilightPoints = in.readUInt16();
                maxStorage = in.readUInt16();
                maxFunctionDefs = in.readUInt16();
                maxInstructionDefs = in.readUInt16();
                maxStackElements = in.readUInt16();
                maxSizeOfInstructions = in.readUInt16();
                maxComponentElements = in.readUInt16();
                maxComponentDepth = in.readUInt16();
            }
            checkSize(start - in.available());
        } catch (StreamOutOfFileException e) {
            LOGGER.log(ERROR, e);
        }
    }

    public Fixed getVersion() {
        return version;
    }

    public UInt16 getNumGlyphs() {
        return numGlyphs;
    }

    public UInt16 getMaxPoints() {
        return maxPoints;
    }

    public UInt16 getMaxContours() {
        return maxContours;
    }

    public UInt16 getMaxCompositePoints() {
        return maxCompositePoints;
    }

    public UInt16 getMaxCompositeContours() {
        return maxCompositeContours;
    }

    public UInt16 getMaxZones() {
        return maxZones;
    }

    public UInt16 getMaxTwilightPoints() {
        return maxTwilightPoints;
    }

    public UInt16 getMaxStorage() {
        return maxStorage;
    }

    public UInt16 getMaxFunctionDefs() {
        return maxFunctionDefs;
    }

    public UInt16 getMaxInstructionDefs() {
        return maxInstructionDefs;
    }

    public UInt16 getMaxStackElements() {
        return maxStackElements;
    }

    public UInt16 getMaxSizeOfInstructions() {
        return maxSizeOfInstructions;
    }

    public UInt16 getMaxComponentElements() {
        return maxComponentElements;
    }

    public UInt16 getMaxComponentDepth() {
        return maxComponentDepth;
    }

    @Override
    public String toString() {
        if (version.compareTo(VERSION_1) >= 0)
            return new StringJoiner(", ", MaxP.class.getSimpleName() + "[", "]")
                    .add("version=" + version)
                    .add("numGlyphs=" + numGlyphs)
                    .add("maxPoints=" + maxPoints)
                    .add("maxContours=" + maxContours)
                    .add("maxCompositePoints=" + maxCompositePoints)
                    .add("maxCompositeContours=" + maxCompositeContours)
                    .add("maxZones=" + maxZones)
                    .add("maxTwilightPoints=" + maxTwilightPoints)
                    .add("maxStorage=" + maxStorage)
                    .add("maxFunctionDefs=" + maxFunctionDefs)
                    .add("maxInstructionDefs=" + maxInstructionDefs)
                    .add("maxStackElements=" + maxStackElements)
                    .add("maxSizeOfInstructions=" + maxSizeOfInstructions)
                    .add("maxComponentElements=" + maxComponentElements)
                    .add("maxComponentDepth=" + maxComponentDepth)
                    .toString();
        else
            return new StringJoiner(", ", MaxP.class.getSimpleName() + "[", "]")
                    .add("version=" + version)
                    .add("numGlyphs=" + numGlyphs)
                    .toString();
    }
}
