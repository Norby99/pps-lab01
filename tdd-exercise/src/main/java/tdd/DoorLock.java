package tdd;

public class DoorLock implements SmartDoorLock {

    private boolean unlockState = true;
    private String pin = "";
    private static final int PIN_LENGHT = 4;
    private int failedAttempts = 0;
    private static final int MAX_ATTEMPTS = 5;

    @Override
    public void setPin(String pin) {
        int intPIN;

        if (pin.length() != PIN_LENGHT) {
            return;
        }

        try {
            intPIN = Integer.parseInt(pin);
        } catch (NumberFormatException e) {
            return;
        }

        if (Integer.parseInt(pin) < 0) {
            return;
        }

        this.pin = pin;
    }

    @Override
    public void unlock(String pin) {
        if (this.pin.equals(pin)){
            this.unlockState = true;
        } else {
            failedAttempts++;
        }
    }

    @Override
    public void lock() throws IllegalAccessException {
        if (this.pin.isEmpty()) {
            throw new IllegalAccessException();
        }
        this.unlockState = false;
    }

    @Override
    public boolean isLocked() {
        return this.unlockState;
    }

    @Override
    public boolean isBlocked() {
        return MAX_ATTEMPTS < this.failedAttempts;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return failedAttempts;
    }

    @Override
    public void reset() {

    }
}
