
package ProjetoEstoque;

/**
 * @author Alan
 * Projeto Estoque de Supermercado
 * Prof Aldo
 * Sistemas de informação
 */
public class Alimento {
    	private String nome;
        private String setor;
	private int codigo;
	private float preco;
	private int quantidade;
        
    public String getnome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setnome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
    
}
