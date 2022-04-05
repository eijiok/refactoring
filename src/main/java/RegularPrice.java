public class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    double getCharge(int daysRented) {
        if (daysRented <= 2) return 2;

        return 2 + (daysRented - 2) * 1.5;
    }
}
