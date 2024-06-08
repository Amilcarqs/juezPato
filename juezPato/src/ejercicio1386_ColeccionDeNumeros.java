import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
public class ejercicio1386_ColeccionDeNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   
        PriorityQueue<Integer> cola = new PriorityQueue<>(Comparator.reverseOrder());
        String opcion;        
        int elemento, incremento, decremento,aux;
        while(true){
            opcion = sc.next();
            switch(opcion) {
                case "S":
                    elemento  = sc.nextInt();
                    cola.offer(elemento);
                    break;
                case "A":
                    if(!cola.isEmpty()){
                        System.out.println(cola.peek());
                    }else{
                        System.out.println("Error");
                    }
                    break;
                case "R":
                    if(!cola.isEmpty()){
                        cola.poll();
                    }else{
                        System.out.println("Error");
                    }
                    break;
                case "I":
                    if(!cola.isEmpty()){
                        incremento = sc.nextInt();
                        aux = cola.poll()+incremento;
                        cola.offer(aux);
                    }else{
                        System.out.println("Error");
                    }
                    break;
                case "D":
                    if(!cola.isEmpty()){
                        decremento = sc.nextInt();                        
                        aux = cola.poll()-decremento;
                        cola.offer(aux);
                    }else{
                        System.out.println("Error");
                    }
                    break;
                case "T":
                    break;
                default:
                    break;
            }
            if(opcion.equals("T"))
                break;
        }
    }
}
