public class DiscountCalculator {

    public int calculateDiscount(String customerType, int totalOrdersInLastYear, boolean isSubscribedToNewsletter) {

        int discount = 5;
        if (customerType.equals("NEW") && totalOrdersInLastYear >= 10) {
            throw new IllegalArgumentException(
                    "NEW customer cannot have 10 or more orders"
            );
        }

        if (isSubscribedToNewsletter) {
            discount += 2;
        }

        switch (customerType) {
            case "REGULAR":
                discount += 3;
                break;

            case "PREMIUM":
                discount += 5;
                break;

            case "NEW":
                discount += 0;
                break;

            default:
                throw new IllegalArgumentException("Invalid customer type");
        }

        if (totalOrdersInLastYear >= 10) {
            discount += 5;
        }

        if (discount > 15) {
            discount = 15;
        }

        return discount;
    }

}

