import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    // Recursive function to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {
        // Base condition
        if (start >= end) {
            return true;
        }

        // Compare characters
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize string: remove spaces & convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(normalized, 0, normalized.length() - 1);

        if (result) {
            System.out.println("The given string is a Palindrome (ignoring case & spaces).");
        } else {
            System.out.println("The given string is NOT a Palindrome (ignoring case & spaces).");
        }

        scanner.close();
    }
}