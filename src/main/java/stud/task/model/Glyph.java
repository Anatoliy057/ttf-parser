package stud.task.model;

import java.util.List;
import java.util.StringJoiner;

public class Glyph {
    private int xMin, yMin, xMax, yMax;
    private List<Contour> contourList;

    public Glyph(int xMin, int yMin, int xMax, int yMax, List<Contour> contourList) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
        this.contourList = contourList;
    }

    public int getxMin() {
        return xMin;
    }

    public int getyMin() {
        return yMin;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public List<Contour> getContourList() {
        return contourList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Glyph.class.getSimpleName() + "[", "]")
                .add("xMin=" + xMin)
                .add("yMin=" + yMin)
                .add("xMax=" + xMax)
                .add("yMax=" + yMax)
                .add("contourList=" + contourList)
                .toString();
    }
}
