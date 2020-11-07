package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends java.lang.RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5186015990336694793L;
	private final int nMaxOP;
	
	public TransactionsOverQuotaException(int nMaxOP) {
		this.nMaxOP = nMaxOP;
	}
    /**
     * 
     * @return the string representation of instances of this class
     */
    @Override
    public String toString() {
        return "Yuo have only " + this.nMaxOP + " transaction";
    }

    @Override
    public String getMessage() {
        return this.toString();
    }
	
}
