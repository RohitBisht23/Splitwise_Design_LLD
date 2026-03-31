package org.example.entities;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    Map<String, Balance> userVSBalance;
    double totalPayment;   //Actual total i paid that time with frnds
    double totalYourExpense;   //Total expense i did except frnds
    double totalYouOwe;
    double totalYouGetBack;

    public UserExpenseBalanceSheet() {
        totalYourExpense = 0;
        totalYouOwe = 0;
        totalYouGetBack = 0;
        totalPayment = 0;
        userVSBalance = new HashMap<>();
    }
    public Map<String, Balance> getUserVsBalance() {
        return userVSBalance;
    }

    public double getTotalYourExpense() {
        return totalYourExpense;
    }

    public void setTotalYourExpense(double totalYourExpense) {
        this.totalYourExpense = totalYourExpense;
    }

    public double getTotalYouOwe() {
        return totalYouOwe;
    }

    public void setTotalYouOwe(double totalYouOwe) {
        this.totalYouOwe = totalYouOwe;
    }

    public double getTotalYouGetBack() {
        return totalYouGetBack;
    }

    public void setTotalYouGetBack(double totalYouGetBack) {
        this.totalYouGetBack = totalYouGetBack;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }


}
