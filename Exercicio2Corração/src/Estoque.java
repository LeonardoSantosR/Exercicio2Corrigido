import javax.swing.JOptionPane;


// Trabalho feito por Frederico, Leonardo e Ricardo

public class Estoque {

    static No Inicio, Final;
    int posição=0;

    public void inserir(Produto dado){
    	
        No x = new No(dado);
        
        if(Inicio == null){
            Inicio = x;
            Final = x;
        } else if (x.dado.getValidade().compareTo(Final.dado.getValidade()) >= 0){   
        	
                x.esq = Final;
                Final.dir = x;
                Final = x;
                
        } else if (x.dado.getValidade().compareTo(Inicio.dado.getValidade()) <= 0) {
        	
                x.dir = Inicio;
                Inicio.esq = x;
                Inicio = x;
            } else {
            	
                No y = Inicio;
                No z = x;
                while(y != null) {
                	
                    if(x.dado.getValidade().compareTo(y.dado.getValidade()) <= 0 ) {
                        z.dir = x;
                        x.esq = z;
                        x.dir = y;
                        y.esq = x;
                        break;
                        
                    } else {
                    	
                        z = y;
                        y = y.dir;
                        
                    }
			    } 
            }
        
        posição++;
    }
    

    
    //Método global para realizar as buscas
    public No Pesquisar(String Nome){
        No x = Inicio;
        boolean achou = false;
        while(x != null && !achou){
            if(x.dado.getNome().equals(Nome)){
                achou = true;
            } else{
                x = x.dir;
            }
        }
        return x;
    }
    
    
    //Remoção de produto
    
    
    public boolean remover(String Nome){
        No x = Pesquisar(Nome);
        boolean realizado = false;

        if(x != null){
            if(posição == 1){
            	
                x.dir = null;
                x.esq = null;
                Inicio = null;
                Final = null;
                
            } else if(x == Inicio){
            	
                Inicio = x.dir;
                Inicio.esq = null;
                x.dir = null;
                
            } else if(x == Final){
            	
                Final = x.esq;
                Final.dir = null;
                x.esq = null;
                
            } else{
            	
                x.esq.dir = x.dir;
                x.dir.esq = x.esq;
                x.dir = null;
                x.esq = null;
                
            }
            posição--;
            realizado = true;
        }
        return realizado;
    }

// Método usado para realizar a impressão
    public void imprimir(){
        No x = Inicio;
        while(x!=null){
        	
            JOptionPane.showMessageDialog(null, "Produto: " + x.dado.getNome() + "\nData de validade: " + x.dado.getValidade() + "\nQuantidade: " + x.dado.getQuantidade());
            x = x.dir;
     //tentei usar o getDados pra usar aqui mas não deu certo, usei separado mesmo
        }
    }

    
}