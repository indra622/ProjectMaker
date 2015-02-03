package csee.narasarang.projmaker.UIcomponent;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;
import java.util.Enumeration;

import csee.narasarang.projmaker.UIcomponent.frame.MainFrame;
import csee.narasarang.projmaker.user.UserVO;

/**
 * @author Hosung
 * @email indra622@gmail.com
 * @classname PMMainPanel.java
 * @package csee.narasarang.projmaker.UIcomponent
 * @date 2013. 5. 3.�ㅽ썑 9:06:30
 * @purpose : Program Main Panel
 *
 * @comment : 
 * 		
 * 			
 *
 */
public class MainPanel extends JPanel{
	private static MainPanel mainPanel = new MainPanel();
	public static MainPanel getInstance(){ return mainPanel;}
	public static UserVO user = new UserVO();
	
	public MainPanel(){
		this.setLayout(new BorderLayout());
		/*********첫화면************/
		this.add(new LoginPanel(), BorderLayout.CENTER); 
//		this.add(new ProjectPanel(), BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public void switchToMainPanel(){
		switchTo(new ProjectPanel());
	}
	
	public void switchToRegisterPanel(){
		switchTo(new RegisterPanel());
	}
	
	public void switchToLoginPanel(){
		switchTo(new LoginPanel());
	}
	
	public void switchToProjectPanel(){
		switchTo(new ProjectPanel());

	}
	
	public void switchTo(JPanel panel){
		this.removeAll();
		this.add(panel);
		this.updateUI();
	}
	
	public static void setUIFont(FontUIResource f) {
        Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                FontUIResource orig = (FontUIResource) value;
                Font font = new Font(f.getFontName(), orig.getStyle(), f.getSize());
                UIManager.put(key, new FontUIResource(font));
            }
        }

	}
}
