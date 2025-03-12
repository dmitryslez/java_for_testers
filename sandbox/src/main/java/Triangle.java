public record Triangle (double a, double b, double c) {

    public double triangleArea() {
        return Math.sqrt((trianglePerimeter()/2.0) * ((trianglePerimeter()/2.0) - a) * ((trianglePerimeter()/2.0) - b) * ((trianglePerimeter()/2.0) - c));
    }

    public double trianglePerimeter() {
        return a + b + c;
    }

}