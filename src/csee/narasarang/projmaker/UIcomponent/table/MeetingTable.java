package csee.narasarang.projmaker.UIcomponent.table;

import java.util.ArrayList;

import csee.narasarang.projmaker.DAO.DAO;
import csee.narasarang.projmaker.meeting.MeetingManager;
import csee.narasarang.projmaker.meeting.MeetingVO;
import csee.narasarang.projmaker.task.TaskVO;
import csee.narasarang.projmaker.test.TestVariables;

public class MeetingTable extends Table{
	
	/**
	 * @uml.property  name="colNames" multiplicity="(0 -1)" dimension="1"
	 */
	String[] colNames = {"Title", "Date", "Location"};
	/**
	 * @uml.property  name="projectNum"
	 */
	int projectNum;
	/**
	 * @uml.property  name="dao"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	DAO dao = new MeetingManager();
	
	public MeetingTable(){
	}

	private MeetingTable(String[] colNames, String[][] datas, int width, int height){
		super(colNames, datas, width, height);
	}
	
	private String[][] meetingListForTable(ArrayList<MeetingVO> meetingList){
		String[][] datas = null;
		System.out.println("meeting사이즈:"+ meetingList.size());
		
		//2차원동적할당
		datas = new String[meetingList.size()][];
		for(int i = 0; i < meetingList.size() ; i++)
		datas[i] = new String[3];
		
		for(int i = 0; i < meetingList.size(); i++){

			datas[i][0] = meetingList.get(i).getMeeting_title();
			datas[i][1] = meetingList.get(i).getMeeting_date();
			datas[i][2] = meetingList.get(i).getLocation();

			System.out.println(datas[i][0] + datas[i][1] + datas[i][2]);
		}
		return datas;
	}
	
	public Table makeTable(){
		MeetingVO meeting = new MeetingVO();
		meeting.setProject_no(projectNum);
		meeting.setCategory("%");
		return new MeetingTable(colNames, meetingListForTable(dao.meetingList(meeting)), 450,150);
	}
	/**
	 * @param projectNum
	 * @uml.property  name="projectNum"
	 */
	public void setProjectNum(int projectNum){
		this.projectNum = projectNum;
	}
}
