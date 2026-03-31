package org.example.entities.Split;

import java.util.List;

public interface ExpenseSplit {
    public boolean validateRequest(List<Splits> splitDetails, double amount);
}
