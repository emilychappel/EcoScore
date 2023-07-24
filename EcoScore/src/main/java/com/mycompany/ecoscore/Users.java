/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecoscore;

import java.util.ArrayList;


/**
 *
 * @author emilychappel
 */

public class Users {
    private double electricBill, gasBill, oilBill, yearlyMileage;
    private int smallFlights, largeFlights;
    private boolean newspaper, aluminumTin;
    ArrayList<ArrayList<Goals>> goals;

    public Users(double electricBill, double gasBill, double oilBill, double yearlyMileage, int smallFlights, int largeFlights, boolean newspaper, boolean aluminumTin, ArrayList<ArrayList<Goals>> goals) {
        this.electricBill = electricBill;
        this.gasBill = gasBill;
        this.oilBill = oilBill;
        this.yearlyMileage = yearlyMileage;
        this.smallFlights = smallFlights;
        this.largeFlights = largeFlights;
        this.newspaper = newspaper;
        this.aluminumTin = aluminumTin;
        this.goals = goals;
    }

    public ArrayList<ArrayList<Goals>> getGoals() {
        return goals;
    }
    

    public double getElectricBill() {
        return electricBill;
    }

    public double getGasBill() {
        return gasBill;
    }

    public int getLargeFlights() {
        return largeFlights;
    }

    public double getOilBill() {
        return oilBill;
    }

    public int getSmallFlights() {
        return smallFlights;
    }

    public double getYearlyMileage() {
        return yearlyMileage;
    }

    public boolean isAluminumTin() {
        return aluminumTin;
    }

    public boolean isNewspaper() {
        return newspaper;
    }

    public void setAluminumTin(boolean aluminumTin) {
        this.aluminumTin = aluminumTin;
    }

    public void setElectricBill(double electricBill) {
        this.electricBill = electricBill;
    }

    public void setGasBill(double gasBill) {
        this.gasBill = gasBill;
    }

    public void setLargeFlights(int largeFlights) {
        this.largeFlights = largeFlights;
    }

    public void setNewspaper(boolean newspaper) {
        this.newspaper = newspaper;
    }

    public void setOilBill(double oilBill) {
        this.oilBill = oilBill;
    }

    public void setSmallFlights(int smallFlights) {
        this.smallFlights = smallFlights;
    }

    public void setYearlyMileage(double yearlyMileage) {
        this.yearlyMileage = yearlyMileage;
    }

    public void setGoals(ArrayList<ArrayList<Goals>> goals) {
        this.goals = goals;
    }
    
    public double calculate(){
        double emissions = electricBill * 105 + gasBill * 105 + oilBill * 112 + yearlyMileage * 0.79 + smallFlights * 1100 + largeFlights * 4400;
        if(newspaper){
            emissions += 184;
        }
        if(aluminumTin){
            emissions += 166;
        }
        return emissions;
    }
    
    public double getCO2Eq(){
        return calculate()/ 2204.62;
    }
    
    public double numericalDifference(){
        return getCO2Eq()-19.33;
    }
    
    public double percentDiffrence(){
        return numericalDifference()/19.33*100;        
    }
    
    @Override
    public String toString() {
        return electricBill + " " + gasBill + " " + oilBill + " " + yearlyMileage + " " + smallFlights + " " + largeFlights + " " + newspaper + " " + aluminumTin + " " + goals; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}

