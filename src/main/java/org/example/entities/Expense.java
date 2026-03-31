package org.example.entities;

import org.example.entities.Split.Splits;
import org.example.enums.ExpenseSplitType;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String expenseId;

    String description;

    double amount;

    User paidBy;

    ExpenseSplitType splitType;

    List<Splits> splitDetails = new ArrayList<>();

    public Expense(String id, String description, double amount, User paidBy, ExpenseSplitType splitType, List<Splits> splitDetails) {
        this.splitType = splitType;
        this.amount = amount;
        this.paidBy = paidBy;
        this.expenseId = id;
        this.description = description;
        this.splitDetails.addAll(splitDetails);
    }

}
