module com.example.projetodeporgramacaojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projetodeporgramacaojavafx to javafx.fxml;
    exports com.example.projetodeporgramacaojavafx;
}