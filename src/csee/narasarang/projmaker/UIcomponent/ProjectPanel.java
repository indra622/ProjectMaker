package csee.narasarang.projmaker.UIcomponent;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import csee.narasarang.projmaker.factory.FrameFactory;

/**
 * @author Hosung
 * @email indra622@gmail.com
 * @classname PMProjectPanel.java
 * @package csee.narasarang.projmaker.UIcomponent
 * @date 2013. 5. 4.오후 2:30:07
 * @purpose : Login이후 들어오게 되는 메인 프로젝트 패널
 *
 * @comment : 
 * 		@hosung WEST 부분에 방 리스트 나오고 디테일 설정 나오게 했구
 *                   EAST 부분에 메뉴 화면 나오게 했듕 
 * 			
 *
 */
public class ProjectPanel extends JPanel{
	private static ProjectPanel projectPanel = new ProjectPanel();
	public static ProjectPanel getInstance(){ return projectPanel;}
	
	
	public ProjectPanel(){
		this.setLayout(new BorderLayout(1,1));
		this.add(new ProjectSwitchPanel(), BorderLayout.WEST);
		this.add(new FixedEastPanel(), BorderLayout.EAST);
		this.setVisible(true);
		
	}
	
	private void switchTo(JPanel panel){
		this.removeAll();
		this.add(panel);
		this.updateUI();
	}
	
	class FixedEastPanel extends JPanel {

		JPanel panel_userFixedTop = new JPanel();
		JPanel panel_userFixedBottom = new JPanel();

		public FixedEastPanel() {
			
//			panel_userFixedBottom.setLayout(new GridLayout(2, 2));
//			panel_userFixedBottom.setBackground(Color.darkGray);
			panel_userFixedTop.setLayout(new GridLayout(0,1));
			JLabel userInfo = new JLabel("<user info>");
			JLabel userID = new JLabel("ID : " + MainPanel.user.getId());
			JLabel userName = new JLabel("name : " + MainPanel.user.getName());
			JLabel userPhone = new JLabel("Phone : " + MainPanel.user.getPhone());
			JLabel userEmail = new JLabel("Email : " + MainPanel.user.getEmail());
			
			panel_userFixedTop.add(userInfo);
			panel_userFixedTop.add(userID);
			panel_userFixedTop.add(userName);
			panel_userFixedTop.add(userPhone);
			panel_userFixedTop.add(userEmail);
			
			
			panel_userFixedBottom.setLayout(new GridLayout(2, 2, 2, 2));
			JButton button01 = new JButton("create");
			JButton button02 = new JButton("home");
			JButton button03 = new JButton("setting");
			JButton button04 = new JButton("logout");
			
			ActionListener actionHandler = new FEActionHandler(); 
			button01.addActionListener(actionHandler);
			button02.addActionListener(actionHandler);
			button03.addActionListener(actionHandler);
			button04.addActionListener(actionHandler);
			panel_userFixedBottom.add(button01);
			panel_userFixedBottom.add(button02);
			panel_userFixedBottom.add(button03);
			panel_userFixedBottom.add(button04);

			// user top. middle. bottom. ����
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.add(panel_userFixedTop);
			this.add(panel_userFixedBottom);
		}
	}
	/*
	 * H9
	 * Fixed East panel's action handler.
	 * 
	 * we can add more functions in here
	 */
	class FEActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			FrameFactory frameFactory = new FrameFactory();
			switch (e.getActionCommand()) {
			case "create":
				frameFactory.makeFrame("CreateRoomFrame",new CreateRoomPanel());
				break;
			case "home":
				MainPanel.getInstance().switchToProjectPanel();
				break;
			case "setting":
				frameFactory.makeFrame("SettingFrame",new SettingPanel());
				break;
			case "logout":
				MainPanel.getInstance().switchToLoginPanel();
				break;

			}

		}

	}
}
