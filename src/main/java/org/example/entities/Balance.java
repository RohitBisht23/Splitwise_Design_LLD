package org.example.entities;

public class Balance {
    double oweBalance;
    double getBackBalance;

    public double getOweBalance() {
        return oweBalance;
    }

    public double getGetBackBalance() {
        return getBackBalance;
    }

    public void setOweBalance(double oweBalance) {
        this.getBackBalance = oweBalance;
    }

    public void setGetBackBalance(double getBackBalance) {
        this.getBackBalance = getBackBalance;
    }
}
