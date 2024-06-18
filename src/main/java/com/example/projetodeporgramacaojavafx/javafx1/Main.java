package com.example.projetodeporgramacaojavafx.javafx1;


public class Main {
    public static void main(String[] args){
        Request r = new Request();
        ParseJson json = new ParseJson();
        String jsonString = r.getJson();
        json.getParse(jsonString);

        }
}




