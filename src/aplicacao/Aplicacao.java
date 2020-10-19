/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Dell i5
 */
public class Aplicacao extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) throws IOException {
        URL url;
        url = getClass().getResource("/tela/TelaInicial.fxml");

        Parent telaCadastrada = FXMLLoader.load(url);

        Scene scene = new Scene(telaCadastrada);

        stage.setScene(scene);
        stage.show();
    }
}