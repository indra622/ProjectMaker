package csee.narasarang.projmaker.UIcomponent;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SubTaskListPanel extends JPanel{
	/**
	 * @uml.property  name="checkbox"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JRadioButton checkbox = new JRadioButton();
	
	/**
	 * @uml.property  name="okButton"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton okButton = new JButton("OK");

	/**
	 * @uml.property  name="tf"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField tf = new JTextField(10);

	
	
	public SubTaskListPanel(String name){
		JLabel member = new JLabel(name);
		this.setLayout(new GridBagLayout());
		this.add(checkbox);
		this.add(member);
		this.add(tf);
		this.add(okButton);
		this.setVisible(true);
	}

}
