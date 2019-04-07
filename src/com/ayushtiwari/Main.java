package com.ayushtiwari;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        boolean managerExists = true;

        //Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1.db");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
        Statement st = conn.createStatement();
        st.execute("SELECT * FROM manager");
        ResultSet results = st.getResultSet();
        managerExists = results.next();
        results.close();
        st.close();
        conn.close();

        //See if manager exists in database, if not

        if (true) {
            Parent root = FXMLLoader.load(getClass().getResource("ManagerUI/managerDashboard.fxml"));
            primaryStage.setTitle("Welcome");
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("ManagerUI/managerSignUp.fxml"));
            primaryStage.setTitle("Manager Sign Up");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
        }

    }
}
