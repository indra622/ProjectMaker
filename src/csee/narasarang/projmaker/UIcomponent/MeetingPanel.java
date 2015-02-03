package csee.narasarang.projmaker.UIcomponent;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import csee.narasarang.projmaker.UIcomponent.table.MeetingTable;
import csee.narasarang.projmaker.factory.FrameFactory;


//public SubTaskTable(String[] colNames, String[][] datas, int width, int height){
	
public class MeetingPanel extends JPanel{
	//private static MeetingPanel meetingPanel = new MeetingPanel();
	//public static MeetingPanel getInstance(){ return meetingPanel;}
	
	/**
	 * @uml.property  name="projectNum"
	 */
	private int projectNum;
	/**
	 * @uml.property  name="meetingTable"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	MeetingTable meetingTable = new MeetingTable();
	
	public MeetingPanel(int projectNum){
		this.projectNum = projectNum;
		meetingTable.setProjectNum(projectNum);
		
		this.setLayout(new BorderLayout(1,1));
		this.add(new MeetingLeftSidePanel(),BorderLayout.WEST);
		this.add(meetingTable.makeTable(),BorderLayout.EAST);
		this.setVisible(true);
	}
	
	 /**
	 * @author  Hosung
	 * @email  indra622@gmail.com
	 * @classname  MeetingPanel.java
	 * @package  csee.narasarang.projmaker.UIcomponent
	 * @date  2013. 6. 1.오후 6:59:52
	 * @purpose  : 
	 * @comment  : 
	 */
	class MeetingLeftSidePanel extends JPanel {
			private JButton createMeeting = new JButton("CreateMeeting");
			private JButton deleteMeeting = new JButton("DeleteMeeting");
			/**
			 * @uml.property  name="actionHandler"
			 * @uml.associationEnd  
			 */
			private ActionHandler actionHandler = new ActionHandler();
			public MeetingLeftSidePanel() {
				this.setLayout(new GridLayout(4, 1));
				
				createMeeting.addActionListener(actionHandler);
				
				this.add(createMeeting);
				this.add(deleteMeeting);
				this.setVisible(true);

			}
			// H9 MeetingLeftSide panel's action handler.
			//
			// we can add more functions in here

			class ActionHandler implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent e) {
					FrameFactory frameFactory = new FrameFactory();
					switch (e.getActionCommand()) {
					case "CreateMeeting":
						frameFactory.makeFrame("CreateMeetingFrame", new CreateMeetingPanel(projectNum));
						break;
					case "Back":
						
					}

				}
			}
		}

}
