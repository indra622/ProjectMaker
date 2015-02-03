package csee.narasarang.projmaker.UIcomponent;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.plaf.FontUIResource;

import csee.narasarang.projmaker.UIcomponent.theme.MetalThemeBuilder;
import csee.narasarang.projmaker.UIcomponent.theme.MotifThemeBuilder;
import csee.narasarang.projmaker.UIcomponent.theme.WindowsThemeBuilder;

public class SettingPanel extends JPanel {

	/**
	 * @uml.property  name="mainPanel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private MainPanel mainPanel = MainPanel.getInstance();

	/**
	 * @uml.property  name="fontstyle"
	 */
	int fontstyle = 0;
	/**
	 * @uml.property  name="fontsize"
	 */
	int fontsize = 15;
	/**
	 * @uml.property  name="fontkind"
	 */
	String fontkind = null;
	/**
	 * @uml.property  name="t"
	 */
	String t = null;
	/**
	 * @uml.property  name="font"
	 */
	final Font font = null;

	/**
	 * @uml.property  name="sample_lb"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JLabel sample_lb = new JLabel("ABCDEF", JLabel.CENTER);
	/**
	 * @uml.property  name="textsize"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextField textsize = new JTextField(10);
	/**
	 * @uml.property  name="checktheme1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JRadioButton checktheme1 = new MetalThemeBuilder()
			.setThemeCommander("Metal");
	/**
	 * @uml.property  name="checktheme2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JRadioButton checktheme2 = new MotifThemeBuilder()
			.setThemeCommander("Motiv");
	/**
	 * @uml.property  name="checktheme3"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JRadioButton checktheme3 = new WindowsThemeBuilder()
			.setThemeCommander("Window");
	/**
	 * @uml.property  name="comboBoxfont"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JComboBox comboBoxfont = new JComboBox();
	/**
	 * @uml.property  name="comboBoxstyle"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JComboBox comboBoxstyle = new JComboBox();
	/**
	 * @uml.property  name="setting"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JPanel setting = new JPanel();

	public SettingPanel() {

		this.setLayout(new FlowLayout());

		JLabel font_lb = new JLabel("1. 글꼴 : ");
		JLabel size_lb = new JLabel("2. 크기 : ");
		JLabel theme_lb = new JLabel("3. 테마 : ");
		JLabel style_lb = new JLabel("4. 스타일 : ");
		JLabel view_lb = new JLabel("5. 미리보기 : ", JLabel.LEFT);
		JButton apply_btn = new JButton("적용");

		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(checktheme1);
		bGroup.add(checktheme2);
		bGroup.add(checktheme3);

		comboBoxfont.setModel(new DefaultComboBoxModel(new String[] { "Serif",
				"SansSerif", "Monospaced", "Dialog" }));
		comboBoxfont.setSelectedIndex(1);

		comboBoxstyle.setModel(new DefaultComboBoxModel(new String[] { "BOLD",
				"ITALIC", "PLAIN", "TRUETYPE" }));
		comboBoxstyle.setSelectedIndex(1);

		JPanel font_p = new JPanel();
		font_p.setLayout(new FlowLayout());
		font_p.add(font_lb);
		font_p.add(comboBoxfont);

		JPanel size_p = new JPanel();
		size_p.setLayout(new FlowLayout());
		size_p.add(size_lb);
		size_p.add(textsize);

		JPanel theme_p = new JPanel();
		theme_p.setLayout(new FlowLayout());
		theme_p.add(theme_lb);
		theme_p.add(checktheme1);
		theme_p.add(checktheme2);
		theme_p.add(checktheme3);

		JPanel style_p = new JPanel();
		style_p.setLayout(new FlowLayout());
		style_p.add(style_lb);
		style_p.add(comboBoxstyle);

		JPanel view_p = new JPanel();
		apply_btn.setSize(5, 5);
		view_p.setLayout(new FlowLayout());
		view_p.add(view_lb);

		JPanel btn_p = new JPanel();
		btn_p.setLayout(new FlowLayout());
		btn_p.add(apply_btn);

		setting.setLayout(new GridLayout(7, 1));
		setting.add(font_p);
		setting.add(size_p);
		setting.add(theme_p);
		setting.add(style_p);
		setting.add(view_p);
		setting.add(sample_lb);
		setting.add(btn_p);

		comboBoxfont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (e.getSource() == comboBoxfont) {
					JComboBox cb = (JComboBox) e.getSource(); 
					switch (cb.getSelectedIndex()) {
					case 0:
						fontkind = "Serif";
						break;
					case 1:
						fontkind = "SansSerif";
						break;
					case 2:
						fontkind = "Monospaced";
						break;
					case 3:
						fontkind = "Dialog";
					}
				}
				sample_lb.setFont(new Font(fontkind, fontstyle, fontsize));

			}
		});

		comboBoxstyle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (e.getSource() == comboBoxstyle) {
					JComboBox cb = (JComboBox) e.getSource(); 
					switch (cb.getSelectedIndex()) {
					case 0:
						fontstyle = Font.BOLD;
						break;
					case 1:
						fontstyle = Font.ITALIC;
						break;
					case 2:
						fontstyle = Font.TYPE1_FONT;
						break;
					case 3:
						fontstyle = Font.TRUETYPE_FONT;
					}
				}
				sample_lb.setFont(new Font(fontkind, fontstyle, fontsize));

			}
		});

		textsize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t = textsize.getText();
				fontsize = Integer.parseInt(t);
				sample_lb.setFont(new Font(fontkind, fontstyle, fontsize));

			}
		});

		apply_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainPanel.setUIFont(new FontUIResource(new Font(fontkind,
						fontstyle, fontsize)));
				SwingUtilities.updateComponentTreeUI(mainPanel);
				SwingUtilities.updateComponentTreeUI(setting);
			}
		});

		this.setLayout(new FlowLayout());
		this.add(setting);

	}

}
