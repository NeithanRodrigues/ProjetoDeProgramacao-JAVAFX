package com.example.projetodeporgramacaojavafx.javafx1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.io.File;
import java.awt.Desktop;

public class HomepageController implements Initializable {
    private Stage stage;
    boolean isPrincipalLoaded, isCreditosLoaded, isPagamentosLoaded = false;
    public Label labelPercMesGerada, labelPercMesUsada, labelEnergiaUsada,  labelEnergiaGerada;
    @FXML
    public Label saldoRestanteLabel;

    public void setLabelCreditosInHomePage(){
        // LABELS DOS BLOCOS DE ENERGIA NA PÁGINA PRINCIPAL E NA PÁGINA DE CRÉDITOS
        Random random = new Random();
        int maxValueGerado = 500000;
        int minValueGerado = 475000;
        int maxValueUsado = 600000;
        int minValueUsado = 550000;
        double randomGerado = random.nextDouble(maxValueGerado - minValueGerado + 1) + minValueGerado;
        double randomUsado = random.nextDouble(maxValueUsado - minValueUsado + 1) + minValueUsado;
        int maxValuePerc = 25;
        int minValuePerc = 15;
        double randomPerc1 = random.nextDouble(maxValuePerc - minValuePerc + 1) + minValuePerc;
        double randomPerc2 = random.nextDouble(maxValuePerc - minValuePerc + 1) + minValuePerc;
        String perc1Formatado = String.format("%.2f", randomPerc1);
        String perc2Formatado = String.format("%.2f", randomPerc2);
        labelEnergiaGerada.setText(String.format("%.0f", randomGerado));
        labelEnergiaUsada.setText(String.format("%.0f", randomUsado));
        labelPercMesGerada.setText("+" + perc1Formatado + "% em relação ao último mês.");
        labelPercMesUsada.setText("+" + perc2Formatado + "% em relação ao último mês.");
        double valueLabelSaldo = randomGerado -randomUsado;
        saldoRestanteLabel.setText(String.format("%.0f", valueLabelSaldo));
    }

    public void emitirBoletos(javafx.scene.input.MouseEvent mouseEvent) {
        String filePath = "src/main/resources/com/example/projetodeporgramacaojavafx/boletos/docBoleto.pdf";
        File file = new File(filePath);
        if (file.exists()) {
            try {
                String os = System.getProperty("os.name").toLowerCase();

                if (os.contains("win")) {
                    Desktop.getDesktop().open(file);
                }
                else {
                    Runtime.getRuntime().exec("xdg-open " + filePath);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("O arquivo não existe: " + file.getName());
        }
    }

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
        PlanosController planosController = fxmlLoader.getController();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
