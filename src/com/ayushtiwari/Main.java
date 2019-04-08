package com.ayushtiwari;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {


        //See if manager exists in database, if not


        boolean managerExists = true;
        Parent root = FXMLLoader.load(getClass().getResource("welcomeScreen.fxml"));
        primaryStage.setTitle("Welcome");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
//        if (managerExists) {
//            Parent root = FXMLLoader.load(getClass().getResource("welcomeScreen.fxml"));
//            primaryStage.setTitle("Welcome");
//            Scene scene = new Scene(root);
//            primaryStage.setScene(scene);
//            primaryStage.setResizable(false);
//            primaryStage.show();
//        } else {
//            Parent root = FXMLLoader.load(getClass().getResource("managerSignUp.fxml"));
//            primaryStage.setTitle("Manager Sign Up");
//            primaryStage.setScene(new Scene(root));
//            primaryStage.setResizable(false);
//            primaryStage.show();
//        }

    }
}
