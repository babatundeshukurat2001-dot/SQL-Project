package bankApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testThatIHaveAnAccount_BalanceIsZero_Deposited200_BalanceIs200() {
        Account shukurat = new Account("1234");
        assertEquals(0, shukurat.getBalance("1234"));

        shukurat.deposit(200);
        assertEquals(200, shukurat.getBalance("1234"));
    }

    @Test
    public void testDeposit_NegativeAmount_BalanceIs0() {
        Account shukurat = new Account("1234");
        assertEquals(0, shukurat.getBalance("1234"));

        shukurat.deposit(-50);
        assertEquals(0, shukurat.getBalance("1234"));
    }

    @Test
    public void testMultipleDeposits_BalanceIs600() {
        Account shukurat = new Account("1234");
        shukurat.deposit(200);
        shukurat.deposit(400);
        assertEquals(600, shukurat.getBalance("1234"));
    }

    @Test
    public void testWithdraw_WithoutDeposit_BalanceStays0() {
        Account shukurat = new Account("1234");
        assertEquals(0, shukurat.getBalance("1234"));
        assertFalse(shukurat.withdraw(50, "1234"));
        assertEquals(0, shukurat.getBalance("1234"));
    }

    @Test
    public void testDeposit500_Withdraw400_BalanceIs100() {
        Account shukurat = new Account("1234");
        shukurat.deposit(500);
        assertTrue(shukurat.withdraw(400, "1234"));
        assertEquals(100, shukurat.getBalance("1234"));
    }

    @Test
    public void testWithdraw_NegativeAmount_BalanceIs0() {
        Account shukurat = new Account("1234");
        assertFalse(shukurat.withdraw(-50, "1234"));
        assertEquals(0, shukurat.getBalance("1234"));
    }

    @Test
    public void testWithdraw_WrongPin_BalanceUnchanged() {
        Account shukurat = new Account("1234");
        shukurat.deposit(500);
        assertFalse(shukurat.withdraw(200, "2001"));
        assertEquals(500, shukurat.getBalance("1234"));
    }

    @Test
    public void testGetBalance_WrongPin_ReturnsMinus1() {
        Account shukurat = new Account("1234");
        shukurat.deposit(100);
        assertEquals(-1, shukurat.getBalance("0000"));
    }
}