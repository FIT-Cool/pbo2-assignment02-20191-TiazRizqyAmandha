package com.amandha.controller;

import com.amandha.entity.Category;
import com.amandha.entity.Items;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class modul1_P02 implements Initializable {
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
    private ObservableList<Category> categories;
    private Items selectedItems;
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
        simpan.setDisable(false);
        update.setDisable(true);
        int count = (int)categories.stream().filter(p -> p.getNama().equalsIgnoreCase(txtName.getText())).count();
        i.setNama(txtName.getText().trim());
        i.setHarga(Double.parseDouble(txtPrice.getText()));
        i.setCategory(ComboBoxCat.getValue());
        items.add(i);
        txtName.clear();
        txtPrice.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        items = FXCollections.observableArrayList();
        tbView.setItems(items);
        categories = FXCollections.observableArrayList();
        ComboBoxCat.setItems(categories);
        col01.setCellValueFactory(data -> {
            Items i = data.getValue();
            return new SimpleStringProperty(i.getNama());
        });
        col02.setCellValueFactory(data -> {
            Items i = data.getValue();
            return new SimpleDoubleProperty(i.getHarga()).asObject();
        });
        col03.setCellValueFactory(data -> {
            Items i = data.getValue();
            return new SimpleStringProperty(i.getCategory().getNama());
        });
        update.setDisable(true);
    }


    @FXML
    private void ResetAction(ActionEvent actionEvent) {
        simpan.setDisable(false);
        reset.setDisable(false);
        update.setDisable(true);
        txtName.clear();
        txtPrice.clear();
        txtCN.clear();
        ComboBoxCat.setValue(null);
    }

    @FXML
    private void UpdateAction(ActionEvent actionEvent) {
        simpan.setDisable(true);
        int count = (int)categories.stream().filter(p -> p.getNama().equalsIgnoreCase(txtName.getText())).count();
        Items i = new Items();
        i.setNama(txtName.getText().trim());
        i.setHarga(Double.parseDouble(txtPrice.getText()));
        i.setCategory(ComboBoxCat.getValue());

        i.setNama(txtName.getText().trim());
        i.setHarga(Double.parseDouble(txtPrice.getText()));
        i.setCategory(ComboBoxCat.getValue());

        tbView.refresh();

    }

    @FXML
    private void SCAction(ActionEvent actionEvent) {
        Category cat = new Category();
        cat.setNama(txtCN.getText().trim());
        categories.add(cat);

    }

    @FXML
    private void tableClicked(MouseEvent mouseEvent) {
        selectedItems = tbView.getSelectionModel().getSelectedItem();
        if(selectedItems!=null){
            txtName.setText(tbView.getSelectionModel().getSelectedItem().getNama());
            txtPrice.setText(String.valueOf(tbView.getSelectionModel().getSelectedItem().getHarga()));
            ComboBoxCat.setValue(tbView.getSelectionModel().getSelectedItem().getCategory());
            simpan.setDisable(true);
            update.setDisable(false);
        }
        //Fakultas f = tableDepartment.getSelectionModel().getSelectedItem();
        //txtName.setText(f.getName());

    }
}
