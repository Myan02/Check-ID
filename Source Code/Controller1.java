package com.among_us;

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller1 {

   //create nodes
   @FXML
   private Label myLabel;
   @FXML
   private TextField myTextField;
   @FXML
   private Button myButton;
   @FXML
   private ImageView myImageView;
   @FXML
   private Label acceptedLabel, deniedLabel;

   String userInput;
   int sum;
   double progress = 0.0;
   boolean submitted = false;

   public void Submit(ActionEvent event) throws Exception {

      if (!submitted){
         try {
            
            userInput = myTextField.getText();

            if (userInput.equals("Close Window")) {
               Stage stage = (Stage) myButton.getScene().getWindow();
               stage.close();
            }
            
            int[] values =  Arrays.stream(userInput.replaceAll("-", " -").split("[^-\\d]+"))
                           .filter(s -> !s.matches("-?"))
                           .mapToInt(Integer::parseInt).toArray();

            sum = SumValues(values);

            if (sum == 100) {
               deniedLabel.setVisible(false);
               acceptedLabel.setVisible(true);
               myTextField.setDisable(true);
               myButton.setText("Next ID");
               submitted = true;
            } 
            else {
               acceptedLabel.setVisible(false);
               deniedLabel.setVisible(true);
            }

            myTextField.setText("");

         } catch(Exception e) {
            System.out.println("error");
         }
      } 
      else {
         submitted = false;
         myButton.setText("Submit");
         acceptedLabel.setVisible(false);
         deniedLabel.setVisible(false);
         myTextField.setDisable(false);
      }
   }

   int SumValues(int[] values) {
      return Arrays.stream(values).sum();
   }
}
