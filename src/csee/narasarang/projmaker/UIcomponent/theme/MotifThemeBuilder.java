package csee.narasarang.projmaker.UIcomponent.theme;

import javax.swing.JRadioButton;

public class MotifThemeBuilder extends ThemeBuilder {

	static String motif = "Motif";
	static String motifClassName = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";

	public JRadioButton setThemeCommander(String name) {
		JRadioButton temp = new JRadioButton(name);

		temp.setActionCommand(motifClassName);
		temp.addActionListener(this);

		return temp;

	}

}
