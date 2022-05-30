public class Produto {
    
	// Trabalho feito por Frederico, Leonardo e Ricardo
	
	
    private String nome, Validade;
    private int Quantidade;

    public Produto(String nome, String Validade, int Quantidade){
    	
        this.nome = nome;
        this.Validade = Validade;
        this.Quantidade = Quantidade;
    }
    
    // método para retornar os dados do filme
 	public String getDados() {
 		
 		String aux = "";
 		aux = aux + "Nome: " + nome + "\n";
 		aux = aux + "Quantidade: " + String.format("%.2f", Quantidade) + "\n";
 		aux = aux + "Validade: " + String.format("%.2f", Validade) + "\n";

 		
 		return aux;
 	}
    
    public String getNome() {
    	
        return nome;
        
    }

    public void setNome(String nome) {
    	
        this.nome = nome;
        
    }

    public String getValidade() {
    	
        return Validade;
        
    }

    public void setValidade(String Validade) {
    	
        this.Validade = Validade;
        
    }
    

    public int getQuantidade() {
    	
        return Quantidade;
        
    }

    public void setQuantidade(int Quantidade) {
    	
        this.Quantidade = Quantidade;
        
    }

	
    
}

