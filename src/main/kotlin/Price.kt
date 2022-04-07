abstract class Price(priceCode: Int) {
    abstract fun getCharge(daysRented: Int): Double

    open fun getFrequentRenterPoints(daysRented: Int) = 1
}