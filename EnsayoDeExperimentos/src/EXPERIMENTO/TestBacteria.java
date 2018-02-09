//package EXPERIMENTO;
//
//public class TestBacteria {
//	public static void main(String[] args) {
//
//		Bacteria b = new BacteriaImpl(265); 
//		System.out.println(b);
//		Bacteria b1 = new BacteriaImpl("Ismaelito", 23); 
//		System.out.println(b1);
//		
//		Bacteria b2 = new BacteriaImpl("Escherichia 524 1 ESFERAS SACACORCHOS"); 
//		System.out.println(b2);
//		Bacteria b3 = new BacteriaImpl("Klebsiella 255 2.2 FILAMENTOS ESFERAS BARRAS SACACORCHOS HELICES"); 
//		System.out.println(b3);
//		b2.añadirForma(FormaBacteria.ESFERAS);
//		System.out.println(b2);
//		Integer tb2 = b2.getNumeroDeFormas(); 
//		Integer tb3 = b3.getNumeroDeFormas();
//		System.out.println(tb2);
//		System.out.println(tb3);
//		Boolean res = b2.equals(b3); 
//		if(res){
//			System.out.println("Los objetos "+ b2 +" y "+ b3+ " son iguales");
//			
//		}else{
//			System.out.println("Los objetos "+ b2 +" y "+ b3+ " no son iguales");
//			
//		}
//		
//		Integer comp = b2.compareTo(b3); 
//		//System.out.println(comp);
//		if(comp<0){
//			System.out.println("La bacteria "+b2.getNombre()+ " en orden natural es menor que "+b3.getNombre());
//		}else if(comp>0){
//			System.out.println("La bacteria "+b2.getNombre()+ " en orden natural es maor que "+b3.getNombre());
//		}else{
//			System.out.println("La bacteria "+b2.getNombre()+ " en orden natural es igual que "+b3.getNombre());
//		}
//	}
//}
