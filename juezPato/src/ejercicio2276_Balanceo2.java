//este si acepta el pato
import java.util.Scanner;
import java.util.Stack;
public class ejercicio2276_Balanceo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String cadena;
        for (int i = 0; i < Integer.parseInt(n); i++) {
            cadena = sc.nextLine().trim();
            //System.out.println(cadena);
            if (balanceado(cadena)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }   
    }
    private static boolean balanceado(String cadena) {
        Stack<Character> pila = new Stack<>();
        char ch;
        int tamano = cadena.length();
        for (int i = 0; i < tamano && tamano<=128; i++) {
            ch = cadena.charAt(i);
            if (ch == '(' || ch == '[') {
                pila.push(ch);
            } else if (ch == ')' || ch == ']') {
                if (pila.isEmpty()) {
                    return false;
                }
                char open = pila.pop();
                if ((ch == ')' && open != '(') || (ch == ']' && open != '[')) {
                    return false;
                }
            }else{
                return false;
            }
        }
        return pila.isEmpty();
    }    
}
