package by.bsu.shapetask.entity;

import by.bsu.shapetask.exception.ShapeException;
import by.bsu.shapetask.validator.TriangleValidator;

public class Triangle extends Shape {
    private static final String INVALID_POINTS = "Points don't form a triangle";
    private Point vertexA;
    private Point vertexB;
    private Point vertexC;

    public Triangle(String name, Point a, Point b, Point c) throws ShapeException {
        super(name);
        TriangleValidator validator = TriangleValidator.getInstance();
        if (!validator.isValid(a, b, c)) {
            throw new ShapeException(INVALID_POINTS);
        }
        this.vertexA = a.clone();
        this.vertexB = b.clone();
        this.vertexC = c.clone();
    }

    public Point getVertexA() {
        return vertexA.clone();
    }

    public void setVertexA(Point a) throws ShapeException {
        TriangleValidator validator = TriangleValidator.getInstance();
        if (!validator.isValid(a, vertexB, vertexC)) {
            throw new ShapeException(INVALID_POINTS);
        }
        this.vertexA = a.clone();
    }

    public Point getVertexB() {
        return vertexB.clone();
    }

    public void setVertexB(Point b) throws ShapeException {
        TriangleValidator validator = TriangleValidator.getInstance();
        if (!validator.isValid(vertexA, b, vertexC)) {
            throw new ShapeException(INVALID_POINTS);
        }
        this.vertexB = b.clone();
    }

    public Point getVertexC() {
        return vertexC.clone();
    }

    public void setVertexC(Point c) throws ShapeException {
        TriangleValidator validator = TriangleValidator.getInstance();
        if (!validator.isValid(vertexA, vertexB, c)) {
            throw new ShapeException(INVALID_POINTS);
        }
        this.vertexC = c.clone();
    }

    public boolean equalsIgnoreName(Triangle triangle) {
        if (this == triangle) {
            return true;
        }
        if (triangle == null) {
            return false;
        }
        if (vertexA != null ? !vertexA.equals(triangle.vertexA) : triangle.vertexA != null) return false;
        if (vertexB != null ? !vertexB.equals(triangle.vertexB) : triangle.vertexB != null) return false;
        return vertexC != null ? vertexC.equals(triangle.vertexC) : triangle.vertexC == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Triangle triangle = (Triangle) o;

        if (vertexA != null ? !vertexA.equals(triangle.vertexA) : triangle.vertexA != null) return false;
        if (vertexB != null ? !vertexB.equals(triangle.vertexB) : triangle.vertexB != null) return false;
        return vertexC != null ? vertexC.equals(triangle.vertexC) : triangle.vertexC == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (vertexA != null ? vertexA.hashCode() : 0);
        result = 31 * result + (vertexB != null ? vertexB.hashCode() : 0);
        result = 31 * result + (vertexC != null ? vertexC.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append(super.toString());
        sb.append(", a=").append(vertexA);
        sb.append(", b=").append(vertexB);
        sb.append(", c=").append(vertexC);
        sb.append('}');
        return sb.toString();
    }
}
