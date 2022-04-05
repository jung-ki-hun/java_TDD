package com.nhnacdemy.kihunjung.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledDemo {

}
@Disabled("Disabled until bug #99 has been fixed")
class DisabledClassDemo {

    @Test
    void testWillBeSkipped() {
    }
}

class DisabledTestsDemo {

    @Disabled("Disabled until bug #42 has been resolved")
    @Test
    void testWillBeSkipped() {
    }

    @Test
    void testWillBeExecuted() {
    }
}
