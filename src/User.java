//import java.util.ArrayList;
//import java.util.List;

public class User {

    String name;
    ShoppingCart[] list;

    private int itemsInArray = 0;
    private double totalPriceOfItems = 0;


    public User(String name) {

        this.name = name;
        this.list = new ShoppingCart[10];

    }

    public void addToCart(String name, double cost) {
        if (this.itemsInArray == 10) {
            System.out.println("You have reached the max allowed items for your shopping cart.");
        } else {
            this.list[this.itemsInArray] = new ShoppingCart(name, cost);
            this.itemsInArray += 1;
        }

    }

    public void removeFromCart(int index) {
//        this.list.remove(index);
        this.list[index] = null;
        this.itemsInArray -= 1;
    }

    public void showCartItems() {

        for(int i = 0; i < this.list.length; i++) {
            if(this.list[i] == null) {
                continue;
            }
            System.out.println(this.list[i].item);
        }

    }

    public double calculateCartTotal() {
        this.totalPriceOfItems = 0;
        for(int i = 0; i <= this.itemsInArray; i++) {
            if(this.list[i] == null) continue;
            this.totalPriceOfItems += this.list[i].price;
        }
        System.out.println("this is the cost of all the items: $" + this.totalPriceOfItems);

        return this.totalPriceOfItems;
    }

    public double cartTotalPlusTax(int taxRate) {
        calculateCartTotal();
        System.out.println("Total plus tax: $" + Math.round(this.totalPriceOfItems * ((taxRate * 0.01) + 1.00) * 100) * 0.01);
        return (this.totalPriceOfItems * Math.round(this.totalPriceOfItems * ((taxRate * 0.01) + 1.00) * 100) * 0.01);
    }

}
