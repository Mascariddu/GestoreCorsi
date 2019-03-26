package it.polito.tdp.corsi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.gestorecorsi.model.Corso;
import it.polito.tdp.gestorecorsi.model.GestoreCorsi;
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
    void DoCalcolaStatCorsi(ActionEvent event) {

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



