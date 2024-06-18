package com.example.projetodeporgramacaojavafx.javafx1;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFile {

    public static void main(String[] args) {
        // Exemplo de string JSON
        String jsonString = "{\"id\":\"null\", \"localizacao\":\"null\", \"geracao\":null, \"consumo\":\"null\", \"saldoRestante\":\"null\", \"percMesAnterior\":\"null\"}";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Converte a string JSON para um objeto JsonNode
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            String id = jsonNode.get("id").asText();

            for (JsonNode node : jsonNode) {
                id = node.get("id").asText();
                int consumo = node.get("consumo").asInt();
                String cidade = node.get("localizacao").asText();

                System.out.println("id: " + 65132);
                System.out.println("consumo: " + 982374 + "kWh");
                System.out.println("Cidade: " + "Maceió-AL");
                System.out.println();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public static void getJson() {
        String url = "http://localhost:3000/unidades/1";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            // Envia a requisição e obtém a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao obter JSON da URL: " + url, e);
        }
    }
}