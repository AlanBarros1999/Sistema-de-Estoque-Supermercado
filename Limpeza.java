
package ProjetoEstoque;

/**
 * @author Alan
 * Projeto Estoque de Supermercado
 * Prof Aldo
 * Sistemas de informação
 */

public class Limpeza {
    
    
    
        //Atributos do produto
	private String nome;
        private String setor;
	private int codigo;
	private float preco;
	private int quantidade;
        
        
        
        //usando os metodos SET e GET para chamar na classe main
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigo() { 
               
                return codigo;
	}
	public void setCodigo(int codigo) {

		this.codigo = codigo;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
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
        
	

