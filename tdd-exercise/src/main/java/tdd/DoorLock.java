package tdd;

public class DoorLock implements SmartDoorLock {

    private boolean unlockState = true;

    @Override
    public void setPin(int pin) {

    }

    @Override
    public void unlock(int pin) {

    }

    @Override
    public void lock() {
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
