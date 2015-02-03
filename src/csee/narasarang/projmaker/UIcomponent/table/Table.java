package csee.narasarang.projmaker.UIcomponent.table;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 * @author Hosung
 * @email indra622@gmail.com
 * @classname PMTable.java
 * @package csee.narasarang.projmaker.UIcomponent.table
 * @date 2013. 5. 4.오후 4:11:11
 * @purpose : table abstract class
 *
 * @comment : 
 * 			
 *
 */
public abstract class Table extends JPanel{
	
	public Table(){
	}
	
	public Table(String[] colNames, String[][] datas, int width, int height){
		this.setVisible(true);
		
		DefaultTableModel model = new DefaultTableModel(datas, colNames);
		
		final JTable table = new JTable(model);
		JScrollPane jsp = new JScrollPane(table);
		this.add(jsp);
		
		table.getTableHeader().setReorderingAllowed(false);	
		table.getTableHeader().setResizingAllowed(false);	
		table.setPreferredScrollableViewportSize(new Dimension(width,height)); 
	}
	public abstract Table makeTable();
}