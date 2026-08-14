package bankApp;

    import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class BankTest {

        @Test
        public void testRegisterCustomerAndFindAccount() {
            Bank bank = new Bank("Semicolon Bank");
            Account acc = bank.registerCustomer("Ope", "1234", "Lagos");

            assertNotNull(acc);
            assertEquals(acc, bank.findAccount(acc.getNumber()));
        }

        @Test
        public void testDeposit() throws InvalidAmountException {
            Bank bank = new Bank("Semicolon Bank");
            Account acc = bank.registerCustomer("Ope", "1234", "Lagos");

            bank.deposit(acc.getNumber(), 5000);
            assertEquals(5000, bank.checkBalance(acc.getNumber(), "1234"));
        }

        @Test
        public void testWithdraw() throws Exception {
            Bank bank = new Bank("Semicolon Bank");
            Account acc = bank.registerCustomer("Ope", "1234", "Lagos");
            bank.deposit(acc.getNumber(), 10000);

            bank.withdraw(acc.getNumber(), 3000, "1234");
            assertEquals(7000, bank.checkBalance(acc.getNumber(), "1234"));
        }

        @Test
        public void testTransfer() throws Exception {
            Bank bank = new Bank("Semicolon Bank");
            Account acc1 = bank.registerCustomer("Ope", "1234", "Lagos");
            Account acc2 = bank.registerCustomer("Bola", "5678", "Abuja");

            bank.deposit(acc1.getNumber(), 5000);
            bank.transfer(acc1.getNumber(), acc2.getNumber(), "1234");

            assertEquals(0, bank.checkBalance(acc1.getNumber(), "1234"));
            assertEquals(5000, bank.checkBalance(acc2.getNumber(), "5678"));
        }

        @Test
        public void testRemoveAccount() throws Exception {
            Bank bank = new Bank("Semicolon Bank");
            Account acc = bank.registerCustomer("Ope", "1234", "Lagos");
            int accNum = acc.getNumber();

            bank.removeAccount(accNum, "1234");
            assertNull(bank.findAccount(accNum));
        }

        @Test
        public void testInvalidPinThrowsException() {
            Bank bank = new Bank("Semicolon Bank");
            Account acc = bank.registerCustomer("Ope", "1234", "Lagos");

            assertThrows(InvalidPinException.class, () -> {
                bank.checkBalance(acc.getNumber(), "9999");
            });
        }
    }

