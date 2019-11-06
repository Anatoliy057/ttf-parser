package stud.task.model;

import java.util.Objects;
import java.util.StringJoiner;

public class GlyphPoint {
    private int x, y;
    private boolean curve;

    public GlyphPoint(int x, int y, boolean curve) {
        this.x = x;
        this.y = y;
        this.curve = curve;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isCurve() {
        return curve;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GlyphPoint that = (GlyphPoint) o;
        return x == that.x &&
                y == that.y &&
                curve == that.curve;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, curve);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GlyphPoint.class.getSimpleName() + "[", "]")
                .add("x=" + x)
                .add("y=" + y)
                .add("curve=" + curve)
                .toString();
    }
}
