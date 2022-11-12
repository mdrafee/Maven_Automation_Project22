package day4_100922;

public class T3_SplitCommand {
    public static void main(String[] args) {
        //declare a string variable
        String message = "My name is_John";
        // extract out john frorm the string and print it
        // call split message by using string array
        String[] splitmessage = message.split(" ");
        System.out.println("result " + splitmessage[1]);

    // extracting each character from a string
        String message2 = "abc";
        String[] splitmessage2 = message2.split("");
        System.out.println("Index 2 is :" + splitmessage2[1]);

    }//end main
}// end class