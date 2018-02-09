package EXPERIMENTO;

import java.util.List;

public interface Bacteria extends Procariota, Comparable<Bacteria>{
	Integer getCodigo(); 
	Double getTama�o(); 
	void setTama�o(Double t); 
	List<FormaBacteria> getFormasDeLaBacteria(); 
	void setFormasDeLaBacteria(List<FormaBacteria> l);
	Integer getNumeroDeFormas(); 
	void a�adirForma(FormaBacteria f);
	

}
