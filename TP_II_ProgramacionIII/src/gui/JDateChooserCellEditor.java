package gui;

import com.toedter.calendar. JDateChooser;

import javax.swing. *;
import javax.swing.table. TableCellEditor;

import java.awt. *;
import java.awt.event. MouseEvent;
import java.util. EventObject;
import java.util. Date;
public class JDateChooserCellEditor extends AbstractCellEditor implements TableCellEditor {
JDateChooser dateChooser = new JDateChooser ();

//Enables the editor only for double-clicks.
public boolean isCellEditable (EventObject evt) {
if (evt instanceof MouseEvent) {
return ((MouseEvent) evt).getClickCount ();
}
return true;
}
@Override
public Object getCellEditorValue() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Component getTableCellEditorComponent(JTable table, Object value,
		boolean isSelected, int row, int column) {
	dateChooser.setDate ((Date) value);
	dateChooser.setDateFormatString ("dd.mm.yyyy");
	return dateChooser;
}
}