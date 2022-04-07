class NewReleasePrice : Price(Movie.NEW_RELEASE) {
    override fun getCharge(daysRented: Int) = daysRented * 3.0

    override fun getFrequentRenterPoints(daysRented: Int) = if (daysRented <= 1) 1 else 2
}