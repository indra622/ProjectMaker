package csee.narasarang.projmaker.UIcomponent.theme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public abstract class ThemeBuilder implements ActionListener {

	/**
	 * @uml.property  name="panel"
	 * @uml.associationEnd  
	 */
	JPanel panel;

	public ThemeBuilder() {

	}

	public ThemeBuilder(JPanel panel) {
		this.panel = panel;
	}

	public void actionPerformed(ActionEvent e) {

		String lfs = e.getActionCommand();

		try {
			UIManager.setLookAndFeel(lfs);

		} catch (Exception e2) {
			System.err.println(e2);
			System.exit(0);
		}

	}

	public abstract JRadioButton setThemeCommander(String name);
}
