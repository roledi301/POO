package EXPERIMENTO;

import java.util.Comparator;

public class ComparadorCodigo implements Comparator<Bacteria> {
	public int compare(Bacteria b, Bacteria b2){
		return b.getCodigo().compareTo(b2.getCodigo());
		
	}
}
