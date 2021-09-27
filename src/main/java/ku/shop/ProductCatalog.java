package ku.shop;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {

    private static final int DEFAULT_QUANTITY = 10;
    private Map<String, Product> products;

    public ProductCatalog() {
        products = new HashMap<>();
    }

    public void addProduct(String name, double price, int quantity) {
        products.put(name, new Product(name, price, quantity));
    }

    public void addProduct(String name, double price) {
        addProduct(name, price, DEFAULT_QUANTITY);
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public boolean checkStock(String name , int quantity){
        if(products.get(name).getQuantity()>=quantity) return true;
        else throw new IllegalArgumentException("Not enough quantity for"+name);
    }
}
