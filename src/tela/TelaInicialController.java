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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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
    private TextArea nota;
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
        
        tableNotas.setEditable(true);
        colunaNota.setCellFactory(TextFieldTableCell.forTableColumn());
        colunaCategoria.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    @FXML
    private void limpar(ActionEvent event) {
        nota.clear();
        categoria.clear();
    }

    @FXML
    private void salvar(ActionEvent event) {
        
        if ("".equals(nota.getText()) || categoria.getText() == ""){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Infomações");
            alert.setHeaderText("Preencha todos os campos");
            alert.showAndWait();
        } else {
            ItemNota item = new ItemNota();

            item.nota = nota.getText();
            item.categoria = categoria.getText();

            item.id = totalItens;

            totalItens++;

            listaNotas.add(item);

            tableNotas.setItems(FXCollections.observableArrayList(listaNotas));
            nota.clear();
            categoria.clear();
        }
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
    private void excluir(ActionEvent event) {
        ItemNota itemSelecionado = tableNotas.getSelectionModel().getSelectedItem();

        for ( int i = 0; i < listaNotas.size(); i++) {
            ItemNota itemLista = listaNotas.get(i);
            if (itemLista.id == itemSelecionado.id) {
                listaNotas.remove(i);
                break;
            }
        }
        tableNotas.setItems(FXCollections.observableArrayList(listaNotas));
    }

    @FXML
    private void editNota(TableColumn.CellEditEvent<ItemNota, String> event) {
        ItemNota edit = tableNotas.getSelectionModel().getSelectedItem();
        edit.setNota(event.getNewValue());
    }

    @FXML
    private void editCategoria(TableColumn.CellEditEvent<ItemNota, String> event) {
        ItemNota edit = tableNotas.getSelectionModel().getSelectedItem();
        edit.setCategoria(event.getNewValue());
    }
}
