import javax.swing.JOptionPane;

//Trabalho feito por Frederico, Leonardo e Ricardo

public class Util {

    static Estoque estoque = new Estoque();
    
    public static String Menu(){
        String aux  = "Escolha uma opção:";
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

			int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Mês : "));

			int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Dia : "));

			int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Ano : "));
			
			String Validade = mes + "/" + dia + "/" + ano;
			int Quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade em estoque: "));

			Produto dado = new Produto(Nome, Validade, Quantidade);
			estoque.inserir(dado);

				JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
		} else {
				JOptionPane.showMessageDialog(null, "Produto já existe no sistema");
		}
	}

    public static void ProdutosL(){
        if(estoque.posição == 0){
            	JOptionPane.showMessageDialog(null, "Ainda não existem produtos cadastrados");
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
                JOptionPane.showMessageDialog(null, "Esse produto não tem um validade correta");
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