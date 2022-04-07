public class ChildrensPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    double getCharge(int daysRented) {
        if (daysRented <= 3) return 1.5;

        return (daysRented - 2) * 1.5;
    }
}
