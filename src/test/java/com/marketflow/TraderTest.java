package com.marketflow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TraderTest {

    @Test
    public void testTraderCreation() {
        Trader trader = new Trader("Raoul", "Cambridge");
        assertEquals("Raoul", trader.getName());
        assertEquals("Cambridge", trader.getCity());
    }

    @Test
    public void testTraderCityUpdate() {
        Trader trader = new Trader("Raoul", "Cambridge");
        trader.setCity("Milan");
        assertEquals("Milan", trader.getCity());
    }
}

