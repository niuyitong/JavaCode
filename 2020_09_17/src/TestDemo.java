import java.util.*;
public class TestDemo {
    public static void main1(String[] args) {
        System.out.println(isValid("[](})"));
    }
    private static boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);
            if(tmp=='(' || tmp=='{' || tmp=='[' )
                stack.push(tmp);
            else{
                if( (!stack.empty()) && (tmp==')' && stack.peek()=='('
                        || tmp=='}' && stack.peek()=='{'
                        ||tmp==']' && stack.peek()=='[')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(stack.empty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,3,4,3,5,6};
        System.out.println(maxLength(arr));
    }
    public static int maxLength (int[] arr) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        for(int i=0; i<arr.length; i++){
            left = i;
            right = i+1;
            set.add(arr[i]);
            int j = i+1;
            for(; j<arr.length; j++,right++){
                if(set.contains(arr[j])){
                    set.clear();
                    if(right-left>max){
                        max = right-left;
                    }
                    break;
                }else{
                    set.add(arr[j]);
                }
            }
            if(j!=arr.length){
                while(i<arr.length && arr[i]!=arr[j]){
                    i++;
                }
            }else{
                if(right-left>max){
                    max = right-left;
                }
                break;
            }
        }
        return max;
    }
}
