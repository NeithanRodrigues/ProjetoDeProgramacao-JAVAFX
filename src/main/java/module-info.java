module com.example.projetodeporgramacaojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.example.projetodeporgramacaojavafx.javafx1 to javafx.fxml;

    exports com.example.projetodeporgramacaojavafx.javafx1;
}
