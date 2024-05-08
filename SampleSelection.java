/*
This program demonstrates how to properly display a menu and prompt the user for their input.
In this example, the menu gives options for a health club membership and asks the user to make a selection.
The program then asks for the number of months that the membership will last.
Finally, it calculates the cost of the membership based on the type of membership and the number of months the membership will last.
*/

import java.util.Scanner;//needed in order to be able to use the Scanner class to get the user's input

public class SampleSelection
{
   public static void main(String[] args)
   {
      int choice = 0;//to hold the menu choice
      int numMonths = 0;//to hold the number of months for the membership
      double totalCost = 0.0;//to hold the total cost of the membership 
      double costPerMonth = 0.0;//to hold the total cost of the membership - initialized to 0.0 to avoid compiler message later on
      
      //constants to hold the cost of the membership types
      final double ADULT_COST = 40.0;
      final double CHILD_COST = 20.0;
      final double SENIOR_COST = 30.0;
      
      //constants to represent the menu options
      final int ADULT_CHOICE = 1;
      final int CHILD_CHOICE = 2;
      
      Scanner keyboard = new Scanner(System.in);//create a Scanner object to get the user's input
      
      //Display the Menu
      System.out.println("Health Club Membership Menu");
      System.out.println("1. Standard Adult Membership - $40 per month");
      System.out.println("2. Child Membership - $20 per month");
      System.out.println("3. Senior Citizen Membership - $30 per month");
      
      System.out.print("\nEnter your choice: ");//Ask the user to make a selection from the menu
      choice = keyboard.nextInt();//read in the user's input for the menu selection
      
      System.out.print("How many months will the membership last? ");//ask the user for the number of months that the membership will last
      numMonths = keyboard.nextInt();//read in the user's input for the number of months
      
      
      //Use if/else if statement to appropriately handle the user's selection
      //assign the correct value to our costPerMonth variable based on the user's selection
      if(choice == ADULT_CHOICE)
      {
         costPerMonth = ADULT_COST;       
      }
      else if(choice == CHILD_CHOICE)
      {
         costPerMonth = CHILD_COST;
      }
      else
      {
         costPerMonth = SENIOR_COST;
      }
      
      /*
      //Since there is only a single statement that we want to conditionally execute  in the body of each if-statement,
      //we can optionally omit the curly braces to make the code shorter as shown below.
      //
      //Be aware that this only works when you want to conditionally execute a SINGLE statement.
      //If you have multiple statements that you want to execute, you MUST include them in curly braces
      //
      //To test this, you can comment out the if-else-if statements above and use the code below instead:
      if(choice == ADULT_CHOICE)
        costPerMonth= ADULT_COST;       
      else if(choice == CHILD_CHOICE)
        costPerMonth = CHILD_COST;
      else       
        costPerMonth = SENIOR_COST;
      */
      
      totalCost = costPerMonth * numMonths; //calculate the total cost using the correct cost per month assigned above

      System.out.printf("The cost of the membership is $%.2f",totalCost);//display the total cost of the membership, formatting the output to two decimal places  
   }//end main
}//end class
