public class Main {
    public static void main(String[]args){

        //create and display two rectangles

        Rectangle rec1 = new Rectangle(4,5);
        System.out.println("A Rectangle with a length of " + rec1.getLength() + " and a width of " + rec1.getWidth() + " has an area of " +rec1.calculateArea());

        Rectangle rec2= new Rectangle(5.7, 8.1);
        System.out.println("A Rectangle with a length of " + rec2.getLength() + " and a width of " + rec2.getWidth() + " has an area of " +rec2.calculateArea());

        //create and display two circles

        Circle cir1 = new Circle (3.2);
        System.out.println("A Circle with the radius " + cir1.getRadius() + " has an area of " + cir1.calculateArea());

        Circle cir2 = new Circle (4);
        System.out.println("A Circle with the radius " + cir2.getRadius() + " has an area of " + cir2.calculateArea());


    }
}
