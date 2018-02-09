package EXPERIMENTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExperimentoImpl implements Experimento {
	
	private Bacteria bacteria; 
	private List<Double> mediciones; 
	private LocalDate fecha; 
	 
//	public ExperimentoImpl(Bacteria b, List<Double> lm, LocalDate f){
//		//super(n,c); 
//		bacteria = b; 
//		mediciones = lm; 
//		fecha = f;
//	}
	
	public ExperimentoImpl(Bacteria b, List<Double> lm, LocalDate f){
		//super(n,c); 
		bacteria = b;
		mediciones = lm; 
		fecha = f;
	}

	
	public ExperimentoImpl(String s){
	
		mediciones = new ArrayList<Double>(); 
		List<String> laux=Arrays.asList(s.split(":"));
		
		if(laux.size()>3){
			throw new IllegalArgumentException("El constructor por cadena de ExperimentoImpl tiene demasiados atributos");
		}
		
		bacteria = new BacteriaImpl(new Integer(laux.get(0).trim()));
		List<String> lfecha = Arrays.asList(laux.get(1).split("-"));
		fecha=LocalDate.of(new Integer(lfecha.get(0).trim()),new Integer(lfecha.get(1).trim()),new Integer(lfecha.get(2).trim()));
		List<String> laux2= Arrays.asList(laux.get(2).split(" ")); 
		Integer tamAux= laux2.size(); 
		for(int i=0; i<tamAux; i++){
			mediciones.add(new Double(laux2.get(i).trim()));
		}
		
	}
	 	
	public Bacteria getBacteria(){
		return bacteria; 
	}
	
	public void setBacteria(Bacteria b){
		bacteria=b; 
	}
	
	public List<Double> getListaDeMediciones(){
		return mediciones; 
	}
	
	public LocalDate getFecha(){
		return fecha; 
	}
	
	public String toString(){
		String s = bacteria.getCodigo()+":"+getFecha()+":";
		String aux=""; 
		for(Double i:mediciones){
			aux+=i+" "; 
		}
		return s+aux;
	}
	
	public  boolean equals (Object o){
		boolean res = false; 
		if ( o instanceof Experimento){
			Experimento e = (Experimento) o; 
			res=getBacteria().equals(e.getBacteria()); 
			if(res){
				res=getFecha().equals(e.getFecha());
				 if(res){ 
					res= getListaDeMediciones().equals(e.getListaDeMediciones());
				}
			}
		}
		return res;
	}
	
	public int hashCode(){
		return getBacteria().hashCode()*31 + getFecha().hashCode()*17+getListaDeMediciones().hashCode()*27; 
	}


}
