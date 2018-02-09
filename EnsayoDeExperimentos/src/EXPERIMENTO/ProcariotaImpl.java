package EXPERIMENTO;

public class ProcariotaImpl implements Procariota {
	
	protected String nombre; 

	public ProcariotaImpl (String nombre){
		this.nombre=nombre;
	}
	public ProcariotaImpl (){
		nombre = ""; 
	}
	
	public String getNombre() {
		
		return nombre;
	}
	
	public void setNombre(String n) {
		nombre = n;		

	}
	
	public String toString(){
		return "Nombre_de_organismo_procariota: "+getNombre();
	}
	
	public boolean equals (Object o){
		boolean res = false; 
		if(o instanceof Procariota){
			Procariota p = (Procariota) o ;
			res=this.getNombre().equals(p.getNombre());
		}
		return res;
	}
	
	public int hashCode(){
		return getNombre().hashCode();
	}
}
