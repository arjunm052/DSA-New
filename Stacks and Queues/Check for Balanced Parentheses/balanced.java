import java.util.*;

public class balanced {

    // TC - O(Length Of String) SC - O(N)
    public static boolean isValidParenthesis(String expression) {
        // Convert the given string to char array
        char[] str = expression.toCharArray();
        // Initialize a stack
        Stack<Character> stack = new Stack<>();

        // Traverse through the array
        for (char c : str) {
            // If the character is an opening bracket push it on the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // If it is a closing bracket, then pop an element from the stack and check
            // whether it is a matching opening bracket, if it isn't then return false. If
            // the stack is empty then also return false
            else if (c == ')') {
                if (stack.isEmpty())
                    return false;
                if (!stack.isEmpty() && stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty())
                    return false;
                if (!stack.isEmpty() && stack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty())
                    return false;
                if (!stack.isEmpty() && stack.pop() != '{') {
                    return false;
                }
            }
        }

        // If the stack is empty after traversing through the array, then expression is
        // balanced, we can return true
        return stack.isEmpty();
    }
}