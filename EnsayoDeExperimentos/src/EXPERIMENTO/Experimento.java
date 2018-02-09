package EXPERIMENTO;

import java.time.LocalDate;
import java.util.List;


public interface Experimento {
	
	Bacteria getBacteria(); 
	void setBacteria(Bacteria b); 
	List<Double> getListaDeMediciones(); 
	LocalDate getFecha(); 
	
	

}
