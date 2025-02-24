package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private SmartDoorLock doorLock;

    @BeforeEach
    public void beforeEach() {
        this.doorLock = new DoorLock();
    }

    @Test
    void testLockDoor() {
        assertTrue(this.doorLock.isLocked());
    }
}
