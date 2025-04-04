package codilityAssignment;

import java.util.Scanner;

public class PasswordStrengthChecker {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        String strength = evaluatePasswordStrength(password);
        System.out.println("Password Strength: " + strength);
    }

    public static String evaluatePasswordStrength(String password) {
        if (password.length() < 6) {
            return "Weak";  
        }

        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        String specialChars = "!@#$%^&*()-+=<>?/{}[]|";

        for (char ch : password.toCharArray()) {
            if (Character.isLetter(ch)) {
                hasLetter = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (specialChars.contains(String.valueOf(ch))) {
                hasSpecialChar = true;
            }
        }

        if (password.length() >= 8 && hasLetter && hasDigit && hasSpecialChar) {
            return "Strong";  
        } else if (hasLetter && hasDigit && password.length() >= 6) {
            return "Moderate";  
        } else {
            return "Weak";  
        }
    }
}
