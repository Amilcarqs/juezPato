
import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio_SegundoDiccionario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s ,s2;
        ArrayList<String> v = new ArrayList<>();
        String todo = sc.next();
        System.out.println("TOTOTOD: "+todo);
        while(sc.hasNext()){         
            s = sc.next();
            char aux = s.charAt(s.length()-1);
            if( aux == '-'){  
                s2="";
                while(aux=='-'){
                    s2=s2+s.substring(0,s.length()-1);
                    s=sc.next();
                    aux = s.charAt(s.length()-1);
                }
                s2=s2+s;
                System.out.println(s2);
            }
            v.add(s);
        }
        sc.close();
        System.out.println("vector: "+v);
    }
    
}
