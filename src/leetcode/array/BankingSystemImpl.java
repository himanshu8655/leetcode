package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
	import java.util.stream.Collectors;

class BankingSystemImpl{
	  
	  HashMap<String, Account> bankingsystem;
	  public BankingSystemImpl() {
	    bankingsystem = new HashMap<>();
	  }

	public boolean createAccount(int timestamp, String accountId) {
	  if(bankingsystem.containsKey(accountId)){
	    return false;
	  }
	  bankingsystem.put(accountId, new Account(timestamp, accountId));
	    return true;
	  }
	  public Optional<Integer> deposit(int timestamp, String accountId, int amount) {
	    if(!bankingsystem.containsKey(accountId) || amount<0)
	      return Optional.empty();
	    
	    Account account = bankingsystem.get(accountId);
	    account.amount+=amount;
	    return Optional.of(account.amount);
	  }
	  
	  public Optional<Integer> transfer(int timestamp, String sourceAccountId, String targetAccountId, int amount) {
	    if(!bankingsystem.containsKey(sourceAccountId) || !bankingsystem.containsKey(targetAccountId) || sourceAccountId == targetAccountId)
	      return Optional.empty();
	      
	    Account sourceAccount = bankingsystem.get(sourceAccountId);
	    Account targetAccount = bankingsystem.get(targetAccountId);
	    
	    if(sourceAccount.amount<amount)
	      return Optional.empty();
	    sourceAccount.withdrawAmount+=amount;
	    sourceAccount.amount-=amount;
	    targetAccount.amount+=amount;
	    
	    return Optional.of(sourceAccount.amount);
	  }
	  
	  public List<String> topSpenders(int timestamp, int n) {
		    return bankingsystem.values().stream().sorted((o1,o2)->{
		      if(o1.withdrawAmount == o2.withdrawAmount){
		        return o1.accountId.compareTo(o2.accountId);
		      }
		      else{
		        return Integer.compare(o2.withdrawAmount, o2.withdrawAmount);
		      }
		    }).limit(n).map(acc->acc.accountId+"("+acc.amount+")").collect(Collectors.toList());
		  }
		}
