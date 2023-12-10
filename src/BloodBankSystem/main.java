
package BloodBankSystem;

/**
 *
 * @author Yousef Saif - Yahya Elimam - Abdulkarim Alsorori
 */


import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
public class main extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        
    }
    

    @Override
    public void start(Stage stage) throws Exception {
        
        // password and username will be printed in the console
        
        
        Hospital h = new Hospital("aybu", 400,"Aybu","9898");
        //h.writeDate();
        h.readData();
        
        
        System.out.println("username: " + h.getUsername());
        System.out.println("password: " + h.getPassword());
       
        // the sizes of most of the scenes and buttons
        int ButtonSize = 40;
        int sceneSize = 650;
        
        // 
        stage.setTitle("Login");
        
        // a pane for the login scene
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        
        

        btn.setOnAction(elogin ->  {

            // if the username and password are right
            if(pwBox.getText().equals(h.getStore().getPassword()) && userTextField.getText().equals(h.getStore().getUserName())){
                
            // pane that will contain everything in the main Scene
            BorderPane bPane = new BorderPane();
            Scene scene = new Scene(bPane,sceneSize,sceneSize);

            // initialize the photos and set the size of them


            ImageView searchImage = new  ImageView("file:images\\search.png");
            searchImage.setFitWidth(40);
            searchImage.setFitHeight(40);

            ImageView checkImage = new  ImageView("file:images\\check .png");
            checkImage.setFitWidth(40);
            checkImage.setFitHeight(40);
            
            ImageView userImage = new  ImageView("file:images\\user.png");
            userImage.setFitWidth(40);
            userImage.setFitHeight(40);

            ImageView homeImage = new  ImageView("file:images\\home.png");
            homeImage.setFitWidth(40);
            homeImage.setFitHeight(40);

            ImageView infoImage = new  ImageView("file:images\\info.png");
            infoImage.setFitWidth(40);
            infoImage.setFitHeight(40);

            ImageView requestImage = new  ImageView("file:images\\request.png");
            requestImage.setFitWidth(40);
            requestImage.setFitHeight(40);

            ImageView showInfoImage = new  ImageView("file:images\\show info.png");
            showInfoImage.setFitWidth(40);
            showInfoImage.setFitHeight(40);

            ImageView donateImage = new  ImageView("file:images\\donate blood main.png");
            donateImage.setFitWidth(40);
            donateImage.setFitHeight(40);

            //initialize the buttons for the main pane and add them to it
            Button btdonate = new Button("Donate",donateImage);
            Button btrequest = new Button("Request",requestImage);
            Button btinfo = new Button("Info",infoImage);
            Button btSearch = new Button("Search",searchImage);
            Button btUser=new Button("User",userImage);
            //keep all button in the same pane and add the pane to the main pane
            HBox paneForButton = new HBox();
            paneForButton.getChildren().addAll(btdonate,btinfo,btrequest,btSearch,btUser);
            paneForButton.setAlignment(Pos.CENTER);
            paneForButton.setSpacing(20);
            bPane.setCenter(paneForButton);
            
            

            //create a home button and a pane for it so i can set it to the center of any other pane
            Button homeButton = new Button("Home",homeImage);
            homeButton.setMaxHeight(ButtonSize);
            homeButton.setMaxWidth(100);
            BorderPane paneForHomeButton = new BorderPane();
            paneForHomeButton.setCenter(homeButton);
            
            homeButton.setMaxWidth(150);
            homeButton.setOnAction(ehome->{
                    stage.setScene(scene);
                });

            // if the user button is pressed
            btUser.setOnAction(euser->{
                
                // create a pane and add the text and the textField and the buttons
                GridPane userGridPane=new GridPane();
                Text username=new Text("Current Username: "+h.getStore().getUserName());
                Text password=new Text("Current Passwors: "+h.getStore().getPassword());
                Text info=new Text();
                TextField Username=new TextField();
                TextField Password=new TextField();
                Button save=new Button("Save");
                
                // create a pane if the user want to change the password or the username
                BorderPane userBorderPane=new BorderPane();
                userGridPane.add(username, 1, 0);
                userGridPane.add(password, 1, 1);
                userGridPane.add(new Text("Edit"),1,3);
                userGridPane.add(new Text("New Username"),0,4);
                userGridPane.add(Username,1, 4);
                userGridPane.add(new Text("New Password"), 0, 5);
                userGridPane.add(Password,1,5);
                userGridPane.add(save, 1, 6);
                userGridPane.add(homeButton, 1, 7);
                //userGridPane.add(info, 1, sceneSize);
                userGridPane.setAlignment(Pos.CENTER);
                userBorderPane.setCenter(userGridPane);
                userBorderPane.setBottom(info);
                userBorderPane.setTop(paneForHomeButton);
                
                // if button save pressed
                save.setOnAction(eSave->{
                    
                    // if the username textField and the password TextField are not empty
                   if (!Username.getText().equals("") && !Password.getText().equals("")){
                        h.setUsername(Username.getText());
                        h.setPassword(Password.getText());
                        info.setText("The Username and the Password have been changed");
                   }
                   else if(!Username.getText().equals("")){
                        h.setUsername(Username.getText());
                        info.setText("The Username has been changed");

                    }
                   else if (!Password.getText().equals("")){
                        h.setPassword(Password.getText());
                                    info.setText("The Password has been changed");

                    }

                    System.out.println("the new user= "+h.getStore().getUserName());
                    System.out.println("the new pass: "+h.getStore().getPassword());
                });







                Scene userScene=new Scene(userBorderPane,500,500);

                stage.setScene(userScene);


            });
            
            // if the button request have been pressed
            btrequest.setOnAction(erequest->{

                // create a new pane and add the TextFields to it
                GridPane paneForPatiant= new GridPane();
                TextField name = new TextField();
                TextField id = new TextField();
                TextField number = new TextField();
                TextField amount = new TextField();
                Button takeBloodBt = new Button("Take Blood");
                //GridPane paneForPatiant2= new GridPane();

                // create a pane for the postive blood type
                HBox paneForBloodType = new HBox();
                paneForBloodType.setPadding(new Insets(5, 5, 5, 5));
                
                // create a pane for the negative blood type
                HBox paneForBloodTypeNeg = new HBox();
                paneForBloodTypeNeg.setPadding(new Insets(5, 5, 5, 5));

                // create the buttons for the blood types and adding them to the panes
                RadioButton a = new RadioButton("A Rh+");
                RadioButton b = new RadioButton("B Rh+");
                RadioButton ab = new RadioButton("AB Rh+");
                RadioButton o = new RadioButton("O Rh+");
                RadioButton aneg= new RadioButton("A Rh-");
                RadioButton bneg= new RadioButton("B Rh-");
                RadioButton abneg= new RadioButton("AB Rh-");
                RadioButton oneg= new RadioButton("O Rh-");

                paneForBloodType.getChildren().addAll(a,b,ab,o);
                paneForBloodType.setAlignment(Pos.CENTER);
                paneForBloodType.setSpacing(5);

                paneForBloodTypeNeg.getChildren().addAll(aneg,bneg,abneg,oneg);
                paneForBloodTypeNeg.setAlignment(Pos.CENTER);
                paneForBloodTypeNeg.setSpacing(10);

                // add the buttons of the blood type to a ToggleGroup
                ToggleGroup bloodTypeGroup = new ToggleGroup();
                a.setToggleGroup(bloodTypeGroup);
                b.setToggleGroup(bloodTypeGroup);
                ab.setToggleGroup(bloodTypeGroup);
                o.setToggleGroup(bloodTypeGroup);
                aneg.setToggleGroup(bloodTypeGroup);
                bneg.setToggleGroup(bloodTypeGroup);
                abneg.setToggleGroup(bloodTypeGroup);
                oneg.setToggleGroup(bloodTypeGroup);
                
                // add the TextField and the Texts to the pane
                paneForPatiant.add(new Text("Name"), 0, 0);
                paneForPatiant.add(new Text("ID (11 digit)"), 0, 1);
                paneForPatiant.add(new Text("Number"), 0, 2);
                paneForPatiant.add(new Text("amount"), 0, 3);
                paneForPatiant.add(new Text("Blood Type"), 0, 4);
                paneForPatiant.add(name, 1, 0);
                paneForPatiant.add(id, 1, 1);
                paneForPatiant.add(number, 1, 2);
                paneForPatiant.add(amount, 1, 3);
                paneForPatiant.add(paneForBloodType, 1, 4);
                paneForPatiant.add(paneForBloodTypeNeg, 1, 5);
                paneForPatiant.add(takeBloodBt, 1, 6);
                paneForPatiant.add(homeButton, 1, 7);

                
                paneForPatiant.setAlignment(Pos.CENTER);

              

                Scene patiantScene = new Scene(paneForPatiant,sceneSize,sceneSize);
                stage.setScene(patiantScene);

                




                // create a patient to use it if the button is pressed
                Patient temp = new Patient("temp", 0, BloodType.A, "temp ");

                    // if the id length is less than 10 the button will be disabled
                    id.setOnKeyTyped(eCheckId ->{
                        //if the id dosen't consist of 10 digits the donate button will not work
                        if(id.getText().length() != 10)
                        {
                            takeBloodBt.setDisable(true);

                        }

                        // if the id consist of 10 digits it will work
                        else 
                        {
                            takeBloodBt.setDisable(false);

                        }
                    });



                // if takeBlood button is pressed
                takeBloodBt.setOnAction(es ->{
                    
                    // set the name and the amount of the patient
                    temp.setName(name.getText());
                    temp.setAmount(Double.valueOf(amount.getText()));
                    
                    //temp.setNumber(number.getText());
                    temp.setId(id.getText());
                    
                    // set the blood type of the patient
                  if (a.isSelected())
                            temp.setBloodType(BloodType.A);

                         if(aneg.isSelected())
                             temp.setBloodType(BloodType.Aneg);

                        if (b.isSelected())
                            temp.setBloodType(BloodType.B);

                        if (bneg.isSelected())
                            temp.setBloodType(BloodType.Bneg);

                        if (ab.isSelected())
                            temp.setBloodType(BloodType.AB);

                        if (abneg.isSelected())
                            temp.setBloodType(BloodType.ABneg);

                        if (o.isSelected())
                          temp.setBloodType(BloodType.O);

                        if (oneg.isSelected())
                            temp.setBloodType(BloodType.Oneg);

                     System.out.println(temp.getBloodType());

                     
                     // if the there was enough blood
                    if (h.takeBlood(temp)){
                        GridPane takeTrue = new GridPane();
                        takeTrue.add(new Text("The operation has been completed successfully"), 0, 0);
                        takeTrue.add(homeButton, 0, 1);
                        takeTrue.setAlignment(Pos.CENTER);
                        Scene accept = new Scene(takeTrue,sceneSize,sceneSize);
                        stage.setScene(accept);
                    }
                    
                    // if there wasn't enough blood
                    else{
                        GridPane takeFalse = new GridPane();
                        takeFalse.add(new Text("There is no enough blood, we will put you in the waiting list"), 0, 0);
                        takeFalse.add(homeButton, 0, 1);
                        takeFalse.setAlignment(Pos.CENTER);
                        Scene reject = new Scene(takeFalse,sceneSize,sceneSize);
                        stage.setScene(reject);

                    }
                    stage.show();
                    });

            });

            
            //if button info is pressed
            btinfo.setOnAction(e -> {

                    // check from the others
                    RadioButton showAllDonor = new RadioButton("Donor list");
                    RadioButton showAllPatient = new RadioButton("Patient list");
                    RadioButton showWaitingDonor = new RadioButton("Donor waiting list");
                    RadioButton showWaitingPatient = new RadioButton("Patient waiting list");
                    RadioButton showInfoHospital= new RadioButton("Hospital info");
                    
                    VBox paneSearchButtons = new VBox();
                    paneSearchButtons.getChildren().addAll(showAllDonor,showAllPatient,showWaitingDonor,showWaitingPatient,showInfoHospital);
                    paneSearchButtons.setSpacing(40);
                    
                    Button btShowInfo = new Button("Show Info",showInfoImage);
                    btShowInfo.setMaxWidth(400);

                    //add them to a toggle group
                    ToggleGroup InfoGroup = new ToggleGroup();
                    showAllDonor.setToggleGroup(InfoGroup);
                    showAllPatient.setToggleGroup(InfoGroup);
                    showWaitingDonor.setToggleGroup(InfoGroup);
                    showWaitingPatient.setToggleGroup(InfoGroup);
                    showInfoHospital.setToggleGroup(InfoGroup);

                    BorderPane paneForInfo = new BorderPane();
                    paneForInfo.setLeft(paneSearchButtons);
                    HBox b = new HBox();
                    b.getChildren().addAll(btShowInfo,homeButton);
                    b.setAlignment(Pos.CENTER);
                    paneForInfo.setTop(b);
                    
                    // create a pane and add the buttons to it
                   

                    // if the button is show info is pressed
                    btShowInfo.setOnAction(eshow -> {
                        
                        // create a scroll pane cause of the long texts
                        
                        Text text = new Text();
                        text.wrappingWidthProperty().bind(scene.widthProperty());
                        
                        
                        if(showAllDonor.isSelected())
                            text.setText(h.showInfoDonorAll());

                        else if(showAllPatient.isSelected())
                            text.setText(h.showPatientInfoAll());

                        else if(showWaitingDonor.isSelected())
                            text.setText(h.showWaitingListDonor());

                        else if(showWaitingPatient.isSelected())
                            text.setText(h.showWaitListPatient());

                        else if(showInfoHospital.isSelected())
                            text.setText(h.ShowInfoStore());
                        
                        System.out.println(text.getText());
                        
                        ScrollPane infoText = new ScrollPane();
                        //create a text to hold the info
                        infoText.setFitToWidth(true);
                        // set the info in the ScrollPane
                        infoText.setContent(text);
                        paneForInfo.setCenter(infoText);
                        
                        paneForInfo.setCenter(infoText);
                        
                        

                        

                        
                    });


                    //BorderPane infoPane = new BorderPane();
                    //infoPane.setCenter(paneForInfo);
                    
                    Scene infoScene = new Scene(paneForInfo,700,sceneSize);

                    
                    stage.setScene(infoScene);




            });

            // if the button search is pressed
            btSearch.setOnAction(e -> {

                //Create a pane and add the buttons to it
                GridPane searchGridPane=new GridPane();
                Button searchDonor=new Button("Donor Search");
                Button searchPatiant=new Button("Patiant Search");
                TextField id=new TextField();
                
                
                // add the buttons and the TextField to the pane
                searchGridPane.add(new Text("ID"), 0, 0);
                searchGridPane.add(id, 1,0 );
                searchGridPane.add(searchDonor, 1, 1);
                searchGridPane.add(searchPatiant, 1, 2);
                searchGridPane.add(homeButton, 1, 3);
                searchGridPane.setAlignment(Pos.CENTER);
                
                
                
                id.setOnKeyTyped(eCheckId ->{
                        //if the id dosen't consist of 10 digits the donate button will not work
                        if(id.getText().length() != 10)
                        {
                            searchDonor.setDisable(true);
                            searchPatiant.setDisable(true);

                        }

                        // if the id consist of 10 digits it will work
                        else 
                        {
                            searchDonor.setDisable(false);
                            searchPatiant.setDisable(false);

                        }
                    });
                
                
                // here we will display the result of the search
                Text searchResult=new Text();

                // if the button is pressed the search result will be added to the pane
                searchDonor.setOnAction(eh->{
                    searchResult.setText(h.searchDonor(id.getText()));
            });
                
                // here we will call the function searchDonor from Hospital
                searchPatiant.setOnAction(eh->{
                    searchResult.setText(h.searchPatient(id.getText()));
            });

                searchGridPane.add(searchResult, 1, 4);


                Scene searchScene = new Scene(searchGridPane,sceneSize,sceneSize);
                stage.setScene(searchScene);
            });

            
            // if the button Donate was pressed
            btdonate.setOnAction(e ->{



                //initialize the temp donor 
                Donor donor = new Donor("temp", 0, BloodType.A, "temp", "temp");

                // initialize the pane that will keep the disease's pane and the button
                BorderPane diseasePane = new BorderPane();
                Button cont = new Button("Continue",checkImage);
                cont.setMaxHeight(ButtonSize);
                cont.setMaxWidth(150);

                Text describeDisease = new Text(" if you have\n any of these\n diseases you can't\n don't blood"
                        + "if\n you have any\n other diseases\n please inform\n the employee");

                describeDisease.setFont(Font. font("Verdana", FontWeight. BOLD, 15));


                // initialize and add the check Boxes to the pane of the disease
                GridPane paneForDisease = new GridPane();
                paneForDisease.setPadding(new Insets(5, 5, 5, 5)); 
                CheckBox disease1 = new CheckBox("HIV");
                CheckBox disease2 = new CheckBox("Myeloma");
                CheckBox disease3 = new CheckBox("Leukemia");
                CheckBox disease4 = new CheckBox("Lymphoma");
                Text QusetionText = new Text("Do you have\nany of these\ndisease?");
                QusetionText.setFont(Font. font("Verdana", FontWeight. BOLD, 15));
                
                paneForDisease.add(QusetionText, 0, 0);
                paneForDisease.add(disease2,0,1);
                paneForDisease.add(disease3,0,2);
                paneForDisease.add(disease4,0,3);
                paneForDisease.add(disease1,0,5);
                paneForDisease.add(cont,0,7);
                paneForDisease.add(describeDisease, 0, 8);
                paneForDisease.setVgap(5);
                diseasePane.setTop(paneForHomeButton);

                //if any of the check boxes is selected the states will turn to false
                //which means he can't donate
                EventHandler<ActionEvent> handler = d -> { 
                    if (disease1.isSelected() || disease2.isSelected() || disease3.isSelected() || disease4.isSelected()) {
                      donor.setState(false);
                    }

                  };

                disease1.setOnAction(handler);
                disease2.setOnAction(handler);
                disease3.setOnAction(handler);
                disease4.setOnAction(handler);
                
                
                diseasePane.setTop(paneForHomeButton);
                
                paneForDisease.setAlignment(Pos.CENTER);
                diseasePane.setCenter(paneForDisease);


                //if the button continue is pressed
                cont.setOnAction(conte ->{

                    // if the donor can donate(state == true)
                    if(donor.getState())
                    {

                    // initialize the button and the text fields and the pane
                    GridPane paneForDonate = new GridPane();
                    Button donateButton = new Button("Donate",donateImage);
                    TextField name = new TextField();
                    TextField id = new TextField();
                    TextField number = new TextField();
                    TextField amount = new TextField();

                    // initialize a pane for the postive blood types
                    HBox paneForBloodType = new HBox();
                    paneForBloodType.setPadding(new Insets(5, 5, 5, 5));

                    // initialize a pane for the negative blood types
                    HBox paneForBloodTypeNeg = new HBox();
                    paneForBloodTypeNeg.setPadding(new Insets(5, 5, 5, 5));

                    // initialize the Randiobuttons and add them to the togglegroup
                    RadioButton a = new RadioButton("A Rh+");
                    RadioButton b = new RadioButton("B Rh+");
                    RadioButton ab = new RadioButton("AB Rh+");
                    RadioButton o = new RadioButton("O Rh+");
                    RadioButton aneg= new RadioButton("A Rh-");
                    RadioButton bneg= new RadioButton("B Rh-");
                    RadioButton abneg= new RadioButton("AB Rh-");
                    RadioButton oneg= new RadioButton("O Rh-");

                    // add the blood types to a ToggleGruop
                    ToggleGroup bloodTypeGroup = new ToggleGroup();
                    a.setToggleGroup(bloodTypeGroup);
                    b.setToggleGroup(bloodTypeGroup);
                    ab.setToggleGroup(bloodTypeGroup);
                    o.setToggleGroup(bloodTypeGroup);
                    aneg.setToggleGroup(bloodTypeGroup);
                    bneg.setToggleGroup(bloodTypeGroup);
                    abneg.setToggleGroup(bloodTypeGroup);
                    oneg.setToggleGroup(bloodTypeGroup);


                    paneForBloodType.getChildren().addAll(a,b,ab,o);
                    paneForBloodType.setAlignment(Pos.CENTER);
                    paneForBloodType.setSpacing(5);

                    paneForBloodTypeNeg.getChildren().addAll(aneg,bneg,abneg,oneg);
                    paneForBloodTypeNeg.setAlignment(Pos.CENTER);
                    paneForBloodTypeNeg.setSpacing(10);
                    

                    // adding the everything to the pane
                    paneForDonate.add(new Text("Name"), 0, 0);
                    paneForDonate.add(new Text("ID(11 digits)"), 0, 1);
                    paneForDonate.add(new Text("Number"), 0, 2);
                    paneForDonate.add(new Text("amount"), 0, 3);
                    paneForDonate.add(new Text("Blood Type"), 0, 4);
                    paneForDonate.add(name, 1, 0);
                    paneForDonate.add(id, 1, 1);
                    paneForDonate.add(number, 1, 2);
                    paneForDonate.add(amount, 1, 3);
                    paneForDonate.add(paneForBloodType, 1, 4);
                    paneForDonate.add(paneForBloodTypeNeg, 1, 5);
                    paneForDonate.add(donateButton, 1, 6);
                    paneForDonate.add(homeButton,1,7);
                    paneForDonate.setAlignment(Pos.CENTER);



                    //to check if the id consist of 10 digits
                    id.setOnKeyTyped(eCheckId ->{
                        //if the id dosen't consist of 10 digits the donate button will be disabled
                        if(id.getText().length() != 10)
                        {
                            donateButton.setDisable(true);
                        }

                        // if the id consist of 10 digits it will work
                        else if(id.getText().length() == 10)
                        {
                            donateButton.setDisable(false);
                        }
                    });


                    // if the donatebutton is pressed
                donateButton.setOnAction(dbe ->{


                        // to set the blood type
                        if (a.isSelected())
                            donor.setBloodType(BloodType.A);

                        if(aneg.isSelected())
                             donor.setBloodType(BloodType.Aneg);

                        if (b.isSelected())
                            donor.setBloodType(BloodType.B);

                        if (bneg.isSelected())
                            donor.setBloodType(BloodType.Bneg);

                        if (ab.isSelected())
                            donor.setBloodType(BloodType.AB);

                        if (abneg.isSelected())
                            donor.setBloodType(BloodType.ABneg);

                        if (o.isSelected())
                          donor.setBloodType(BloodType.O);

                        if (oneg.isSelected())
                            donor.setBloodType(BloodType.Oneg);




                    // set all the info of the donor
                    donor.setName(name.getText());
                    donor.setAmount(Double.valueOf(amount.getText()));
                    donor.setNumber(number.getText());
                    donor.setId(id.getText());

                    // the donor have been add
                    if(h.addDonor(donor))
                    {
                        GridPane acceptPane = new GridPane();
                        acceptPane.add(new Text("Thank you for your donation " + donor.getName()), 0, 0);
                        acceptPane.add(homeButton, 0, 5);
                        acceptPane.setAlignment(Pos.CENTER);
                        acceptPane.setVgap(20);
                        
                        Scene accept = new Scene(acceptPane,sceneSize,sceneSize);
                        stage.setScene(accept);
                    }

                    // if there is no space in the store
                    else
                    {
                        VBox noSpace = new VBox();
                        noSpace.getChildren().add(new Text("Sorry there is no enough space in the store\n "
                                + "we will put you in the waiting list"));
                        noSpace.getChildren().add(homeButton);
                        noSpace.setSpacing(15);
                        noSpace.setAlignment(Pos.CENTER);
                        
                        Scene noSpaceScene = new Scene(noSpace,sceneSize,sceneSize);
                        stage.setScene(noSpaceScene);
                    }



                });



                // then we will put the paneForDonate that contains all the other panes in the scene
                Scene infoScene = new Scene(paneForDonate,sceneSize,sceneSize);

                stage.setScene(infoScene);


                }
                    // if the state of the donor is false(he have a disease)
                    else if(!donor.getState()){
                        GridPane rejectPane = new GridPane();
                        rejectPane.add(new Text("sorry but you can't donate"), 0, 0);
                        rejectPane.add(homeButton, 0, 5);
                        rejectPane.setAlignment(Pos.CENTER);
                        rejectPane.setVgap(8);
                        
                        Scene rejectScene = new Scene(rejectPane,sceneSize,sceneSize);
                        stage.setScene(rejectScene);

                    }

                });



                Scene diseaseScene = new Scene(diseasePane,sceneSize,sceneSize);
                stage.setScene(diseaseScene);

            });

            
           System.out.println(h.getStore().toString());
            
            stage.setTitle("AYBU Blood Bank");

            stage.setScene(scene);
            stage.show();
                }

                // if the password was wrong
                else
                {
                    Stage stage2 = new Stage();
                    Scene loginFail = new Scene(new Button("Wrong password or username"),250,150);
                    stage2.setScene(loginFail);
                    stage2.setTitle("Wrong info");
                    stage2.show();
                }

        });
                                        
        h.writeDate();
        
        Scene scene = new Scene(grid, 400, 400);
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:images\\donate blood main.png"));
        stage.show();
        
    }

}   

