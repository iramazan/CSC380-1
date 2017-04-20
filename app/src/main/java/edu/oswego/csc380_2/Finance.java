package edu.oswego.csc380_2;

import java.io.*;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Set;

public class Finance implements Serializable {

    private class Tuple implements Serializable {
        private double profit, employeeData, ingredients, property, misc;

        public Tuple(double profit, double employeeData, double ingredients, double property, double misc) {
            this.profit = profit;
            this.employeeData = employeeData;
            this.ingredients = ingredients;
            this.property = property;
            this.misc = misc;
        }

        public double getProfit() {
            return profit;
        }

        public void setProfit(double profit) {
            this.profit = profit;
        }

        public double getEmployeeData() {
            return employeeData;
        }

        public void setEmployeeData(double employeeData) {
            this.employeeData = employeeData;
        }

        public double getIngredients() {
            return ingredients;
        }

        public void setIngredients(double ingredients) {
            this.ingredients = ingredients;
        }

        public double getProperty() {
            return property;
        }

        public void setProperty(double property) {
            this.property = property;
        }

        public double getMisc() {
            return misc;
        }

        public void setMisc(double misc) {
            this.misc = misc;
        }

        public String toString() {
            StringBuilder returnString = new StringBuilder();
            returnString.append("Profit: " + profit + ", ");
            returnString.append("Employee Data: " + employeeData + ", ");
            returnString.append("Ingredients: " + ingredients + ", ");
            returnString.append("Property: " + property + ", ");
            returnString.append("Misc: " + misc + ", ");
            returnString.delete(returnString.length() - 2, returnString.length());
            return returnString.toString();
        }
    }

    private String name; // Tag for financial data object

    protected HashMap<String, Tuple> history; // Historic financial data

    private double profit; // Amount restaurant made
    private double employeePay; // Amount paid to employees per month
    private double ingredients; // Amount spent on ingredients per month
    private double property; // Amount spend on the restaurant
    private double misc; // Miscellaneous costs

    public Finance(String name) {
        history = new HashMap<>();
        this.name = name;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getEmployeePay() {
        return employeePay;
    }

    public void setEmployeePay(double employeePay) {
        this.employeePay = employeePay;
    }

    public double getIngredients() {
        return ingredients;
    }

    public void setIngredients(double ingredients) {
        this.ingredients = ingredients;
    }

    public double getProperty() {
        return property;
    }

    public void setProperty(double property) {
        this.property = property;
    }

    public double getMisc() {
        return misc;
    }

    public void setMisc(double misc) {
        this.misc = misc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * Move current financial data into historical database
     * Reset changing data for new time period
     * Return true if successful
     */
    public boolean moveToHistory() {
        GregorianCalendar cal = new GregorianCalendar();
        int month = cal.get(GregorianCalendar.MONTH);
        int year = cal.get(GregorianCalendar.YEAR);
        String historyID;
        switch(month) {
            case 0:  historyID = "dec" + year;
                     break;
            case 1:  historyID = "jan" + year;
                     break;
            case 2:  historyID = "feb" + year;
                     break;
            case 3:  historyID = "mar" + year;
                     break;
            case 4:  historyID = "apr" + year;
                     break;
            case 5:  historyID = "may" + year;
                     break;
            case 6:  historyID = "jun" + year;
                     break;
            case 7:  historyID = "jul" + year;
                     break;
            case 8:  historyID = "aug" + year;
                     break;
            case 9:  historyID = "sep" + year;
                     break;
            case 10: historyID = "oct" + year;
                     break;
            case 11: historyID = "nov" + year;
                     break;
            default: return false;
        }
        history.put(historyID, new Tuple(this.profit, this.employeePay, this.ingredients,
                this.property, this.misc));
        // Set not repeating payments to zero (employee pay and property will stay the same most likely)
        this.profit = 0;
        this.ingredients = 0;
        this.misc = 0;
        return true;
    }

    // Get history by ID
    public String getHistory(String historyID) {
        Tuple tuple = history.get(historyID);
        return tuple != null ? tuple.toString() : null;
    }

    public String listHistory() {
        Set<String> historySet = history.keySet();
        StringBuilder returnString = new StringBuilder();
        for(String i : historySet)
            returnString.append(i + "\n");
        return returnString.toString();
    }
}
