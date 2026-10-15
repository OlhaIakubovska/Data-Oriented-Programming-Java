package ua.kpi.comsys.dop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class OrderStatusTest {

    // -------- Paid --------

    @Test
    void paidAcceptValidDate() {
        Paid paid = assertDoesNotThrow(() -> new Paid("PAY-1", new BigDecimal("10.50")));
        assertEquals("PAY-1", paid.paymentID());
        assertEquals(new BigDecimal("10.50"), paid.amount());
    }

    @Test
    void paidRejectsNullPaymentId() {
        assertThrows(IllegalArgumentException.class, () -> new Paid(null, BigDecimal.TEN));
    }

    @Test
    void paidRejectsBlankPaymentId() {
        assertThrows(IllegalArgumentException.class, () -> new Paid("   ", BigDecimal.TEN));
    }

    @Test
    void paidRejectsNullAmount() {
        assertThrows(IllegalArgumentException.class, () -> new Paid("PAY-1", null));
    }

    @Test
    void paidRejectsZeroAmount() {
        assertThrows(IllegalArgumentException.class, () -> new Paid("PAY-1", BigDecimal.ZERO));
    }

    @Test
    void paidRejectsNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> new Paid("PAY-1", new BigDecimal("-1")));
    }

    // -------- Shipped --------

    @Test
    void shippedAcceptsValidDate() {
        LocalDate date = LocalDate.of(2026, 10, 15);
        Shipped shipped = assertDoesNotThrow(() -> new Shipped("TRK-1", date));
        assertEquals("TRK-1", shipped.trackingCode());
        assertEquals(date, shipped.dispatchDate());
    }

    @Test
    void shippedRejectsNullTrackingCode() {
        assertThrows(IllegalArgumentException.class, () -> new Shipped(null, LocalDate.now()));
    }

    @Test
    void shippedRejectsBlankTrackingCode() {
        assertThrows(IllegalArgumentException.class, () -> new Shipped(" ", LocalDate.now()));
    }

    @Test
    void shoppedRejectsNullDate() {
        assertThrows(IllegalArgumentException.class, () -> new Shipped("TRK-1",null));
    }

    // -------- Cancelled --------

    @Test
    void cancelledAcceptsValidReason() {
        Cancelled cancelled = assertDoesNotThrow(() -> new Cancelled("Out of stock"));
        assertEquals("Out of stock", cancelled.reason());
    }

    @Test
    void cancelledRejectsNullReason() {
        assertThrows(IllegalArgumentException.class, () -> new Cancelled(null));
    }

    @Test
    void cancelledRejectsBlankReason() {
        assertThrows(IllegalArgumentException.class, () -> new Cancelled(""));
    }
}
