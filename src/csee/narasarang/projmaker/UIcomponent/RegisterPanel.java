package csee.narasarang.projmaker.UIcomponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import csee.narasarang.projmaker.DAO.DAO;
import csee.narasarang.projmaker.user.UserVO;
import csee.narasarang.projmaker.user.UserManager;
//List


public class RegisterPanel extends JPanel  {
	
	 private static RegisterPanel registerPanel = new RegisterPanel();
	 public static RegisterPanel getInstance(){ return registerPanel;}
	 
	 //private static DAO info = new DAO();
	 
      /**
	 * @uml.property  name="id_lb"
	 * @uml.associationEnd  
	 */
    JLabel id_lb = new JLabel("1. 아이디:     ", JLabel.LEFT);
      /**
	 * @uml.property  name="password_lb"
	 * @uml.associationEnd  
	 */
    JLabel password_lb = new JLabel("2. 비밀번호 :  ", JLabel.LEFT);
      /**
	 * @uml.property  name="name_lb"
	 * @uml.associationEnd  
	 */
    JLabel name_lb = new JLabel("3. 이름:           ", JLabel.LEFT);
      /**
	 * @uml.property  name="phone_lb"
	 * @uml.associationEnd  
	 */
    JLabel phone_lb = new JLabel("4. 핸드폰번호:", JLabel.LEFT);
      /**
	 * @uml.property  name="email_lb"
	 * @uml.associationEnd  
	 */
    JLabel email_lb = new JLabel("5. 이메일:       ", JLabel.LEFT);
      /**
	 * @uml.property  name="id_check_lb"
	 * @uml.associationEnd  
	 */
    JLabel id_check_lb = new JLabel("");
      
      
    
      /**
	 * @uml.property  name="bt1"
	 * @uml.associationEnd  
	 */
    JButton bt1 = new JButton("Join");
      /**
	 * @uml.property  name="bt2"
	 * @uml.associationEnd  
	 */
    JButton bt2 = new JButton("Clear");
      /**
	 * @uml.property  name="bt3"
	 * @uml.associationEnd  
	 */
    JButton bt3 = new JButton("Back");
      /**
	 * @uml.property  name="bt4"
	 * @uml.associationEnd  
	 */
    JButton bt4= new JButton("중복확인");
    
      /**
	 * @uml.property  name="id_tf"
	 * @uml.associationEnd  
	 */
    JTextField id_tf = new JTextField(10);
      /**
	 * @uml.property  name="password_tf"
	 * @uml.associationEnd  
	 */
    JPasswordField password_tf = new JPasswordField(10);
      /**
	 * @uml.property  name="name_tf"
	 * @uml.associationEnd  
	 */
    JTextField name_tf = new JTextField(10);
      /**
	 * @uml.property  name="phone_tf"
	 * @uml.associationEnd  
	 */
    JTextField phone_tf = new JTextField(10);
      /**
	 * @uml.property  name="email_tf"
	 * @uml.associationEnd  
	 */
    JTextField email_tf = new JTextField(10);

     public RegisterPanel(){
    	 

    	 this.setBounds(400,400,500,500);
    	 this.setLayout(new BorderLayout());
    	 
    	 JPanel up_panel = new JPanel();
    	 up_panel.setLayout(new BorderLayout());
    	 
    	 JPanel bottom_panel = new JPanel();
    	 bottom_panel.setLayout(new FlowLayout());
    	 
    
    	 JPanel id_panel = new JPanel();
    	 id_panel.setLayout(new FlowLayout());
    	 
    	 JPanel pw_panel = new JPanel();
    	 pw_panel.setLayout(new FlowLayout());
    	 
    	 JPanel name_panel = new JPanel();
    	 name_panel.setLayout(new FlowLayout());
    	 
    	 JPanel phone_panel = new JPanel();
    	 phone_panel.setLayout(new FlowLayout());
    	 
    	 JPanel email_panel = new JPanel();
    	 email_panel.setLayout(new FlowLayout());
     	 
    	 JPanel panel = new JPanel();
    	 panel.setLayout(new BorderLayout());
    	 
         JPanel reg_panel = new JPanel();
         reg_panel.setLayout(new GridLayout(5,1));
         
   
         panel.setBorder(new TitledBorder("회원가입"));
     
         
         id_panel.add(id_lb);
         id_panel.add(id_tf);
         id_panel.add(bt4);
         id_panel.add(id_check_lb);
         
         
         pw_panel.add(password_lb);
         pw_panel.add(password_tf);
         
         
         name_panel.add(name_lb);
         name_panel.add(name_tf);
         
         phone_panel.add(phone_lb);
         phone_panel.add(phone_tf);
         
         email_panel.add(email_lb);
         email_panel.add(email_tf);
         
         
         JPanel button_panel = new JPanel();
         button_panel.setLayout(new FlowLayout());
         button_panel.add(bt1);
         button_panel.add(bt2);
         button_panel.add(bt3);
         
         reg_panel.add(id_panel);
         reg_panel.add(pw_panel);
         reg_panel.add(name_panel);
         reg_panel.add(phone_panel);
         reg_panel.add(email_panel);
         
      
         
         up_panel.add(reg_panel);
         bottom_panel.add(button_panel);
         
         panel.add(up_panel,BorderLayout.CENTER);
         panel.add(bottom_panel,BorderLayout.SOUTH);
         
         this.add(panel,BorderLayout.CENTER);
         this.setVisible(true);
         
         //ActionEventHandler_check actionHandler_check= new ActionEventHandler_check(id_tf);
         ActionEventHandler_reg actionHandler_reg=new ActionEventHandler_reg(id_tf, password_tf, name_tf, phone_tf, email_tf);
         ActionEventHandler_clear actionHandler_clear=new ActionEventHandler_clear(id_tf, password_tf, name_tf, phone_tf, email_tf);
 		 ActionEventHandler_back actionHandler_back=new ActionEventHandler_back();
 		 bt1.addActionListener(actionHandler_reg);
 		 bt2.addActionListener(actionHandler_clear);
 		 bt3.addActionListener(actionHandler_back);
 		 //bt4.addActionListener(actionHandler_check);
 		 
 		bt4.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				DAO userManager = new UserManager();
		 				
				 				if (true==userManager.isExistId(id_tf.getText())) {
				 					id_check_lb.setText("이미 사용하고 있는 'id' 입니다. ");
				 				}
				 				else 
				 					id_check_lb.setText("사용할 수 있는 'id' 입니다. ");
				 				
 				}
 			}
 				
	);
 		 
 	 
     }
 	 		
 }
class Pop_up_Panel extends RegisterPanel {
	
	
	 /**
	 * @uml.property  name="popuppanel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JFrame popuppanel=new JFrame();
	
	 /**
	 * @uml.property  name="text_label0"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JLabel text_label0=new JLabel();
	 /**
	 * @uml.property  name="text_label1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JLabel text_label1=new JLabel();
	 /**
	 * @uml.property  name="text_label2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JLabel text_label2=new JLabel();
	 
	 /**
	 * @uml.property  name="img_label"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JLabel img_label=new JLabel();
	 /**
	 * @uml.property  name="img"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	ImageIcon img;
	 
	 public Pop_up_Panel() {
		 
		 popuppanel.setBounds(400,400,500,500);
		 popuppanel.setLayout(new BorderLayout());
		 
		 JPanel welcome_panel=new JPanel();
		 img = new ImageIcon("image/welcom.jpg");
		 JLabel img_label = new JLabel(img,JLabel.CENTER);
		 JLabel text_label0=new JLabel("환영합니다.",JLabel.CENTER);
		 JLabel text_label1=new JLabel("Project Maker에",JLabel.CENTER);
		 JLabel text_label2=new JLabel("정상적으로 가입되셨습니다.",JLabel.CENTER);
		 
		 text_label0.setFont(new Font("Serif",Font.BOLD,48));
		 text_label0.setForeground(Color.black);
		 text_label1.setFont(new Font("Serif",Font.BOLD,60));
		 text_label1.setForeground(Color.black);
		 text_label2.setFont(new Font("Serif",Font.PLAIN,32));
		 text_label2.setForeground(Color.black);
		 
		 
		 welcome_panel.setLayout(new FlowLayout());
		 welcome_panel.add(img_label);
		 welcome_panel.add(text_label0);
		 welcome_panel.add(text_label1);
		 welcome_panel.add(text_label2);
		 
		 popuppanel.add(welcome_panel,BorderLayout.CENTER);
		 popuppanel.setVisible(true);
		 
		 
	 }
	 
}
class ActionEventHandler_reg implements ActionListener
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
	/**
	 * @uml.property  name="name"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextField name;
	/**
	 * @uml.property  name="phone"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextField phone;
	/**
	 * @uml.property  name="email"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextField email;
	
	public ActionEventHandler_reg (JTextField id, JPasswordField password, JTextField name, JTextField phone,JTextField email ) {
		this.id=id;
		this.password=password;
		this.name=name;
		this.phone=phone;
		this.email=email;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	  System.out.println("ID:"+id.getText());
	  System.out.println("PASSWORD:"+new String(password.getPassword()));
	  System.out.println("NAME:"+name.getText());
	  System.out.println("PHONE:"+phone.getText());
	  System.out.println("email:"+email.getText());
	  
	  
	  	// 2013. 05. 07. Hwang Nara. 
	  	DAO dao = new UserManager();
		
		UserVO user = new UserVO();
		user.setId(id.getText());
		user.setPassword(new String(password.getPassword()));
		user.setName(name.getText());
		user.setPhone(phone.getText());
		user.setEmail(email.getText());
		
		try {
			dao.addMember(user);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	  
		// TODO ?ш린 ?꾨옒?먮떎媛 萸?媛???섏뿀?ㅻ뒗 ?앹뾽醫 ?④쾶 ?댁쨾.
		Pop_up_Panel popup=new Pop_up_Panel();
		// 媛????泥??붾㈃?쇰줈
		MainPanel.getInstance().switchToLoginPanel();
		LoginPanel login_p =new LoginPanel ();
	}
	
}
class ActionEventHandler_clear implements ActionListener
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
	/**
	 * @uml.property  name="name"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextField name;
	/**
	 * @uml.property  name="phone"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextField phone;
	/**
	 * @uml.property  name="email"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextField email;
	
	public ActionEventHandler_clear (JTextField id, JPasswordField password, JTextField name, JTextField phone,JTextField email ) {
		
		this.id=id;
		this.password=password;
		this.name=name;
		this.phone=phone;
		this.email=email;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		  id.setText("");
		  password.setText("");
		  name.setText("");
		  phone.setText("");
		  email.setText("");
	 
	}
	
}
class ActionEventHandler_back implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		MainPanel.getInstance().switchToLoginPanel();
		// TODO Auto-generated method stub
		
		
	}
	
}




