import java.util.Scanner;//for getting user input

public class PaintCost
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      
      double length, width, height, perimeter, wallSpace, 
             paintCost, laborCost, totalCost = 0;
      int numOfRooms;
      
      
      System.out.print("Enter the number of rooms to be painted: ");
      numOfRooms = keyboard.nextInt();      
      
      System.out.println();
      
      //for each room, get the dimensions and figure out the costs
      for(int i=0; i < numOfRooms; i++)
      {
         System.out.print("Enter the length of the room: ");
         length = keyboard.nextDouble(); 
         
         System.out.print("Enter the width of the room: ");
         width = keyboard.nextDouble();
         
         System.out.print("Enter the height of the room: ");
         height = keyboard.nextDouble();
         
         
         //figure out the sq ft of wall space
         wallSpace = calcWallSpace(length, width, height);
         //figure out the paint cost
         paintCost = calculatePaintCost(wallSpace);
         //figure out the labor cost
         laborCost = calculateLaborCost(wallSpace);
         
         //add the paint and labor costs to our running total
         totalCost += paintCost;
         totalCost += laborCost;
         
         //display the costs
         System.out.println();
         displayData(paintCost, laborCost);
         System.out.println();
      }
      
      System.out.printf("The total cost of painting the "+numOfRooms+" rooms" +
                        " is $%,.2f", totalCost);
   }
   
   /**
      Calculates and returns the perimeter of a room
      @param length The length of the room
      @param height The height of the room
      @return The perimeter of a room
   */
   public static double calcPerimeter(double length, double width) 
   {
      return (width + length) * 2;
   }
   
   /**
      Calculates and returns the perimeter of a room
      @param length The length of the room
      @param width The width of the room
      @param height The height of the room
      @return The sqaure feet of wallspace in a room
   */
   public static double calcWallSpace(double length, double width
                                                   , double height) 
   {
      return calcPerimeter(length, width) * height;
   }
   
   /**
      Calculates and returns the cost of paint for painting a room
      @param sqFtWallSpace The square feet of wall space in a room
      @return The cost of paint for painting a room
   */
   public static double calculatePaintCost(double sqFtWallSpace) 
   {
      final double PAINT_COST_PER_GALLON = 60.00;
      final double SQUARE_FT_PER_GALLON = 250;
      
      return Math.ceil((sqFtWallSpace / SQUARE_FT_PER_GALLON)) * PAINT_COST_PER_GALLON;
   }
   
   /**
      Calculates and returns the cost of labor for painting a room
      @param sqFtWallSpace The square feet of wall space in a room
      @return The cost of labor for painting a room
   */
    public static double calculateLaborCost(double sqFtWallSpace) 
    {
      final double LABOR_COST_PER_HOUR = 35.00;
      final double SQ_FT_PER_HOUR = 62.5; //250 square feet per 4 hours, so 250/4 = 62.5 sq ft per labor hour
      
      return (sqFtWallSpace / SQ_FT_PER_HOUR) * LABOR_COST_PER_HOUR;
    }
    
    /**
      Displays the paint and labor costs
      @param paintCost The cost of paint for painting the room
      @param laborCost The cost of labor for painting the room
    */
    public static void displayData(double paintCost, double laborCost) 
    {
      System.out.printf("Paint cost: $%,.2f\n", paintCost);
      System.out.printf("Labor cost: $%,.2f\n", laborCost);
    }
   
}
