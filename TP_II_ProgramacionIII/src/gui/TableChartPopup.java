package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.ToolTipManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class TableChartPopup extends JFrame {

	  public TableChartPopup() {
		  
		    super("Table Chart");
		    setSize(300,200);
		    TableModel tm = new AbstractTableModel( ) {
			      String data[][] = {
			        {"Ron", "0.00", "68.68", "77.34", "78.02"},
			        
			        {"Ravi", "0.00", "70.89", "64.17", "75.00"},
			        {"Maria", "76.52", "71.12", "75.68", "74.14"},
			        {"James", "70.00", "15.72", "26.40", "38.32"},
			        {"Ellen", "80.32", "78.16", "83.80", "85.72"}
			      };
			      String headers[] = { "", "Q1", "Q2", "Q3", "Q4" };
			      public int getColumnCount( ) { return headers.length; }
			      public int getRowCount( ) { return data.length; }
			      public String getColumnName(int col) { return headers[col]; }
			      public Class getColumnClass(int col) {
			        return (col == 0) ? String.class : Number.class;
			      }
			      public boolean isCellEditable(int row, int col) { return true; }
			      public Object getValueAt(int row, int col) { return data[row][col]; }
			      public void setValueAt(Object value, int row, int col) {
			        data[row][col] = (String)value;
			        fireTableRowsUpdated(row,row);
			      }
			    };
		    TableChart tc = new TableChart(tm);
		    getContentPane( ).add(tc, BorderLayout.CENTER);
		  // Use the following line to turn on tooltips:
		  ToolTipManager.sharedInstance( ).registerComponent(tc);
		  }
		
}
