public class Main {

    public static void main(String[] args) {
        User john = new User("John");

        john.addToCart("water bottle", 5.09);
        john.addToCart("tv", 500.50);
        john.addToCart("table", 100.67);
        john.addToCart("chairs", 75.29);

        john.showCartItems();

        System.out.println(john.list.length);

        john.removeFromCart(2);
        System.out.println("removed item from list");

        john.showCartItems();

        john.calculateCartTotal();
        john.cartTotalPlusTax(7);
    }

}
