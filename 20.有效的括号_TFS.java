
/**
 * 使用栈来实现递归依次去除整体表达式中匹配的括号。 算法： 1.初始化栈 S。 2.一次处理表达式的每个括号。
 * 3.如果遇到开括号，我们只需将其推到栈上即可。这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式。
 * 4.如果我们遇到一个闭括号，那么我们检查栈顶的元素。如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。否则，这意味着表达式无效。
 * 5.如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。
 */
import java.util.HashMap;
import java.util.Stack;

class Solution {

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;
  
    // Initialize hash map with mappings. This simply makes the code easier to read.
    public Solution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }
  
    public boolean isValid(String s) {
  
        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();
  
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
  
            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {
  
                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();
  
                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }
  
        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}