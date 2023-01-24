import java.util.Objects;
import java.util.Scanner;

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
        Boolean isAnswerCorrect = false;

        String correctWord = "Pickle";

        System.out.printf("Hello %s welcome to level 1", input);

        Scanner scanner = new Scanner(System.in);

        System.out.println("On this stage you will have 3 tries to guess the word if you can not guess the word within 3 tries you will lose BUT good news you can also ask for a hint. Are you ready? y/n");

        String userInput = scanner.nextLine();

        if(Objects.equals(userInput, "n")){
            exitGame(input);
        }

        System.out.println("Alrighty let's begin!");
    }
    public static void stageTwo(){

    }
    public static void stageThree(){

    }
    public static void exitGame(String input){
        System.out.printf("Bye %s", input);
    }
}
