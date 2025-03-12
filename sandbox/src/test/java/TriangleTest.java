import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    void CalculatePerimeter() {
        var testTriangle = new Triangle(5.0,5.0,5.0);
        double result = testTriangle.trianglePerimeter();
        Assertions.assertEquals(15.0, result);
    }
    @Test
    void CalculatArea() {
        var testTriangle = new Triangle(5.0,5.0,5.0);
        double result = testTriangle.triangleArea();
        Assertions.assertEquals(10.825317547305483, result);
    }
    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-5, -5, -5);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {

        }
    }
    @Test
    void cannotCreateTriangleWithInequalityViolation() {
        try {
            new Triangle(1,2,5);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {

        }
    }
}
