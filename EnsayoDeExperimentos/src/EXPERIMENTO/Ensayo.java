package EXPERIMENTO;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public interface Ensayo  {
	
	void cargaFichero(String nombreFichero1, String nombreFichero2);
	 
	Double tamañoMedio ();
	Bacteria mayorDiversidad ();
	Boolean fechaExperimentos (LocalDate f); 
	String BacteriaMayorExp (FormaBacteria f); 
	Map<Bacteria, Integer> BacteriaNumExp(); 
	SortedSet<Bacteria> ExpFechaOrden (LocalDate f);
	Integer numMaxExpPorBacteria(); 
	Map<Bacteria, Double> mayorValorMedioConjExp (); 
	Boolean ExpBacteria(LocalDate f, Integer cod); 

	void imprimirMapa();
}
