package com.example.projetodeporgramacaojavafx.javafx1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Request {
    public String getJson() {
        String url = "http://localhost:3000/unidades";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            // Envia a requisição e obtém a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return json;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao obter JSON da URL: " + url, e);
        }
    }

}
