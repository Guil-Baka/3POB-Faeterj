public class Carrinho {

  private int idItemCarrinho;
  private int precoTotal;

  // construtor
  public Carrinho(int idProduto, int precoTotal) {
    this.idItemCarrinho = idItemCarrinho;
    this.precoTotal = precoTotal;
  }

  // getters

  public int getIdProduto() {
    return this.idItemCarrinho;
  }

  public int getPrecoTotal() {
    return this.precoTotal;
  }

  // setters

  public void setIdproduto(int idProduto) {
    this.idItemCarrinho = idProduto;
  }

  public void setPrecoTotal(int precoTotal) {
    this.precoTotal = precoTotal;
  }

  // métodos

}
