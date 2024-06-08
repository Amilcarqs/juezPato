//acepta el pato
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class ejercicio1075_Foquitos {
    static class Grafo {
    private int V; // Número de vértices
    private LinkedList<Integer> listaAdy[]; // Lista de adyacencia
    // Constructor
    Grafo(int v) {
        V = v+1;
        listaAdy = new LinkedList[v+1];
        for (int i=1; i<=v; ++i)
            listaAdy[i] = new LinkedList();
    }    
    // Método para agregar una arista al grafo
    void agregarArista(int v, int w) {
        listaAdy[v].add(w); // Agregar w a la lista de v
        //listaAdy[w].add(v); // Agregar v a la lista de w
    }    
    // Método para imprimir el grafo
    void imprimirGrafo() {
        for (int i=1; i<V; ++i) {
            if(!listaAdy[i].isEmpty()){
                System.out.println("Lista de adyacencia del vértice " + i);
                System.out.print("head");

                for (Integer nodo : listaAdy[i]) {
                    System.out.print(" -> " + nodo);
                }
                System.out.println("\n");
            }
        }
    }    
    public void quema(ArrayList<Integer> a,int n){
        while(n!=1){            
            if(a.get(n)==1){
                break;
            }else{                
                a.set(n, 1);
                //System.out.println("quemando: "+n);
                n = this.listaAdy[n].get(0);
            }            
        }            
    }            
} 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);        
        int t,n, q, a , b;
        t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            ArrayList<Integer> totalQuemados = new ArrayList<Integer>(); //para contar los quemados
            n = sc.nextInt();
            q = sc.nextInt();
            Grafo g = new Grafo(n);
            for (int i = 0; i < n+1; i++) {
                totalQuemados.add(0);
            }        
            for (int i = 0; i < n-1; i++) {
                a = sc.nextInt();
                b = sc.nextInt();
                g.agregarArista(b, a);
            }
            totalQuemados.set(1, 1);
            for (int i = 0; i < q; i++) {
                a = sc.nextInt();
                g.quema(totalQuemados,a);
            }
            //System.out.println(totalQuemados);
            System.out.println(totalQuemados.stream().reduce(0, Integer::sum));
        }        
    }
}

