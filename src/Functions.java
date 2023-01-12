import javafx.scene.control.Alert;

public class Functions {
    public static void errorAlert(String msg){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(msg);
        alert.show();
    }
    public static void confirmAlert(String msg){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(msg);
        alert.show();
    }
}
