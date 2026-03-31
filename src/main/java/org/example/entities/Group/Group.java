package org.example.entities.Group;

import org.example.controller.ExpenseController;
import org.example.entities.Expense;
import org.example.entities.Split.Splits;
import org.example.entities.User;
import org.example.enums.ExpenseSplitType;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;

    List<User> members;

    List<Expense> expenseList;

    ExpenseController expenseController;

    public Group() {
        members = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    public void addMember(User user) {
        members.add(user);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Splits> splitDetails, ExpenseSplitType splitType, User paidByUser) {

        Expense expense = expenseController.createExpense(expenseId, description, paidByUser, splitType, splitDetails, expenseAmount);
        expenseList.add(expense);
        return expense;
    }
}
