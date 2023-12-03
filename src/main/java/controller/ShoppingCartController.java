/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import javafx.scene.paint.Color;
import model.ShoppingCart;
import model.ShoppingCartException;
import view.ShoppinCartViewInterface;

/**
 *
 * @author patriciamacedo
 */
public class ShoppingCartController {


    public static final float THRESHOLD_VALUE = 100;
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

    public void doRemoveProduct(){
        String id = view.getInputProductId();

        try {
            model.removeProduct(Integer.parseInt(id));
            view.clearInput();
        } catch(ShoppingCartException e){
            view.showError(e.getMessage());
        } catch(NumberFormatException e){
            view.showError("it is not a number");
        }
    }

    public void checkTotalValue(){
        double totalValue = model.getTotal();

        System.out.println(totalValue);

        if(totalValue > THRESHOLD_VALUE){
            view.showAlert("Total Value Exceeded", "The total value has exceeded the threshold.");

            view.setAddButtonDisabled(true);
            view.setLblCountTextFill(Color.RED);
        } else {
            view.setAddButtonDisabled(false);
            view.setLblCountTextFill(Color.BLACK);
        }

    }

}
