import java.util.Scanner;

// PalindromeChecker class encapsulates the palindrome logic
class PalindromeChecker {

    // Method to check palindrome (case-insensitive, ignores spaces)
    public boolean checkPalindrome(String str) {

        // Normalize string: remove spaces and convert to lowercase
        String normalized = str.replaceAll("\\s+", "").toLowerCase();

        // Use internal logic with character comparison
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false; // mismatch found
            }
            start++;
            end--;
        }

        return true; // all characters matched
    }
}

public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string from user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Create an object of PalindromeChecker
        PalindromeChecker checker = new PalindromeChecker();

        // Call the checkPalindrome() method
        boolean result = checker.checkPalindrome(input);

        // Display result
        if (result) {
            System.out.println("The given string is a Palindrome (Object-Oriented Service).");
        } else {
            System.out.println("The given string is NOT a Palindrome (Object-Oriented Service).");
        }

        scanner.close();
    }
}