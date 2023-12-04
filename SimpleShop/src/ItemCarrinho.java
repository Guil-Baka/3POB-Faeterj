public class ItemCarrinho {

  private int idProduto;
  private int idItemCarrinho;
  private int quantidade;

  // construtor
  public ItemCarrinho(int idProduto, int idItemCarrinho, int quantidade) {
    this.idProduto = idProduto;
    this.idItemCarrinho = idItemCarrinho;
    this.quantidade = quantidade;
  }

  // getters

  public int getIdProduto() {
    return this.idProduto;
  }

  public int getIdItemCarrinho() {
    return this.idItemCarrinho;
  }

  public int getQuantidade() {
    return this.quantidade;
  }

  // setters

  public void setIdProduto(int idProduto) {
    this.idProduto = idProduto;
  }

  public void setIdItemCarrinho(int idItemCarrinho) {
    this.idItemCarrinho = idItemCarrinho;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }
}