//este no acepta el pato
import java.util.Scanner;
import java.util.Stack;
public class ejercicio2276_BalanceoEntreParentesis {
    public static void main(String[] args) {
        String cadena;
        int i, tamano, n;
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Stack<Character> p = new <Character>Stack();
        n = sc.nextInt();
        for (int j = 0; j < n; j++) {
            cadena = sc2.nextLine();
            i = 0;
            tamano = cadena.length();
            while(i <tamano){
                char c = cadena.charAt(i);
                if (c == '(' || c=='[') {
                    p.push(c);               
                }else{
                    if(p.isEmpty())
                        break;
                    else{
                        char c2 = p.pop();
                        //System.out.println(c2+"num: "+(int)c2);
                        if((int)c2 != ((int)c)-1 && (int)c2 != ((int)c)-2 ){
                            break;
                        }
                    }

                } 
                i++;
            }
            if(p.isEmpty() && i == tamano){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
            p.clear();
        }                  
    }    
}
