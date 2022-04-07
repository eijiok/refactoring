import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CustomerTest {
    @Test
    fun testStatementMixed() {
        val customer = Customer("Eiji Okuda")
        customer.addRental(Rental(Movie("The Godfather", Movie.REGULAR), 2))
        customer.addRental(Rental(Movie("The Northman", Movie.NEW_RELEASE), 3))
        customer.addRental(Rental(Movie("The Lion King", Movie.CHILDRENS), 4))
        val expected = """Rental Record for Eiji Okuda
	The Godfather	2.0
	The Northman	9.0
	The Lion King	3.0
Amount owed is 14.0
You earned 4 frequent renter points"""
        assertEquals(expected, customer.statement())
    }

    @Test
    fun testStatementRegular2Days() {
        val customer = Customer("Eiji Okuda")
        customer.addRental(Rental(Movie("The Matrix", Movie.REGULAR), 2))
        assertEquals("""Rental Record for Eiji Okuda
	The Matrix	2.0
Amount owed is 2.0
You earned 1 frequent renter points""", customer.statement())
    }

    @Test
    fun testStatementRegular3Days() {
        val customer = Customer("Eiji Okuda")
        customer.addRental(Rental(Movie("The Matrix", Movie.REGULAR), 3))
        assertEquals("""Rental Record for Eiji Okuda
	The Matrix	3.5
Amount owed is 3.5
You earned 1 frequent renter points""", customer.statement())
    }

    @Test
    fun testStatementRegularMultiple() {
        val customer = Customer("Eiji Okuda")
        customer.addRental(Rental(Movie("The Matrix", Movie.REGULAR), 1))
        customer.addRental(Rental(Movie("The Matrix Reloaded", Movie.REGULAR), 3))
        customer.addRental(Rental(Movie("The Matrix Revolutions", Movie.REGULAR), 2))
        assertEquals("""Rental Record for Eiji Okuda
	The Matrix	2.0
	The Matrix Reloaded	3.5
	The Matrix Revolutions	2.0
Amount owed is 7.5
You earned 3 frequent renter points""", customer.statement())
    }

    @Test
    fun testStatementRelease() {
        val customer = Customer("Eiji Okuda")
        customer.addRental(Rental(Movie("New release", Movie.NEW_RELEASE), 2))
        assertEquals("""Rental Record for Eiji Okuda
	New release	6.0
Amount owed is 6.0
You earned 2 frequent renter points""", customer.statement())
    }

    @Test
    fun testStatementRelease2() {
        val customer = Customer("Eiji Okuda")
        customer.addRental(Rental(Movie("New release", Movie.NEW_RELEASE), 3))
        assertEquals("""Rental Record for Eiji Okuda
	New release	9.0
Amount owed is 9.0
You earned 2 frequent renter points""", customer.statement())
    }

    @Test
    fun testStatementReleaseMultiple() {
        val customer = Customer("Eiji Okuda")
        customer.addRental(Rental(Movie("New Release", Movie.NEW_RELEASE), 1))
        customer.addRental(Rental(Movie("New Release Reloaded", Movie.NEW_RELEASE), 2))
        customer.addRental(Rental(Movie("New Release Revolutions", Movie.NEW_RELEASE), 3))
        assertEquals("""Rental Record for Eiji Okuda
	New Release	3.0
	New Release Reloaded	6.0
	New Release Revolutions	9.0
Amount owed is 18.0
You earned 5 frequent renter points""", customer.statement())
    }

    @Test
    fun testStatementChildrens() {
        val customer = Customer("Eiji Okuda")
        customer.addRental(Rental(Movie("The Lion King", Movie.CHILDRENS), 3))
        assertEquals("""Rental Record for Eiji Okuda
	The Lion King	1.5
Amount owed is 1.5
You earned 1 frequent renter points""", customer.statement())
    }

    @Test
    fun testStatementChildrens4Days() {
        val customer = Customer("Eiji Okuda")
        customer.addRental(Rental(Movie("The Lion King", Movie.CHILDRENS), 4))
        assertEquals("""Rental Record for Eiji Okuda
	The Lion King	3.0
Amount owed is 3.0
You earned 1 frequent renter points""", customer.statement())
    }

    @Test
    fun testStatementChildrens5Days() {
        val customer = Customer("Eiji Okuda")
        customer.addRental(Rental(Movie("The Lion King", Movie.CHILDRENS), 5))
        assertEquals("""Rental Record for Eiji Okuda
	The Lion King	4.5
Amount owed is 4.5
You earned 1 frequent renter points""", customer.statement())
    }

//    @Test
    fun perfomanceTest() {
        val init = System.currentTimeMillis()
        for (i in 0 until 10 * K) {
            runTest(i.toInt(), init)
        }
        println(System.currentTimeMillis() - init)
    }

    private fun runTest(j: Int, init: Long) {
        val customer = Customer("Eiji Okuda$init")
        for (i in 0..99) {
            customer.addRental(Rental(Movie(j.toString() + "The Godfather" + init + i, Movie.REGULAR), i + 1))
            customer.addRental(Rental(Movie(j.toString() + "The Northman" + init + i, Movie.NEW_RELEASE), i + 1))
            customer.addRental(Rental(Movie(j.toString() + "The Lion King" + init + i, Movie.CHILDRENS), i + 1))
        }
        customer.statement()
    }

    companion object {
        var K: Long = 1000
    }
}