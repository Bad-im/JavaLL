package com.mkyong.examples.Chapter8.VariantC;

public class StrongPasswordChecker {

    public static void main(String[] args) {
        String password = "YourPassword123_";
        boolean isStrong = isStrongPassword(password);

        if (isStrong) {
            System.out.println("Пароль является сильным.");
        } else {
            System.out.println("Пароль не является сильным.");
        }
    }

    public static boolean isStrongPassword(String password) {
        if (password.length() < 10) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasValidChar = true;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (c != '_') {
                hasValidChar = false;
                break;
            }
        }

        return hasUpperCase && hasLowerCase && hasDigit && hasValidChar;
    }
}
