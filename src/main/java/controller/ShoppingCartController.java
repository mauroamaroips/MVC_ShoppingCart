/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import model.ShoppingCart;
import model.ShoppingCartException;
import view.ShoppinCartViewInterface;

/**
 *
 * @author patriciamacedo
 */
public class ShoppingCartController {
    

    private final ShoppinCartViewInterface view;
    private final ShoppingCart model;

    
    public ShoppingCartController(ShoppinCartViewInterface view, ShoppingCart model) {
        this.view = view;
        this.model = model;
        
        view.setTriggers(this);
        model.addObservers(view);
    }
    
    public void doAddProduct() {
        
        String id = view.getInputProductId();
        
        try {
            model.addProduct(Integer.parseInt(id));
            view.clearInput();

        } catch (ShoppingCartException e) {
            view.showError(e.getMessage());
        }
        catch (NumberFormatException e) {
            view.showError("it is not a number");
        }
        
    }
    

}
