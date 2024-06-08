import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String cadena = sc2.nextLine();
            LinkedList<Character> pila = new LinkedList<>();
            boolean sw = true;
            if(cadena.length()>128)
                sw = false;
            for (int j = 0; j < cadena.length() && sw && (cadena.length()<=128); j++) {
                char c = cadena.charAt(i);
                if(c == '(' || c == '['){
                    pila.addFirst(c);
                }
                else if (c==')'){
                    if(pila.isEmpty()){
                        sw = false;
                        break;
                    }
                    char aux = pila.removeFirst();
                    if(aux!='('){
                        sw = false;
                    }
                }
                else if (c==']'){
                    if(pila.isEmpty()){
                        sw = false;
                        break;
                    }
                    char aux = pila.removeFirst();
                    if(aux!='['){
                        sw = false;
                    }
                }
            }
            sw = pila.isEmpty() && sw;
            if(sw){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
