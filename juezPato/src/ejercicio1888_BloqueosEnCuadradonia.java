//acepta el pato
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class ejercicio1888_BloqueosEnCuadradonia {
    static int nodes = 1000;
    static char grafo[][] = new char[nodes][nodes];
    static int visit[][] = new int[nodes][nodes];
    static int n;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            n = in.nextInt();
            if (n == 0)
                break;

            int ix = in.nextInt();
            int iy = in.nextInt();
            int fx = in.nextInt();
            int fy = in.nextInt();
            for(int i = 0; i < n; i++) {
                String cad = in.next();
                for(int j = 0; j < n; j++) {
                    grafo[i][j] = cad.charAt(j);
                }
            }

//            bfs(ix, iy);
//            String ans = "HAY RUTA POSIBLE";
//            if (visit[fx][fy] == -1) {
//                ans = "NO " + ans;
//            }
//            System.out.println(ans);

            if (check(ix, iy)) {
                for(int i = 0; i < n; i++)
                    for(int j = 0; j < n; j++)
                        visit[i][j] = -1;
                dfs(ix, iy);
                String ans = "HAY RUTA POSIBLE";
                if (visit[fx][fy] == -1) {
                    ans = "NO " + ans;
                }
                System.out.println(ans);
            } else {
                System.out.println("NO HAY RUTA POSIBLE");
            }

        }
    }

    public static boolean check(int i, int j) {
        return i >= 0 && i < n && j < n && j >= 0 && grafo[i][j] == 'L';
    }

    public static void dfs(int start_x, int start_y) {
        visit[start_x][start_y] = 0;
        for(int i = 0; i < 4; i++) {
            int vx = start_x + dx[i];
            int vy = start_y + dy[i];
            if (check(vx, vy) && visit[vx][vy] == -1) {
                dfs(vx, vy);
            }
        }
    }

    public static void bfs(int start_x, int start_y) {

        // O(n)
        for(int i = 0; i < nodes; i++) {
            for(int j = 0; j < nodes; j++) {
                visit[i][j] = -1; // no lo visite
            }
        }
        visit[start_x][start_y] = 0; // ya lo visite
        Queue<Integer> q = new LinkedList<>();
        if (check(start_x, start_y)) {
            q.add(start_x);
            q.add(start_y);
        }

        // O(n + m)
        while(!q.isEmpty()) {
            int ux = q.poll();
            int uy = q.poll();
            for(int i = 0; i < 4; i++) {
                int vx = ux + dx[i];
                int vy = uy + dy[i];
                if (check(vx, vy) && visit[vx][vy] == -1) {
                    visit[vx][vy] = visit[ux][uy] + 1;
                    q.add(vx);
                    q.add(vy);
                }
            }
        }
    }
}