package com.example.projetodeporgramacaojavafx.javafx1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SolarApplication extends Application {

    @Override
    public void start(Stage start) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SolarApplication.class.getResource("tela-principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        HomepageController solarController = fxmlLoader.getController();
        solarController.setLabelCreditosInHomePage();
        start.setScene(scene);
        start.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
