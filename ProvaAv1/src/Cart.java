import java.util.ArrayList;

public class Cart {

  private ArrayList<CartItens> cartItens;

  // construtor
  public Cart() {
    this.cartItens = new ArrayList<CartItens>();
  }

  public void addProduct(CartItens cartIten) {
    this.cartItens.add(cartIten);
  }

  public void removeProduct(int productId) {
    for (CartItens cartIten : cartItens) {
      if (cartIten.getProductId() == productId) {
        this.cartItens.remove(cartIten);
      }
    }
  }

  public void printCart() {
    System.out.println("========================Carrinho========================");
    for (CartItens cartIten : cartItens) {
      System.out.println("Id do produto: " + cartIten.getProductId() + ", quantidade: " + cartIten.getQuantity());
    }
    System.out.println("=========================================================");
  }
}
