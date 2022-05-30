public class Produto {
    
    private String nome, Validade;
    private int Quantidade;

    public Produto(String nome, String Validade, int Quantidade){
        this.nome = nome;
        this.Validade = Validade;
        this.Quantidade = Quantidade;
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

    public void setDtValidade(String dtValidade) {
        this.Validade = Validade;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    
}

