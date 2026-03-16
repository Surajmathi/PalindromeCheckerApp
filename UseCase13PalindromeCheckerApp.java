import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Scanner;

public class UseCase13PalindromeCheckerApp {

    // 1️⃣ Iterative palindrome check (two-pointer)
    public static boolean iterativeCheck(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = normalized.length() - 1;
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 2️⃣ Recursive palindrome check
    public static boolean recursiveCheck(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursiveCheck(str, start + 1, end - 1);
    }

    // 3️⃣ Stack-based palindrome check
    public static boolean stackCheck(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) stack.push(ch);
        for (char ch : normalized.toCharArray()) if (ch != stack.pop()) return false;
        return true;
    }

    // 4️⃣ Deque-based palindrome check
    public static boolean dequeCheck(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char ch : normalized.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // 1️⃣ Iterative
        long startTime = System.nanoTime();
        boolean iterResult = iterativeCheck(input);
        long iterTime = System.nanoTime() - startTime;

        // 2️⃣ Recursive
        startTime = System.nanoTime();
        boolean recResult = recursiveCheck(normalized, 0, normalized.length() - 1);
        long recTime = System.nanoTime() - startTime;

        // 3️⃣ Stack
        startTime = System.nanoTime();
        boolean stackResult = stackCheck(input);
        long stackTime = System.nanoTime() - startTime;

        // 4️⃣ Deque
        startTime = System.nanoTime();
        boolean dequeResult = dequeCheck(input);
        long dequeTime = System.nanoTime() - startTime;

        // Display results
        System.out.println("\n--- Palindrome Check Results ---");
        System.out.printf("Iterative: %b (Time: %d ns)\n", iterResult, iterTime);
        System.out.printf("Recursive: %b (Time: %d ns)\n", recResult, recTime);
        System.out.printf("Stack    : %b (Time: %d ns)\n", stackResult, stackTime);
        System.out.printf("Deque    : %b (Time: %d ns)\n", dequeResult, dequeTime);

        scanner.close();
    }
}