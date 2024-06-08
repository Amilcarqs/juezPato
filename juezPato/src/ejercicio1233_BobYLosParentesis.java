import java.util.Scanner;
import java.util.Stack;
public class ejercicio1233_BobYLosParentesis { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        int x = sc.nextInt();
        sc.nextLine();          
        for (int i = 0; i < x; i++) {
            String n = sc.nextLine().trim();
            if (balanceado(n)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
    
    private static boolean balanceado(String n) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : n.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if ((ch == ')' && open != '(') || (ch == ']' && open != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
