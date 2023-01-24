import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        randomInput();
    }
    public static void randomInput(){
        Scanner scanner = new Scanner(System.in); // create scanner class
        System.out.print("Hey user enter your name: "); // Asking user for input
        String userInput = scanner.nextLine(); // Stores the users input
        nextStage(userInput);
    }
    public static void nextStage(String input){
        System.out.printf("Well Hello %s ", input); // uses the printf to use the dynamic data from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("What stage did you want to start at? 1, 2 or 3");
        String userInput = scanner.nextLine();
        if(Objects.equals(userInput, "1")){
            stageOne(input);
        } else if (Objects.equals(userInput, "2")){
            stageTwo();
        } else {
            stageThree();
        }
    }
    public static void stageOne(String input){
        Boolean isAnswerCorrect = false; // Will let us know if they entered the correct word
        Integer tries = 3; // Amount of tries the user has
        String correctWord = "pickle"; // The correct answer
        String[] hintsArray = {"It is green", "It enjoys its time in a jar", "Its crunchy"}; // The array of hints the user has
        System.out.printf("Hello %s welcome to level 1", input);
        Scanner scanner = new Scanner(System.in);
        System.out.println("On this stage you will have 3 tries to guess the word if you can not guess the word within 3 tries you will lose BUT good news you can also ask for a hint. Are you ready? y/n");
        String userInput = scanner.nextLine(); // Holding the value of y or no depending on the users response
        if(Objects.equals(userInput, "n")){
            exitGame(input);
        }
        System.out.println("Alrighty let's begin!");
        Integer returnValueFromRandomFunction = getRandomItem(hintsArray);
        System.out.printf("Your first hint is %s: ", hintsArray[returnValueFromRandomFunction]);
        String firstAnswer = scanner.nextLine().toLowerCase();
        Boolean isTheFirstAnswerCorrect = Objects.equals(correctWord, firstAnswer);
       while (!isAnswerCorrect){
           if(isTheFirstAnswerCorrect) {
               isAnswerCorrect = true;
               System.out.println("Congrats you won the game!");
               break;
           }
           tries--;
           System.out.printf("OOF you have %s tries left your next hint is %s", tries, hintsArray[returnValueFromRandomFunction]);
           String secondTry = scanner.nextLine().toLowerCase();
           Boolean isTheSecondAnswerTrue = Objects.equals(correctWord, secondTry);
           if(isTheSecondAnswerTrue){
               isAnswerCorrect = true;
               System.out.println("Congrats you won the game!");
               break;
           }

           tries--;
           System.out.printf("bruh.. you have %s your next AND FINAL HINT IS %s", tries, hintsArray[returnValueFromRandomFunction]);
           String lastTry = scanner.nextLine().toLowerCase();
           Boolean isTheFINALAnswerCorrect = Objects.equals(correctWord, lastTry);
           if(isTheFINALAnswerCorrect){
               isAnswerCorrect = true;
               System.out.println("Finally you won");
               break;
           }
           tries--;
           if(tries ==0){
               System.out.println("Laters sucker");
               break;
           }
       }
    }
    public static void stageTwo(){

    }
    public static void stageThree(){

    }
    public static void exitGame(String input){
        System.out.printf("Bye %s", input);
    }
    public static int getRandomItem(String[] input){
        Integer randomValue = new Random().nextInt(input.length);
        return randomValue;
    }
}
