import java.util.ArrayList

class Customer(val name: String) {
    private val rentals: ArrayList<Rental> = ArrayList<Rental>()

    fun addRental(rental: Rental) {
        rentals.add(rental)
    }

    fun statement(): String {
        var result = "Rental Record for $name\n"
        for (each in rentals)
            result += "	${each.movie.title}	${each.movie.getCharge(each.daysRented)}\n"
        result += "Amount owed is $totalCharge\n"
        result += "You earned $frequentRenterPoints frequent renter points"
        return result
    }

    private val frequentRenterPoints: Int
        private get() {
            var frequentRenterPoints = 0
            for (each in rentals) frequentRenterPoints += each.movie.getFrequentRenterPoints(each.daysRented)
            return frequentRenterPoints
        }

    private val totalCharge: Double
        private get() {
            var totalAmount = 0.0
            for (each in rentals) totalAmount += each.movie.getCharge(each.daysRented)
            return totalAmount
        }
}
