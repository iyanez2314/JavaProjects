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
        boolean isAnswerCorrect = false; // Will let us know if they entered the correct word
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
        int returnValueFromRandomFunction = getRandomItem(hintsArray);
        System.out.printf("Your first hint is %s: ", hintsArray[returnValueFromRandomFunction]);
        String firstAnswer = scanner.nextLine().toLowerCase();
        boolean isTheFirstAnswerCorrect = Objects.equals(correctWord, firstAnswer);
       while (!isAnswerCorrect){
           if(isTheFirstAnswerCorrect) {
               isAnswerCorrect = true;
               System.out.println("Congrats you won the game!");
               chooseNextLevel("step one");
               break;
           }
           tries--;
           System.out.printf("OOF you have %s tries left your next hint is %s", tries, hintsArray[returnValueFromRandomFunction]);
           String secondTry = scanner.nextLine().toLowerCase();
           boolean isTheSecondAnswerTrue = Objects.equals(correctWord, secondTry);
           if(isTheSecondAnswerTrue){
               isAnswerCorrect = true;
               System.out.println("Congrats you won the game!");
               chooseNextLevel("step one");
               break;
           }

           tries--;
           System.out.printf("bruh.. you have %s your next AND FINAL HINT IS %s", tries, hintsArray[returnValueFromRandomFunction]);
           String lastTry = scanner.nextLine().toLowerCase();
           boolean isTheFINALAnswerCorrect = Objects.equals(correctWord, lastTry);
           if(isTheFINALAnswerCorrect){
               isAnswerCorrect = true;
               System.out.println("Finally you won");
               chooseNextLevel("step one");
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
        Scanner scanner = new Scanner(System.in);
        Boolean isCorrect = false;
        int tries = 2;
        String correctWord = "sponge bob square pants"; // The correct answer
        String[] hintsArray = {"hes yellow with a lot of holes in him", "he lives in a pineapple under the sea", "his best friend is pink"};
        System.out.printf("Welcome to stage two! Here are the rules in stage two you have %s tries and you will still hints", tries);
        System.out.println("Are you ready for the stage? y/n ");
        String userInput = scanner.nextLine().toLowerCase();
        if(Objects.equals(userInput, "n")){
            exitGame();
        }
        System.out.println("Okay lets begin stage two!");
        int randomItemInArray = getRandomItem(hintsArray);
        System.out.printf("Your first hint is: %s", hintsArray[randomItemInArray]);
        String userInputToFirstQuestion = scanner.nextLine().toLowerCase();
        boolean isTheFirstAnswerCorrect = Objects.equals(correctWord, userInputToFirstQuestion);
        while(!isCorrect){
            if(isTheFirstAnswerCorrect){
                isCorrect = true;
                System.out.println("Congrats on guessing right! Would you like to continue? y/n: ");
                chooseNextLevel("step two");
            }
        }

    }
    public static void stageThree(){
        
    }
    public static void exitGame(String input){
        System.out.printf("Bye %s", input);
    }
    public static void exitGame(){
        System.out.println("See ya!");
    }
    public static int getRandomItem(String[] input){
        int randomValue = new Random().nextInt(input.length);
        return randomValue;
    }
    public static void chooseNextLevel(String input){
        Scanner scanner = new Scanner(System.in);
        switch (input){
            case "step one":
                System.out.printf("Congrats on finishing %s would you like to continue? y/n", input);
                String userResponse = scanner.nextLine();
                if(Objects.equals(userResponse, "y")){
                    stageTwo();
                }
                // exitGame();
                break;
            case "step two":
                System.out.printf("Congrats on finishing %s would you like to continue? y/n: ", input);
                String userSecondResponse = scanner.nextLine();
                if(Objects.equals(userSecondResponse, "y")){
                    stageThree();
                }
                // exitGame();
                break;
            default:
                System.out.println("I broke");
        }

    }
}
