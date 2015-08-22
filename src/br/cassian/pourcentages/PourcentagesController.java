package br.cassian.pourcentages;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import br.cassian.pourcentages.util.Utilities;

public class PourcentagesController {
	@FXML 
	private TextField value1TextField;
	
	@FXML 
	private TextField value2TextField;

	@FXML 
	private TextField percentTextField;
	
	@FXML 
	private Text errorText;
	
	@FXML
	private Text text1;
	
	@FXML
	private Text text2;
	
	@FXML
	private Text text3;
	
	@FXML
	private Text text4;
	
	@FXML
	private Text text5;
	
	@FXML
	private Text text6;
	
	@FXML
	public void initialize() {
		text1.setText("Ce programme calcule l'accroissement de la ");
		text2.setText("valeur 1 ");
		text3.setText(" à la ");
		text4.setText("valeur 2 ");
		text5.setText(", en pourcentage. \n\nRenseignez les deux valeurs puis cliquez sur ");
		text6.setText("Calculer");
		
	}
	
	@FXML
	private void calculateButtonPressed() {
		try {
		errorText.setText("");
		
		String value1String = Utilities.trimNumberString(value1TextField.getText());
		String value2String = Utilities.trimNumberString(value2TextField.getText());
		
		BigDecimal from = Utilities.stringToBigDecimal(value1String);
		BigDecimal to = Utilities.stringToBigDecimal(value2String);

		if(from != BigDecimal.ZERO ) {
			BigDecimal percent = Utilities.calculatePercentChange(from, to);
			percentTextField.setText(Utilities.formatPercent(percent));
		} else {
			errorText.setText("Valeur 1 ne peut pas être nulle. Corrigez svp.");
			percentTextField.setText("");
		}
		} catch (NumberFormatException e) {
			errorText.setText("Valeur 1 ou Valeur 2 non valide. Corrigez puis cliquez sur Calculer.");
			percentTextField.setText("");
		}
	}
}
