package csee.narasarang.projmaker.UIcomponent;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import csee.narasarang.projmaker.UIcomponent.table.SubTaskTable;
import csee.narasarang.projmaker.factory.FrameFactory;
import csee.narasarang.projmaker.task.MyTask;

public class SubTaskPanel extends JPanel{
	private static SubTaskPanel subTaskPanel = new SubTaskPanel();
	public static SubTaskPanel getInstance(){ return subTaskPanel;}
	
	/**
	 * @uml.property  name="subTaskTable"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	SubTaskTable subTaskTable = new SubTaskTable();
	int projectNum;
	
	public SubTaskPanel(int projectNum){
		this.projectNum = projectNum;
		subTaskTable.setProjectNum(projectNum);
		
		this.setLayout(new BorderLayout(10,10));
		this.add(new SubTaskLeftSidePanel(),BorderLayout.WEST);
		this.add(subTaskTable.makeTable() ,BorderLayout.EAST);
		this.setVisible(true);
	}
	public SubTaskPanel() {
		// TODO Auto-generated constructor stub
	}
	class SubTaskLeftSidePanel extends JPanel{
		
		
		private JButton mySubTask = new JButton("MySubTask");
		private JButton createSubTask = new JButton("CreateSubTask");
		private JButton deleteSubTask = new JButton("DeleteSubTask");
		private JButton Schedule = new JButton("Schedule");
		
		public SubTaskLeftSidePanel(){
			this.setLayout(new GridLayout(4,1));


			ActionListener actionHandler = new FEActionHandler(); 
			createSubTask.addActionListener(actionHandler);
			mySubTask.addActionListener(actionHandler);
			
			this.add(mySubTask);
			this.add(createSubTask);
			this.add(deleteSubTask);
			this.add(Schedule);
			this.setVisible(true);

		}
		class FEActionHandler implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameFactory frameFactory = new FrameFactory();
				switch (e.getActionCommand()) {
				case "CreateSubTask":
					frameFactory.makeFrame("CreateTaskFrame", new CreateTaskPanel(projectNum));
					break;
				case "MySubTask":
					subTaskPanel.removeAll();
					subTaskPanel.add(new SubTaskPanel2());
					subTaskPanel.updateUI();
					System.out.println("dd");
					
					break;
				case "DeleteSubTask":
					break;

				}

			}
		}
	}
}
