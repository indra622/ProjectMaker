package csee.narasarang.projmaker.UIcomponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import csee.narasarang.projmaker.DAO.DAO;
import csee.narasarang.projmaker.UIcomponent.frame.MainFrame;
import csee.narasarang.projmaker.project.ProjectVO;
import csee.narasarang.projmaker.project.ProjectManager;

/**
 * @author H9
 * 
 *         panel for create room
 * 
 *         no button listener yet. no correct date data yet. no text restriction
 *         yet. : in JtextField numArea
 */
public class CreateRoomPanel extends JPanel {

	/**
	 * @uml.property  name="nameArea"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextField nameArea = new JTextField(20);
	/**
	 * @uml.property  name="numArea"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextField numArea = new JTextField(2);

	/**
	 * @uml.property  name="startDatePicker"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private DatePicker startDatePicker = new DatePicker();
	/**
	 * @uml.property  name="dueDatePicker"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private DatePicker dueDatePicker = new DatePicker();;

	public CreateRoomPanel() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setAlignmentX(LEFT_ALIGNMENT);

		JLabel title = new JLabel("Create Project");
		JLabel name = new JLabel("project name");
		JLabel numOfMember = new JLabel("members");

		// name
		JPanel namePanel = new JPanel();
		namePanel.add(name);
		namePanel.add(nameArea);

		// num
		JPanel numOfMemberPanel = new JPanel();
		numOfMemberPanel.add(numOfMember);
		numOfMemberPanel.add(numArea);

		// start date
		JPanel startDatePanel = new JPanel();
		JLabel startDate = new JLabel("start date : ");
		startDatePanel.add(startDate);
		startDatePanel.add(startDatePicker);
		// due date
		JPanel dueDatePanel = new JPanel();
		JLabel dueDate = new JLabel("due date : ");
		dueDatePanel.add(dueDate);
		dueDatePanel.add(dueDatePicker);

		// control buttons
		JPanel btnPanel = new JPanel();

		JButton cancelBtn = new JButton("Cancel");
		JButton createBtn = new JButton("Create");

		btnPanel.add(cancelBtn);
		btnPanel.add(createBtn);

		ActionHandler handler = new ActionHandler();
		createBtn.addActionListener(handler);
		cancelBtn.addActionListener(handler);

		this.add(title);
		this.add(namePanel);
		this.add(numOfMemberPanel);
		this.add(startDatePanel);
		this.add(dueDatePanel);
		this.add(btnPanel);

	}

	// H9 Fixed East panel's action handler.
	// we can add more functions in here
	class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Cancel":
				//this.dispose();
				break;
			case "Create":
				DAO dao = new ProjectManager();
				ProjectVO project = getProjectInfo();
				System.out.println(project.getProject_title()
						+ project.getStart_date() + project.getEnd_date());
				dao.createProject(project);
				ProjectSwitchPanel.getInstance().switchToListPanel();
				break;
			}

		}
	}

	private ProjectVO getProjectInfo() {
		ProjectVO project = new ProjectVO();

		project.setProject_title(nameArea.getText());
		project.setMax_num(Integer.parseInt(numArea.getText()));
		project.setStart_date(startDatePicker.getDate());
		project.setEnd_date(dueDatePicker.getDate());
		project.setCaptain(MainPanel.user.getId());

		return project;
	}
}
