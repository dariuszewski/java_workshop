package pl.dariuszewski.sales;

import org.springframework.web.bind.annotation.*;
import pl.dariuszewski.sales.offerting.Offer;
import pl.dariuszewski.sales.ordering.CustomerData;

@RestController
public class SalesController {
    public static final String CUSTOMER_ID = "Darius";

    private SalesFacade salesFacade;

    public SalesController(SalesFacade salesFacade) {
        this.salesFacade = salesFacade;
    }

    @PostMapping("/api/add-product/{productId}")
    public void addProductToCart(@PathVariable String productId) {
        String customerId = getCurrentCustomerId();
        salesFacade.addToCart(customerId, productId);
    }

    @PostMapping("/api/accept-offer")
    public void acceptOffer(@RequestBody CustomerData customerData) {
        String customerId = getCurrentCustomerId();
        salesFacade.acceptOffer(customerId, customerData);
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