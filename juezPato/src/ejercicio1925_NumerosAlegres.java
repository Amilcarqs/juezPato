import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
public class ejercicio1925_NumerosAlegres {
    public static List<Long> genNumAlegr(long limite) {
        List<Long> numsAlegr = new ArrayList<>();
        Queue<String> cola = new LinkedList<>();
        for (long i = 1; i <= 9; i++) {
            cola.offer(String.valueOf(i));
        }
        while (numsAlegr.size() < limite) {
            String num = cola.poll();
            numsAlegr.add(Long.parseLong(num));            
            int ultDig = num.charAt(num.length() - 1) - '0';
            if (ultDig > 0) {
                cola.offer(num + (ultDig - 1));
            }
            cola.offer(num + ultDig);
            if (ultDig < 9) {
                cola.offer(num + (ultDig + 1));
            }
        }       
        return numsAlegr;
    }
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        List<Integer> cons = new ArrayList<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            cons.add(sc.nextInt());
        }
        long maxCons = Collections.max(cons);
        List<Long> numAleg = genNumAlegr(maxCons);
        for (int i = 0; i < cons.size(); i++) {
            int consulta = cons.get(i);
            System.out.println(numAleg.get(consulta - 1));
        }
    }    
}