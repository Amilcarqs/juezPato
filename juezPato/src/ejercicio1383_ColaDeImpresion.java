import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
public class ejercicio1383_ColaDeImpresion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t, n, e, m;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            ArrayList<Integer> cola = new ArrayList<>();
            PriorityQueue<Integer> colaP = new PriorityQueue<>(Comparator.reverseOrder());
            n = sc.nextInt();
            m = sc.nextInt();
            for (int j = 0; j < n; j++) {
                e = sc.nextInt();
                cola.add(e);
                colaP.offer(e);
            }
            int tiempo = 0;
            //System.out.println(cola);
            while(true) {
                if(colaP.peek() == cola.get(0)){
                    if(m==0){
                        tiempo++;
                        break;
                    }else{
                        colaP.poll();
                        cola.remove(0);
                        tiempo++;
                        m--;
                    }
                }else{
                    e = cola.remove(0);
                    cola.add(e);                    
                    if(m==0){
                        m = cola.size()-1;
                    }else{
                        m--;
                    }
                }
                //System.out.println(cola);
            }
            System.out.println(tiempo);
        }
    }
}
//otra solucion (de CHATGPT ggggg)
/*
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class ejercicio1383_ColaDeImpresion {
    static class PrintJob {
        int position;
        int priority;        
        PrintJob(int position, int priority) {
            this.position = position;
            this.priority = priority;
        }
    }
    public static void main(String[] args) {
        Scanner lee = new Scanner(System.in);        
        int t = lee.nextInt();       
        for (int i = 0; i < t; i++) {
            int n = lee.nextInt();
            int m = lee.nextInt();
            Queue<PrintJob> q = new LinkedList<>();
            int[] priorities = new int[n];            
            for (int j = 0; j < n; j++) {
                int priority = lee.nextInt();
                priorities[j] = priority;
                q.add(new PrintJob(j, priority));
            }            
            int time = 0;            
            while (!q.isEmpty()) {
                PrintJob currentJob = q.poll();
                boolean hasHigherPriority = false;
                
                for (PrintJob job : q) {
                    if (job.priority > currentJob.priority) {
                        hasHigherPriority = true;
                        break;
                    }
                }                
                if (hasHigherPriority) {
                    q.add(currentJob);
                } else {
                    time++;
                    if (currentJob.position == m) {
                        System.out.println(time);
                        break;
                    }
                }
            }
        }
    }        
}
*/