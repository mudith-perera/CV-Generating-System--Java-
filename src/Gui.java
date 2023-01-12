import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class Gui {
    //username
    public static String username;
    //Creating a stage for the menu
    Stage stageMenu = new Stage();
    //dynamic stage
    public void mainMenuStage(GridPane gridPane,int closeStatus){
        stageMenu.setTitle("CV Generating System");
        stageMenu.setResizable(false);
        //Creating a javafx scene for menu
        Scene scene = new Scene(gridPane, 1000, 750);
        //stageMenu.setMaximized(true);
        stageMenu.setScene(scene);
        stageMenu.show();
        if (closeStatus==1){
            stageMenu.close();
        }
    }

    public void logIn(){
        Stage stage = new Stage();
        stage.setTitle("CV Generating System");stage.setResizable(false);

        //adding a grid pane
        GridPane gridPane = new GridPane();
        //horizontal gap in pixels
        gridPane.setHgap(20);
        //vertical gap in pixels
        gridPane.setVgap(20);
        //margins around the whole grid
        gridPane.setPadding(new Insets(10, 15, 15, 10));
        //gridPane.setStyle("-fx-background-image: url('Resourses/Login.png');-fx-background-cover: contain;-fx-background-repeat: no-repeat;");

        //Creating elements
        Label lblLoginStage     = new Label("Login");
        Label lblUsername       = new Label("Username : ");
        Label lblPwd            = new Label("Password : ");
        Label lblDisplayInfo    = new Label("");
        TextField txtUsername   = new TextField();
        PasswordField txtPwd    = new PasswordField();
        Button btnLogin         = new Button("Login");
        Button btnCreate        = new Button("Create");

        //adding elements to Grid pane
        gridPane.add(lblLoginStage,2,1);
        gridPane.add(lblUsername,2,3);
        gridPane.add(txtUsername,3,3);
        gridPane.add(lblPwd,2,5);
        gridPane.add(txtPwd,3,5);
        gridPane.add(btnLogin,3,6);
        gridPane.add(btnCreate,3,6);

        //Styling grid pane elements
        lblLoginStage.setStyle("-fx-font-weight: bold;-fx-font-size: 28px;");
        lblUsername.setStyle("-fx-font-weight: bold;");
        lblPwd.setStyle("-fx-font-weight: bold;");
        lblDisplayInfo.setStyle("-fx-text-fill: red;-fx-font-weight: bold;");
        GridPane.setHalignment(lblDisplayInfo, HPos.CENTER);
        GridPane.setHalignment(btnCreate,HPos.RIGHT);

        //username and password validations
        btnLogin.setOnAction(actionEvent -> {
            username = txtUsername.getText();
            String pwd = txtPwd.getText();
            Database database = new Database();
            String fullName = database.getFullNameByUsernamePswd(username,pwd);

            if (fullName.equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Wrong Username or Password!");
                alert.show();
            }else{
                stage.close();
                mainMenuStage(landingPage(),0);
            }
        });
        btnCreate.setOnAction(actionEvent -> {
            stage.close();
            createAccount();
        });

        //Creating a javafx scene
        Scene scene = new Scene(gridPane, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public void createAccount(){
        Stage stage = new Stage();
        stage.setTitle("CV Generating System");stage.setResizable(false);

        //adding a grid pane
        GridPane gridPane = new GridPane();
        //horizontal gap in pixels
        gridPane.setHgap(20);
        //vertical gap in pixels
        gridPane.setVgap(20);
        //margins around the whole grid
        gridPane.setPadding(new Insets(10, 15, 15, 10));
        //gridPane.setStyle("-fx-background-image: url('Resourses/Login.png');-fx-background-cover: contain;-fx-background-repeat: no-repeat;");

        //create elements
        Label lblStageInfo = new Label("Create");
        Label lblFullName       = new Label("Full Name : ");
        Label lblEmail          = new Label("Email : ");
        TextField txtFullName   = new TextField();
        TextField txtEmail      = new TextField();
        Label lblUsername = new Label("Username : ");
        TextField txtUsername = new TextField();
        Label lblPassword = new Label("Password : ");
        PasswordField txtPassword = new PasswordField();
        Button btnCreate = new Button("Create");
        Button btnBack = new Button("Back");

        //set styles
        lblStageInfo.setStyle("-fx-font-weight: bold;-fx-font-size: 28px;");

        //add to gridpane
        gridPane.add(lblStageInfo,2,1);

        gridPane.add(lblFullName,2,4);
        gridPane.add(txtFullName,3,4);
        gridPane.add(lblEmail,2,6);
        gridPane.add(txtEmail,3,6);
        gridPane.add(lblUsername,2,8);
        gridPane.add(txtUsername,3,8);
        gridPane.add(lblPassword,2,10);
        gridPane.add(txtPassword,3,10);
        gridPane.add(btnCreate,4,12);
        gridPane.add(btnBack,3,12);

        //button actions
        btnBack.setOnAction(actionEvent -> {
            stage.close();
            logIn();
        });

        btnCreate.setOnAction(actionEvent -> {
            Database database = new Database();
            if ((txtPassword.getText()=="") || (txtUsername.getText()=="")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please Enter Values!!");
                alert.show();
            }else{
                User.setUnamePswdFullNameEmail(txtUsername.getText(),txtPassword.getText(),txtFullName.getText(),txtEmail.getText());
                User.printArray();
                database.userAdd(txtUsername.getText(),txtPassword.getText(),txtFullName.getText(),txtEmail.getText());
            }
        });

        //Creating a javafx scene
        Scene scene = new Scene(gridPane, 400, 500);
        stage.setScene(scene);
        stage.show();
    }

    public GridPane landingPage(){
        //adding a grid pane
        GridPane gridPane = new GridPane();
        //horizontal gap in pixels
        gridPane.setHgap(20);
        //vertical gap in pixels
        gridPane.setVgap(20);
        //margins around the whole grid
        gridPane.setPadding(new Insets(10, 15, 15, 10));
        //gridPane.setStyle("-fx-background-image: url('Resourses/Login.png');-fx-background-cover: contain;-fx-background-repeat: no-repeat;");

        //Creating elements
        Label label = new Label("Enter Details");

        Label lblPhoto = new Label("Picture : ");
        Button btnSearch = new Button("Search");
        Button btnImage = new Button();

        Label lblFullName = new Label("Full Name : ");
        TextField txtFullName = new TextField();

        Label lblAbout = new Label("About : ");
        TextArea txtAbout = new TextArea();

        Label lblWorkXp = new Label("Work Xp : ");
        TextArea txtWorkXp = new TextArea();

        Label lblEdu = new Label("Education : ");
        TextArea txtEdu = new TextArea();

        Label lblSkill1 = new Label("Skill 1 : ");
        TextField txtSkill1 = new TextField();
        Label lblSkill2 = new Label("Skill 2 : ");
        TextField txtSkill2 = new TextField();
        Label lblSkill3 = new Label("Skill 3 : ");
        TextField txtSkill3 = new TextField();

        Label lblMobile = new Label("Mobile No : ");
        TextField txtMobile = new TextField();

        Label lblEmail = new Label("Email : ");
        TextField txtEmail = new TextField();

        Label lblArea = new Label("Area : ");
        TextField txtArea = new TextField();

        Label lblLinkedln = new Label("Linkedln : ");
        TextField txtLinkedln = new TextField();

        Label lblLang1 = new Label("Language 1 : ");
        TextField txtLang1 = new TextField();
        Label lblLang2 = new Label("Language 2 : ");
        TextField txtLang2 = new TextField();
        Label lblLang3 = new Label("Language 3 : ");
        TextField txtLang3 = new TextField();

        Label lblHobby1 = new Label("Hobby 1 : ");
        TextField txtHobby1 = new TextField();
        Label lblHobby2 = new Label("Hobby 2 : ");
        TextField txtHobby2 = new TextField();
        Label lblHobby3 = new Label("Hobby 3 : ");
        TextField txtHobby3 = new TextField();

        Button btnSave = new Button("Save");
        //Button btnClear = new Button("Clear");
        Button btnLogOut = new Button("Logout");
        Button btnGotoCv = new Button("Go To CV");

        //Adding javafx elements to the grid pane
        gridPane.add(lblPhoto,1,3); gridPane.add(btnImage,2,3); gridPane.add(btnSearch,2,3);
        gridPane.add(lblFullName,1,4);
        gridPane.add(txtFullName,2,4);
        gridPane.add(lblAbout,1,5);
        gridPane.add(txtAbout,2,5);
        gridPane.add(lblWorkXp,1,6);
        gridPane.add(txtWorkXp,2,6);
        gridPane.add(lblEdu,1,7);
        gridPane.add(txtEdu,2,7);
        gridPane.add(lblMobile,1,8);
        gridPane.add(txtMobile,2,8);
        gridPane.add(lblEmail,1,9);
        gridPane.add(txtEmail,2,9);
        gridPane.add(lblArea,1,10);
        gridPane.add(txtArea,2,10);
        gridPane.add(lblLinkedln,1,11);
        gridPane.add(txtLinkedln,2,11);

        gridPane.add(lblSkill1,8,3);gridPane.add(txtSkill1,9,3);
        gridPane.add(lblSkill2,8,4);gridPane.add(txtSkill2,9,4);
        gridPane.add(lblSkill3,8,5);gridPane.add(txtSkill3,9,5);
        gridPane.add(lblLang1,8,6);gridPane.add(txtLang1,9,6);
        gridPane.add(lblLang2,8,7);gridPane.add(txtLang2,9,7);
        gridPane.add(lblLang3,8,8);gridPane.add(txtLang3,9,8);
        gridPane.add(lblHobby1,8,9);gridPane.add(txtHobby1,9,9);
        gridPane.add(lblHobby2,8,10);gridPane.add(txtHobby2,9,10);
        gridPane.add(lblHobby3,8,11);gridPane.add(txtHobby3,9,11);
        gridPane.add(btnSave,2,14);
        gridPane.add(btnGotoCv,8,14);
        gridPane.add(btnLogOut,9,14);

        gridPane.add(label,1,1);

        //set login details to landing page
        Database database = new Database();
        database.loadUserData(username);
        txtFullName.setText(User.userArr[2]);
        txtAbout.setText(User.userArr[3]);
        txtWorkXp.setText(User.userArr[4]);
        txtEdu.setText(User.userArr[5]);
        txtMobile.setText(User.userArr[6]);
        txtEmail.setText(User.userArr[7]);
        txtArea.setText(User.userArr[8]);
        txtLinkedln.setText(User.userArr[9]);
        txtSkill1.setText(User.userArr[10]);
        txtSkill2.setText(User.userArr[11]);
        txtSkill3.setText(User.userArr[12]);
        txtLang1.setText(User.userArr[13]);
        txtLang2.setText(User.userArr[14]);
        txtLang3.setText(User.userArr[15]);
        txtHobby1.setText(User.userArr[16]);
        txtHobby2.setText(User.userArr[17]);
        txtHobby3.setText(User.userArr[18]);

        //adding styles for the elements
        GridPane.setHalignment(btnSave,HPos.RIGHT);
        GridPane.setHalignment(btnSearch,HPos.RIGHT);
        btnImage.setStyle("-fx-pref-width:60px;-fx-pref-height:180px;-fx-focus-color:transparent;-fx-faint-focus-color: transparent;");
        //btnImage.setDisable(true);

        btnSearch.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
            File file = fileChooser.showOpenDialog(null);
            //file.setTitle("Open File");
            //file.showOpenDialog(stageMenu);
            if (file != null) {
                Image image = new Image(file.toURI().toString());
                ImageView view = new ImageView(image);
                view.setFitHeight(50);
                view.setFitWidth(50);
                btnImage.setGraphic(view);
                Templates.img=view;
                //myImageView.setImage(image);
            }
        });

        btnSave.setOnAction(actionEvent -> {
            //Database database = new Database();
            User user = new User(txtAbout.getText(),txtWorkXp.getText(),txtEdu.getText(),txtMobile.getText(),txtArea.getText()
                    ,txtLinkedln.getText(),txtSkill1.getText(),txtSkill2.getText(),txtSkill3.getText(),txtLang1.getText(),txtLang2.getText(),txtLang3.getText(),txtHobby1.getText(),
                    txtHobby2.getText(),txtHobby3.getText());
            User.printArray();
            database.addUserDetails(user.userArr);
            User.printArray();
        });

        btnLogOut.setOnAction(actionEvent -> {
            //Platform.exit();
            stageMenu.close();
            logIn();
        });

        btnGotoCv.setOnAction(actionEvent -> {
            mainMenuStage(templateSelectionView(),0);
        });

        return gridPane;
    }
    public GridPane templateSelectionView(){
        //adding a grid pane
        GridPane gridPane = new GridPane();
        //horizontal gap in pixels
        gridPane.setHgap(20);
        //vertical gap in pixels
        gridPane.setVgap(20);
        //margins around the whole grid
        gridPane.setPadding(new Insets(10, 15, 15, 10));
        //gridPane.setStyle("-fx-background-image: url('Resourses/Login.png');-fx-background-cover: contain;-fx-background-repeat: no-repeat;");

        //creating elements
        Label lblDisplayInfo = new Label("Select Template");
        Button btnBack = new Button("Back");
        Button btnTemp1 = new Button();
        Button btnTemp2 = new Button();
        Button btnTemp3 = new Button();


        gridPane.add(btnBack,2,19);
        gridPane.add(btnTemp1,2,1);
        gridPane.add(btnTemp2,4,1);
        gridPane.add(btnTemp3,5,1);

        //btnBack.setStyle("-fx-pref-width:30px;");
        btnTemp1.setStyle("-fx-pref-width:300px;-fx-pref-height:250px;-fx-background-image: url('Resourses/1.png');-fx-background-size: cover;-fx-background-repeat: no-repeat;");
        btnTemp2.setStyle("-fx-pref-width:300px;-fx-pref-height:250px;-fx-background-image: url('Resourses/4-01.png');-fx-background-size: cover;-fx-background-repeat: no-repeat;");
        btnTemp3.setStyle("-fx-pref-width:300px;-fx-pref-height:250px;-fx-background-image: url('Resourses/9-01.png');-fx-background-size: cover;-fx-background-repeat: no-repeat;");

        btnBack.setOnAction(actionEvent -> {
            mainMenuStage(landingPage(),0);
        });

        Templates templates = new Templates();
        btnTemp1.setOnAction(actionEvent -> {
            templates.template1(User.userArr);
        });
        btnTemp2.setOnAction(actionEvent -> {
            templates.template2();
        });

        final ScrollPane sp = new ScrollPane();
        gridPane.add(sp,14,1);
        return gridPane;
    }
}
