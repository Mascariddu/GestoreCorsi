package it.polito.tdp.gestorecorsi.model;

import java.util.Map.Entry;
import java.util.*;

public class TestModel {

	public void run() {
		GestoreCorsi model = new GestoreCorsi();
		
		Map<Corso, Integer> res = model.getIscrittiCorsi(1);
		
		for(Entry<Corso, Integer> entry: res.entrySet()) {
			 
			System.out.println(((Corso)entry.getKey()).getNome()+ "=" + entry.getValue());
			
		}
	}
	
	public static void Main(String[] args) {
		
		TestModel main = new TestModel();
		main.run();
		
	}
	
}
