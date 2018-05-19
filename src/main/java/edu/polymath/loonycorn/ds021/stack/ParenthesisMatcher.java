package edu.polymath.loonycorn.ds021.stack;


public class ParenthesisMatcher {

  public boolean hasMatchingParens(String expression) {
    Stack<Character> stack = new Stack<Character>(50);
    for (char ch : expression.toCharArray()) {
      if (ch == '(' || ch == '[' || ch == '{') {
        stack.push(ch);
      } else if (ch == ')' && (stack.isEmpty() || stack.pop() != '(')) {
        return false;
      } else if (ch == ']' && (stack.isEmpty() || stack.pop() != '[')) {
        return false;
      } else if (ch == '}' && (stack.isEmpty() || stack.pop() != '{')) {
        return false;
      }
    }
    return stack.isEmpty();
  }

}


