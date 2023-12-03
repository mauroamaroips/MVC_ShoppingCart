/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ShoppingCartController;
import javafx.scene.paint.Color;
import observer.Observer;

/**
 *
 * @author patricia.macedo
 */
public interface ShoppinCartViewInterface extends Observer {
    
    String getInputProductId();
    
    void clearInput();
    
    void showError(String msg);

    void setTriggers(ShoppingCartController controller);

    //Adicionado em relação ao código original para suportar alert views
    void showAlert(String title, String content);

    // Adicionado em relação ao código original para suportar o desabilitar do botão "btAddProduct"
    void setAddButtonDisabled(boolean disabled);

    // Adicionado em relação ao código original para suportar a mundança de cor da label "lblCount"
    void setLblCountTextFill(Color color);
}
