import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    void CalculatePerimeter(){
        var result = Triangle.trianglePerimeter(5.0, 5.0, 5.0);
        Assertions.assertEquals(15.0, result);
    }
    @Test
    void CalculatArea(){
        var result = Triangle.triangleArea(5.0, 5.0, 5.0);
        Assertions.assertEquals(10.825317547305483, result);
    }
}
