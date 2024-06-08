//el pato no acepta este
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class ejercicio1148_Agregar {
    public static void main(String[] args) {
        int n,e,cont,suma;
        Scanner sc = new Scanner(System.in);
        while(true){
            ArrayList<Integer> b = new ArrayList<Integer>();
            n = sc.nextInt();
            if(n==0)
                break;
            while(n-- >0){
                b.add(sc.nextInt());
            }
            Collections.sort(b);
            cont = 0;
            suma = b.get(0);
            for (int i = 1; i < b.size(); i++) {
                suma = suma+b.get(i);
                cont = cont+suma;
            }
            System.out.println(cont);
            b.clear();
        }
    }
}
