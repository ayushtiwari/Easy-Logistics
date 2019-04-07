package com.ayushtiwari;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    boolean managerExists = true;
    @Override
    public void start(Stage primaryStage) throws Exception {
      try {
//        Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TrasportCompany/database1.db");

          Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TrasportCompany//database1.db");
          Statement st = conn.createStatement();
          st.execute("SELECT * FROM manager");
          ResultSet results = st.getResultSet();
          managerExists = results.next();
      }catch(SQLException e){
          System.out.println("Something went wrong: " + e.getMessage());
      }

        //See if manager exists in database, if not


        if (managerExists) {
            Parent root = FXMLLoader.load(getClass().getResource("welcomeScreen.fxml"));
            primaryStage.setTitle("Welcome");
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("managerSignUp.fxml"));
            primaryStage.setTitle("Manager Sign Up");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
        }

    }
}
