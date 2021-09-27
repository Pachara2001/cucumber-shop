package ku.shop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<OrderItem> items;
    private LocalDateTime date;

    public Order(int id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
    }

    public Order() {
        this.id = 0;
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
    }

    public void addItem(ProductCatalog catalog,Product prod, int quantity) {
        if(catalog.checkStock(prod.getName(),quantity)){
        items.add(new OrderItem(prod, quantity));}

    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items)
            total += item.getSubtotal();
        return total;
    }

}
