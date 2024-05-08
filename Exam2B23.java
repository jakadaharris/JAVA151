import java.util.Scanner;

public class Exam2B23
{
   public static String getMembershipType()
   {
      Scanner input = new Scanner(System.in);
      String membershipType;
      
      System.out.println("Welcome to the CPCC Roadside Assistance Service! \n");
      
      System.out.print("Enter your type of Membership: 'basic', 'plus' or 'premier': ");
      membershipType = input.nextLine();
      
      while(!membershipType.equalsIgnoreCase("basic") && !membershipType.equalsIgnoreCase("plus")
            && !membershipType.equalsIgnoreCase("premier"))
         {
            System.out.println("\nERROR: Invalid membership entered. Try Again. \n");
            System.out.print("Enter your type of Membership: 'basic', 'plus' or 'premier': ");
            membershipType = input.nextLine();
         } 
   
      return membershipType;
   }

   public static int getMaxOilChanges(String membershipType)
   {
      if(membershipType.equalsIgnoreCase("basic"))
         return 1;
      else if(membershipType.equalsIgnoreCase("plus"))
         return 2;
      else
         return 4;
   }
   
   public static double getMembershipBaseRate(String membershipType)
   {
      if(membershipType.equalsIgnoreCase("basic"))
         return 64.50;
      else if(membershipType.equalsIgnoreCase("plus"))
         return 95.95;
      else
         return 124.00;
   }
   
   public static double getOilChangeRate(String membershipType)
   {
      if(membershipType.equalsIgnoreCase("basic"))
         return 65.55;
      else if(membershipType.equalsIgnoreCase("plus"))
         return 55.75;
      else
         return 35.99;
   }
      
   public static void displayMembershipInformation(String type, int maxOilChanges, double oilChangeRate, 
      double cost)
      {
         System.out.println("-----------------------------------------------------------------------");
         System.out.println("Membership Type: " + type);
         System.out.printf("Total Free Oil Changes Included: %d \n", maxOilChanges);
         System.out.printf("Cost per oil change after free changes: $%.2f per oil change \n", oilChangeRate);
         System.out.println("-----------------------------------------------------------------------");
         System.out.printf( "%s Membership Base Cost: $%.2f \n", type, cost);
         System.out.println("-----------------------------------------------------------------------");
      }
      
   public static String repeatServiceInput(int count)
   {
      Scanner input = new Scanner(System.in);
      String serviceString;
      String repeat;
      
      if(count == 0)
         serviceString = "an";
      else
         serviceString = "another";
      
      System.out.print("\nEnter y or yes to add " + serviceString + 
            " oil change service. Enter no or n to stop and process your invoice: ");
      repeat = input.nextLine();
      
      while(!repeat.equalsIgnoreCase("yes") && !repeat.equalsIgnoreCase("y") &&
            !repeat.equalsIgnoreCase("no") && !repeat.equalsIgnoreCase("n"))
      {
         System.out.println("\nERROR: Invalid response. Try again. \n");
         System.out.print("\nEnter y or yes to add " + serviceString + 
            " oil change service. Enter no or n to stop and process your invoice: ");
         repeat = input.nextLine();
      }
      
      return repeat;
   }
   
   public static void invoice(double mCost, int nServices, double totalOilChangeCharges)
   {
      System.out.println("\n\n\t*******Invoice*******");
      System.out.printf("Membership Base Cost: $%.2f\n", mCost);
      System.out.println("Number of Oil Changes: " + nServices);
      System.out.println("----------------------------------");
      System.out.printf("Towing Charges: $%.2f \n", totalOilChangeCharges);
      System.out.printf("\nTotal Charges: $%.2f \n", (mCost + totalOilChangeCharges));
   }
   
  
   public static void getOilChangeCost(String membershipType, int remainingOilChanges, double oilChangeRate)
   {
      
      if(remainingOilChanges >= 1)
      {
         System.out.printf("\nNOTE: You have %d remaining free oil changes with your %s membership. \n" + 
         "You will be charged at a rate of $%.2f per service for oil changes if you exceed the free oil changes. \n", 
            remainingOilChanges, membershipType, oilChangeRate);
      }        
      else
      {
         System.out.printf("\nNOTE: You do not have any free remaining oil changes with your %s membership. \n" 
         +" You will be charged at a rate of $%.2f per service for an oil change. \n", membershipType, oilChangeRate);
      }
     
   }
   
   public static double calcOilChangeCost(int remainingOilChanges, double oilChangeRate)
   {
      if(remainingOilChanges < 1)
      {
         System.out.printf("\nOil Change Charge: $%.2f", oilChangeRate);
         return oilChangeRate;
      }
      else
      {
         System.out.println("\nOil Change Charge: $0.00");
         return 0.00;
      }
   } 

   public static void main(String[] args)
   {
      String membershipType;
      double membershipCost, oilChangeRate;
      double oilChangeCost;
      double totalCharges = 0, totalOilChangeCharges = 0;
      int serviceCount = 0, maxOilChanges, remainingFreeOilChanges;
      String moreServices = "yes";
      
      membershipType = getMembershipType();
      maxOilChanges = getMaxOilChanges(membershipType);
      membershipCost = getMembershipBaseRate(membershipType);
      oilChangeRate = getOilChangeRate(membershipType);
      displayMembershipInformation(membershipType, maxOilChanges, oilChangeRate, 
                                    membershipCost);
      remainingFreeOilChanges = maxOilChanges;
      totalCharges += membershipCost;
      
      do
      {
         moreServices = repeatServiceInput(serviceCount);
         
         if(moreServices.equalsIgnoreCase("yes") || moreServices.equalsIgnoreCase("y"))
         {  
            serviceCount++;
                   
            getOilChangeCost(membershipType, remainingFreeOilChanges, oilChangeRate);
            
            oilChangeCost = calcOilChangeCost(remainingFreeOilChanges, oilChangeRate);
           
            totalOilChangeCharges += oilChangeCost;
            
            if(remainingFreeOilChanges > 0)
               remainingFreeOilChanges--;
            else
               remainingFreeOilChanges = 0;
         }
          
      }while(moreServices.equalsIgnoreCase("yes") || moreServices.equalsIgnoreCase("y"));
      
      invoice(membershipCost, serviceCount, totalOilChangeCharges);
      
   }
}