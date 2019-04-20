package com.ayushtiwari.ManagerUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.*;

public class Welcome {

    @FXML
    private Label employeeName;

    public void initialize() {

        try {

            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Manager");

            employeeName.setText(resultSet.getString("name"));

        } catch (SQLException e) {
            System.out.println("Something went wrong" + e.getMessage());
        }

    }

}
