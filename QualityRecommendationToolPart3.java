import java.util.Scanner;

public class QualityRecommendationToolPart3{

public static void main(String[] args){

   Scanner scanner = new Scanner(System.in);
   
   displayTitle();
   
   int calculatorLoop = 1;
   
   int loopTotal = 0;
   
   System.out.println("How many computers are being processed?");
   while (!scanner.hasNextInt()){
      System.out.println("Invalid input. Please enter input from the menu above.");
      System.out.println("How many computers are being processed?");
      scanner.next();
   }
   loopTotal = scanner.nextInt();

   double highestPerformanceScore = 0.00;
   
   double lowestPerformanceScore = 0.00;
   
   while (calculatorLoop <= loopTotal){
      
   // Graphics resolution menu.
   String resolutionString = "";
      
   System.out.println("\nWhat is the resolution of your monitor?");
   System.out.println(" 1. 1280 x 720");
   System.out.println(" 2. 1920 x 1080");
   System.out.println(" 3. 2560 x 1440");
   System.out.println(" 4. 3840 x 2160");
   System.out.println("Please enter option from above");
   scanner.next(); 
   
   while (!scanner.hasNextLine()){
      System.out.println("Invalid input. Please enter input from the menu above.");
      System.out.println("What is the resolution of your monitor?");
      scanner.next();
   }
   
   resolutionString = scanner.nextLine();
   
   String monitorResolution = getResolutionString(resolutionString);
   
   double multiplierValue = getMultiplierValue(monitorResolution);
   
   System.out.print("Please enter the clock speed (in Megahertz) of your graphics card: ");
      while (!scanner.hasNextDouble()){
      System.out.println("Invalid input. Please enter input from the menu above.");
      System.out.println("What is the clock speed of your graphics card?");
      scanner.next();
   }
      double graphicsCard = scanner.nextDouble();
      
   System.out.print("Please enter the clock speed (in Megahertz) of your processor: ");
      while (!scanner.hasNextDouble()){
      System.out.println("Invalid input. Please enter input from the menu above.");
      System.out.println("What is the clock speed of your processor?");
      scanner.next();
   }
      double cpuClockSpeed = scanner.nextDouble();
   System.out.print("Please enter the number of cores of your processor: ");
      while (!scanner.hasNextInt()){
      System.out.println("Invalid input. Please enter input from the menu above.");
      System.out.println("How many cores does your processor have?");
      scanner.next();
   }
      int cores = scanner.nextInt();
   
   double performanceScore = calculatePerformanceScore(graphicsCard, cpuClockSpeed, cores, multiplierValue);
   
    // Highest score calculator. 
      if (calculatorLoop == 1){
         highestPerformanceScore = performanceScore;
      } else if (performanceScore > highestPerformanceScore){
         highestPerformanceScore = performanceScore;
      }
     
      // Lowest score calculator.      
      if (calculatorLoop == 1){
         lowestPerformanceScore = performanceScore;
      } else if (performanceScore < lowestPerformanceScore){
         lowestPerformanceScore = performanceScore;
      }
   
   String recommendedGraphics = getRecommendedQuality(performanceScore);
   
   displayInformation(graphicsCard, cpuClockSpeed, cores, monitorResolution, performanceScore, recommendedGraphics);
   
   calculatorLoop++;
   }
   
   System.out.println("");
   System.out.printf("\nThe highest performance score was: %,.3f", highestPerformanceScore);
   System.out.printf("\nThe lowest performance score was: %,.3f", lowestPerformanceScore);
   
}

   public static void displayTitle(){
      System.out.println("Computer Hardware Graphics Quality Recommendation Tool");
   }
   
   public static String getResolutionString(String monitorResolution){
      String resolution = "";
      if (monitorResolution == "1"){
      resolution = "1280 x 720";
      } else if (monitorResolution == "2"){
      resolution = "1920 x 1080";
      } else if (monitorResolution == "3"){
      resolution = "2560 x 1440";
      }  else if (monitorResolution == "4"){
      resolution = "3840 x 2160";
      }
      return resolution;   
   }
   
   public static double getMultiplierValue(String inputResolution){
      double multiplier = 0.0;
      if (inputResolution.equals("1280 x 720")){
      multiplier = 1.0;
      } else if (inputResolution.equals("1920 x 1080")){
      multiplier = .75;
      } else if (inputResolution.equals("2560 x 1440")){
      multiplier = .55;
      }  else if (inputResolution.equals("3840 x 2160")){
      multiplier = 0.35;
      }
      return multiplier;
   }
   
    public static double calculatePerformanceScore(double gpu, double cpu, int cores, double multiplier){
      double performanceScore = ((5 * gpu) + (cores * cpu)) * multiplier;
      return performanceScore;
   }
   
      public static String getRecommendedQuality(double performanceScore){
      String recommendedGraphics = "";
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
      return recommendedGraphics;
   }
   
   public static void displayInformation(double gpu, double cpu, int cores, String monitorResolution, double performanceScore, String recommendedGraphics){
   System.out.print("\n GPU Clock Speed: " + gpu + " MHz");
   System.out.print("\n CPU Clock Speed: " + cpu + " MHz");
   System.out.print("\n Number of cores: " + cores);
   System.out.print("\n Monitor Resolution: " + monitorResolution);
   System.out.printf("\n Performance score: %,.3f", performanceScore);
   System.out.print("\n Recommended Graphics Quality: " + recommendedGraphics);
   return;
   }

}
