package it.polito.tdp.indovinaNumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {
	
	private final int NMAX=100;
	private final int TMAX=8;
	private int secret;
	private int tentativiFatti;
	private boolean inGioco=false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnNew;

    @FXML
    private TextField txtRimasti;

    @FXML
    private HBox layoutTentativo;

    @FXML
    private TextField txtTentativo;

    @FXML
    private Button btnTry;

    @FXML
    private TextArea txtRisultato;

    @FXML
    void doNuova(ActionEvent event) {
    	//Gestione inizio nuova partita, logica del gioco
    	this.secret= (int) (Math.random()*NMAX)+1;
    	this.tentativiFatti=0;
    	this.inGioco=true;
    	layoutTentativo.setDisable(false);
    	txtRisultato.clear();
    	txtRimasti.setText(Integer.toString(TMAX));

    }

    @FXML
    void doTentativo(ActionEvent event) {
    	String ts= txtTentativo.getText();
    	int tentativo;
    	try {
    		tentativo= Integer.parseInt(ts);
    	}
    	catch(NumberFormatException e) {
    		txtRisultato.appendText("Devi inserire un numero");
    		return;
    		
    	}
    	
    	this.tentativiFatti++;
    	if(tentativo==this.secret) {
    		txtRisultato.appendText("HAI VINTO" +"\n"+ "Hai usato " +this.tentativiFatti+" tentativi!");
    		layoutTentativo.setDisable(true);
    		inGioco=false;
    		return;
    	}
    	if(tentativiFatti==TMAX) {
    		txtRisultato.appendText("HAI PERSO" +"\n"+ "Il numero segreto e'" +this.secret);
    		this.layoutTentativo.setDisable(true);
    		this.inGioco=false;
    		return;
    	}
    	
    	if(tentativo<this.secret) 
    		txtRisultato.appendText("Tentativo troppo basso!\n");
    	
    		else 
    			txtRisultato.appendText("Tentativo troppo alto!\n");
    	
    	txtRimasti.setText(Integer.toString(TMAX-this.tentativiFatti));
    	}
    	
    

    @FXML
    void initialize() {
        assert btnNew != null : "fx:id=\"btnNew\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRimasti != null : "fx:id=\"txtRimasti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert layoutTentativo != null : "fx:id=\"layoutTentativo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativo != null : "fx:id=\"txtTentativo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTry != null : "fx:id=\"btnTry\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}