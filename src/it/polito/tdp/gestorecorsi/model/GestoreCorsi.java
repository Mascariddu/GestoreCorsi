package it.polito.tdp.gestorecorsi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.db.CorsoDAO;
import javafx.event.ActionEvent;

public class GestoreCorsi {
	
	//sOLUZIONE 1
	/*public List<Corso> getCorsoByPeriodo(int periodo){
		CorsoDAO dao = new CorsoDAO();
		
		List<Corso> corsi = dao.listAll();
		List<Corso> result = new ArrayList<Corso>();
		
		for(Corso c: corsi) {
			if(c.getPd() == periodo) {
				result.add(c);
			}
		}
		return result;
	*/
	//Soluzione 2
	 
	public List<Corso> getCorsoByPeriodo(int periodo){
		CorsoDAO dao = new CorsoDAO();
		return dao.listCorsiByPD(periodo);
	}
	}
