/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecoscore;

/**
 *
 * @author emilychappel
 */

public class Goals {
    private String attribute;
    private int val;
    private double progress, reduction;
    public String getAttribute() {
        return attribute;
    }

    public int getVal() {
        return val;
    }

    public double getProgress() {
        return progress;
    }

    public double getReduction(Users user) {
        //save for later use
//        int type;
//        switch(attribute){
//            case "electric":
//                type = 0;
//            case "gas":
//                type = 1;
//            case "oil":
//                type = 2;
//            case "mileage":
//                type = 3;
//            case "smallFlights":
//                type = 4;
//            case "largeFlights":
//                type = 5;
//            case "recycle newspaper":
//                type = 6;
//            case "recycle aluminum and tin":
//                type = 7;
//            
//        }
        double tempCalc = user.getCO2Eq();
        double temp;
        boolean placeholder;
        switch(attribute){
            case "electric":
                temp = user.getElectricBill();
                user.setElectricBill(temp-val);
                reduction = tempCalc - user.getCO2Eq();
                user.setElectricBill(temp);
            case "gas":
                temp = user.getGasBill();
                user.setGasBill(temp-val);
                reduction = tempCalc - user.getCO2Eq();
                user.setGasBill(temp);
            case "oil":
                temp = user.getOilBill();
                user.setOilBill(temp-val);
                reduction = tempCalc - user.getCO2Eq();
                user.setOilBill(temp);
            case "mileage":
                temp = user.getYearlyMileage();
                user.setYearlyMileage(temp-val);
                reduction = tempCalc - user.getCO2Eq();
                user.setYearlyMileage(temp);
            case "smallFlights":
                temp = user.getSmallFlights();
                user.setSmallFlights((int) (temp-val));
                reduction = tempCalc - user.getCO2Eq();
                user.setSmallFlights((int) temp);
            case "largeFlights":
                temp = user.getLargeFlights();
                user.setLargeFlights((int) (temp-val));
                reduction = tempCalc - user.getCO2Eq();
                user.setLargeFlights((int) temp);
            case "recycle newspaper":
                if(val == 1){
                    user.setNewspaper(true);
                } else {
                    user.setNewspaper(false);
                }
                placeholder = user.isNewspaper();
                reduction = tempCalc - user.getCO2Eq();
                user.setNewspaper(placeholder);
            case "recycle aluminum and tin":
                if(val == 1){
                    user.setAluminumTin(true);
                } else {
                    user.setAluminumTin(false);
                }
                placeholder = user.isAluminumTin();
                reduction = tempCalc - user.getCO2Eq();
                user.setAluminumTin(placeholder);
        }
        return reduction;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return attribute + " " + val + " " + progress + " " + reduction; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
