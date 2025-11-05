package leetcode.array;


public class Account{
    
    public int timestamp;
    public String accountId;
    public int amount;
    public int withdrawAmount;
    
    public Account(int timestamp, String accountId){
        this.timestamp = timestamp;
        this.accountId = accountId;
        this.amount = 0;
        this.withdrawAmount = 0;
    }
}