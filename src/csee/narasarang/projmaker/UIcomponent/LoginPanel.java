package csee.narasarang.projmaker.UIcomponent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import csee.narasarang.projmaker.DAO.DAO;
import csee.narasarang.projmaker.test.TestDAO;
import csee.narasarang.projmaker.user.UserVO;
import csee.narasarang.projmaker.user.UserManager;
//List
//List

/**
 * @author Hwang Nara
 * @email narahwang7@gmail.com
 * @classname PMLoginPanel.java
 * @package csee.narasarang.projmaker.UIcomponent
 * @date 2013. 5. 8. 오후 1:27:23
 * @purpose : 회원가입, 로그인 창.
 *
 * @comment : id와 password가 맞아야만 로그인 가능
 * 
 */

class JLabelAndJTextField implements ActionListener {
	/**
	 * @uml.property  name="id"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextField id;
	/**
	 * @uml.property  name="password"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JPasswordField password;
	
	public JLabelAndJTextField (JTextField id, JPasswordField password) {
		this.id=id;
		this.password=password;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	  System.out.println("ID:"+id.getText());
	  System.out.println("PASSWORD:"+new String(password.getPassword()));
	  id.setText("");
	  password.setText("");
	}
}

public class LoginPanel extends JPanel{
	
	/**
	 * @uml.property  name="integ_panel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JPanel integ_panel=new JPanel();
	/**
	 * @uml.property  name="image_panel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JPanel image_panel=new JPanel();
	/**
	 * @uml.property  name="login_panel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JPanel login_panel=new JPanel();
	/**
	 * @uml.property  name="btn_panel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JPanel btn_panel=new JPanel();
	/**
	 * @uml.property  name="text_panel1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JPanel text_panel1=new JPanel();
	/**
	 * @uml.property  name="text_panel2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JPanel text_panel2=new JPanel();
	/**
	 * @uml.property  name="text_panel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JPanel text_panel=new JPanel();
	/**
	 * @uml.property  name="null_panel1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JPanel null_panel1=new JPanel();
	/**
	 * @uml.property  name="null_panel2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JPanel null_panel2=new JPanel();
	/**
	 * @uml.property  name="img"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	ImageIcon img;
		
	public LoginPanel () {
		
		JButton register_btn=new JButton("Register");
		JButton login_btn=new JButton("Login");
		JLabel idLabel=new JLabel("ID   ",JLabel.CENTER);
		JLabel passwordLabel=new JLabel("Password",JLabel.CENTER);
		JTextField idText=new JTextField(10);
		JPasswordField passwordText=new JPasswordField(10);
		img = new ImageIcon("image/project.jpg");
		JLabel img_label = new JLabel(img,JLabel.CENTER);
		
		passwordText.setEchoChar('*');
		passwordText.addActionListener(new JLabelAndJTextField(idText,passwordText));

		btn_panel.setLayout(new GridLayout(2,1));
		btn_panel.add(register_btn);
		btn_panel.add(login_btn);
		
		
		text_panel1.setLayout(new GridLayout(1,4));
		text_panel1.add(idLabel);
		text_panel1.add(idText);
		
		text_panel2.setLayout(new GridLayout(1,4));
		text_panel2.add(passwordLabel);
		text_panel2.add(passwordText);
		
		text_panel.setLayout(new GridLayout(5,1));
		text_panel.add(null_panel1);
		text_panel.add(text_panel1);
		text_panel.add(null_panel2);
		text_panel.add(text_panel2);
		
		
		
		login_panel.setLayout(new BorderLayout());
		login_panel.add(btn_panel,BorderLayout.WEST);
		login_panel.add(text_panel,BorderLayout.CENTER);
		
		login_panel.setBorder(new TitledBorder("ProjectMaker"));
		login_panel.setPreferredSize(new Dimension(230, 180));
		login_panel.setBounds(10, 10, 20, 10);
		
		image_panel.setLayout(new BorderLayout());
		image_panel.add(img_label,BorderLayout.SOUTH);
		
		integ_panel.setLayout(new GridLayout(0,1));
		
		integ_panel.add(login_panel);
		integ_panel.add(image_panel);
		
		
		ActionEventHandler_register actionHandler_register=new ActionEventHandler_register();
		ActionEventHandler_login actionHandler_login=new ActionEventHandler_login(idText, passwordText);
		register_btn.addActionListener(actionHandler_register);
		login_btn.addActionListener(actionHandler_login);
		
		//this.setLayout(new GridLayout(1,0));
		this.add(integ_panel,BorderLayout.CENTER);
	}
}
class ActionEventHandler_register implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainPanel.getInstance().switchToRegisterPanel();
		
	}
	
}
class ActionEventHandler_login implements ActionListener
{
	
	/**
	 * @uml.property  name="id"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextField id;
	/**
	 * @uml.property  name="password"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JPasswordField password;
	
	public ActionEventHandler_login (JTextField id, JPasswordField password) {
		this.id = id;
		this.password = password;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean loginOk = false;
		
		
		System.out.println(id.getText());
		System.out.println(new String(password.getPassword()));
		
		
		try {
			DAO dao = new UserManager();
			UserVO user = new UserVO();
			
			
			user.setId(id.getText());
			user.setPassword(new String(password.getPassword()));
			
			TestDAO tdo = new TestDAO();
			//tdo.alreadyJoinedProject();
			
			loginOk = dao.login(user);
			System.out.println("loginOK = " + loginOk);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		if(loginOk) {
			DAO dao = new UserManager();
			MainPanel.user = dao.getUserInfo(id.getText());
			MainPanel.getInstance().switchToProjectPanel();
			}
		//이 아래는 현재 ID/PW 안 맞아도 로그인 되게 해놓음.
		else  MainPanel.getInstance().switchToProjectPanel();
			
			
		
	}
}
