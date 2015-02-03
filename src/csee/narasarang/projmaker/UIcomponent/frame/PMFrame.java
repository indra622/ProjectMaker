package csee.narasarang.projmaker.UIcomponent.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import csee.narasarang.projmaker.UIcomponent.MainPanel;

/**
 * @author Hosung
 * @email indra622@gmail.com
 * @classname PMMainFrame.java
 * @package csee.narasarang.projmaker.UIcomponent.frame
 * @date 2013. 5. 3.오후 9:07:18
 * @purpose : Program MainFrame
 *
 * @comment : 
 * 			@hosung 일단 적당히 해서 만들었는데 사이즈를 잘 몰라서 일단 600 400으로 했듕
 * 			@hosung 800 500
 *
 */
public class PMFrame extends JFrame {
	
	public PMFrame(JPanel panel, int width, int height){
		this.setVisible(true);
		this.setSize(width,height);
		this.add(panel);
	}
}
