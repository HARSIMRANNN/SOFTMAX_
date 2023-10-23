package com.digipayroll.issueCheque;

public class ChequeData {
    private int empId;
    private int billId;
    private int amount;
    private String dateOfIssue;

    public ChequeData(int empId, int billId, int amount, String dateOfIssue) {
        this.empId = empId;
        this.billId = billId;
        this.amount = amount;
        this.dateOfIssue = dateOfIssue;
    }

    // Getter and setter methods for the fields (empId, billId, amount, dateOfIssue) go here

    // You can also override toString() method for debugging or display purposes
}
