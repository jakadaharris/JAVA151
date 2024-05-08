/*
   This program will calculate what graphics quality the user will be able to run a newly developed video game on when the user enters the specifications of their computer's hardware.
*/

import java.util.Scanner;

public class GraphicsQualityCalculator {
   public static void main(String[] args){
   
   Scanner scanner = new Scanner(System.in);
   
   System.out.print("Hello! Please enter the clock speed (number value only, in Megahertz) of your graphics card: \n");
   int graphicsCard = scanner.nextInt(); // MHz for graphics card (GPU)
   
   System.out.print("Please enter the clock speed (number value only, in Megahertz) of your processor: \n");
   int processorClock = scanner.nextInt(); // MHz for processor (CPU)
   
   System.out.print("Please enter the number of core(s) of your processor. \n");
   int processorCore = scanner.nextInt(); // number of cores in processor
  
   
   System.out.print("Computer Hardware Graphics Quality Recommendation Tool: \n");
   System.out.print("\n"); // line skip for easier reading / visuals
   System.out.print("GPU Clock Speed: " + graphicsCard + " MHz. \n");
   System.out.print("CPU Clock Speed: " + processorClock + " MHz. \n");
   System.out.print("Number of cores: " + processorCore + " MHz. \n");
   System.out.print("\n"); // line skip for easier reading / visuals
   System.out.print("Thank you for using this program!");
   
   scanner.close();
   
   }
}

