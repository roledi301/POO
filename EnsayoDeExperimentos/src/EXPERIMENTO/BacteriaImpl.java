package EXPERIMENTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BacteriaImpl extends ProcariotaImpl implements Bacteria {
	
	private Integer codigo;
	private Double tama�o; 
	private List<FormaBacteria> lf; 
	
	
	public BacteriaImpl (Integer c){
		super();
		codigo=c; 
		tama�o=0.0;
		lf = new ArrayList<FormaBacteria>(); 
		
	}
	
	public BacteriaImpl (String n, Integer c){
		super(n);
		codigo = c; 
		tama�o = 0.0;
		lf = new ArrayList<FormaBacteria>(); 
				
	}
	
	public BacteriaImpl (String s){
		lf=new ArrayList<FormaBacteria>(); 
		
		List<String> laux = Arrays.asList(s.split(" "));
		if(laux.size()<3){
			throw new IllegalArgumentException("El constructor de BacteriaImpl tiene poco argumentos");
		}
		nombre = laux.get(0).trim();
		codigo =new Integer(laux.get(1).trim());
		Double tam = new Double(laux.get(2).trim());
				if(tam<0.5 || tam>5 ){ 
					throw new BacteriaNoValidaException("El tama�o para el tipo BacteriaImpl no es correcto");
				}
				
		
		tama�o = tam;
		Integer tamAux = laux.size();
		for(int i=3; i<tamAux; i++){
			lf.add(FormaBacteria.valueOf(laux.get(i).trim()));
		}

	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public Double getTama�o() {
		return tama�o;
	}

	public void setTama�o(Double t) {
		/*if(t<=0.5||t>=5){
		 * throw new BacteriaNoValidaException("El tama�o para el tipo BacteriaImpl no es correcto");
		 *}
		 **/
		ComprobarTama�o(t);
		tama�o=t; 
	}

	private void ComprobarTama�o(Double t){
		if(getTama�o()<=0.5||getTama�o()>=5){ //if(t<=0.5||t>=5) 
			throw new BacteriaNoValidaException("El tama�o para el tipo BacteriaImpl no es correcto");
		}
	}

	public List<FormaBacteria> getFormasDeLaBacteria() {
		return lf;
	}

	public void setFormasDeLaBacteria(List<FormaBacteria> l) {
		lf = l;
	}

	public Integer getNumeroDeFormas() {
		return this.getFormasDeLaBacteria().size();
	}
	
	public void a�adirForma(FormaBacteria f) {
		this.getFormasDeLaBacteria().add(f);
	}
	
	public String toString(){
		String s= super.toString() + ", Codigo: " + getCodigo()+ ", Tama�o: "+getTama�o()+ " [";
		String aux="";
		for(FormaBacteria fb: lf){
			aux+=fb+",";
		}
		return s+aux+"]";
		
	}
	
	public boolean equals (Object o){ 
		boolean res = false; 
		if( o instanceof Bacteria){
			Bacteria b = (Bacteria) o; 
			res=this.getNombre().equals(b.getNombre()); //super.equals(b); 
			if(res){
				res=this.getCodigo().equals(b.getCodigo()); 
				if(res){
					res=this.getTama�o().equals(b.getTama�o()); 
					if(res){
						res=this.getFormasDeLaBacteria().equals(b.getFormasDeLaBacteria());
					}
				}
			}
		}
		return res; 
	}
	
	public int hashCode(){
		return getNombre().hashCode()*31+ getCodigo().hashCode()*23+ getTama�o().hashCode()*47+ getFormasDeLaBacteria().hashCode()*21;
	}
	
	public int compareTo (Bacteria b){
		int res = 0; 
		res=this.getNombre().compareTo(b.getNombre());
		if(res==0){ 
			res=this.getCodigo().compareTo(b.getCodigo());
			
		}
		return res; 
	}


	
}