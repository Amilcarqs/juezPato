import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
public class ejercicio_Dijkstra {
    static public class GrafoLA {
        private int n; // Número de vértices
        class Par implements Comparable<Par> {
            public Par padre = null;
            public int vertice;
            public int peso;
            public Par(int vertice, int peso){
            this.vertice = vertice;
            this.peso = peso;
            }
            @Override
            public int compareTo(Par o) {
            if (this.peso != o.peso)
            return this.peso - o.peso;
            else
            return this.vertice - o.vertice;
            }
            @Override
            public String toString() {
            return "(" + this.vertice + ", " + this.peso + ")";
            }
        }
        ArrayList < ArrayList <Par> > lista; // Lista de Adyacencias

        public GrafoLA(int n) {
            this.lista = new ArrayList<ArrayList<Par>>();
            for (int i = 0; i <= n; i++) // 0..n
            this.lista.add(new ArrayList<Par>());
            this.n = n;
        }
        public void adiArco(int u, int v, int peso) {
            this.lista.get(u).add(new Par(v, peso));
        }

        public ArrayList<Integer> dijkstra(int verticeInicial) {
            final int INFINITO = Integer.MAX_VALUE;
            int u, v, peso;
            /* Se etiqueta las distancias de todos los vértices */
            ArrayList<Integer> distancia = new ArrayList<Integer>();
            distancia.addAll(Collections.nCopies(n + 1, INFINITO)); // Etiquetas
            distancia.set(verticeInicial, 0); // vértice inicial
            /* Se etiqueta el camino mínimo (nodo padre) de todos los vértices */
            ArrayList<Integer> camino_minimo = new ArrayList<Integer>();
            camino_minimo.addAll(Collections.nCopies(n + 1, 0));
            /* Se inserta el vertice inicial en la cola de prioridad */
            PriorityQueue<Par> cp = new PriorityQueue<Par>();
            cp.add(new Par(verticeInicial, 0));
            while (!cp.isEmpty()) {
                /*
                * Se extrae u de la cola de prioridad (u tiene la distancia mínima)
                */
                Par nodo_u = cp.poll();
                int d = nodo_u.peso;
                u = nodo_u.vertice;
                /* ... (u, di) ... (u, dj) ... */
                /* ¿d es mayor que la distancia actual hasta u? */
                if (d > distancia.get(u))
                continue;
                Iterator it = this.lista.get(u).iterator();
                while (it.hasNext()) {
                    Par nodo_v = (Par) it.next();
                    v = nodo_v.vertice;
                    peso = nodo_v.peso;
                    /* total = distancia (hasta u) + distancia (u, v) */
                    int total = distancia.get(u) + peso;
                    if (total < distancia.get(v)) {
                        camino_minimo.set(v, u); // Actualiza el padre de v
                        distancia.set(v, total); // Actualiza la distancia de v
                        cp.offer(new Par(v, total));
                    }
                }
            }
            v = n;
            ArrayList<Integer> salida = new ArrayList<Integer>(); 
            while (v != 1) {
                salida.add(v);
                v = camino_minimo.get(v);
            }
            salida.add(v);
            return salida;
        }

        public void verGrafo() {
            for (int u = 1; u <= n; u++) {
            System.out.print(u + ": ");

                Iterator<Par> it = lista.get(u).iterator();
            while (it.hasNext())
            System.out.print(it.next());
            System.out.println();
            }
            System.out.println();
        }
    }        
    public static void main(String[] args) {      
        int n, m, a,b,c;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        GrafoLA grafo = new GrafoLA(n); // n vértices
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            grafo.adiArco(a, b, c); // (u, v, peso) (inicia en u)
        }
        ArrayList<Integer> camino =   grafo.dijkstra(1); // dijkstra(vértice de inicio)
        if(camino.isEmpty() || camino.size()==1){
            System.out.println(-1);
        }else{      
            for (int i = camino.size()-1; i >= 0; i--) {
                System.out.print(camino.get(i)+" ");
            }            
        } 
    }
}