package org.example.controller;

import org.example.entities.*;
import org.example.entities.Split.ExpenseSplit;
import org.example.entities.Split.Splits;
import org.example.enums.ExpenseSplitType;

import java.util.List;

public class ExpenseController {

    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        this.balanceSheetController = new BalanceSheetController();
    }


    public Expense createExpense(String expenseId, String description, User paidBy, ExpenseSplitType expenseSplitType, List<Splits> splitDetails, double expenseAmount) {
        ExpenseSplit expenseSplit = SplitFactory.getExpenseObjectBasedOnSplitType(expenseSplitType);

        boolean isValid = expenseSplit.validateRequest(splitDetails, expenseAmount);
        if(!isValid) {
            System.out.println("There is an issue in amount calculation.");
            return null;
        }

        Expense newExpense = new Expense(expenseId, description, expenseAmount,paidBy, expenseSplitType, splitDetails);

        //Update balanceSheet
        balanceSheetController.updateUserExpenseBalanceSheet(paidBy, splitDetails, expenseAmount);
        return newExpense;
    }
}
