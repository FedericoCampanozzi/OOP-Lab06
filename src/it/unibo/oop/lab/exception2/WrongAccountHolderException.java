package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends java.lang.IllegalArgumentException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3875060869152815734L;
	private int idTryAccess;
	private int idHaveAccess;

	public WrongAccountHolderException(int nameToTryAccess, int idHaveAccess) {
		this.idTryAccess = nameToTryAccess;
		this.idHaveAccess = idHaveAccess;
	}
    /**
     * 
     * @return the string representation of instances of this class
     */
    @Override
    public String toString() {
        return "Try to access at id " + this.idTryAccess + ". But your id is " + this.idHaveAccess;
    }

    @Override
    public String getMessage() {
        return this.toString();
    }
}
