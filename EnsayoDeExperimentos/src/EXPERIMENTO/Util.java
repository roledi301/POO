package EXPERIMENTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Util {
	//dado el 	nombre de un fichero devuelva una lista de String con
	//cada cadena una línea de dicho fichero
	public static List<String> leeFicheroPorLinea(String fileName) {
		List<String> res= new LinkedList<String>();
		try {
		Scanner sc = new Scanner(new File(fileName));
		while (sc.hasNextLine()) {
		res.add(sc.nextLine());
		}
		sc.close();
		} catch (FileNotFoundException e) {
		System.out.println("Fichero no encontrado");
		}
		return res;
		}
	public static <K,T> Map<K, T> invierteMap(Map<T, K> m){
		Map<K, T> mapinv= new HashMap<K, T>();
		Set<T> conj=m.keySet();
		for (T ti: conj){
		K ki= m.get(ti);
		if (mapinv.containsKey(ki)){
		mapinv.put(ki,ti);
		}
		else{
		T tiAux=ti;
		mapinv.put(ki,tiAux);
		}
		}
		return mapinv;
		}
}
