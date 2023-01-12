import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Templates {
    public static ImageView img;
    public void template1(String[] arr){
        Stage stage = new Stage();
        stage.setTitle("CV Generating System");stage.setResizable(false);
        //adding a grid pane
        GridPane gridPane = new GridPane();
        //horizontal gap in pixels
        gridPane.setHgap(10);
        //vertical gap in pixels
        gridPane.setVgap(10);
        //margins around the whole grid
        gridPane.setPadding(new Insets(2, 2, 2, 2));
        gridPane.setStyle("-fx-background-image: url('Resourses/1.png');-fx-background-cover: contain;-fx-background-repeat: no-repeat;" +
                "-fx-background-size: contain;");

        //elements
        Label lblFullName = new Label("Name");
        Label lblAbout = new Label("about");
        Label lblWorkXp = new Label("WorkXp");
        Label lblEdu = new Label("Edu");
        Label lblSkill1 = new Label("skill 1");
        Label lblSkill2 = new Label("skill 2");
        Label lblSkill3 = new Label("skill 3");
        Label lblMobile = new Label("mobile");
        Label lblEmail = new Label("email");
        Label lblArea = new Label("area");
        Label lblLinkedln = new Label("linkedln");
        Label lblLang1 = new Label("Lang 1");
        Label lblLang2 = new Label("Lang 2");
        Label lblLang3 = new Label("Lang 3");
        Label lblHobby1 = new Label("Hobby 1");
        Label lblHobby2 = new Label("Hobby 2");
        Label lblHobby3 = new Label("Hobby 3");

        Button btnPicture = new Button();
        //btnPicture.setStyle("-fx-background-radius: 5em;-fx-min-width: 6px;-fx-min-height: 6px;");
        btnPicture.setGraphic(img);
        //adding to the grid pane
        gridPane.add(btnPicture,4,6);
        gridPane.add(lblFullName,12,6);
        gridPane.add(lblAbout,12,7);
        gridPane.add(lblWorkXp,12,14);
        gridPane.add(lblEdu,12,30);
        gridPane.add(lblSkill1,12,38);
        gridPane.add(lblSkill2,12,40);
        gridPane.add(lblSkill3,12,42);
        gridPane.add(lblMobile,4,24);
        gridPane.add(lblEmail,4,26);
        gridPane.add(lblArea,4,28);
        gridPane.add(lblLinkedln,4,30);
        gridPane.add(lblLang1,3,35);
        gridPane.add(lblLang2,3,36);
        gridPane.add(lblLang3,3,37);
        gridPane.add(lblHobby1,3,40);
        gridPane.add(lblHobby2,3,41);
        gridPane.add(lblHobby3,3,42);

        //GridPane.setHalignment(lblMobile, HPos.RIGHT);
        lblMobile.setStyle("-fx-text-fill: white;");
        lblEmail.setStyle("-fx-text-fill: white;");
        lblArea.setStyle("-fx-text-fill: white;");
        lblLinkedln.setStyle("-fx-text-fill: white;");
        lblLang1.setStyle("-fx-text-fill: white;");
        lblLang2.setStyle("-fx-text-fill: white;");
        lblLang3.setStyle("-fx-text-fill: white;");
        lblHobby1.setStyle("-fx-text-fill: white;");
        lblHobby2.setStyle("-fx-text-fill: white;");
        lblHobby3.setStyle("-fx-text-fill: white;");

        lblFullName.setText(User.userArr[2]);
        lblAbout.setText(User.userArr[3]);
        lblWorkXp.setText(User.userArr[4]);
        lblEdu.setText(User.userArr[5]);
        lblMobile.setText(User.userArr[6]);
        lblEmail.setText(User.userArr[7]);
        lblArea.setText(User.userArr[8]);
        lblLinkedln.setText(User.userArr[9]);
        lblSkill1.setText(User.userArr[10]);
        lblSkill2.setText(User.userArr[11]);
        lblSkill3.setText(User.userArr[12]);
        lblLang1.setText(User.userArr[13]);
        lblLang2.setText(User.userArr[14]);
        lblLang3.setText(User.userArr[15]);
        lblHobby1.setText(User.userArr[16]);
        lblHobby2.setText(User.userArr[17]);
        lblHobby3.setText(User.userArr[18]);

        //Creating a javafx scene
        Scene scene = new Scene(gridPane, 550, 750);
        stage.setScene(scene);
        stage.show();
    }

    public void template2(){
        Stage stage = new Stage();
        stage.setTitle("CV Generating System");stage.setResizable(false);
        //adding a grid pane
        GridPane gridPane = new GridPane();
        //horizontal gap in pixels
        gridPane.setHgap(50);
        //vertical gap in pixels
        gridPane.setVgap(50);
        //margins around the whole grid
        gridPane.setPadding(new Insets(2, 2, 2, 2));
        gridPane.setStyle("-fx-background-image: url('Resourses/4-01.png');-fx-background-cover: contain;-fx-background-repeat: no-repeat;-fx-background-size: contain;");

        //Creating a javafx scene
        Scene scene = new Scene(gridPane, 550, 750);
        stage.setScene(scene);
        stage.show();
    }
}
