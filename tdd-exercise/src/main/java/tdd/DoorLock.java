package tdd;

public class DoorLock implements SmartDoorLock {

    private boolean unlockState = true;
    private String pin = "";

    @Override
    public void setPin(String pin) {
        if (pin.length() != 4) {
            return;
        }

        try {
            int intPIN = Integer.parseInt(pin);
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
        this.unlockState = true;
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
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
