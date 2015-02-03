package csee.narasarang.projmaker.UIcomponent.frame;

import javax.swing.JFrame;

import csee.narasarang.projmaker.UIcomponent.MainPanel;
import csee.narasarang.projmaker.UIcomponent.ProjectPanel;

public class MainFrame extends JFrame {
	
	/**
	 * @uml.property  name="mainPanel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private MainPanel mainPanel = MainPanel.getInstance();
	
	public MainFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(1200,500);

		this.add(mainPanel);
	}
}
