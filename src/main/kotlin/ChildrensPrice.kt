class ChildrensPrice() : Price(Movie.CHILDRENS) {
    override fun getCharge(daysRented: Int) = if (daysRented <= 3) 1.5 else (daysRented - 2) * 1.5
}