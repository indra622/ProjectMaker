package csee.narasarang.projmaker.UIcomponent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DatePicker extends JPanel {
	/**
	 * @uml.property  name="comboBoxY"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
	 */
	public JComboBox comboBoxY = new JComboBox();
	/**
	 * @uml.property  name="comboBoxM"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
	 */
	public JComboBox comboBoxM = new JComboBox();
	/**
	 * @uml.property  name="comboBoxD"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
	 */
	public JComboBox comboBoxD = new JComboBox();

	public DatePicker() {
		
		comboBoxY.setModel(new DefaultComboBoxModel(new String[] { "2013",
				"2014", "2015", "2016" }));
		comboBoxY.setSelectedIndex(1);
		comboBoxM.setModel(new DefaultComboBoxModel(new String[] { "01", "02",
				"03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		comboBoxM.setSelectedIndex(1);
		comboBoxD.setModel(new DefaultComboBoxModel(new String[] { "01", "02",
				"03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		comboBoxD.setSelectedIndex(1);

		JLabel dateYear = new JLabel("year ");
		JLabel dateMonth = new JLabel("month ");
		JLabel dateDay = new JLabel("day ");
		
		this.add(dateYear);
		this.add(comboBoxY);
		this.add(dateMonth);
		this.add(comboBoxM);
		this.add(dateDay);
		this.add(comboBoxD);
	}

	public String getDate() {
		String date = null;

		date = (String) comboBoxY.getSelectedItem()
				+ (String) comboBoxM.getSelectedItem()
				+ (String) comboBoxD.getSelectedItem();
		return date;

	}
}
