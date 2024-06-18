module com.example.projetodeporgramacaojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.desktop;
    requires jdk.management;
    requires java.net.http;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;

    opens com.example.projetodeporgramacaojavafx.javafx1 to javafx.fxml;

    exports com.example.projetodeporgramacaojavafx.javafx1;
}
