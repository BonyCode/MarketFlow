package com.marketflow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    public void testTransactionCreation() {
        Trader trader = new Trader("Mario", "Milan");
        Transaction transaction = new Transaction(trader, 2012, 700);
        assertEquals(trader, transaction.getTrader());
        assertEquals(2012, transaction.getYear());
        assertEquals(700, transaction.getValue());
    }
}

