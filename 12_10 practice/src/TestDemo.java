import java.util.Stack;

public class TestDemo {
    //括号匹配问题
    public  static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{'|| ch == '[') {
                stack.push(ch);
            }else {
                if(stack.empty()) {
                    System.out.println("右括号多");
                    return false;
                }
                char top = stack.peek();
                if(top == '(' && ch == ')' ||
                        top == '{' && ch == '}'||
                        top == '[' && ch == ']' ){
                    stack.pop();
                }else {
                    System.out.println("右括号匹配错误！");
                    return false;
                }
            }
        }
        if(!stack.empty()) {
            System.out.println("左括号多！");
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "{()}";
        System.out.println(isValid(str));
    }
}
