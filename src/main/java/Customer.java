import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : this.rentals) {
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getMovie().getCharge(each.getDaysRented()) + "\n";
        }
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : this.rentals) {
            frequentRenterPoints += each.getMovie().getFrequentRenterPoints(each.getDaysRented());
        }
        return frequentRenterPoints;
    }

    private double getTotalCharge() {
        double totalAmount = 0;
        for (Rental each : this.rentals) {
            totalAmount += each.getMovie().getCharge(each.getDaysRented());
        }
        return totalAmount;
    }

}
