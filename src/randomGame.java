public class randomGame {
    public static void main(String[] args) {
        String string = "The best of both worlds";
        countCharacters(string);
        countCharacters();
        int returnValue = multiplyMe(25);
        System.out.println(returnValue);
    }

    public static void countCharacters(String string){
        int count = 0;
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) != ' ')
                count++;

        }
        System.out.println("Total number of characters in a string: " + count);
    }

    public static void countCharacters(){
        System.out.println("There is no string for me to count");
    }

    public static int multiplyMe(int inputNumber){
        if(inputNumber == 25){
            System.out.println("Sorry I hate 25");
            return 0;
        } else {
            return (inputNumber * inputNumber);
        }

    }

    public static void divideString (String inputString){
    }
}
