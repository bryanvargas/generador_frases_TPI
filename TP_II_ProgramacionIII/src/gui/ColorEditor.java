package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.toedter.calendar.JDateChooser;

public class ColorEditor extends AbstractCellEditor
implements TableCellEditor,
           ActionListener {
Date currentColor;
protected Object value;
JButton button;
JDateChooser colorChooser;
JDialog dialog;
protected static final String EDIT = "edit";

public ColorEditor() {



//Set up the dialog that the button brings up.
colorChooser = new JDateChooser();
colorChooser.setDateFormatString( "dd MMM yyyy" );
colorChooser.setOpaque(true);
}


@Override
public Object getCellEditorValue() {
return colorChooser.getDate();
}



@Override
public void actionPerformed(ActionEvent arg0) {
	if (EDIT.equals(arg0.getActionCommand())) {
		//The user has clicked the cell, so
		//bring up the dialog.
		
		colorChooser.setDate(currentColor);
		dialog.setVisible(true);

		fireEditingStopped(); //Make the renderer reappear.

		} else { //User pressed dialog's "OK" button.
		currentColor = colorChooser.getDate();
		}
	
}

@Override
public Component getTableCellEditorComponent(JTable table, Object value,
		boolean isSelected, int row, int column) {
	if (value ==null) {
		value =  new Date();
	}
	colorChooser.setDate((Date)value);
	if (isSelected) {
		colorChooser.setBackground(table.getSelectionBackground());
	}else{
		colorChooser.setBackground(table.getBackground());
	}
	return colorChooser;
}
}