package csee.narasarang.projmaker.UIcomponent.theme;

import javax.swing.JRadioButton;

public class WindowsThemeBuilder extends ThemeBuilder {
	static String windows = "Windows";
	static String windowsClassName = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

	public JRadioButton setThemeCommander(String name) {
		JRadioButton temp = new JRadioButton(name);

		temp.setActionCommand(windowsClassName);
		temp.addActionListener(this);

		return temp;

	}
}
