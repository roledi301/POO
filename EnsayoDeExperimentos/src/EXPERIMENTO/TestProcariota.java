package EXPERIMENTO;

public class TestProcariota {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Procariota p = new ProcariotaImpl("Agapito"); 
		Procariota p1 = new ProcariotaImpl("Juanito");
		System.out.println(p); 
		p.setNombre("Juanito");
		Boolean aux = p.equals(p1); 
		if(aux){
			System.out.println("Los objetos "+ p +" y "+ p1+ " son iguales");
			
		}else{
			System.out.println("Los objetos "+ p +" y "+ p1+ " no son iguales");
			
		}

	}

}
