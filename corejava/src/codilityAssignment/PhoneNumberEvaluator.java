package codilityAssignment;

import java.util.Scanner;

public class PhoneNumberEvaluator {
	public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        System.out.print("Please input a number: ");
        String userInput = number.nextLine();
        int memoryScore = assessNumber(userInput);
        System.out.println("Memory score for " + userInput + ": " + memoryScore);
    }

    public static boolean isSymmetric(String num) {
        int length = num.length();
        for (int i = 0; i < length / 2; i++) {
            if (num.charAt(i) != num.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
     public static boolean hasRepeatingDigits(String num) {
        char firstChar = num.charAt(0);
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) != firstChar) {
                return false;
            }
        }
        return true;
    }
     
public static int assessNumber(String num) {
        int score = 0;
        int length = num.length();
        if (length <= 4) {
            score += 5; 
        } else if (length <= 6) {
            score += 3;  
        } else if (length <= 8) {
            score += 2; 
        } else {
            score += 1; 
        }
        if (isSymmetric(num)) {
            score += 3;  
        }
        if (hasRepeatingDigits(num)) {
            score += 2;  
        }
        return score;
    }
}
