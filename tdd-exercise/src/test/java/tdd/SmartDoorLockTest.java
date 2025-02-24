package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private SmartDoorLock doorLock;
    private final String PIN = "1234";

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
}
