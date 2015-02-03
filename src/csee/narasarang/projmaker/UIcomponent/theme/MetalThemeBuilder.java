package csee.narasarang.projmaker.UIcomponent.theme;

import javax.swing.JRadioButton;

public class MetalThemeBuilder extends ThemeBuilder {
	static String metal = "Metal";
	static String metalClassName = "javax.swing.plaf.metal.MetalLookAndFeel";

	public JRadioButton setThemeCommander(String name) {
		JRadioButton temp = new JRadioButton(name);

		temp.setActionCommand(metalClassName);
		temp.addActionListener(this);

		return temp;

	}
}
