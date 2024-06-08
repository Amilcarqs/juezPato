import java.util.PriorityQueue;
import java.util.Scanner;
public class ejercicio1176_BancoVitalicio {
    public static class Persona implements Comparable<Persona>{
        private int hora;
        private String edad;
        public Persona(int hora, String e){
            this.hora  = hora;
            this.edad = e;
        }
        @Override
        public String toString() {
            return "Persona{" + "hora=" + hora + ", edad=" + edad + '}';
        }
        public int compareTo(Persona x){
            if(this.hora==x.hora){
                return x.edad.compareTo(this.edad);
            }
            return this.hora - x.hora;
        } 
        public int getHora() {
            return hora;
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){            
            PriorityQueue<Persona> personas = new PriorityQueue<>();        
            int limite, n ,  promedio, hora, cont;
            String edad; 
            n = sc.nextInt();
            limite = sc.nextInt();
            promedio = sc.nextInt();
            for (int i = 0; i < n; i++) {
                hora = sc.nextInt();
                edad = sc.next();
                personas.offer(new Persona(hora,edad));
            }
            cont = personas.peek().getHora();       
            while(cont < limite & promedio<limite){
                Persona p = personas.poll();
                cont+=promedio;
                System.out.println(cont);
                if((cont+promedio) > limite){
                    break;
                }
            }
            while(!personas.isEmpty()){
                personas.poll();
                System.out.println("Mil disculpas, regrese mañana");          
            }            
        }  
    }   
}
