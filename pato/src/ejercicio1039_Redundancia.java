//acepta el pato malo
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
public class ejercicio1039_Redundancia {
	public static void main(String[] args) throws FileNotFoundException {				
		Scanner lee = new Scanner(System.in);	
		Map<Integer,Integer> mapa= new LinkedHashMap<Integer,Integer>();                
                while (lee.hasNextInt()) {
			int numero = lee.nextInt();
			if(!mapa.containsKey(numero)) {
				mapa.put(numero, 1);
			}else {
				int cantidad = mapa.get(numero);
				mapa.put(numero, cantidad+1);
			}			
		}
		//System.out.println(mapa);		
		mapa.keySet();
		for (int obj :mapa.keySet()) {
			   System.out.println(obj + " " + mapa.get(obj)); 
		}                
	}
}
