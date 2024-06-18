package com.example.projetodeporgramacaojavafx.javafx1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PlanosController {
    private Stage stage;
    boolean isPrincipalLoaded, isCreditosLoaded, isPagamentosLoaded = false;

    // TROCA DE CENAS:
    @FXML
    void trocarParaPrincipal(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SolarApplication.class.getResource("tela-principal.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = fxmlLoader.load();
        HomepageController princiopalController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        if (!isPrincipalLoaded){
            princiopalController.setLabelCreditosInHomePage();
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    void trocarParaPagamentos(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SolarApplication.class.getResource("tela-pagamentos.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = fxmlLoader.load();
        PagamentosController pagamentosController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        if (!isPagamentosLoaded) {
            pagamentosController.setIdLabels();
        }
    }

    @FXML
    void trocarParaPlanos(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SolarApplication.class.getResource("tela-planos.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = fxmlLoader.load();
        PlanosController pagamentosController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void trocarParaCreditos(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SolarApplication.class.getResource("tela-creditos.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = fxmlLoader.load();
        CreditosController creditosController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        if (!isCreditosLoaded) {
            creditosController.setLabelCreditosInHomePage();
            creditosController.setIdUnidadeTabela();
            creditosController.setLabelsInTabelaCreditos();
        }
        stage.setScene(scene);
        stage.show();
    }
}
