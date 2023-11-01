/* doesn't work with source level 1.8:
module com.student.studentregister {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.student.studentregister to javafx.fxml;
    exports com.student.studentregister;
}
*/
