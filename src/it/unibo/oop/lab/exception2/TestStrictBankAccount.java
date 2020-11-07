package it.unibo.oop.lab.exception2;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public class TestStrictBankAccount {
	
    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	AccountHolder account1 = new AccountHolder("Mario", "Rossi", 1152);
    	AccountHolder account2 = new AccountHolder("Luigi", "Neri", 1153);
    	
    	StrictBankAccount sb1 = new StrictBankAccount(1152, 10_000, 10);
    	StrictBankAccount sb2 = new StrictBankAccount(1153, 10_000, 10);
    	
    	
    	
    	try {
    		
    		sb1.deposit(1153, 300);
    		fail();
    		
    	} catch (WrongAccountHolderException e) {
    		System.out.println("ERROR : " + e.getMessage());
    	}
    	
    	try {
    		sb1.deposit(1152, 300);
    		sb2.depositFromATM(1153, 300);
    	} catch (WrongAccountHolderException e) {
    		fail();
    	}
    	
    	
    	try {
    		
    		sb1.withdraw(1152, 20_000);
    		fail();
    		
    	} catch (NotEnoughFoundsException e) {
    		System.out.println("ERROR : " + e.getMessage());
    	}
    	
    	try {
    		
    		sb1.withdraw(1152, 1000);
    		sb2.withdraw(1153, 200);
    		System.out.println(sb1.getBalance());
    		System.out.println(sb2.getBalance());
    		
    	} catch (NotEnoughFoundsException e) {
    		fail();
    	}
    	
		try {

			for (int i = 0; i < 15; i++) {

				sb1.withdrawFromATM(1152, 10);
			}
			
			fail();
			
		} catch (TransactionsOverQuotaException e) {
			System.out.println("ERROR : " + e.getMessage());
		}
    }
}
