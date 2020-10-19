/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import registros.ItemNota;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Dell i5
 */
public class TelaInicialController implements Initializable {

    @FXML
    private AnchorPane tabela;
    @FXML
    private TextField nota;
    @FXML
    private TextField categoria;
    @FXML
    private TextField pesquisar;
    @FXML
    private TableView<ItemNota> tableNotas;
    @FXML
    private TableColumn<ItemNota, String> colunaNota;
    @FXML
    private TableColumn<ItemNota, String> colunaCategoria;

    List<ItemNota> listaNotas = new ArrayList<>();
    int totalItens = 1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaNota.setCellValueFactory(new PropertyValueFactory("nota"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory("categoria"));

    }

    @FXML
    private void limpar(ActionEvent event) {
    }

    @FXML
    private void salvar(ActionEvent event) {

        ItemNota item = new ItemNota();

        item.nota = nota.getText();
        item.categoria = categoria.getText();

        item.id = totalItens;

        totalItens++;

        listaNotas.add(item);
    }

    @FXML
    private void pesquisar(ActionEvent event) {
        String pesquisa = pesquisar.getText();
        
        if(pesquisa == null || pesquisa == "") {
            tableNotas.setItems(FXCollections.observableArrayList(listaNotas));
            
        } else {
            List<ItemNota> listaFiltrada = listaNotas
                                    .stream()
                                    .filter(f -> f.nota.contains(pesquisa))
                                    .collect(Collectors.toList());
        
            tableNotas.setItems(FXCollections.observableArrayList(listaFiltrada));
        }
        
    }

    @FXML
    private void editar(ActionEvent event) {
   
    }

    @FXML
    private void excluir(ActionEvent event) {
        ItemNota itemSelecionado = tableNotas.getSelectionModel().getSelectedItem();

        for ( int i = 0; i < listaNotas.size(); i++) {
            ItemNota itemLista = listaNotas.get(i);
            if (itemLista.id == itemSelecionado.id) {
                listaNotas.remove(i);
                break;
            }
        }
    }

}
