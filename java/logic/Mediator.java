package logic;

import cache.Cache;
import pojo.Account;
import pojo.Customer;
import exception.BankException;
import persistence.DBConnector;
import java.util.*;


public enum Mediator {
    INSTANCE;
   
    Cache cache = Cache.INSTANCE;


    public void load() throws BankException {

    	DBConnector connector = new DBConnector();
    	
            List<Account> accounts = connector.getAccounts();
            List<Integer> usersWithNoActiveAccounts = connector.getUsersWithNoActiveAccounts();
            List<Customer> customers = connector.getCustomers();

            cache.addToCache(accounts);
            cache.addUsersWithNoActiveAccounts(usersWithNoActiveAccounts);
            cache.addToUsers(customers);
      

    }

    public int insertCustomer(Customer customer) throws BankException {
    	
        int userId = 0;
        
        DBConnector connector = new DBConnector();
        userId = connector.insertIntoCustomers(customer);
        return userId;
    }

    public long insertAccount(Account account) throws BankException {
        long accountNumber = 0;
        
        DBConnector connector = new DBConnector();
        accountNumber = connector.insertIntoAccounts(account);
        return accountNumber;
    }

    public List<Integer> insertCustomers(List<Customer> customers) throws BankException {
        List<Integer> userIds = null;
        DBConnector connector = new DBConnector();
        userIds = connector.insertIntoCustomers(customers);
     
        return userIds;
    }

    public List<Long> insertAccounts(List<Account> accounts) throws BankException {
        List<Long> accountNumbers = null;
        DBConnector connector = new DBConnector();
        accountNumbers = connector.insertIntoAccounts(accounts);
       
        return accountNumbers;
    }

    public long updateBalance(int option, long accountNumber, long amount) throws BankException {
    	DBConnector connector = new DBConnector();
        long balance = 0;
        if (option == 1) {
        
             
                balance = connector.withdrawMoney(accountNumber, amount);
            
        } else {
        	 
                balance = connector.depositMoney(accountNumber, amount);
            
        }
        return balance;
    }

    public boolean deactivateAccount(long accountNumber) throws BankException {
        boolean done = false;
        DBConnector connector = new DBConnector();
        done = connector.deactivateAccount(accountNumber);
        return done;
    }

    public boolean deactivateUser(int userid) throws BankException {
        boolean done = false;
        DBConnector connector = new DBConnector();
        done = connector.deactivateUser(userid);
        return done;
    }
}