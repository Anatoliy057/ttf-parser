package stud.task.model;

import java.util.List;
import java.util.StringJoiner;

public class Glyph {
    private int xMin, yMin, xMax, yMax;
    private int leftSideBearing, rightSideBearing;
    private List<Contour> contourList;

    public Glyph(int xMin, int yMin, int xMax, int yMax, List<Contour> contourList) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
        this.contourList = contourList;
    }

    public Glyph(int xMin, int yMin, int xMax, int yMax, int leftSideBearing, int rightSideBearing, List<Contour> contourList) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
        this.leftSideBearing = leftSideBearing;
        this.rightSideBearing = rightSideBearing;
        this.contourList = contourList;
    }

    public Glyph() {
    }

    public int getxMin() {
        return xMin;
    }

    public void setXMin(int xMin) {
        this.xMin = xMin;
    }

    public int getYMin() {
        return yMin;
    }

    public void setYMin(int yMin) {
        this.yMin = yMin;
    }

    public int getXMax() {
        return xMax;
    }

    public void setXMax(int xMax) {
        this.xMax = xMax;
    }

    public int getYMax() {
        return yMax;
    }

    public void setYMax(int yMax) {
        this.yMax = yMax;
    }

    public int getLeftSideBearing() {
        return leftSideBearing;
    }

    public void setLeftSideBearing(int leftSideBearing) {
        this.leftSideBearing = leftSideBearing;
    }

    public int getRightSideBearing() {
        return rightSideBearing;
    }

    public void setRightSideBearing(int rightSideBearing) {
        this.rightSideBearing = rightSideBearing;
    }

    public List<Contour> getContourList() {
        return contourList;
    }

    public void setContourList(List<Contour> contourList) {
        this.contourList = contourList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Glyph.class.getSimpleName() + "[", "]")
                .add("xMin=" + xMin)
                .add("yMin=" + yMin)
                .add("xMax=" + xMax)
                .add("yMax=" + yMax)
                .add("leftSideBearing=" + leftSideBearing)
                .add("rightSideBearing=" + rightSideBearing)
                .add("contourList=" + contourList)
                .toString();
    }
}
