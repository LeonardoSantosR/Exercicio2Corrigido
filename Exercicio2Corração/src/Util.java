import javax.swing.JOptionPane;

public class Util {

    static Estoque estoque = new Estoque();
    
    public static String Menu(){
        String aux  = "Escolha uma op��o:";
            aux += "\n1. Cadastrar produto";
            aux += "\n2. Listar produtos";
            aux += "\n3. Comprar produto";
            aux += "\n4. Encerrar";
        
        return aux;   
    }

	public static void Cadastrar() {
		String Nome = JOptionPane.showInputDialog(null, "Nome do produto: ");

		No aux = estoque.Pesquisar(Nome);
		if (aux == null) {

			int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "M�s : "));

			int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Dia : "));

			int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Ano : "));
			
			String Validade = mes + "/" + dia + "/" + ano;
			int Quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade em estoque: "));

			Produto dado = new Produto(Nome, Validade, Quantidade);
			estoque.inserir(dado);

			JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Produto j� existe no sistema");
		}
	}

    public static void ProdutosL(){
        if(estoque.posi��o == 0){
            JOptionPane.showMessageDialog(null, "Ainda n�o existem produtos cadastrados");
            throw new UnsupportedOperationException();

        } else {
            estoque.imprimir();
        }
    }

    public static void Vender(){
        String nome = JOptionPane.showInputDialog("Nome do produto: ");
        No aux = estoque.Pesquisar(nome);
        if(aux == null){
            JOptionPane.showMessageDialog(null, "Produto inexistente");
        } else{
            JOptionPane.showMessageDialog(null, "Produto: " + aux.dado.getNome() + "\nData de validade: " + aux.dado.getValidade() + "\nValidade: " + aux.dado.getQuantidade());
            int qtd = Integer.parseInt(JOptionPane.showInputDialog("Validade desejada: "));
            if(qtd > aux.dado.getQuantidade()){
                JOptionPane.showMessageDialog(null, "Esse produto n�o tem um validade correta");
            } else{
                aux.dado.setQuantidade(aux.dado.getQuantidade() - qtd);
                JOptionPane.showMessageDialog(null, "Venda realizada :)");
                if(aux.dado.getQuantidade() == 0){
                    estoque.remover(nome); 
                }
            }
        }
        
    }
    }