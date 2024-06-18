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
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class PagamentosController implements Initializable {
    private Stage stage;
    boolean isPrincipalLoaded, isCreditosLoaded, isPagamentosLoaded = false;
    @FXML
    public Label id1Label, id2Label, id3Label, id4Label, id5Label, id6Label, id7Label, id8Label, id9Label, id10Label,id11Label, id12Label;

    void setIdLabels(){
        Random random = new Random();
        int minValue = 100_000_000;
        int maxValue = 1_000_000_000;
        int valorRandom1 = random.nextInt(maxValue - minValue + 1) + minValue;
        int valorRandom2 = random.nextInt(maxValue - minValue + 1) + minValue;
        int valorRandom3 = random.nextInt(maxValue - minValue + 1) + minValue;
        int valorRandom4 = random.nextInt(maxValue - minValue + 1) + minValue;
        int valorRandom5 = random.nextInt(maxValue - minValue + 1) + minValue;
        int valorRandom6 = random.nextInt(maxValue - minValue + 1) + minValue;
        int valorRandom7 = random.nextInt(maxValue - minValue + 1) + minValue;
        int valorRandom8 = random.nextInt(maxValue - minValue + 1) + minValue;
        int valorRandom9 = random.nextInt(maxValue - minValue + 1) + minValue;
        int valorRandom10 = random.nextInt(maxValue - minValue + 1) + minValue;
        int valorRandom11 = random.nextInt(maxValue - minValue + 1) + minValue;
        int valorRandom12 = random.nextInt(maxValue - minValue + 1) + minValue;
        id1Label.setText(String.valueOf(valorRandom1));
        id2Label.setText(String.valueOf(valorRandom2));
        id3Label.setText(String.valueOf(valorRandom3));
        id4Label.setText(String.valueOf(valorRandom4));
        id5Label.setText(String.valueOf(valorRandom5));
        id6Label.setText(String.valueOf(valorRandom6));
        id7Label.setText(String.valueOf(valorRandom7));
        id8Label.setText(String.valueOf(valorRandom8));
        id9Label.setText(String.valueOf(valorRandom9));
        id10Label.setText(String.valueOf(valorRandom10));
        id11Label.setText(String.valueOf(valorRandom11));
        id12Label.setText(String.valueOf(valorRandom12));

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
