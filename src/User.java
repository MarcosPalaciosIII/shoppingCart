import java.util.ArrayList;
//import java.util.List;

public class User {

    private String name;
    private ArrayList<ShoppingCartItem> shoppingCart;


    public User(String name) {
        this.name = name;
        this.shoppingCart = new ArrayList<ShoppingCartItem>(10);
    }

    public void addToCart(String name, double cost) {
        if (this.shoppingCart.size() == 10) {
            System.out.println("You have reached the max allowed items for your shopping cart.");
        } else {
            ShoppingCartItem item = new ShoppingCartItem(name, cost, 1);
            this.shoppingCart.add(item);
        }
    }

    public void removeFromCart(int index) {
        this.shoppingCart.remove(index);
    }

    public ArrayList<ShoppingCartItem> showCartItems() {
        ArrayList<ShoppingCartItem> validItems = new ArrayList<>();
        for(int i = 0; i < this.shoppingCart.size(); i++) {
            if(this.shoppingCart.get(i) != null) {
                String itemName = this.shoppingCart.get(i).getName();
                double price = this.shoppingCart.get(i).getPrice();
                System.out.println("Item: " + itemName + " Price: " + price + ".");
                validItems.add(new ShoppingCartItem(itemName, price, 1));
            }
        }
        return validItems;
    }

    public double calculateCartTotal() {
        int totalPriceOfItems = 0;
        for(int i = 0; i < this.shoppingCart.size(); i++) {
            if(this.shoppingCart.get(i) == null) continue;
            totalPriceOfItems += this.shoppingCart.get(i).getPrice();
        }
        System.out.println("this is the cost of all the items: $" + totalPriceOfItems);

        return totalPriceOfItems;
    }

    public double cartTotalPlusTax(int taxRate) {
        double totalPrice = this.calculateCartTotal();
        System.out.println("Total plus tax: $" + Math.round(totalPrice * ((taxRate * 0.01) + 1.00) * 100) * 0.01);
        return (totalPrice * Math.round(totalPrice * ((taxRate * 0.01) + 1.00) * 100) * 0.01);
    }
}
