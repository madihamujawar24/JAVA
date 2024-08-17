public class Area 
{	
    static final double PIE = 3.14159;  
    public static double calculateCircleArea(double radius) 
	{
        return PIE * radius * radius;
    }

    public static void main(String[] args) 
	{    
        double radius = 5.0;
        double area = calculateCircleArea(radius);
        System.out.println("The area of a circle with radius " + radius + " is: " + area);
    }
}