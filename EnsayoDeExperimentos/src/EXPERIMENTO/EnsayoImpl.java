package EXPERIMENTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class EnsayoImpl implements Ensayo {

		//Atributos
		private  Map<Bacteria, Set<Experimento>> mapa; 
		private List<Experimento> listaExp; 
		
		
		
		//Metodo para crear una lista de bacterias mediante un String
		private  List<Bacteria> creaBacterias(List<String> stringBac){
			//Creamos la lista vacia
			List<Bacteria> lb = new ArrayList<Bacteria>();
			//Recorremos por elemento la lista que entra por parametro
			for(String s:stringBac){
				//por cada elemento de esa lista se crea una bacteria con el constructor por String
				Bacteria b = new BacteriaImpl(s); 
				//se añade la bacteria a la lista
				lb.add(b);
			}
			return lb;
		}

		//metodo para crear un conjutno de experimentos a partir de una lista de String
		private  Set<Experimento> creaExperimentos(List<String> experimentos){
			//creamos el conjunto vacio
			Set<Experimento> se = new HashSet<Experimento>(); 
			//recorremos cada elemento de la lista de entrada 
			for(String s: experimentos){
				//con cada elemento nos creamos un experimento nuevo mediante su constructor
				Experimento e = new ExperimentoImpl(s);
				//se añade el experimento al conjunto 
				se.add(e);
			}
			
			return se;
		}
		
		//metodo que busca una bacteria en la coleccion que se le mete por parametro de entrada y un codigo(?)	
		private  Bacteria buscaBacteria(Collection<Bacteria> bacterias, Integer ss){
			//nos creamos la bacteria a devolver vacia
			Bacteria bAux = null ;
			//por cada elemento de la coleccion 
			for(Bacteria b : bacterias){
				//buscamos cual de ella coincide con el codigo de entrada 
				if(b.getCodigo().equals(ss)){
					//devolvemos esa bacteria
				//	Bacteria bac = new BacteriaImpl(ss);
					bAux=b;//ac;
				}
			}
			return bAux;
		}
		
		public EnsayoImpl(){
			mapa=new HashMap<Bacteria, Set<Experimento>>();
			listaExp = new ArrayList<Experimento>();
			
		}
	//1. Metodo que carga los datos del fichero
	public void cargaFichero(String nombreFichero1, String nombreFichero2){
			
		//Inicializamos los atributos vacios
			mapa=new HashMap<Bacteria, Set<Experimento>>();
			listaExp = new ArrayList<Experimento>();
			
			//Mediante el metodo de utils guardamos en diferentes listas los datos de los dos ficheros
			List<String> lineas1 = Util.leeFicheroPorLinea(nombreFichero1);
			List<String> lineas2 = Util.leeFicheroPorLinea(nombreFichero2);
			
				//Mediante los metodos anteriores creamos la lista de bacteria y el conjunto de experimento
				List<Bacteria> lisBacteria = creaBacterias(lineas1);
				Set<Experimento> ConjExp = creaExperimentos(lineas2);
				
				for(Experimento e: ConjExp){
					listaExp.add(e);
					Bacteria key = buscaBacteria(lisBacteria, e.getBacteria().getCodigo()); 
					if(mapa.containsKey(key)){
							mapa.get(key).add(e);
					}else{							
							Set<Experimento> se = new HashSet<Experimento>(); 
							se.add(e); 
							mapa.put(key, se);
						
						
					}
				}
	}
	
	
	

	public void imprimirMapa(){
		Iterator it = mapa.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}
	
	
	
//		2. Calcular el tamaño medio de las bacterias del ensayo realizado.
		
		public  Double tamañoMedio (){ 
			Double tam=0.0; 
			Set<Bacteria> conjBac = mapa.keySet(); 
			for(Bacteria b : conjBac){
				tam+=b.getTamaño();
			}
			return tam/conjBac.size(); 
		}
		
//		3. Devolver la bacteria con mayor diversidad de formas.
		
		

		public Bacteria mayorDiversidad (){
			Bacteria b = null; 
			Integer aux = 0; 
			Set<Bacteria> conjBac = mapa.keySet(); 
			for(Bacteria bac : conjBac){
				if(aux.compareTo(bac.getNumeroDeFormas())<0){
					aux=bac.getNumeroDeFormas(); 
					b=bac;
				}
				
			}
			return b; 
		}
		
//		4. Dada una fecha, devolver si todos los experimentos se han realizado con fecha posterior a la dada.
		
		public Boolean fechaExperimentos (LocalDate f){
			Boolean res = true;
			for( Set<Experimento> experimentos: mapa.values()){
				for(Experimento ex: experimentos){
					if(ex.getFecha().compareTo(f)<0){
						res=false;
					}
				}
				
			}
			return res; 
		}
		
//		5. Dada una forma de bacteria f, devolver el nombre de la bacteria con mayor número de experimentos y que tenga entre sus formas f.
		
		public String BacteriaMayorExp (FormaBacteria f){
			 String nombre= ""; 
			 Integer aux=0;
			 Set<Bacteria> conjBac = mapa.keySet(); 
			 for(Bacteria b : conjBac){
				 if(b.getFormasDeLaBacteria().contains(f)){
					 Set<Experimento> sAux = mapa.get(b);
					 Integer numExp = sAux.size();
					 if(numExp.compareTo(aux)>0){
						 aux=numExp;
						 nombre=b.getNombre();
					 }
				 }
			 }
			 return nombre; 
		}
		
//		6. Devolver un Map relacionando a cada bacteria con el número de experimentos realizados sobre dicha bacteria.
		
		public Map<Bacteria, Integer> BacteriaNumExp(){
			Map<Bacteria, Integer> mapaRes = new HashMap<Bacteria, Integer>(); 
			Set<Bacteria> bacterias = mapa.keySet(); 
			for(Bacteria b: bacterias){ 
				Set<Experimento> experimentosBacteria = mapa.get(b); 
				Integer numExp = experimentosBacteria.size(); 
				mapaRes.put(b, numExp);
			}
			return mapaRes; 
		}
		
//		7. Dada una fecha, devolver el conjunto de bacterias sobre las que se haya realizado un experimento
//		en dicha fecha ordenado según el código de las bacterias.

		public SortedSet<Bacteria> ExpFechaOrden (LocalDate f){ 
			SortedSet<Bacteria> conjBac = new TreeSet<Bacteria>(new ComparadorCodigo()); 
			Set<Bacteria> conjAux = mapa.keySet(); 
			for(Bacteria b : conjAux){ 
				Set<Experimento> experimentosBac = mapa.get(b); 
				for(Experimento e : experimentosBac){ 
					if(e.getFecha().equals(f)){ 
						conjBac.add(b);
					}
				}
			}
			
			return conjBac; 
		}
		
//		8. Utilizando el ejercicio 6 y el método de la clase utilidad invierteMap, devolver el máximo número 
//		de experimentos realizados sobre una bacteria.
		
		public Integer numMaxExpPorBacteria(){
			Integer max=0;
			Map<Bacteria,Integer> mapAux = BacteriaNumExp();
			Map<Integer, Bacteria> mapaInv = Util.invierteMap(mapAux);
			Set<Integer> NumExp = mapaInv.keySet(); 
			max = Collections.max(NumExp);
			return max; 
		}
		
//		9. Devolver el conjunto de bacterias de todo el ensayo en un Map relacionando a cada bacteria con el mayor 
//		valor medio obtenido en su conjunto de experimentos. Nota: para este ejercicio implemente una función que dada 
//		una lista de valores reales, devuelva el valor medio de dichos valores.
		
		private Double valorMedioValores(List<Double> l) {
			Double res=0.0;
			for(Double d:l){ 
				res+=d; 
			}
			return res/l.size();
		
		}
	
		public Map<Bacteria, Double> mayorValorMedioConjExp (){ 
			Map<Bacteria, Double> mapaRes = new HashMap<Bacteria, Double>(); 
			Set<Bacteria> bacterias = mapa.keySet(); 
			List<Double> lAux = new ArrayList<Double>(); 
		
			for(Bacteria b: bacterias){
				for(Experimento e: mapa.get(b)){
					Double aux=valorMedioValores(e.getListaDeMediciones());
					lAux.add(aux);
					
				}
				Double d = Collections.max(lAux); 
				mapaRes.put(b,d);
				lAux = new ArrayList<Double>(); 
			}
			return 	mapaRes; 
		}
		
//		10. Dada una fecha y un código de bacteria, devolver si existe o no un experimento sobre esa bacteria y con la fecha dada.
		
		public Boolean ExpBacteria(LocalDate f, Integer cod){ 
			 Boolean res=false; 
			 Set<Bacteria> bacterias =mapa.keySet(); 
			 for(Bacteria b:bacterias){
				 if(b.getCodigo().equals(cod)){
					 Set<Experimento> se= mapa.get(b);
					 for(Experimento e:se){ 
						 if(e.getFecha().equals(f)){
							 res=true; 
						 }
					 }
				 }
			 }
			 return res;
		}

		
		
		
}

