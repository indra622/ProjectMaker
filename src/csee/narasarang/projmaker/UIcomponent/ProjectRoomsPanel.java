package csee.narasarang.projmaker.UIcomponent;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import csee.narasarang.projmaker.DAO.DAO;
import csee.narasarang.projmaker.factory.FrameFactory;
import csee.narasarang.projmaker.iterator.ItemIterator;
import csee.narasarang.projmaker.iterator.ProjectCollection;
import csee.narasarang.projmaker.project.ProjectManager;
import csee.narasarang.projmaker.project.ProjectMemberVO;
import csee.narasarang.projmaker.project.ProjectVO;

/**
 * @author H9
 * @email fllff2@hanmail.net
 * @classname ProjectRoomsPanel.java
 * @package csee.narasarang.projmaker.UIcomponent
 * @date 2013. 5. 4
 * @purpose : show project rooms
 * 
 * @comment : use table
 */
// new version
public class ProjectRoomsPanel extends JPanel {

	/**
	 * @uml.property name="projectList"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	ProjectCollection projectList = new ProjectCollection();
	/**
	 * @uml.property name="dao"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	DAO dao = new ProjectManager();

	public ProjectRoomsPanel() {

		JPanel col0 = new JPanel();
		JPanel col1 = new JPanel();
		JPanel col = new JPanel();

		col0.setLayout(new BoxLayout(col0, BoxLayout.Y_AXIS));
		col1.setLayout(new BoxLayout(col1, BoxLayout.Y_AXIS));
		col.setLayout(new GridLayout(0, 2));

		ItemIterator it = projectList.iterator();

		while (it.hasNext()) {
			JPanel room = this.makeRoom((ProjectVO) it.next());
			col.add(room);
		}

		JPanel roomPanel = new JPanel();
		roomPanel.add(col);

		this.setLayout(new FlowLayout());
		this.add(roomPanel);
		this.setVisible(true);
	}

	private JPanel makeRoom(ProjectVO project) {
		JPanel room = new JPanel();
		room.setLayout(new GridLayout(1, 1));

		JPanel roomInfo = new JPanel();
		roomInfo.setLayout(new BoxLayout(roomInfo, BoxLayout.Y_AXIS));
		// 방정보 표시
		JLabel title = new JLabel("<" + project.getProject_title() + ">");
		JLabel empty1 = new JLabel("  ");
		JLabel startDate = new JLabel("start date : " + project.getStart_date());
		JLabel endDate = new JLabel("end date : " + project.getEnd_date());
		JLabel member = new JLabel("member : "
				+ Integer.toString(project.getMember_num()) + " / "
				+ Integer.toString(project.getMax_num()));
		JLabel captain = new JLabel("PM : " + project.getCaptain());

		JButton join = new JButton("join");
		join.setActionCommand(Integer.toString(project.getProject_no()));

		// join button action listener
		join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int projectNum = Integer.parseInt(e.getActionCommand());
				// 李몄뿬�먯씤吏�寃�궗�댁꽌 �덉갭�ъ옄�대㈃ 李몄뿬�섎씪洹몃윭怨�李몄뿬�먯씠硫��섏뼱媛�
				ProjectMemberVO member = new ProjectMemberVO();
				member.setProject_no(Integer.parseInt(e.getActionCommand()));
				member.setJoin_member(MainPanel.user.getId());

				if (dao.alreadyJoinedProject(member)) {
					System.out.println("enter the project "
							+ e.getActionCommand());
					new ProjectSwitchPanel().switchToDetailPanel(
							projectNum);
				}

				else {
					System.out.println("등록되지 않은 맴버");
					FrameFactory frameFactory = new FrameFactory();
					frameFactory.makeFrame("ProjectJoinFrame", new joinPanel(projectNum));
				}

			}
		});
		TitledBorder border = new TitledBorder(Integer.toString(project
				.getProject_no()));
		room.setBorder(border);
		room.setPreferredSize(new Dimension(280, 200));

		roomInfo.add(title);
		roomInfo.add(empty1);
		roomInfo.add(startDate);
		roomInfo.add(endDate);
		roomInfo.add(member);
		roomInfo.add(captain);
		roomInfo.add(join);

		room.add(roomInfo);
		return room;
	}
}

// H9 Fixed East panel's action handler.
// we can add more functions in here
/*
 * class JoinActionHandler implements ActionListener {
 * 
 * @Override public void actionPerformed(ActionEvent e) { switch
 * (e.getActionCommand()) { case "join":
 * System.out.println(e.getActionCommand());
 * 
 * break; }
 * 
 * } }
 */
/*
 * project join을 위한 button의 정의
 */
/*
 * class JoinButton extends JButton { private int projectNum;
 * 
 * public JoinButton(String label,int projectNum){ super(label); this.projectNum
 * = projectNum; }
 * 
 * public int getProjectNum() { return projectNum; } } }
 */
