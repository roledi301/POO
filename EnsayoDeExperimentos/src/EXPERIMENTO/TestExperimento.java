package EXPERIMENTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestExperimento {
	public static void main(String[] args) {
		
		
//	Bacteria b = new BacteriaImpl("Enterococcus 123 0.8 FILAMENTOS BARRAS HELICES");
//	List<Double> lm = new ArrayList<Double>();
//	String s = "2015-12-01";
//	List<String> l = Arrays.asList(s.split("-"));
//	LocalDate f = LocalDate.of(new Integer(l.get(0).trim()), new Integer(l.get(1).trim()),new Integer(l.get(2).trim()));
//	Experimento e = new ExperimentoImpl(b, lm, f );
//	System.out.println(e); 
		Experimento e = new ExperimentoImpl("123:2015-12-01:2 4 5 2 3 1 1 1 1 1 2 4 3 4 3"); 
		System.out.println(e.getBacteria().toString());
		
		Experimento e1 = new ExperimentoImpl("524:2015-12-03:2 4 5 2 3 4 5 2 2 3 4 5 2 2 3");
		System.out.println(e1);
		Boolean res = e.equals(e1);
		System.out.println(res);
	}
}
