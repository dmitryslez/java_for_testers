public class Triangle {
    double a;
    double b;
    double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public static void main(String[] args) {
        Triangle triangle = new Triangle(5, 5, 5);
        System.out.println(triangleArea(triangle.a, triangle.b, triangle.c));
        System.out.println("Perimeter of triangle with sides " + "a = " +  triangle.a + ", " + "b = " + triangle.b + ", " + "c = " + triangle.c + " = " + trianglePerimeter(triangle.a, triangle.b, triangle.c));
        System.out.println("Area of triangle with sides " + "a = " + triangle.a + ", " + "b = "  + triangle.b + ", " +  "c = " + triangle.c + " = " + triangleArea(triangle.a, triangle.b, triangle.c));}

    public static double triangleArea(double a, double b, double c) {
        return Math.sqrt((trianglePerimeter(a, b, c)/2.0) * ((trianglePerimeter(a, b, c)/2.0) - a) * ((trianglePerimeter(a, b, c)/2.0) - b) * ((trianglePerimeter(a, b, c)/2.0) - c));
    }

    public static double trianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }

}