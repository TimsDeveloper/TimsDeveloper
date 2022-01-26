public class Circle {

    //instance variable
    private double radius;

    //default constructor
    public Circle(){
        radius = 0;
    }

    //argument constructor
    public Circle(double radius) {
        this.radius =radius;
    }

    //getter and setter
    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    //method to return area
    public double calculateArea(){
        return radius*radius*Math.PI;
    }
}
