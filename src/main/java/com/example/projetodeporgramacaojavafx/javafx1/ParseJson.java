package com.example.projetodeporgramacaojavafx.javafx1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.TableColumn;

import java.io.IOException;
import java.util.ArrayList;

public class ParseJson{
    public void getParse(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Converte a string JSON para um objeto JsonNode
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            for (JsonNode node : jsonNode) {
                String id = node.get("id").asText();
                int consumo = node.get("consumo").asInt();
                String localizacao = node.get("localizacao").asText();
                int geracao = node.get("geracao").asInt();
                int saldoRestante = node.get("saldoRestante").asInt();
                int percMesAnterior = node.get("percMesAnterior").asInt();
                ArrayList<String> colunas = new ArrayList<>();
                colunas.add(id);
                colunas.add(localizacao);
                colunas.add(String.valueOf(consumo));
                colunas.add(String.valueOf(geracao));
                colunas.add(String.valueOf(saldoRestante));
                colunas.add(String.valueOf(percMesAnterior));
                System.out.println(colunas);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
