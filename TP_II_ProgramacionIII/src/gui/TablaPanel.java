package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ScrollPane;
import java.util.Date;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView.TableRow;


public class TablaPanel extends JPanel{

	private static final long serialVersionUID = 6294456506146229717L;
	private JTable $tabla;
	private GenericTablaModel $genericTablaModel;
	private SortngColumnaModel $sorted;
	private TableRowSorter<TableModel> orden;
	public TablaPanel() {
		$genericTablaModel = new GenericTablaModel();
		this.$tabla = new JTable($genericTablaModel);
		 
			
			this.$tabla.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
			this.$tabla.setColumnSelectionAllowed(true);
			this.$tabla.createDefaultColumnsFromModel();

			
		setLayout(new BorderLayout());
		add(new JScrollPane($tabla), BorderLayout.CENTER);
	}
	
	public void setDataTabla(Object[][] $tabla){
		$genericTablaModel.setTabla($tabla);	
		this.orden = new TableRowSorter<TableModel>($genericTablaModel);		
		this.$tabla.setRowSorter(orden);
		  //Set up renderer and editor for the Favorite Color column.
        this.$tabla.setDefaultRenderer(Date.class,
                                 new ColorRenderer(true));
        this.$tabla.setDefaultEditor(Date.class,
                               new ColorEditor());
		initColumnSizes(this.$tabla);
		setUpReservaColumna(this.$tabla, this.$tabla.getColumnModel().getColumn(1));
		
	}
	public void setNombreColumnasTabla(String[] $nombreColumnas){
		$genericTablaModel.setNombreColumnas($nombreColumnas);
		
		
		
		
	}
	
	
	
	
	  /**
	  * Returns <code>true</code> if the specified cell is editable, and 
	  * <code>false</code> if it is not.  This implementation returns 
	 * <code>false</code> for all arguments, subclasses should override the 
	  * method if necessary.
	  *
	  * @param rowIndex  the row index of the cell.
	  * @param columnIndex  the column index of the cell.
	  *
	  * @return <code>false</code>.
	  */
	public void refresh(){
		$genericTablaModel.fireTableDataChanged();
	}
	
	 private void initColumnSizes(JTable table) {
	        GenericTablaModel model = (GenericTablaModel)table.getModel();
	        TableColumn column = null;
	        Component comp = null;
	        int headerWidth = 0;
	        int cellWidth = 0;
	        Object[] longValues = model.getNombreColumnas();
	        TableCellRenderer headerRenderer =
	            table.getTableHeader().getDefaultRenderer();

	        for (int i = 0; i < 5; i++) {
	            column = table.getColumnModel().getColumn(i);

	            comp = headerRenderer.getTableCellRendererComponent(
	                                 null, column.getHeaderValue(),
	                                 false, false, 0, 0);
	            headerWidth = comp.getPreferredSize().width;

	            comp = table.getDefaultRenderer(model.getColumnClass(i)).
	                             getTableCellRendererComponent(
	                                 table, longValues[i],
	                                 false, false, 0, i);
	            cellWidth = comp.getPreferredSize().width;

	            

	            column.setPreferredWidth(Math.max(headerWidth, cellWidth));
	        }
	    }
	
	
	public void setUpReservaColumna(JTable table,TableColumn sportColumn) {
		//Set up the editor for the sport cells.
		JComboBox comboBox = new JComboBox();		
		comboBox.addItem("Pool");
		comboBox.addItem("None of the above");
		sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
		
		//Set up tool tips for the sport cells.
		DefaultTableCellRenderer renderer =
		new DefaultTableCellRenderer();		
		renderer.setToolTipText("Click for combo box");
		sportColumn.setCellRenderer(renderer);
	}
	
	

}
