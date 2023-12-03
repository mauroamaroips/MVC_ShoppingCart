/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.ShoppingCartController;
import javafx.scene.control.*;
import model.Product;
import model.ShoppingCart;
import observer.Observer;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Product;
import observer.Observer;

import java.util.Collection;


/**
 *
 * @author brunomnsilva
 */
public class ShoppingCartUI extends VBox implements Observer, ShoppinCartViewInterface {

    //controlos
    private TextField txtInputId;

    private Button btAddProduct;
    private Button btRemoveProduct;
    private ListView<Product> listProductsView;
    private Label lblError;
    private Label lblCount;

    //alerta
    private Alert totalPriceAlert;

    //modelo
    private final ShoppingCart model;
    
    public ShoppingCartUI(ShoppingCart model) {
        this.model = model;
        initComponents();
        update(model);
    }
    
    @Override
    public void update(Object o) {
        if(o instanceof ShoppingCart) {
            ShoppingCart model = (ShoppingCart)o;
            Collection<Product> listProducts = model.getProducts();
            this.listProductsView.getItems().clear();
            listProductsView.getItems().addAll(listProducts);
            lblCount.setText(""+ model.getTotal());


        }
    }
    
    private void initComponents() {
        
        this.txtInputId = new TextField();
        this.btAddProduct = new Button("Add");
        this.btRemoveProduct = new Button("Remove");
        this.listProductsView = new ListView<>();
        lblError = new Label();
        lblCount = new Label("0");

        this.totalPriceAlert = new Alert(Alert.AlertType.WARNING); //alerta

        HBox firstRow = new HBox(txtInputId,btAddProduct, btRemoveProduct, new Label("Total Value"),lblCount);
        firstRow.setAlignment(Pos.CENTER);
        firstRow.setPadding(new Insets(2,2,2,2));
        firstRow.setSpacing(4);

        this.getChildren().addAll(firstRow, listProductsView, lblError);
    }

    @Override
    public void setTriggers(ShoppingCartController controller) {

        btAddProduct.setOnAction((ActionEvent event) -> {
            controller.doAddProduct();
        });

        btRemoveProduct.setOnAction((ActionEvent event) -> {
            controller.doRemoveProduct();
        });

        lblCount.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.checkTotalValue();
        });

    }

    @Override
    public void showError(String msg) {
        lblError.setText(msg);
    }

    @Override
    public String getInputProductId() {
        return txtInputId.getText().trim();
    }

    @Override
    public void clearInput() {
        txtInputId.setText("");
    }

    // Alerta

    @Override
    public void showAlert(String title, String content){

        totalPriceAlert.setTitle(title);
        totalPriceAlert.setHeaderText(null);
        totalPriceAlert.setContentText(content);
        totalPriceAlert.showAndWait();

    }

    @Override
    // Add methods to enable/disable the "Add" button
    public void setAddButtonDisabled(boolean disabled) {
        btAddProduct.setDisable(disabled);
    }

    @Override
    // Add method to set the text fill color of lblCount
    public void setLblCountTextFill(javafx.scene.paint.Color color) {
        lblCount.setTextFill(color);
    }


}
