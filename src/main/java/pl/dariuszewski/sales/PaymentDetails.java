package pl.dariuszewski.sales;

public class PaymentDetails {
    private final String paymentId;
    private final String url;

    public PaymentDetails(String paymentId, String url) {
        this.paymentId = paymentId;
        this.url = url;
    }

    public String getId() {
        return paymentId;
    }

    public String getUrl() {
        return url;
    }
}