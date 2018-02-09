/*package EXPERIMENTO;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Test  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Enterococcus 123 0.8 FILAMENTOS BARRAS HELICES"; 
		Bacteria b = new BacteriaImpl(s);
		System.out.println(b); 
		String s1 = "123:2015-12-01:2 4 5 2 3 1 1 1 1 1 2 4 3 4 3";
		Experimento e = new ExperimentoImpl(s1); 
		System.out.println(e); 
				
		
		
		
//		Ejercicio 1. Carga de la información realizada
		Ensayo ensayo = new EnsayoImpl();
		ensayo.cargaFichero("test1.txt", "test2.txt");
		
//		Ejercicio 2. El tamaño medio de las bacterias del ensayo es: 1.4
		 Double tam = ensayo.tamañoMedio(); 
		 System.out.println("El tamaño medio de las bacterias del ensayo es: "+tam);
		 
//		Ejercicio 3. La bacteria con mayor diversidad de formas es: Klebsiella 255 2.2 [FILAMENTOS, ESFERAS, BARRAS, SACACORCHOS, HELICES]
		 Bacteria bacteria = ensayo.mayorDiversidad(); 
		 System.out.println("La bacteria con mayor diversidad de formas es: "+bacteria);
		 
//		Ejercicio 4. ¿Hay experimentos con fechas posteriores al dia 25 de enero de 2012? true
		String f = "25-01-2012"; 
		List<String> laux = Arrays.asList(f.split("-"));
		LocalDate fecha = LocalDate.of(new Integer(laux.get(0).trim()),
				new Integer(laux.get(1).trim()), new Integer(laux.get(2).trim()));
		Boolean res = ensayo.fechaExperimentos(fecha);
		System.out.println("¿Hay experimentos con fechas posteriores al dia 25 de enero de 2012?"+res);
		
//		Ejercicio 4. ¿Hay experimentos con fechas posteriores al dia 25 de enero de 2018? false
		String f2 = "25-01-2018"; 
		List<String> laux2 = Arrays.asList(f2.split("-"));
		LocalDate fecha2 = LocalDate.of(new Integer(laux.get(0).trim()),
				new Integer(laux.get(1).trim()), new Integer(laux.get(2).trim()));
		Boolean res2 = ensayo.fechaExperimentos(fecha2);
		System.out.println("¿Hay experimentos con fechas posteriores al dia 25 de enero de 2018?"+res2);
		
//		Ejercicio 5. ¿Dada la forma SACACORCHOS devolver la bacteria con esta forma y mayor num de experimentos: Klebsiella
		FormaBacteria f1 = FormaBacteria.SACACORCHOS;
		String nom = ensayo.BacteriaMayorExp ( f1);
		System.out.println("Dada la forma SACACORCHOS devolver la bacteria con esta forma y mayor num de experimentos:"+nom);
		
//		Ejercicio 6. Cuenta experimentos por bacteria: {Escherichia 524 1.0 [ESFERAS, SACACORCHOS]=1, Pseudomonas 125 2.0 [BARRAS, SACACORCHOS]=5, sStreptococcus 321 1.0 [FILAMENTOS, ESFERAS]=1, Enterococcus 123 0.8 [FILAMENTOS, BARRAS, HELICES]=2, Klebsiella 255 2.2 [FILAMENTOS, ESFERAS, BARRAS, SACACORCHOS, HELICES]=6}
		 Map<Bacteria, Integer> mapa =  ensayo.BacteriaNumExp(); 
		 System.out.println("Cuenta experimentos por bacteria:" + mapa.toString());
		 
//		Ejercicio 7. Bacterias con experimento en esa fecha: [Klebsiella 255 2.2 [FILAMENTOS, ESFERAS, BARRAS, SACACORCHOS, HELICES], Escherichia 524 1.0 [ESFERAS, SACACORCHOS]]

//		Ejercicio 8. Número de experimentos por bacteria: 6
		 Integer max = ensayo.numMaxExpPorBacteria();
		System.out.println(" Número de experimentos por bacteria:" +max);	
		 
//		Ejercicio 9. Bacteria relacionada con mayor valor medio de experimento: {Escherichia 524 1.0 [ESFERAS, SACACORCHOS]=3.2, Pseudomonas 125 2.0 [BARRAS, SACACORCHOS]=5.7272727272727275, sStreptococcus 321 1.0 [FILAMENTOS, ESFERAS]=3.2666666666666666, Enterococcus 123 0.8 [FILAMENTOS, BARRAS, HELICES]=2.466666666666667, Klebsiella 255 2.2 [FILAMENTOS, ESFERAS, BARRAS, SACACORCHOS, HELICES]=3.7142857142857144}
		 Map<Bacteria, Double> mapa2 = ensayo.mayorValorMedioConjExp (); 
		 System.out.println("Bacteria relacionada con mayor valor medio de experimento:"+mapa2.toString());
		 
//		Ejercicio 10. Existe la bacteria 555 con experimentos realizados el 3 del 12 2015?: false
		 String f3 = "3-12-2015"; 
			List<String> laux3 = Arrays.asList(f3.split("-"));
			LocalDate fecha3 = LocalDate.of(new Integer(laux.get(0).trim()),
					new Integer(laux.get(1).trim()), new Integer(laux.get(2).trim()));
		 Boolean res3 = ensayo.ExpBacteria(fecha3, 555);
		 System.out.println("Existe la bacteria 555 con experimentos realizados el 3 del 12 2015?:"+res3);

//		Ejercicio 10. Existe la bacteria 255 con experimentos realizados el 5 del 12 2015?: true
		 String f4 = "5-12-2015"; 
			List<String> laux4 = Arrays.asList(f4.split("-"));
			LocalDate fecha4 = LocalDate.of(new Integer(laux.get(0).trim()),
					new Integer(laux.get(1).trim()), new Integer(laux.get(2).trim()));
		 Boolean res4 = ensayo.ExpBacteria(fecha3, 555);
		 System.out.println("Existe la bacteria 255 con experimentos realizados el 5 del 12 2015?:"+res4);

	}

}
*/