package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private SmartDoorLock doorLock;
    private static final String PIN = "1234";
    private static final String FAKE_PIN = "0000";
    private static final int NUMBER_ATTEMPTS = 3;

    @BeforeEach
    public void beforeEach() {
        this.doorLock = new DoorLock();
    }

    @Test
    void testInitialState() {
        assertTrue(this.doorLock.isLocked());
    }

    @Test
    void testLock() {
        this.doorLock.setPin(PIN);
        assertDoesNotThrow(() -> this.doorLock.lock());
        assertFalse(this.doorLock.isLocked());
    }

    @Test
    void testLockWithoutPIN() {
        assertThrows(IllegalAccessException.class, () -> this.doorLock.lock());
    }

    @Test
    void testUnlock() {
        this.doorLock.setPin(PIN);
        assertDoesNotThrow(() -> this.doorLock.lock());
        this.doorLock.unlock(PIN);
        assertTrue(this.doorLock.isLocked());
    }

    @Test
    void testWrongPinUnlock() {
        this.doorLock.setPin(PIN);
        assertDoesNotThrow(() -> this.doorLock.lock());
        this.doorLock.unlock(FAKE_PIN);
        assertFalse(this.doorLock.isLocked());
    }

    @Test
    void testFailedAttempts() {
        this.doorLock.setPin(PIN);
        for (int i = 0; i < NUMBER_ATTEMPTS; i++) {
            this.doorLock.unlock(FAKE_PIN);
        }
        assertEquals(NUMBER_ATTEMPTS, this.doorLock.getFailedAttempts());
    }
}
