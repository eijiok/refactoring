import java.lang.IllegalArgumentException

class Movie(val title: String, priceCode: Int) {
    private lateinit var price: Price

    init {
        setPriceCode(priceCode)
    }

    fun setPriceCode(priceCode: Int) {
        price = when (priceCode) {
            REGULAR -> RegularPrice()
            NEW_RELEASE -> NewReleasePrice()
            CHILDRENS -> ChildrensPrice()
            else -> throw IllegalArgumentException("Incorrect Price Code")
        }
    }

    fun getCharge(daysRented: Int): Double {
        return price.getCharge(daysRented)
    }

    fun getFrequentRenterPoints(daysRented: Int): Int {
        return price.getFrequentRenterPoints(daysRented)
    }

    companion object {
        const val REGULAR = 0
        const val NEW_RELEASE = 1
        const val CHILDRENS = 2
    }
}