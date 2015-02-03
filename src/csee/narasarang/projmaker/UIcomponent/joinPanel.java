package csee.narasarang.projmaker.UIcomponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import csee.narasarang.projmaker.DAO.DAO;
import csee.narasarang.projmaker.project.ProjectManager;
import csee.narasarang.projmaker.project.ProjectMemberVO;

public class joinPanel extends JPanel {
	private int projectNum;
	private JFrame parent;
	public joinPanel(int projectNum){
		this.projectNum = projectNum;
		//this.parent = parent;
		
		JButton join = new JButton("join");
		JButton cancel = new JButton("cancel");
		JLabel label = new JLabel("프로젝트에 참여 하시겠습니까?");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(join);
		buttonPanel.add(cancel);
		
		ActionHandler handler = new ActionHandler();
		join.addActionListener(handler);
		cancel.addActionListener(handler);
		
		
		this.add(label);
		this.add(buttonPanel);

	}
	class ActionHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			switch(e.getActionCommand()){
			case "join":
				userJoin();
				ProjectSwitchPanel.getInstance().switchToDetailPanel(projectNum);
				parent.dispose();
				break;
			case "cancel":
				parent.dispose();
				break;
			}
		}
		private void userJoin(){
			DAO dao = new ProjectManager();
			ProjectMemberVO joinMember = new ProjectMemberVO();
			//MainPanel.getInstance();
			joinMember.setJoin_member(MainPanel.user.getId());
			joinMember.setProject_no(projectNum);
			
			dao.projectJoin(joinMember);
		}
		
	}
	
	
}
