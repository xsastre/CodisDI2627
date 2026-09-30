package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Label lblNom = new Label("Nom:");
        Label lblEmail = new Label("Email:");
        Label lblTelefon = new Label("Telèfon:");

        TextField txtNom = new TextField();
        TextField txtEmail = new TextField();
        TextField txtTelefon = new TextField();

        Button btnGuardar = new Button("Guardar");

        btnGuardar.setOnAction(e -> {

            String nom = txtNom.getText();
            String email = txtEmail.getText();
            String telefon = txtTelefon.getText();

            try (FileWriter writer = new FileWriter("dades.txt", true)) {

                writer.write("Nom: " + nom + "\n");
                writer.write("Email: " + email + "\n");
                writer.write("Telèfon: " + telefon + "\n");
                writer.write("---------------------\n");

                Alert alert =
                        new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Correcte");
                alert.setHeaderText(null);
                alert.setContentText("Dades guardades.");

                alert.showAndWait();

                txtNom.clear();
                txtEmail.clear();
                txtTelefon.clear();

            } catch (IOException ex) {

                Alert alert =
                        new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Error en guardar les dades.");

                alert.showAndWait();
            }
        });

        GridPane grid = new GridPane();

        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(lblNom, 0, 0);
        grid.add(txtNom, 1, 0);

        grid.add(lblEmail, 0, 1);
        grid.add(txtEmail, 1, 1);

        grid.add(lblTelefon, 0, 2);
        grid.add(txtTelefon, 1, 2);

        grid.add(btnGuardar, 1, 3);

        Scene scene = new Scene(grid, 400, 200);

        //grid.add(new Label("Posicio 4,0"), 0,4);
        //grid.add(new Label("Posicio 4,3"), 3,4);
        //Label novaetiqueta = new Label("Posicio 0,5");
        //novaetiqueta.setPrefWidth(150);
        //grid.add(novaetiqueta, 5,0);

        stage.setTitle("Formulari JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}