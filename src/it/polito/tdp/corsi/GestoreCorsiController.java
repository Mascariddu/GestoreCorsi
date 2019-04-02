package it.polito.tdp.corsi;

import java.net.URL;
import java.util.Map.Entry;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.gestorecorsi.model.Corso;
import it.polito.tdp.gestorecorsi.model.GestoreCorsi;
import it.polito.tdp.gestorecorsi.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GestoreCorsiController {
	
	private GestoreCorsi model= new GestoreCorsi();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextField TxtPeriodo;

    @FXML
    private Button BtnCercaCorsi;

    @FXML
    private Button BtnStatCorsi;
    
    @FXML
    private Button BtnStudenteCorso;

    @FXML
    private Button BtnCDS;

    @FXML
    void DoCalcolaStatCorsi(ActionEvent event) {

    	int periodo;
    	try {
    	  periodo= Integer.parseInt(TxtPeriodo.getText());
    	} catch(NumberFormatException e) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	if(periodo !=1 && periodo!=2) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	
    	List<Corso> corsi = this.model.getCorsoByPeriodo(periodo);
    	for(Corso c: corsi) {
    		txtResult.appendText(c.toString()+"\n");
    	}
    	
    	Map<Corso,Integer> res = model.getIscrittiCorsi(periodo);
    	
    	for(Entry<Corso,Integer> entry : res.entrySet()) {
    		txtResult.appendText(entry.getKey().toString()+ ", Numero iscritti: "+entry.getValue()+"\n");
    	}
    	
    }
    
    @FXML
    void DoBtnCDS(ActionEvent event) {

    }
    
    @FXML
    void DoStudenteCorso(ActionEvent event) {

    	txtResult.clear();
    	
    	String codins = TxtPeriodo.getText();
    	List<Studente> studenti = this.model.elencaStudenti(codins);
    	
    	for(Studente s : studenti)
    		txtResult.appendText(s.toString());
    	
    }

    @FXML
    void DoCercaCorsi(ActionEvent event) {
    	
    	int periodo;
    	try {
    	  periodo= Integer.parseInt(TxtPeriodo.getText());
    	} catch(NumberFormatException e) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	if(periodo !=1 && periodo!=2) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	
    	List<Corso> corsi = this.model.getCorsoByPeriodo(periodo);
    	for(Corso c: corsi) {
    		txtResult.appendText(c.toString()+"\n");
    	}
    }
    
    public void setModel(GestoreCorsi model) {
    	this.model=model;
    }

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert TxtPeriodo != null : "fx:id=\"TxtPeriodo\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert BtnCercaCorsi != null : "fx:id=\"BtnCercaCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert BtnStatCorsi != null : "fx:id=\"BtnStatCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";

    }
}



