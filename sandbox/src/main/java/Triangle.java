import java.util.Objects;

public record Triangle (double a, double b, double c) {

    public Triangle {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }
        if (a + b < c || a + c < b || c + b < a) {
            throw new IllegalArgumentException("Such a triangle does not exist");
        }
    }

    public double triangleArea() {
        return Math.sqrt((trianglePerimeter()/2.0) * ((trianglePerimeter()/2.0) - a) * ((trianglePerimeter()/2.0) - b) * ((trianglePerimeter()/2.0) - c));
    }
  
    public double trianglePerimeter() {
        return a + b + c;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(a(), triangle.a()) == 0 && Double.compare(b(), triangle.b()) == 0 && Double.compare(c(), triangle.c()) == 0)
                || (Double.compare(a(), triangle.a()) == 0 && Double.compare(b(), triangle.c()) == 0 && Double.compare(c(), triangle.b()) == 0)
                || (Double.compare(a(), triangle.b()) == 0 && Double.compare(b(), triangle.c()) == 0 && Double.compare(c(), triangle.a()) == 0)
                || (Double.compare(a(), triangle.b()) == 0 && Double.compare(b(), triangle.a()) == 0 && Double.compare(c(), triangle.c()) == 0)
                || (Double.compare(a(), triangle.c()) == 0 && Double.compare(b(), triangle.a()) == 0 && Double.compare(c(), triangle.b()) == 0)
                || (Double.compare(a(), triangle.c()) == 0 && Double.compare(b(), triangle.b()) == 0 && Double.compare(c(), triangle.a()) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a(), b(), c());
    }
}