public class Triangle {
    double a;
    double b;
    double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    //public static void main(String[] args) {
        //Triangle triangle = new Triangle(5, 5, 5);
       // System.out.println("Perimeter of triangle with sides " + "a = " +  triangle.a + ", " + "b = " + triangle.b + ", " + "c = " + triangle.c + " = " + triangle.trianglePerimeter());
       // System.out.println("Area of triangle with sides " + "a = " + triangle.a + ", " + "b = "  + triangle.b + ", " +  "c = " + triangle.c + " = " + triangle.triangleArea());}

    public double triangleArea() {
        return Math.sqrt((trianglePerimeter()/2.0) * ((trianglePerimeter()/2.0) - this.a) * ((trianglePerimeter()/2.0) - this.b) * ((trianglePerimeter()/2.0) - this.c));
    }

    public double trianglePerimeter() {
        return this.a + this.b + this.c;
    }

}