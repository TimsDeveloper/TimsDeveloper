public class Rectangle {

    //instance variables
    private double length, width;

    //default constructor
    public Rectangle() {
        length = 0;
        width = 0;
    }

    //argument constructor
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    //getters and setters

    public double getLength(){
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth(){
        return width;
    }

    public void setWidth(double width){
        this.width = width;
    }


    //method to return area
    public double calculateArea(){
        return this.length * this.width;
    }
}
