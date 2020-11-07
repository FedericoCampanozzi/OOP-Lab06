package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends java.lang.IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1159808475879283028L;
	private final double found;
	private final double withdrawal;
	
	public NotEnoughFoundsException(double found, double withdrawal) {
		this.found = found;
		this.withdrawal = withdrawal;
	}

    /**
     * 
     * @return the string representation of instances of this class
     */
    @Override
    public String toString() {
        return "You need " + this.withdrawal + ". But you have " + this.found;
    }

    @Override
    public String getMessage() {
        return this.toString();
    }
}
