//Made By : Tiaz Rizqy Amandha 1772052
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
    private ObservableList<Items> items;
    @FXML
    private ObservableList<Category> categories;
    @FXML
    private TableColumn<Items, String> col01;
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
        Alert a = new Alert(Alert.AlertType.ERROR);
        if(txtName.getText().trim().isEmpty() || txtPrice.getText().trim().isEmpty() || ComboBoxCat.getValue() == null) {
            a.setContentText("Please fill name/ price/ category");
            a.showAndWait();
        }
        else{
            int count = (int) items.stream().filter(p -> p.getNama().equalsIgnoreCase(txtName.getText())).count();
            if(count >= 1){
                a.setContentText("Duplicate name");
                a.showAndWait();
            }
            else{
                Items i = new Items();
                i.setNama(txtName.getText().trim());
                i.setHarga(Double.parseDouble(txtPrice.getText().trim()));
                i.setCategory(ComboBoxCat.getValue());
                items.add(i);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categories = FXCollections.observableArrayList();
        ComboBoxCat.setItems(categories);
        items = FXCollections.observableArrayList();
        tbView.setItems(items);
        col01.setCellValueFactory(data -> {
            Items a = data.getValue();
            return new SimpleStringProperty(a.getNama());
        });
        col02.setCellValueFactory(data -> {
            Items b = data.getValue();
            return new SimpleDoubleProperty(b.getHarga()).asObject();
        });
        col03.setCellValueFactory(data -> {
            Items c = data.getValue();
            return new SimpleStringProperty(c.getCategory().getNama());
        });
        update.setDisable(true);
    }


    @FXML
    private void ResetAction(ActionEvent actionEvent) {
        simpan.setDisable(false);
        update.setDisable(true);
        txtName.setText(null);
        txtPrice.setText(null);
        txtCN.setText(null);
        ComboBoxCat.setValue(null);
    }

    @FXML
    private void UpdateAction(ActionEvent actionEvent) {
        Items i = tbView.getSelectionModel().getSelectedItem();
        i.setCategory(ComboBoxCat.getValue());
        i.setNama(txtName.getText());
        i.setHarga(Double.parseDouble(txtPrice.getText()));
        tbView.refresh();
    }

    @FXML
    private void SCAction(ActionEvent actionEvent) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        if(txtCN.getText().isEmpty()){
            a.setContentText("Please fill category name");
            a.showAndWait();
        }
        else {
            Category c = new Category();
            c.setNama(txtCN.getText().trim());
            int count = (int) categories.stream().filter(p -> p.getNama().equalsIgnoreCase(txtCN.getText().trim())).count();
            if(count >= 1){
                a.setContentText("Duplicate category name");
                a.showAndWait();
            }
            else{
                categories.add(c);
            }
        }
        txtCN.clear();

    }

    @FXML
    private void tableClicked(MouseEvent mouseEvent) {
        Items i = tbView.getSelectionModel().getSelectedItem();
        txtName.setText(i.getNama());
        txtPrice.setText(String.valueOf(i.getHarga()));
        ComboBoxCat.setValue(i.getCategory());
        simpan.setDisable(true);
        update.setDisable(false);

    }
}
