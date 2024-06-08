import java.util.Scanner;
import java.util.Stack;
public class ejercicio1107_Monton {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        while (sc.hasNext()){
            Stack<Integer> pila = new Stack<>();            
            String cadena = sc.nextLine();
            int a,b;
            for (char letra : cadena.toCharArray()) {
                if((int)letra >= 48){
                    pila.add(letra - '0');
                }else{
                    a = pila.pop();
                    b = pila.pop();
                    switch(letra){
                        case '+':
                            pila.add(a+b);
                            break;
                        case '*':
                            pila.add(a*b);
                            break;
                        default:
                            break;                        
                    }
                }   
            }
            System.out.println(pila.peek());         
        }
    }
}
