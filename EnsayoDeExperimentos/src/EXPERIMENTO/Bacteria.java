package EXPERIMENTO;

import java.util.List;

public interface Bacteria extends Procariota, Comparable<Bacteria>{
	Integer getCodigo(); 
	Double getTamaño(); 
	void setTamaño(Double t); 
	List<FormaBacteria> getFormasDeLaBacteria(); 
	void setFormasDeLaBacteria(List<FormaBacteria> l);
	Integer getNumeroDeFormas(); 
	void añadirForma(FormaBacteria f);
	

}
