package pruebas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * Ejemplo de uso de TableRowSorter y RowFilter.
 * 
 * @author Chuidiang
 * 
 */
public class PruebaJTable {

	private TableRowSorter<TableModel> modeloOrdenado;

	/**
	 * main del ejemplo.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new PruebaJTable();
	}

	/**
	 * Instancia un JFrame con un JTable dentro y diez filas de datos. Lleva un
	 * trozo de c�digo comentado para poder reemplazar.
	 */
	public PruebaJTable() {
		JFrame v = new JFrame("Prueba JTable");

		// Modelo de datos, segunda columna Integer y primera String. Los
		// �ndices empiezan en cero.
		DefaultTableModel modelo = new DefaultTableModel() {
			@Override
			public Class getColumnClass(int columna) {
				if (columna == 1)
					return Integer.class;
				return String.class;
			}
		};

		// A�adimos unos datos.
		modelo.addColumn("columna 1");
		modelo.addColumn("columna 2");
		for (int i = 0; i < 20; i++) {
			modelo.addRow(new Object[] { "" + i, 100 - i });
		}

		

		// Lo pintamos todo en la ventana y la mostramos.
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		
		// Metemos el modelo ordenable en la tabla.
				modeloOrdenado = new TableRowSorter<TableModel>(modelo);
				tabla.setRowSorter(modeloOrdenado);
				modeloOrdenado.setRowFilter(RowFilter.regexFilter("2", 1));
		v.getContentPane().add(scroll);
		v.pack();
		v.setVisible(true);
		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
}


