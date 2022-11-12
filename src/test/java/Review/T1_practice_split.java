package Review;

import javax.security.auth.Subject;

public class T1_practice_split {
    public static void main(String[] args) {


        String subjectLine = "Automation_AI05";
        //split the string
        String[] splitMessageArray = subjectLine.split("_");
        //take the second string from the array then grab the number only
        String actionItemNumber = splitMessageArray[1].substring(2);
        //print out John to the console
        System.out.println("The action number item is " + actionItemNumber);
    }
}
