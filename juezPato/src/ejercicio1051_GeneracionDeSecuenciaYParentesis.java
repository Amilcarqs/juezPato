import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class ejercicio1051_GeneracionDeSecuenciaYParentesis { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> li = new ArrayList<>();        
        while (sc.hasNextInt()) {
            li.add(sc.next());
        }        
        for (String x : li) {
            int n = Integer.parseInt(x);
            List<String> resuelto = new ArrayList<>();
            par(resuelto, "", 0, 0, n);
            Collections.sort(resuelto);
            for (String c : resuelto) {
                System.out.println(c);
            }
        }
    }
    
    private static void par(List<String> resuelto, String z, int open, int close, int max) {
        if (z.length() == max * 2) {
            resuelto.add(z);
            return;
        }
        if (open < max) {
            par(resuelto, z + "(", open + 1, close, max);
        }
        if (close < open) {
            par(resuelto, z + ")", open, close + 1, max);
        }
    }
}