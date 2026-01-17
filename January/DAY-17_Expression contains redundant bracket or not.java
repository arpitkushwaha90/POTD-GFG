class Solution {
    public static boolean checkRedundancy(String s) {
       
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                stack.push(ch);
            }
            else if (ch == ')') {
                boolean hasOperator = false;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }

                if (!stack.isEmpty()) {
                    stack.pop(); 
                }

                if (!hasOperator) {
                    return true;
                }
            }
        }

        return false;
    }
}
