package pl.dariuszewski.sales;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dariuszewski.sales.offerting.Offer;

@RestController
public class SalesController {
    public static final String CUSTOMER_ID = "Jacob";

    private SalesFacade salesFacade;

    public SalesController(SalesFacade salesFacade) {
        this.salesFacade = salesFacade;
    }

    @PostMapping("/api/add-product/{productId}")
    public void addProductToCart(@PathVariable String productId) {
        String customerId = getCurrentCustomerId();
        salesFacade.addToCart(customerId, productId);
    }

    @GetMapping("/api/current-offer")
    public Offer getCurrentOffer() {
        String customerId = getCurrentCustomerId();
        return salesFacade.getCurrentOffer(customerId);
    }

    private String getCurrentCustomerId() {
        return CUSTOMER_ID;
    }
}