import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testStatementMixed() {
        Customer customer = new Customer("Eiji Okuda");
        customer.addRental(new Rental(new Movie("The Godfather", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("The Northman", Movie.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("The Lion King", Movie.CHILDRENS), 4));
        String expected = "Rental Record for Eiji Okuda\n" +
                "\tThe Godfather\t2.0\n" +
                "\tThe Northman\t9.0\n" +
                "\tThe Lion King\t3.0\n" +
                "Amount owed is 14.0\n" +
                "You earned 4 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    void testStatementRegular2Days() {
        Customer customer = new Customer("Eiji Okuda");
        customer.addRental(new Rental(new Movie("The Matrix", Movie.REGULAR), 2));
        assertEquals("Rental Record for Eiji Okuda\n" +
                "\tThe Matrix\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", customer.statement());
    }

    @Test
    void testStatementRegular3Days() {
        Customer customer = new Customer("Eiji Okuda");
        customer.addRental(new Rental(new Movie("The Matrix", Movie.REGULAR), 3));
        assertEquals("Rental Record for Eiji Okuda\n" +
                "\tThe Matrix\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points", customer.statement());
    }


    @Test
    void testStatementRegularMultiple() {
        Customer customer = new Customer("Eiji Okuda");
        customer.addRental(new Rental(new Movie("The Matrix", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("The Matrix Reloaded", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("The Matrix Revolutions", Movie.REGULAR), 2));
        assertEquals("Rental Record for Eiji Okuda\n" +
                "\tThe Matrix\t2.0\n" +
                "\tThe Matrix Reloaded\t3.5\n" +
                "\tThe Matrix Revolutions\t2.0\n" +
                "Amount owed is 7.5\n" +
                "You earned 3 frequent renter points", customer.statement());
    }

    @Test
    void testStatementRelease() {
        Customer customer = new Customer("Eiji Okuda");
        customer.addRental(new Rental(new Movie("New release", Movie.NEW_RELEASE), 2));
        assertEquals("Rental Record for Eiji Okuda\n" +
                "\tNew release\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points", customer.statement());
    }

    @Test
    void testStatementRelease2() {
        Customer customer = new Customer("Eiji Okuda");
        customer.addRental(new Rental(new Movie("New release", Movie.NEW_RELEASE), 3));
        assertEquals("Rental Record for Eiji Okuda\n" +
                "\tNew release\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points", customer.statement());
    }

    @Test
    void testStatementReleaseMultiple() {
        Customer customer = new Customer("Eiji Okuda");
        customer.addRental(new Rental(new Movie("New Release", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("New Release Reloaded", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("New Release Revolutions", Movie.NEW_RELEASE), 3));
        assertEquals("Rental Record for Eiji Okuda\n" +
                "\tNew Release\t3.0\n" +
                "\tNew Release Reloaded\t6.0\n" +
                "\tNew Release Revolutions\t9.0\n" +
                "Amount owed is 18.0\n" +
                "You earned 5 frequent renter points", customer.statement());
    }

    @Test
    void testStatementChildrens() {
        Customer customer = new Customer("Eiji Okuda");
        customer.addRental(new Rental(new Movie("The Lion King", Movie.CHILDRENS), 3));
        assertEquals("Rental Record for Eiji Okuda\n" +
                "\tThe Lion King\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points", customer.statement());
    }

    @Test
    void testStatementChildrens4Days() {
        Customer customer = new Customer("Eiji Okuda");
        customer.addRental(new Rental(new Movie("The Lion King", Movie.CHILDRENS), 4));
        assertEquals("Rental Record for Eiji Okuda\n" +
                "\tThe Lion King\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", customer.statement());
    }

    @Test
    void testStatementChildrens5Days() {
        Customer customer = new Customer("Eiji Okuda");
        customer.addRental(new Rental(new Movie("The Lion King", Movie.CHILDRENS), 5));
        assertEquals("Rental Record for Eiji Okuda\n" +
                "\tThe Lion King\t4.5\n" +
                "Amount owed is 4.5\n" +
                "You earned 1 frequent renter points", customer.statement());
    }

    static long K = 1000;

    void perfomanceTest() {
        long init = System.currentTimeMillis();
        for (int i = 0; i < 10 * K; i++) {
            runTest();
        }
        System.out.println(System.currentTimeMillis() - init);
    }

    private void runTest() {
        Customer customer = new Customer("Eiji Okuda");
        for (int i = 0; i < 100; i++) {
            customer.addRental(new Rental(new Movie("The Godfather" + i, Movie.REGULAR), i + 1));
            customer.addRental(new Rental(new Movie("The Northman" + i, Movie.NEW_RELEASE), i + 1));
            customer.addRental(new Rental(new Movie("The Lion King" + i, Movie.CHILDRENS), i + 1));
        }
        customer.statement();
    }
}