package org.example.entities.Split;

import java.util.List;

public class EqualSplits implements ExpenseSplit {
    @Override
    public boolean validateRequest(List<Splits> splitDetails, double totalAmount) {
        double amountShouldBePresent = totalAmount/splitDetails.size();

        for(Splits splits : splitDetails) {
            if(splits.getAmount() != amountShouldBePresent) {
                return false;
            }
        }
        return true;
    }
}
