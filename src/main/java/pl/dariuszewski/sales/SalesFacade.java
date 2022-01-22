package pl.dariuszewski.sales;


import pl.dariuszewski.sales.cart.Cart;
import pl.dariuszewski.sales.cart.InMemoryCartStorage;
import pl.dariuszewski.sales.offerting.Offer;
import pl.dariuszewski.sales.offerting.OfferMaker;

public class SalesFacade {
    InMemoryCartStorage cartStorage;
    private ProductDetailsProvider productDetailsProvider;
    private OfferMaker offerMaker;

    public SalesFacade(
            InMemoryCartStorage cartStorage,
            ProductDetailsProvider productDetailsProvider,
            OfferMaker offerMaker
    ) {
        this.cartStorage = cartStorage;
        this.productDetailsProvider = productDetailsProvider;
        this.offerMaker = offerMaker;
    }

    public void addToCart(String customerId, String productId) {
        Cart cart = cartStorage.loadForCustomer(customerId)
                .orElse(Cart.empty());

        Product product = productDetailsProvider.getDetails(productId);

        cart.addProduct(product);

        cartStorage.save(customerId, cart);
    }

    public Offer getCurrentOffer(String customerId) {
        Cart cart = cartStorage.loadForCustomer(customerId)
                .orElse(Cart.empty());

        return offerMaker.createAnOffer(cart);
    }
}