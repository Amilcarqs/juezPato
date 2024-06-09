//axepta el pato malo
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class ejercicio1118_SegundoDiccionario {
    public static void main(String[] args) {
        Set<String> palabras = new TreeSet<String>();
        Scanner sc = new Scanner(System.in);
        String s ,s2;
        while(sc.hasNext()){         
            s = sc.next();
            char aux = s.charAt(s.length()-1);
            if(aux == '-'){  
                s2="";
                while(aux=='-'){
                    s2=s2+s.substring(0,s.length()-1);
                    s=sc.next();
                    aux = s.charAt(s.length()-1);
                }
                if(aux=='.' || aux==','){
                        s = s.substring(0,s.length()-1);
                }
                s=s2+s;
            }else if(aux =='.' || aux==','){
                s=s.substring(0,s.length()-1);
            }
            s = s.toLowerCase();
            palabras.add(s);
            //System.out.println("v: "+ palabras);
        }
        sc.close();
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }    
}