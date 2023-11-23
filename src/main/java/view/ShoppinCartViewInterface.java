/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ShoppingCartController;
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
}
