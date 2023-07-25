/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecoscore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 *
 * @author emilychappel
 */

public class Users {
    private double electricBill, gasBill, oilBill, yearlyMileage;
    private int smallFlights, largeFlights;
    private boolean newspaper, aluminumTin;
    ArrayList<Goals> goals;

    public ArrayList<Goals> getGoals() {
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

    public void setGoals(ArrayList<Goals> goals) {
        this.goals = goals;
    }
    
    public Double calculate(){
        double emissions = electricBill * 105 + gasBill * 105 + oilBill * 112 + yearlyMileage * 0.79 + smallFlights * 1100 + largeFlights * 4400;
        if(newspaper){
            emissions += 184;
        }
        if(aluminumTin){
            emissions += 166;
        }
        return emissions;
    }
    
    public Double getCO2Eq(){
        return calculate()/ 2204.62;
    }
    
    public double numericalDifference(){
        return getCO2Eq()-19.33;
    }
    
    public double percentDiffrence(){
        return numericalDifference()/19.33*100;        
    }
    public ArrayList <Goals> search(double numberToFind){
        this.sortGoals();
        ArrayList <Goals> searcher = goals;
        ArrayList <Goals> array = new ArrayList<>();
        int pos;
        while((pos = binarySearch(searcher, numberToFind)) != -1){
            array.add(goals.get(pos));
            searcher.remove(pos);
        }
        return array;
    }
    public int binarySearch(ArrayList <Goals> array, double numberToFind) {
        int low = 0;
        int high = array.size() - 1;

        while (low <= high){
          int middlePosition = (low + high) / 2;
          double middleNumber = array.get(middlePosition).getReduction();

          if (numberToFind == middleNumber){
            return middlePosition;
          }
          if (numberToFind < middleNumber){
            high = middlePosition - 1;
          }
          else {
            low = middlePosition + 1;
          }
        }
        return -1;
    }
    public void sortGoals() {
        quicksort(goals, 0, goals.size() - 1);
    }

    public void quicksort(ArrayList <Goals> array, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        double pivot = array.get(pivotIndex).getReduction();
        swap(array, pivotIndex, highIndex);

        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);

    }

    public int partition(ArrayList <Goals> array, int lowIndex, int highIndex, double pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer < rightPointer) {

            // Walk from the left until we find a number greater than the pivot, or hit the right pointer.
            while (array.get(leftPointer).getReduction() <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            // Walk from the right until we find a number less than the pivot, or hit the left pointer.
            while (array.get(rightPointer).getReduction() >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }

        // This is different from what the video has, and fixes an issue where the last value could potentially be out of order. 
        // Thanks to viewer Wilson Barbosa for suggesting the fix!
        if(array.get(leftPointer).getReduction() > array.get(highIndex).getReduction()) {
            swap(array, leftPointer, highIndex);
        }
        else {
            leftPointer = highIndex;
        }

        return leftPointer;
    }

    public void swap(ArrayList <Goals> array, int index1, int index2) {
        Collections.swap(array, index1, index2);
    }
    @Override
    public String toString() {
        return electricBill + " " + gasBill + " " + oilBill + " " + yearlyMileage + " " + smallFlights + " " + largeFlights + " " + newspaper + " " + aluminumTin + " " + goals; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}

