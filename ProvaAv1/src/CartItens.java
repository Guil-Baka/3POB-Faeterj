public class CartItens {

  private int productId;
  private int quantity;

  // construtor
  public CartItens(int initialProductId, int initialQuantity) {
    this.productId = initialProductId;
    this.quantity = initialQuantity;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
