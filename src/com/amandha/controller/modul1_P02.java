package com.amandha.controller;

import com.amandha.entity.Category;
import com.amandha.entity.Items;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class modul1_P02 {
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtCN;
    @FXML
    private TableView<Items> tbView;
    @FXML
    private TableColumn<Items, String> col01;
    private ObservableList<Items> items;
    @FXML
    private TableColumn<Items, Double> col02;
    @FXML
    private TableColumn<Items, String> col03;
    @FXML
    private Button simpan;
    @FXML
    private Button reset;
    @FXML
    private Button update;
    @FXML
    private ComboBox<Category> ComboBoxCat;

    @FXML
    private void SaveAction(ActionEvent actionEvent) {
        Items i = new Items();
        i.setNama(txtName.getText().trim());
        i.setHarga(Double.parseDouble(txtPrice.getText()));
        i.setCategory(ComboBoxCat.getValue());
    }

    @FXML
    private void ResetAction(ActionEvent actionEvent) {
        simpan.setDisable(false);
        reset.setDisable(false);
        update.setDisable(true);
        txtName.clear();
        txtPrice.clear();
        txtCN.clear();
    }

    @FXML
    private void UpdateAction(ActionEvent actionEvent) {

    }

    @FXML
    private void SCAction(ActionEvent actionEvent) {
    }

    @FXML
    private void tableClicked(MouseEvent mouseEvent) {
        //Fakultas f = tableDepartment.getSelectionModel().getSelectedItem();
        //txtName.setText(f.getName());

    }
}
