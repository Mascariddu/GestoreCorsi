package it.polito.tdp.gestorecorsi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.db.StudenteDAO;
import javafx.event.ActionEvent;

public class GestoreCorsi {
	 
	public List<Corso> getCorsoByPeriodo(int periodo){
		CorsoDAO dao = new CorsoDAO();
		return dao.listCorsiByPD(periodo);
	}
	
	public Map<Corso, Integer> getIscrittiCorsi(int periodo){
		CorsoDAO dao = new CorsoDAO();
		
		return dao.getIscrittiCorsi(periodo);
	}

	public List<Studente> elencaStudenti(String codins) {
		// TODO Auto-generated method stub
		StudenteDAO dao = new  StudenteDAO();
		
		return dao.elencaStudenti(codins);
	}
	
}
