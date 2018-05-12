package com.md.lab1;


public class EquationModel {
    private int varQuantity = 2;
    private Integer matrix [];
    private Integer signs [];
    EquationModel(int eqQuantity){
        matrix = new Integer[(eqQuantity + 1) * (varQuantity+1)];
        signs = new Integer[eqQuantity];
    }

    EquationModel(){
        matrix = new Integer[(varQuantity + 1) * (varQuantity+1)];
        signs = new Integer[varQuantity];
    }

    public int getVarQuantity() {
        return varQuantity;
    }

    public void setVarQuantity(int varQuantity) {
        this.varQuantity = varQuantity;
    }

    public Integer[] getMatrix() {
        return matrix;
    }

    public void setMatrix(Integer[] matrix) {
        this.matrix = matrix;
    }

    public Integer[] getSigns() {
        return signs;
    }

    public void setSigns(Integer[] signs) {
        this.signs = signs;
    }
}
