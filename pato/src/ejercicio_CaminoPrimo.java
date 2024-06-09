
import java.util.Scanner;


public class ejercicio_CaminoPrimo {

    static boolean esPrimo(int n){
        int raiz = (int)(Math.sqrt(n));
        for (int i = 2; i < raiz; i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1000;
        int m = 1999;
        for (int i = n; i <= m; i++) {
            if(esPrimo(i))
                System.out.println(i);
        }
        while(sc.hasNext()){
            n = sc.nextInt();
            /*
            int m = sc.nextInt();
            for (int i = n; i <= m; i++) {
                if(esPrimo(n))
                    System.out.println(i);
            }}*/
            if(esPrimo(n))
                System.out.println("primo");
            else
                System.out.println("no primo");
        }           
            
        
    }
    
}
