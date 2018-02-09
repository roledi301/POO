package EXPERIMENTO;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

public class TestEnsayo {

	public static void main(String[] args) {
		
		Ensayo ensayo = new EnsayoImpl();
		
//		Ejercicio 1. Carga de la información realizada
		//
		ensayo.cargaFichero("test1.txt", "test2.txt");
		//ensayo.imprimirMapa();
		
//		Ejercicio 2. El tamaño medio de las bacterias del ensayo es: 1.4
		 Double tam = ensayo.tamañoMedio(); 
		 System.out.println("2-El tamaño medio de las bacterias del ensayo es: "+tam);
		 
//		Ejercicio 3. La bacteria con mayor diversidad de formas es: Klebsiella 255 2.2 [FILAMENTOS, ESFERAS, BARRAS, SACACORCHOS, HELICES]
		 Bacteria bacteria = ensayo.mayorDiversidad(); 
		 System.out.println("3-La bacteria con mayor diversidad de formas es: "+bacteria);
//		 
////		Ejercicio 4. ¿Hay experimentos con fechas posteriores al dia 25 de enero de 2012? true
		LocalDate fecha = LocalDate.of(2012,01,25);
		Boolean res = ensayo.fechaExperimentos(fecha);
		System.out.println("4.a-¿Hay experimentos con fechas posteriores al dia 25 de enero de 2012?"+res);
		
////		Ejercicio 4. ¿Hay experimentos con fechas posteriores al dia 25 de enero de 2018? false
		
		LocalDate fecha2 = LocalDate.of(2018,01,25);
		Boolean res2 = ensayo.fechaExperimentos(fecha2);
		System.out.println("4.b-¿Hay experimentos con fechas posteriores al dia 25 de enero de 2018?"+res2);
		
////		Ejercicio 5. ¿Dada la forma SACACORCHOS devolver la bacteria con esta forma y mayor num de experimentos: Klebsiella
		FormaBacteria f1 = FormaBacteria.SACACORCHOS;
		String nom = ensayo.BacteriaMayorExp ( f1);
		System.out.println("5-Dada la forma SACACORCHOS devolver la bacteria con esta forma y mayor num de experimentos:"+nom);
		
////		Ejercicio 6. Cuenta experimentos por bacteria: {Escherichia 524 1.0 [ESFERAS, SACACORCHOS]=1, Pseudomonas 125 2.0 [BARRAS, SACACORCHOS]=5, sStreptococcus 321 1.0 [FILAMENTOS, ESFERAS]=1, Enterococcus 123 0.8 [FILAMENTOS, BARRAS, HELICES]=2, Klebsiella 255 2.2 [FILAMENTOS, ESFERAS, BARRAS, SACACORCHOS, HELICES]=6}
		
		Map<Bacteria, Integer> mapa =  ensayo.BacteriaNumExp(); 
		
		 System.out.println("6-Cuenta experimentos por bacteria:");// + mapa.toString());
		 Iterator it = mapa.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry e = (Map.Entry)it.next();
					System.out.println(e.getKey() + " ---> " + e.getValue());
				}
		 
////		Ejercicio 7. Bacterias con experimento en esa fecha: [Klebsiella 255 2.2 [FILAMENTOS, ESFERAS, BARRAS, SACACORCHOS, HELICES], Escherichia 524 1.0 [ESFERAS, SACACORCHOS]]
		 
		 LocalDate fAux = LocalDate.of(2015,12,03);
		 SortedSet<Bacteria> conjOrdenado= ensayo.ExpFechaOrden(fAux);	
		 System.out.println("7-Bacterias con experimento en esa fecha:" +conjOrdenado);	
		 
////		Ejercicio 8. Número de experimentos por bacteria: 6
		 Integer max = ensayo.numMaxExpPorBacteria();
		System.out.println("8-Número de experimentos por bacteria:" +max);	
		 
////		Ejercicio 9. Bacteria relacionada con mayor valor medio de experimento: {Escherichia 524 1.0 [ESFERAS, SACACORCHOS]=3.2, Pseudomonas 125 2.0 [BARRAS, SACACORCHOS]=5.7272727272727275, sStreptococcus 321 1.0 [FILAMENTOS, ESFERAS]=3.2666666666666666, Enterococcus 123 0.8 [FILAMENTOS, BARRAS, HELICES]=2.466666666666667, Klebsiella 255 2.2 [FILAMENTOS, ESFERAS, BARRAS, SACACORCHOS, HELICES]=3.7142857142857144}
		 Map<Bacteria, Double> mapa2 = ensayo.mayorValorMedioConjExp (); 
		 System.out.println("9-Bacteria relacionada con mayor valor medio de experimento: ");//+mapa2.toString());
		 Iterator it2 = mapa2.entrySet().iterator();
			while (it2.hasNext()) {
				Map.Entry e = (Map.Entry)it2.next();
				System.out.println(e.getKey() + " ---> " + e.getValue());
			}
	 
		 
		 
		 
////		Ejercicio 10. Existe la bacteria 555 con experimentos realizados el 3 del 12 2015?: false
		 String f3 = "3-12-2015"; 
			
			LocalDate fecha3 = LocalDate.of(2015,12,03);
		 Boolean res3 = ensayo.ExpBacteria(fecha3, 555);
		 System.out.println("10.a-Existe la bacteria 555 con experimentos realizados el 3 del 12 2015?:"+res3);
//
////		Ejercicio 10. Existe la bacteria 255 con experimentos realizados el 5 del 12 2015?: true
		 String f4 = "5-12-2015"; 
		
			LocalDate fecha4 = LocalDate.of(2015,12,05);
		 Boolean res4 = ensayo.ExpBacteria(fecha4, 255);
		 System.out.println("10.b-Existe la bacteria 255 con experimentos realizados el 5 del 12 2015?:"+res4);

	}

}
