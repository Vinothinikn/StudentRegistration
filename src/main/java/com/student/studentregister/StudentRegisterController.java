package com.student.studentregister;

import com.student.studentregisterinterface.StudentInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class StudentRegisterController implements StudentInterface{

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField birthYearField;

    @FXML
    private TextField passwordField;
    
    @FXML
    private Label messageLabel;
    
    @FXML
    private Button registerButton;
     
    private boolean isRegistered = false;
     
     @Override
    public String getFirstName() {
         return firstNameField.getText();
    }

    @Override
    public void setFirstName(String firstName) {
        firstNameField.setText(firstName);
    }

    @Override
    public String getLastName() {
        return lastNameField.getText();
    }

    @Override
    public void setLastName(String lastName) {
        lastNameField.setText(lastName);
    }

    @Override
    public String getBirthYear() {
        return birthYearField.getText();
    }

    @Override
    public void setBirthYear(String birthYear) {
         birthYearField.setText(birthYear);
    }

    @Override
    public String getPassword() {
        return passwordField.getText();
    }

    @Override
    public void setPassword(String password) {
        passwordField.setText(password);
    }

     @FXML
    private void register() {
        if (!isRegistered) {
        String firstName = getFirstName();
        String lastName = getLastName();
        String birthYear = getBirthYear();
        
        if (firstName.isEmpty() || lastName.isEmpty() || birthYear.isEmpty()) {
            passwordField.clear();
            messageLabel.setText("Please enter first and last name and year of birth.");
        } else {
            String temporaryPassword = firstName + "*" + birthYear;
            setPassword(temporaryPassword);
            messageLabel.setText("Welcome, " + firstName + " "+lastName + "!");
             isRegistered = true;
        }
        if(isRegistered){
            registerButton.setText("View");
            registerButton.setOnAction(e -> viewStudentInfo());
        }
        }else{
            viewStudentInfo();
        }
    }
    
    private void viewStudentInfo() {
    try {
        // Load the FXML for displaying student data
        FXMLLoader loader = new FXMLLoader(App.class.getResource("studentdisplay.fxml"));
        Parent root = loader.load();

        // Create a new stage and set it to display the student data
        Stage stage = new Stage();
        stage.setTitle("Student Information");
        stage.setScene(new Scene(root));
        
        // Pass the student data to the display controller
        StudentDisplayController displayController = loader.getController();
        String studentInfo = "First Name: " + getFirstName() + "\n" +
                             "Last Name: " + getLastName() + "\n" +
                             "Year of Birth: " + getBirthYear() + "\n" +
                             "Temporary Password: " + getPassword();
        displayController.setStudentInfo(studentInfo);

        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    @FXML
    private void exit() {
        System.exit(0);
    }

    
}
