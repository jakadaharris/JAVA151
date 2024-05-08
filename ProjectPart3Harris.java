import java.util.Scanner;

public class ProjectPart3Harris
{
   public static void main(String[] args)
   {

   // Initialize variables.
   double graphicsCard = 0.0; 
   double cpuClockSpeed = 0.0;
   int cores = 0;
   int inputResolution = 0;
   double multiplier = 0.0;
   double performanceScore = 0.00;
   String recommendedGraphics = "";
   String monitorResolution = "";
   double lowestPerformanceScore = 0.00;
   double highestPerformanceScore = 0.00;
    
   // Create String object in memory for title.
   String str1 = "Computer Hardware Graphics Quality Recommendation Tool";
   
   // Constants to represent the menu option.
   final int lowResolution = 1;
   final int mediumResolution = 2;
   final int highResolution = 3; 
   final int perfectResolution = 4;
   
   Scanner scanner = new Scanner(System.in);  
   
   // Start loop for entering data for all computers.
   
   System.out.println(str1);
   
   System.out.println("\nHow many computers are being processed: ");
   int userInputRepeat = scanner.nextInt();
   while (userInputRepeat < 0){
      System.out.println("Input outside of range. Please enter a number greater than 0: ");
      userInputRepeat = scanner.nextInt();
   }
   
   int repeat = 1;
   
   while (repeat <= userInputRepeat){
      
      // Request user to input specifications of graphics card, processor, and cores.
      // Add while loops to ensure that the proper ranges are inputed.
      
      // The GPU clock speed should be between 800 and 2000 MHz.
      System.out.println("\nData for Computer " + repeat + ": ");
      
      System.out.print("Please enter the clock speed (in Megahertz) of your graphics card: ");
         graphicsCard = scanner.nextDouble();
         while (graphicsCard < 800 || graphicsCard > 2000){
            System.out.print("Input out of range. Please enter a clock speed between 800 and 2000 in MHz: ");
            graphicsCard = scanner.nextDouble();
         }

      // The CPU clock speed should be between 1000 and 5500 MHz.
      System.out.print("Please enter the clock speed (in Megahertz) of your processor: ");
         cpuClockSpeed = scanner.nextDouble();
         while (cpuClockSpeed < 1000 || cpuClockSpeed > 5500){
            System.out.print("Input out of range. Please enter a clock speed between 1000 and 5500 in MHz: ");
            cpuClockSpeed = scanner.nextDouble();
         }

      // The number of cores should be between 1 and 16.
      System.out.print("Please enter the number of cores of your processor: ");
         cores = scanner.nextInt();
         while (cores < 1 || cores > 16){
            System.out.print("Input out of range. Please enter a number of cores between 1 and 16 in MHz: ");
            cores = scanner.nextInt();
         }

         
      // Graphics resolution menu. The user's input for the menu selection should be between 1 and 4.
      System.out.println("What is the resolution of your monitor?");
      System.out.println(" 1. 1280 x 720");
      System.out.println(" 2. 1920 x 1080");
      System.out.println(" 3. 2560 x 1440");
      System.out.println(" 4. 3840 x 2160");
      
      // Ask for user selection from above ^^. 
      System.out.println("Please enter your choice from the options above: ");
         inputResolution = scanner.nextInt();
         while (inputResolution < 1 || inputResolution > 4){
            System.out.println("Input out of range. Please enter a number 1 through 4 from the menu above: ");
            inputResolution = scanner.nextInt();
         }

      
      // Calculate multiplier for performance score equation. 
      if (inputResolution == lowResolution){
         multiplier = 1.0;
         monitorResolution = "1280 x 720";
      } else if (inputResolution == mediumResolution){
         multiplier = .75;
         monitorResolution = "1920 x 1080";
      } else if (inputResolution == highResolution){
         multiplier = .55;
         monitorResolution = "2560 x 1440";
      }  else if (inputResolution == perfectResolution){
         multiplier = 0.35;
         monitorResolution = "3840 x 2160";
      }
             
      // Performance score equation.
      performanceScore = ((5 * graphicsCard) + (cores * cpuClockSpeed)) * multiplier;
      
      // Recommended Quality Graphics
      if (performanceScore > 17000){
         recommendedGraphics = "Ultra";
      } else if (performanceScore > 15000 && performanceScore <= 17000){
         recommendedGraphics = "High";
      } else if (performanceScore > 13000 && performanceScore <= 15000){
         recommendedGraphics = "Medium";
      } else if (performanceScore > 11000 && performanceScore <= 13000){
         recommendedGraphics = "Low";
      } else if (performanceScore <= 11000){
         recommendedGraphics = "Unable to Play";
      }
      
      // Highest score calculator. 
      if (repeat == 1){
         highestPerformanceScore = performanceScore;
      } else if (performanceScore > highestPerformanceScore){
         highestPerformanceScore = performanceScore;
      }
     
      // Lowest score calculator.      
      if (repeat == 1){
         lowestPerformanceScore = performanceScore;
      } else if (performanceScore < lowestPerformanceScore){
         lowestPerformanceScore = performanceScore;
      }
      
      // Output results.
   System.out.println("GPU Clock Speed: " + graphicsCard + " MHz");
   System.out.println("CPU Clock Speed: " + cpuClockSpeed + " MHz");
   System.out.println("Number of cores: " + cores);
   System.out.println("Monitor Resolution: " + monitorResolution);
   System.out.printf("Performance score: %,.3f", performanceScore);
   System.out.print("\nRecommended Graphics Quality: " + recommendedGraphics);
   
      repeat++;
   }
   
   
   
   
   // Output highest/lowest scores.
   System.out.println("");
   System.out.printf("\nThe highest performance score was: %,.3f", highestPerformanceScore);
   System.out.printf("\nThe lowest performance score was: %,.3f", lowestPerformanceScore);
   
   
   }
}