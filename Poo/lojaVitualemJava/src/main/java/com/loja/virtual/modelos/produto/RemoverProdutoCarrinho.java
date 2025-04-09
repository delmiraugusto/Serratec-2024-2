package com.loja.virtual.modelos.produto;
import static com.loja.virtual.modelos.pedido.Pedido.carrinho;

public class RemoverProdutoCarrinho {

    public static void removerProdutoCarrinho(String user, int codProduto) {
        boolean produtoRemovido = false;
        for (int index = 0; index < carrinho.size(); index++) {
            if (carrinho.get(index).getProduto().getCodProduto() == codProduto) {
                carrinho.remove(index);
                produtoRemovido = true;
                System.out.println("Produto removido com sucesso.");
                break;
            }
        }
        if (!produtoRemovido) {
            System.out.println("Erro: Produto não encontrado com o código fornecido.");
        }
    }
}
