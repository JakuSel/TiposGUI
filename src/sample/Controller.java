package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Collections;

public class Controller {

    //Login
    public TextField username;
    public PasswordField pass;
    public Label errLabel;
    public Button loginButton;
    public ImageView logo;
    public ImageView imgAdmin;
    public ImageView imgPass;

    //Generator
    public Button gen;
    public Label winNumbers;

    public void clickLogin(ActionEvent actionEvent) throws Exception{
        errLabel.setText("");
        String login = username.getText().trim();
        String password = pass.getText().trim();
        System.out.println(login+" "+password);

        if(login.length()<1 || password.length()<2){
            errLabel.setText("Incorrect login or password!");
        }else {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Generate.fxml"));
            Stage newStage = new Stage();
            newStage.setTitle("Generator");
            newStage.setScene(new Scene(root, 450, 300));
            newStage.show();
            stage.close();
        }
    }

    public void btnGenerate(ActionEvent actionEvent) throws Exception{

        Integer[] arr = new Integer[35];
        Integer[] arrTipos = new Integer[5];
        for (int i = 0; i <arr.length; i++) {
            arr[i] = i+1;
        }

        Collections.shuffle(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));
        arrTipos=Arrays.copyOf(arr,5);
        Arrays.sort(arrTipos);
        System.out.println(Arrays.toString(arrTipos));

        StringBuilder stringBuilder = new StringBuilder();


        for (int i = 0; i <5; i++) {

            System.out.println(Integer.toString(arrTipos[i]));
            stringBuilder.append(Integer.toString(arrTipos[i]));
            stringBuilder.append("  ");
            winNumbers.setText(stringBuilder.toString());
        }





    }




}
