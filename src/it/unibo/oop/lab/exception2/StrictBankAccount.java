package it.unibo.oop.lab.exception2;

/**
 * Class modeling a BankAccount with strict policies: getting money is allowed
 * only with enough founds, and there are also a limited number of free ATM
 * transaction (this number is provided as a input in the constructor).
 * 
 */
public class StrictBankAccount implements BankAccount {

	private final int usrID;
	private double balance;
	private int nTransactions;
	private final int nMaxATMTransactions;
	private static final double ATM_TRANSACTION_FEE = 1;
	private static final double MANAGEMENT_FEE = 5;
	private static final double TRANSACTION_FEE = 0.1;

	/**
	 * 
	 * @param usrID               user id
	 * @param balance             initial balance
	 * @param nMaxATMTransactions max no of ATM transactions allowed
	 */
	public StrictBankAccount(final int usrID, final double balance, final int nMaxATMTransactions) {
		this.usrID = usrID;
		this.balance = balance;
		this.nMaxATMTransactions = nMaxATMTransactions;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @throws WrongAccountHolderException
	 */
	public void deposit(final int usrID, final double amount) 
			throws WrongAccountHolderException {

		checkUser(usrID);
		this.balance += amount;
		incTransactions();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void withdraw(final int usrID, final double amount)
			throws WrongAccountHolderException, NotEnoughFoundsException {
		
		checkUser(usrID);
		isWithdrawAllowed(amount);
		this.balance -= amount;
		incTransactions();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void depositFromATM(final int usrID, final double amount)
			throws WrongAccountHolderException, TransactionsOverQuotaException {
		
		checkTransactions();
		this.deposit(usrID, amount - StrictBankAccount.ATM_TRANSACTION_FEE);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void withdrawFromATM(final int usrID, final double amount)
			throws WrongAccountHolderException, TransactionsOverQuotaException, NotEnoughFoundsException {

		checkTransactions();
		this.withdraw(usrID, amount + StrictBankAccount.ATM_TRANSACTION_FEE);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public double getBalance() {
		return this.balance;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public int getNTransactions() {
		return nTransactions;
	}

	/**
	 * 
	 * @param usrID id of the user related to these fees
	 */
	public void computeManagementFees(final int usrID) 
			throws WrongAccountHolderException, NotEnoughFoundsException {
		
		checkUser(usrID);
		final double feeAmount = MANAGEMENT_FEE + (nTransactions * StrictBankAccount.TRANSACTION_FEE);
		isWithdrawAllowed(feeAmount);
		balance -= MANAGEMENT_FEE + nTransactions * StrictBankAccount.TRANSACTION_FEE;
		nTransactions = 0;

	}

	// Check Method

	private void checkUser(final int id) throws WrongAccountHolderException {
		if (this.usrID != id) {
			throw new WrongAccountHolderException(id, this.usrID);
		}
	}

	private void isWithdrawAllowed(final double amount) throws NotEnoughFoundsException {
		if (balance < amount) {
			throw new NotEnoughFoundsException(this.balance, amount);
		}
	}

	private void checkTransactions() throws TransactionsOverQuotaException {
		if (this.nTransactions > this.nMaxATMTransactions) {
			throw new TransactionsOverQuotaException(this.nMaxATMTransactions);
		}
	}

	private void incTransactions() {
		this.nTransactions++;
	}
}
