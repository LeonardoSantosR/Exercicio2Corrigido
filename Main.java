import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;

//Trabalho feito por Frederico, Leonardo e Ricardo

public class Main {
	public static void main(String[] args) {

    int opcao;
    
    do {
    	opcao = parseInt(showInputDialog(Util.Menu()));
    			if (opcao < 1|| opcao >5) {
    				
    				showMessageDialog(null, "Opção inválida");
    			}else {
    				
    				switch(opcao) {
    	
    				case 1:
    					Util.Cadastrar();
    					break;
    				case 2:
    					Util.ProdutosL();
    					break;
    				case 3:
    					Util.Vender();
    					break;
    			
    				}
    			}
       }
    	while(opcao != 4);
    
	}
 
}