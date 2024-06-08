//el pato acepta este
import java.util.PriorityQueue;
import java.util.Scanner;
public class ejercicioB_Agregar { 
    public static void main(String[] args) {
        Scanner lee = new Scanner(System.in);        
        while (true) {
            int x = lee.nextInt();
            if (x == 0)
                break;        
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < x; i++) {
                pq.add(lee.nextInt());
            }
            int costoTotal = 0;
            while (pq.size() > 1) {
                int num1 = pq.poll();
                int num2 = pq.poll();
                int suma = num1 + num2;
                costoTotal += suma;
                pq.add(suma);
            }
            System.out.println(costoTotal);
        }
    }
}
