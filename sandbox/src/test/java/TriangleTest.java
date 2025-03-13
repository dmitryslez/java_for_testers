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
    @Test
    void testEquality() {
        var t1 = new Triangle(3,4,5);
        var t2 = new Triangle(3,4,5);
        Assertions.assertEquals(t1,t2);
    }
    @Test
    void testNonEquality() {
        var t1 = new Triangle(3,4,5);
        var t2 = new Triangle(5,6,8);
        Assertions.assertNotEquals(t1,t2);
    }
    @Test
    void testEquality2() {
        var t1 = new Triangle(3,4,5);
        var t2 = new Triangle(3,5,4);
        Assertions.assertEquals(t1,t2);
    }
}
