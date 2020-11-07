package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private final double needBattery;
    private final double battery;

    /**
     * Construct new instance of the exception.
     * 
     * @param initX
     *            position on X that caused the exception
     * @param initY
     *            position on Y that caused the exception
     */
    public NotEnoughBatteryException(final double needBattery, final double battery) {
        super();
        this.needBattery = needBattery;
        this.battery = battery;
    }

    /**
     * 
     * @return the string representation of instances of this class
     */
    @Override
    public String toString() {
        return "You need " + this.needBattery + ". But have " + this.battery;
    }

    @Override
    public String getMessage() {
        return this.toString();
    }
}
