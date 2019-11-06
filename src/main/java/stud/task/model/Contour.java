package stud.task.model;

import java.util.List;
import java.util.StringJoiner;

public class Contour {
    private List<GlyphPoint> points;

    public Contour(List<GlyphPoint> points, boolean closed) {
        this.points = points;
        if (!closed) {
            this.points.add(points.get(0));
        }
    }

    public List<GlyphPoint> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Contour.class.getSimpleName() + "[", "]")
                .add("points=" + points)
                .toString();
    }
}
