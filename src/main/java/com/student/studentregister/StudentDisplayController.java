package com.student.studentregister;

import java.io.IOException;
import javafx.fxml.FXML;

public class StudentDisplayController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}