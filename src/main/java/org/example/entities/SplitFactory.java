package org.example.entities;

import org.example.entities.Split.EqualSplits;
import org.example.entities.Split.ExpenseSplit;
//import org.example.entities.Split.PercentageSplit;
import org.example.entities.Split.UnequalSplits;
import org.example.enums.ExpenseSplitType;

public class SplitFactory {

    public static ExpenseSplit getExpenseObjectBasedOnSplitType(ExpenseSplitType expenseSplitType) {
        return switch (expenseSplitType) {
           // case PERCENTAGE -> new PercentageSplit();
            case EQUAL -> new EqualSplits();
            case UNEQUAL -> new UnequalSplits();
            default -> null;
        };
    }
}
