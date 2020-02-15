package logic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControllerGrafico {
	@FXML
	public Label result;
	private boolean start=true;
	private String operation="";
	ControllerApplicativo controller=new ControllerApplicativo();
	float number1=0;
	float number2;
	
	
	
	public void processNumbers(ActionEvent event) {
		if(start) {
			
			result.setText("");
			start=false;
		}
		String value=((Button)event.getSource()).getText();
		result.setText(result.getText()+value);	}
	
	public void processOperators(ActionEvent event) {
		String value=((Button)event.getSource()).getText();
		if(!value.contentEquals("=")) {
			if(!operation.isEmpty()) 
				return;
			
				operation=value;
				number1=Float.parseFloat(result.getText());
				result.setText("");}
		else {
			if(operation.isEmpty()) 
				return;
			
			number2=Float.parseFloat(result.getText());
			
			float output=controller.calculator(number1, number2, operation);
			result.setText(String.valueOf(output));
			if(number2==0) {
				result.setText("error");
			}
			operation="";
			start=true;
			
			}
		}

}
