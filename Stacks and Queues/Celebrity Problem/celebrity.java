import java.util.*;

/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/

//TC - O(N)  SC - O(N)
public class celebrity {
    public static int findCelebrity(int n) {
        // Initialize the stack
        Stack<Integer> stack = new Stack<>();

        // Push all the ids of the person on the stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // While we have more than one person on the stack
        while (stack.size() > 1) {
            // We pop two persons from the stack
            int first = stack.pop();
            int second = stack.pop();

            // If first knows second, then first can't be the celebrity, so push second back
            // on stack
            if (Runner.knows(first, second)) {
                stack.push(second);
            }
            // If first doesn't know second, second can't be celebrity, push first on stack
            else {
                stack.push(first);
            }
        }

        // Pop the potential celebrity from the stack
        int celebrity = stack.pop();

        // Now we go through all the persons again
        for (int i = 0; i < n; i++) {
            // If the person is not the celebrity itself
            if (i != celebrity) {
                // If this celebrity knows someone oe someone doesn't knnow this celebrity,
                // return -1
                if (Runner.knows(celebrity, i) || !Runner.knows(i, celebrity)) {
                    return -1;
                }
            }
        }

        // Else our potential candidate will be the celebrity, return it
        return celebrity;
    }
}