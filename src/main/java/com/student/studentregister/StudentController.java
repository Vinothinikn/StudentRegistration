package com.student.studentregister;

import com.student.studentregisterinterface.StudentInterface;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class StudentController implements StudentInterface{

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
        String firstName = getFirstName();
        String lastName = getLastName();
        String birthYear = getBirthYear();
        
        if (firstName.isEmpty() || lastName.isEmpty() || birthYear.isEmpty()) {
            passwordField.clear();
            messageLabel.setText("Please enter first and last name and year of birth.");
        } else {
            String temporaryPassword = firstName + "*" + birthYear;
            setPassword(temporaryPassword);
            messageLabel.setText("Welcome, " + firstName + "!");
        }
    }

    @FXML
    private void exit() {
        System.exit(0);
    }

    
}
