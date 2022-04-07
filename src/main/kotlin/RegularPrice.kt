class RegularPrice : Price(Movie.REGULAR) {
    override fun getCharge(daysRented: Int) = if (daysRented <= 2) 2.0 else 2 + (daysRented - 2) * 1.5
}