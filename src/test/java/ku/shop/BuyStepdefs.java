package ku.shop;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product {string} with price {float} exists")
    public void a_product_with_price_exists(String name, double price) {
        catalog.addProduct(name, price);
    }

    @Given("a product {string} with price {float} exists and quantity {int}")
    public void a_product_with_price_exists(String name, double price,int quantity) {
        catalog.addProduct(name, price, quantity);
    }

    @When("I buy {string} with quantity {int}")
    public void i_buy_with_quantity(String name, int quantity) {
        Product prod = catalog.getProduct(name);
        order.addItem(catalog,prod, quantity);
    }
    @Then("total should be {float}")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }

@When("I buy {string} with not enough quantity {int}")
    public void i_buy_with_not_enough_quantity(String name,int quantity) throws IllegalArgumentException{
        Product prod = catalog.getProduct(name);
        assertThrows(IllegalArgumentException.class,
                () -> order.addItem(catalog,prod,quantity));
}
}


