package org.example.controller;

import org.example.entities.Balance;
import org.example.entities.Split.Splits;
import org.example.entities.User;
import org.example.entities.UserExpenseBalanceSheet;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User paidBy, List<Splits> splitDetails, double totalExpenseAmount) {

        // update the total amount paid of the expense paid by user
        UserExpenseBalanceSheet paidByUserExpenseSheet = paidBy.getUserExpenseBalanceSheet();
        paidByUserExpenseSheet.setTotalPayment(paidByUserExpenseSheet.getTotalPayment() + totalExpenseAmount);

        for(Splits s : splitDetails) {
            User userOwe = s.getUser();
            UserExpenseBalanceSheet oweUserExpenseSheet = userOwe.getUserExpenseBalanceSheet();

            double oweAmount = s.getAmount();

            if(paidBy.getUserId().equals(userOwe.getUserId())) {
                //This user is the user who paid expense that time for all friends
                paidByUserExpenseSheet.setTotalYourExpense(paidByUserExpenseSheet.getTotalYourExpense() + oweAmount);
            } else {
                //Update the balance of paid user
                paidByUserExpenseSheet.setTotalYouGetBack(paidByUserExpenseSheet.getTotalYouGetBack() + oweAmount); //If this is not same user who paid then first update the user who paid total get back amount

                Balance userOwnBalance;
                if(paidByUserExpenseSheet.getUserVsBalance().containsKey(userOwe.getUserId())) {
                    userOwnBalance = paidByUserExpenseSheet.getUserVsBalance().get(userOwe.getUserId());
                } else {
                    userOwnBalance = new Balance();
                    paidByUserExpenseSheet.getUserVsBalance().put(userOwe.getUserId(), userOwnBalance);
                }

                userOwnBalance.setGetBackBalance(userOwnBalance.getGetBackBalance() + oweAmount);


                //update the balance sheet of owe user
                oweUserExpenseSheet.setTotalYouOwe(oweUserExpenseSheet.getTotalYouOwe() + oweAmount);
                oweUserExpenseSheet.setTotalYourExpense(oweUserExpenseSheet.getTotalYourExpense() + oweAmount);

                Balance userPaidBalance;
                if(oweUserExpenseSheet.getUserVsBalance().containsKey(paidBy.getUserId())){
                    userPaidBalance = oweUserExpenseSheet.getUserVsBalance().get(paidBy.getUserId());
                }
                else{
                    userPaidBalance = new Balance();
                    oweUserExpenseSheet.getUserVsBalance().put(paidBy.getUserId(), userPaidBalance);
                }
                userPaidBalance.setOweBalance(userPaidBalance.getOweBalance() + oweAmount);
            }
        }
    }

    public void showBalanceSheetOfUser(User user){

        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getUserId());

        UserExpenseBalanceSheet userExpenseBalanceSheet =  user.getUserExpenseBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalYourExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalYouGetBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getTotalYouOwe());
        System.out.println("TotalPaymnetMade: " + userExpenseBalanceSheet.getTotalPayment());
        for(Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()){

            String userID = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("userID:" + userID + " YouGetBack:" + balance.getGetBackBalance() + " YouOwe:" + balance.getOweBalance());
        }

        System.out.println("---------------------------------------");

    }

}
