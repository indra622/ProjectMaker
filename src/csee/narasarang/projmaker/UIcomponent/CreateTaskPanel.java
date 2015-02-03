package csee.narasarang.projmaker.UIcomponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import csee.narasarang.projmaker.DAO.DAO;
import csee.narasarang.projmaker.task.EnumProgress;
import csee.narasarang.projmaker.task.TaskManager;
import csee.narasarang.projmaker.task.TaskVO;

public class CreateTaskPanel extends JPanel {
	//private static CreateTaskPanel createTaskPanel = new CreateTaskPanel();
	//public static CreateTaskPanel getInstance(){ return createTaskPanel;}
	private int projectNum;
	JTextField nameArea = new JTextField(20);
	JTextField chargeArea = new JTextField(20);
	DatePicker startDatePicker = new DatePicker();
	DatePicker endDatePicker = new DatePicker();
	
	public CreateTaskPanel(int projectNum) {
		this. projectNum = projectNum;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setAlignmentX(LEFT_ALIGNMENT);

		JLabel title = new JLabel("Create SubTask");
		JLabel name = new JLabel("SubTask");
		JLabel charge = new JLabel("charge");
		
		// name
		JPanel namePanel = new JPanel();
		namePanel.add(name);
		namePanel.add(nameArea);

		// num
		JPanel numOfMemberPanel = new JPanel();
		numOfMemberPanel.add(charge);
		numOfMemberPanel.add(chargeArea);

		// start date
		JPanel startDatePanel = new JPanel();
		startDatePanel.add(startDatePicker);
		
		// due date
		JPanel dueDatePanel = new JPanel();
		dueDatePanel.add(endDatePicker);
		// control buttons
		JPanel btnPanel = new JPanel();

		JButton cancelBtn = new JButton("Cancel");
		JButton createBtn = new JButton("Create");

		ActionListener actionHandler = new FEActionHandler();
		cancelBtn.addActionListener(actionHandler);
		createBtn.addActionListener(actionHandler);
		btnPanel.add(cancelBtn);
		btnPanel.add(createBtn);
		
		

		this.add(title);
		this.add(namePanel);
		this.add(numOfMemberPanel);
		this.add(startDatePanel);
		this.add(dueDatePanel);
		this.add(btnPanel);
	}
	
	class FEActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Cancel":
				break;
			case "Create":
				TaskVO task = new TaskVO();
				task.setProject_no(projectNum);
				task.setTask_title(nameArea.getText());
				task.setTask_member(chargeArea.getText());
				task.setTask_progress(EnumProgress.Todo.name());
				task.setDue_date(endDatePicker.getDate());
				
				DAO dao = new TaskManager();
				dao.assignTask(task);
				//MainPanel.getInstance().removeAll();
				//MainPanel.getInstance().updateUI();
				//ProjectSwitchPanel.getInstance().switchToDetailPanel(projectNum);
				ProjectSwitchPanel.getInstance().switchToListPanel();
				break;

			}

		}
	}

}
