import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class ejercicio1046_AdivineLaEstructura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){                    
            Stack<Integer> pila = new Stack<>();
            Queue<Integer> cola = new LinkedList<>();        
            PriorityQueue<Integer> colaP = new PriorityQueue<>(Comparator.reverseOrder());
            int n, tipo, x,aux;
            boolean[] sw = {true,true,true};
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                tipo = sc.nextInt();
                x = sc.nextInt();
                switch(tipo){
                    case 1 :
                        if(sw[0]){
                            pila.add(x);
                        }
                        if(sw[1]){
                            cola.add(x);
                        }
                        if(sw[2]){
                            colaP.offer(x);
                        }
                        break;
                    
                    case 2 :
                        if(pila.isEmpty() && cola.isEmpty() && colaP.isEmpty()){
                            sw[0]=false; sw[1]=false; sw[2] = false;
                            break;
                        }
                        if(sw[0]){
                            aux = pila.pop();
                            if(aux != x)
                                sw[0] = false;
                        }
                        if(sw[1]){
                            aux = cola.poll();
                            if(aux != x)
                                sw[1]=false;
                        }
                        if(sw[2]){
                            aux = colaP.poll();
                            if(aux!= x)
                                sw[2]=false;
                        }
                        break;
                    default:
                        break;
                }
            }
            int cont = 0;
            for(boolean b: sw){
                if(b)
                    cont++;
            }
            switch(cont){
                case 0 :
                    System.out.println("impossible");
                    break;                
                case 1 :
                    if(sw[0])
                        System.out.println("stack");
                    else if(sw[1])
                        System.out.println("queue");
                    else if(sw[2])
                        System.out.println("priority queue");
                    break;                
                default :
                    System.out.println("not sure");
                    break;               
            }
        }        
    }    
}
