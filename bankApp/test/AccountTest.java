package bankApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testThatIHaveAnAccount_BalanceIsZero_Deposited200_BalanceIs200() {
        Account opeyemi = new Account("1234");
        assertEquals(0, opeyemi .getBalance("1234"));

        opeyemi .deposit(200);
        assertEquals(200, opeyemi .getBalance("1234"));
    }

    @Test
    public void testDeposit_NegativeAmount_BalanceIs0() {
        Account opeyemi  = new Account("1234");
        assertEquals(0, opeyemi .getBalance("1234"));

        opeyemi .deposit(-50);
        assertEquals(0, opeyemi .getBalance("1234"));
    }

    @Test
    public void testMultipleDeposits_BalanceIs600() {
        Account opeyemi  = new Account("1234");
        opeyemi .deposit(200);
        opeyemi .deposit(400);
        assertEquals(600, opeyemi .getBalance("1234"));
    }

    @Test
    public void testWithdraw_WithoutDeposit_BalanceStays0() {
        Account opeyemi  = new Account("1234");
        assertEquals(0, opeyemi .getBalance("1234"));
        assertFalse(opeyemi.withdraw(50, "1234"));
        assertEquals(0, opeyemi .getBalance("1234"));
    }

    @Test
    public void testDeposit500_Withdraw400_BalanceIs100() {
        Account opeyemi  = new Account("1234");
        opeyemi .deposit(500);
        assertTrue(opeyemi .withdraw(400, "1234"));
        assertEquals(100, opeyemi .getBalance("1234"));
    }

    @Test
    public void testWithdraw_NegativeAmount_BalanceIs0() {
        Account opeyemi  = new Account("1234");
        assertFalse(opeyemi .withdraw(-50, "1234"));
        assertEquals(0, opeyemi .getBalance("1234"));
    }

    @Test
    public void testWithdraw_WrongPin_BalanceUnchanged() {
        Account opeyemi  = new Account("1234");
        opeyemi .deposit(500);
        assertFalse(opeyemi .withdraw(200, "2001"));
        assertEquals(500, opeyemi .getBalance("1234"));
    }

    @Test
    public void testGetBalance_WrongPin_ReturnsMinus1() {
        Account opeyemi  = new Account("1234");
        opeyemi .deposit(100);
        assertEquals(-1, opeyemi .getBalance("0000"));
    }
    
}