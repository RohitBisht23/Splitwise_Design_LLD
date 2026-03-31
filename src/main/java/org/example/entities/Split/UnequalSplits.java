package org.example.entities.Split;

import java.util.List;

public class UnequalSplits implements ExpenseSplit {
    @Override
    public boolean validateRequest(List<Splits> splitDetails, double amount) {
        double sum = 0.0F;
        for(Splits s: splitDetails) {
            sum += s.getAmount();
        }

        if(sum == amount) {
            return true;
        } else {
            return false;
        }
    }
}
