package tdt4140.gr1836.app.ui;



import javafx.scene.control.Alert;
import javafx.stage.Window;
/*hjelpeklasse for pop-up vindu ved registeringstilbakemelding*/
public class AlertHelper {

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}