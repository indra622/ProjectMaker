package csee.narasarang.projmaker.UIcomponent;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import csee.narasarang.projmaker.DAO.DAO;
import csee.narasarang.projmaker.file.Attachment;
import csee.narasarang.projmaker.file.Save;
import csee.narasarang.projmaker.meeting.EnumCategory;
import csee.narasarang.projmaker.meeting.MeetingManager;
import csee.narasarang.projmaker.meeting.MeetingVO;
import csee.narasarang.projmaker.task.EnumProgress;

/*@@@@@@@@@@@@@@@@@@@@@@@@@
 *  @ author H9
 *  여기있는부분을 date설정 코드를 만드는 class로 만들어서
 *  여기저기서
 *  쓸수있게
 *  하는것도나쁘지안을거같아요
 *  actionListener달아서 30일 까지제한 31일까지 제한 하는거 나중에해볼께요
 *  
 */

public class CreateMeetingPanel extends JPanel {
	/**
	 * @uml.property  name="actionHandler"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="this$0:csee.narasarang.projmaker.UIcomponent.CreateMeetingPanel$ActionHandler"
	 */
	private ActionHandler actionHandler = new ActionHandler();
	private ActionHandler_radio actionHandler_radio = new ActionHandler_radio();
	
	public JLabel openpath = new JLabel();
	public String category;
	public String year;
	public String month;
	public String day;
	
	
	private int projectNum;
	
	JTextField titleField = new JTextField(25);
	JTextField locationField = new JTextField(10);
	JTextField numOfMemField = new JTextField(10);
	JTextArea contentArea = new JTextArea();
	
	DatePicker startDatePicker = new DatePicker();
	DatePicker endDatePicker = new DatePicker();
	
	public CreateMeetingPanel(int projectNum) {
		
		this.projectNum = projectNum;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setAlignmentX(LEFT_ALIGNMENT);

		JLabel mainLable = new JLabel("Meeting");

		// select purpose
		Border rbtnBorder = BorderFactory.createEtchedBorder();
		rbtnBorder = BorderFactory.createTitledBorder(rbtnBorder, "purpose");

		JPanel purposePanel = new JPanel();
		purposePanel.setLayout(new FlowLayout());
		purposePanel.setBorder(rbtnBorder);

		JRadioButton rbtnSchedule = new JRadioButton(EnumCategory.SCHEDULE.name());
		rbtnSchedule.addActionListener(actionHandler_radio);
		
		JRadioButton rbtnRecord = new JRadioButton(EnumCategory.RECORD.name());
		rbtnRecord.addActionListener(actionHandler_radio);
		
		ButtonGroup purposeGroup = new ButtonGroup();
		purposeGroup.add(rbtnSchedule);
		purposeGroup.add(rbtnRecord);

		// purposePanel.add(purposeLabel);
		purposePanel.add(rbtnSchedule);
		purposePanel.add(rbtnRecord);

		// set title
		JPanel titlePanel = new JPanel();
		JLabel titleLabel = new JLabel("Title");
		

		titlePanel.add(titleLabel);
		titlePanel.add(titleField);

		// set date
		JPanel datePanel = new JPanel();
		JLabel dateLabel = new JLabel("Date ");

		JLabel dateLabelYaer = new JLabel("yaer");
		JLabel dateLabelMonth = new JLabel("month");
		JLabel dateLabelday = new JLabel("day");

		final JComboBox comboBoxYear = new JComboBox();
		comboBoxYear.setModel(new DefaultComboBoxModel(new String[] { "2013",
				"2014", "2015", "2016" }));
		comboBoxYear.setSelectedIndex(0);
		final JComboBox comboBoxMonth = new JComboBox();
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] { "1",
				"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		comboBoxMonth.setSelectedIndex(0);
		final JComboBox comboBoxDay = new JComboBox();
		comboBoxDay.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", 
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
				"22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		comboBoxDay.setSelectedIndex(0);

		datePanel.add(dateLabel);
		datePanel.add(dateLabelYaer);
		datePanel.add(comboBoxYear);
		datePanel.add(dateLabelMonth);
		datePanel.add(comboBoxMonth);
		datePanel.add(dateLabelday);
		datePanel.add(comboBoxDay);

		// set location
		JPanel locationPanel = new JPanel();
		JLabel locationLabel = new JLabel("Location");

		locationPanel.add(locationLabel);
		locationPanel.add(locationField);

		// set number of member
		JPanel numOfMemPanel = new JPanel();
		JLabel numOfMemLabel = new JLabel("number of members");

		

		numOfMemPanel.add(numOfMemLabel);
		numOfMemPanel.add(numOfMemField);
		
		//file_attachment
		JPanel filePanel = new JPanel();
		
		JButton open = new JButton("attachment");
		open.addActionListener(actionHandler);
		
		filePanel.add(open);
		filePanel.add(openpath);
		

		// record content
		

		// OK button
		JButton btn1 = new JButton("accept");
		btn1.addActionListener(actionHandler);

		// group to meeting info
		Border infoBorder = BorderFactory.createEtchedBorder();
		infoBorder = BorderFactory.createTitledBorder(infoBorder,
				"Meeting Information");

		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(0, 1));
		infoPanel.setBorder(infoBorder);

		infoPanel.add(titlePanel);
		infoPanel.add(datePanel);
		infoPanel.add(locationPanel);
		infoPanel.add(numOfMemPanel);
		infoPanel.add(filePanel);

		// group to content
		/*
		 * Border contentBorder = BorderFactory.createEtchedBorder();
		 * contentBorder = BorderFactory.createTitledBorder(contentBorder,
		 * "content");
		 * 
		 * JPanel contentPanel = new JPanel(); contentPanel.setLayout(new
		 * GridLayout(0, 1)); contentPanel.setBorder(contentBorder);
		 * 
		 * contentPanel.add(contentArea);
		 */
		comboBoxYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (e.getSource() == comboBoxYear) {
					JComboBox cb = (JComboBox) e.getSource(); 
					switch (cb.getSelectedIndex()) {
					case 0:
						year = "2013";
						break;
					case 1:
						year = "2014";
						break;
					case 2:
						year = "2015";
						break;
					case 3:
						year = "2016";
					}
				}
			}
		});
		comboBoxMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (e.getSource() == comboBoxMonth) {
					JComboBox cb = (JComboBox) e.getSource(); 
					switch (cb.getSelectedIndex()) {
					case 0:
						month = "01";
						break;
					case 1:
						month = "02";
						break;
					case 2:
						month = "03";
						break;
					case 3:
						month = "04";
					case 4:
						month = "05";
						break;
					case 5:
						month = "06";
						break;
					case 6:
						month = "07";
						break;
					case 7:
						month = "08";
					case 8:
						month = "09";
						break;
					case 9:
						month = "10";
						break;
					case 10:
						month = "11";
						break;
					case 11:
						month = "12";
					
					}
				}
			}
		});
		comboBoxDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (e.getSource() == comboBoxDay) {
					JComboBox cb = (JComboBox) e.getSource(); 
					switch (cb.getSelectedIndex()) {
					case 0:
						day = "01";
						break;
					case 1:
						day = "02";
						break;
					case 2:
						day = "03";
					case 3:
						day = "04";
						break;
					case 4:
						day = "05";
						break;
					case 5:
						day = "06";
					case 6:
						day = "07";
						break;
					case 7:
						day = "08";
						break;
					case 8:
						day = "09";
					case 9:
						day = "10";
						break;
					case 10:
						day = "11";
						break;
					case 11:
						day = "12";
					case 12:
						day = "13";
						break;
					case 13:
						day = "14";
						break;
					case 14:
						day = "15";
					case 15:
						day = "16";
						break;
					case 16:
						day = "17";
						break;
					case 17:
						day = "18";
					case 18:
						day = "19";
						break;
					case 19:
						day = "20";
						break;
					case 20:
						day = "21";
					case 21:
						day = "22";
						break;
					case 22:
						day = "23";
					case 23:
						day = "24";
						break;
					case 24:
						day = "25";
						break;
					case 25:
						day = "26";
					case 26:
						day = "27";
						break;
					case 27:
						day = "28";
						break;
					case 28:
						day = "29";
					case 29:
						day = "30";
						break;
					case 30:
						day = "31";
						break;
					}
				}
			}
		});


		// add to panel
		this.add(mainLable);
		this.add(purposePanel);
		this.add(infoPanel);
		this.add(contentArea);
		this.add(btn1);

	}

	// H9 CreateMeetingPanel panel's action handler.
	//
	// we can add more functions in here
	
	class ActionHandler_radio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			category = e.getActionCommand();
			
		}
		
	}
	class ActionHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "accept":
				
				MeetingVO meeting = new MeetingVO();
				meeting.setProject_no(projectNum);
				meeting.setMeeting_title(titleField.getText());
				meeting.setCategory(category);
				
				
				meeting.setMeeting_date(year+month+day);
				meeting.setLocation(locationField.getText());
				meeting.setContent(contentArea.getText());
				meeting.setWrite_member(MainPanel.user.getId());
			
				System.out.println("proj Num: " + projectNum);
				System.out.println("title : " + titleField.getText());
				System.out.println("cat : " +category);
				System.out.println("year: " + year);
				System.out.println("month: " + month);
				System.out.println("day: " + day);
				System.out.println("loc: " + locationField.getText());
				System.out.println("cont : " +contentArea.getText());
				System.out.println("userId : " +MainPanel.user.getId());
				
				DAO dao = new MeetingManager();
				
				dao.insertMeeting(meeting);
				
				//MainPanel.getInstance().removeAll();
				//MainPanel.getInstance().updateUI();
				//ProjectSwitchPanel.getInstance().switchToDetailPanel(projectNum);
				ProjectSwitchPanel.getInstance().switchToListPanel();
				
				Save save = new Save();
				break;
			case "attachment":
				Attachment tf = new Attachment();
				openpath.setText(tf.openpath());
				break;
			}
		}
		
	}
}
