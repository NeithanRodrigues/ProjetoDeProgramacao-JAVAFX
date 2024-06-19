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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class CreditosController implements Initializable {

    private Stage stage;
    boolean isPrincipalLoaded, isCreditosLoaded, isPagamentosLoaded = false;
    double randomGerado, randomUsado;
    public Label labelPercMesGerada, labelPercMesUsada, labelEnergiaUsada, labelEnergiaGerada;
    @FXML
    public Label mesAnterior1, mesAnterior2, mesAnterior3, mesAnterior4, mesAnterior5, saldoRestanteLabel, saldoUnidade1, saldoUnidade2, saldoUnidade3, saldoUnidade4, saldoUnidade5, consumoUnidade1, consumoUnidade2, consumoUnidade3, consumoUnidade4, consumoUnidade5, geracaoUnidade1, geracaoUnidade2, geracaoUnidade3, geracaoUnidade4, geracaoUnidade5, idUnidade1, idUnidade2, idUnidade3, idUnidade4, idUnidade5;


    public void setLabelCreditosInHomePage() {
        // LABELS DOS BLOCOS DE ENERGIA
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
        double valueLabelSaldo = randomGerado - randomUsado;
        saldoRestanteLabel.setText(String.format("%.0f", valueLabelSaldo));
    }

    public void setLabelsInTabelaCreditos() {
        Random random = new Random();
        int maxValueGerado = 500000;
        int minValueGerado = 475000;
        int maxValueUsado = 600000;
        int minValueUsado = 550000;
        double randomGerado = random.nextDouble(maxValueGerado - minValueGerado + 1) + minValueGerado;
        double randomUsado = random.nextDouble(maxValueUsado - minValueUsado + 1) + minValueUsado;
        // COLUNA DE CONSUMO DE UNIDADE:
        List<Label> labelList = new ArrayList<>();
        labelList.add(consumoUnidade1);
        labelList.add(consumoUnidade2);
        labelList.add(consumoUnidade3);
        labelList.add(consumoUnidade4);
        labelList.add(consumoUnidade5);
        double energia;
        double energia2;
        double energia3;
        for (Label i : labelList) {
            int max = 6;
            int min = 4;
            int cont = random.nextInt(max - min + 1) + min;
            energia = randomUsado / cont;
            String energiaFormatada = String.format("%.2f", energia);
            i.setText(energiaFormatada + " kWh");
        }

        // COLUNA DE GERAÇÃO
        List<Label> labelList2 = new ArrayList<>();
        labelList2.add(geracaoUnidade1);
        labelList2.add(geracaoUnidade2);
        labelList2.add(geracaoUnidade3);
        labelList2.add(geracaoUnidade4);
        labelList2.add(geracaoUnidade5);
        for (Label label : labelList2) {
            int max = 6;
            int min = 4;
            double cont = random.nextDouble(max - min + 1) + min;
            energia2 = randomGerado / cont;
            String energiaFormatada = String.format("%.2f", energia2);
            label.setText(energiaFormatada + " kWh");
        }

        // COLUNA DE SALDO DE CRÉDITOS
        List<Label> labelList3 = new ArrayList<>();
        labelList3.add(saldoUnidade1);
        labelList3.add(saldoUnidade2);
        labelList3.add(saldoUnidade3);
        labelList3.add(saldoUnidade4);
        labelList3.add(saldoUnidade5);
        for (Label label : labelList3) {
            int max = 12500;
            int min = 7500;
            int cont = random.nextInt(max - min + 1) + min;
            label.setText(cont + " kWh");
        }

        List<Label> labelList4 = new ArrayList<>();
        labelList4.add(mesAnterior1);
        labelList4.add(mesAnterior2);
        labelList4.add(mesAnterior3);
        labelList4.add(mesAnterior4);
        labelList4.add(mesAnterior5);
        for (Label label : labelList4) {
            int max = 7;
            int min = 4;
            double cont = random.nextDouble(max - min + 1) + min;
            String contFormatada = String.format("%.2f", cont);
            label.setText(contFormatada + " %");
        }
    }

    public void setIdUnidadeTabela() {
        Random random = new Random();
        int minValue = 100_000_000;
        int maxValue = 1_000_000_000;
        int valorRandom1 = random.nextInt(maxValue - minValue + 1) + minValue;
        int valorRandom2 = random.nextInt(maxValue - minValue + 1) + minValue;
        int valorRandom3 = random.nextInt(maxValue - minValue + 1) + minValue;
        int valorRandom4 = random.nextInt(maxValue - minValue + 1) + minValue;
        int valorRandom5 = random.nextInt(maxValue - minValue + 1) + minValue;
        idUnidade1.setText(String.valueOf(valorRandom1));
        idUnidade2.setText(String.valueOf(valorRandom2));
        idUnidade3.setText(String.valueOf(valorRandom3));
        idUnidade4.setText(String.valueOf(valorRandom4));
        idUnidade5.setText(String.valueOf(valorRandom5));
    }

    @FXML
    void trocarParaPrincipal(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SolarApplication.class.getResource("tela-principal.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = fxmlLoader.load();
        HomepageController princiopalController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        if (!isPrincipalLoaded) {
            princiopalController.setLabelCreditosInHomePage();
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void trocarParaPagamentos(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SolarApplication.class.getResource("tela-pagamentos.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = fxmlLoader.load();
        PlanosController planosController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void trocarParaCreditos(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SolarApplication.class.getResource("tela-creditos.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
