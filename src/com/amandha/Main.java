//Made By : Tiaz Rizqy Amandha 1772052
package com.amandha;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/modul1_P02.fxml"));
        primaryStage.setTitle("Praktikum minggu#2");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }



}
