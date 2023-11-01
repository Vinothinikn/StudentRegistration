package com.student.studentregister;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StudentDisplayController {

   @FXML
    private Label studentInfoLabel;

    public void setStudentInfo(String studentInfo) {
        studentInfoLabel.setText(studentInfo);
    }
}