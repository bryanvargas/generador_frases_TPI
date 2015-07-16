package gui;

import java.lang.reflect.Method;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ReflectionTableModel extends AbstractTableModel{


	private static final long serialVersionUID = -7593908960243505812L;

	private List<?> lista;  
	  
	private String[] $nombreColumnas = new String[0];
	    public void adicionaItem(){  
	        int linha = lista.size()-1;  
	        fireTableRowsInserted(linha,linha);  
	    }  
	  
	    public Object carregaItem(int row){  
	        return lista.get(row);  
	    }  
	  
	    public void deleteItem(int row){  
	        fireTableRowsDeleted(row, row);  
	        lista.remove(row);  
	    }  
	    
  
	      
	     @Override    
	     public int getColumnCount() {          //ESSE AQUI RETORNA O NÚMERO DE COLUNAS CERTO?  
	        return lista.size();    
	     }    
	      
	     @Override    
	     public String getColumnName(int column) {  // ESSE RETORNA O NOME DA COLUNA? DO BD OU DO MODELO?  
	        return $nombreColumnas[column];  
	     }    
	      
	     @Override    
	     public int getRowCount() {         //RETORNA O NÚMERO DE LINHAS?  
	        return lista.size();    
	     }    
	      
	     @Override    
	     public Object getValueAt(final int rowIndex, final int columnIndex) {          //ESSE AQUI NÃO FAÇO A MENOR IDÉIA  
	        return lista.get(rowIndex);    
	     }    
	      
	     @Override    
	     public boolean isCellEditable(final int rowIndex, final int columnIndex) {     //ESSE AQUI EU ATÉ JÁ SEI, DEIXA AS CELULAS EDITAVEIS OU NÃO.  
	        return false;                                 
	    }    
	 }    
}
