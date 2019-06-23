import java.util.*;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
public class ValidParentheses {
    public boolean isValid(String str) {

        if ( str.length() == 0 ) {
            return true;
        }

        Map<Character,Character> map = new HashMap<>();
        map.put('[',']');
        map.put('(',')');
        map.put('{','}');

        Stack<Character> stack = new Stack<>();

        for ( int index=0;index<str.length();index++ ) {
            char ch = str.charAt(index);
            if ( map.containsKey(ch)) {
                stack.push(ch);
                continue;
            }
            if ( stack.isEmpty() ) {
                return false;
            }

            if ( map.get(stack.pop()) != ch ) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
