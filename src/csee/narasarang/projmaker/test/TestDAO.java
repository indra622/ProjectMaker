package csee.narasarang.projmaker.test;

import java.sql.SQLException;
import java.util.ArrayList;

import csee.narasarang.projmaker.DAO.DAO;
import csee.narasarang.projmaker.meeting.EnumCategory;
import csee.narasarang.projmaker.meeting.MeetingVO;
import csee.narasarang.projmaker.meeting.MeetingManager;
import csee.narasarang.projmaker.project.ProjectVO;
import csee.narasarang.projmaker.project.ProjectManager;
import csee.narasarang.projmaker.project.ProjectMemberVO;
import csee.narasarang.projmaker.task.EnumProgress;
import csee.narasarang.projmaker.task.TaskVO;
import csee.narasarang.projmaker.task.TaskManager;
import csee.narasarang.projmaker.user.UserVO;
import csee.narasarang.projmaker.user.UserManager;

//////////////////////////////////////////////////////////////////////////////////////////////////
//////																																											//////
//////									나라의 원시적인 테스트 영역임																	//////
//////																																											//////
//////////////////////////////////////////////////////////////////////////////////////////////////

public class TestDAO {
	
	/**
	 * @uml.property  name="userDao"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	DAO userDao = new UserManager();
	/**
	 * @uml.property  name="projectDao"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	DAO projectDao = new ProjectManager();
	/**
	 * @uml.property  name="taskDao"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	DAO taskDao = new TaskManager();
	/**
	 * @uml.property  name="meetingDao"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	DAO meetingDao = new MeetingManager();

	//프로젝트 목록
	public void projectList() throws ClassNotFoundException, SQLException {
		projectDao.projectList();
	}
	
	//프로젝트 생성
	public void createProject() throws ClassNotFoundException, SQLException {
		 	ProjectVO project = new ProjectVO();
			project.setProject_title("second proje");
			project.setMax_num(5);
			//project.setMemo("hiyo, my name is ...");
			project.setStart_date("20130511");
			project.setEnd_date("20130523");
			project.setCaptain("H9");
			projectDao.createProject(project);
	}
	
	//test 프로젝트 참가 여부
	public void alreadyJoinedProject() throws ClassNotFoundException, SQLException {
		ProjectMemberVO pm = new ProjectMemberVO();
		pm.setProject_no(4);
		pm.setJoin_member("narane");
		System.out.println("이미 가입 되있나? : " + projectDao.alreadyJoinedProject(pm));
	}
	
	//test  프로젝트 참가
	public void projectJoin() throws ClassNotFoundException, SQLException {
		ProjectMemberVO pm = new ProjectMemberVO();
		pm.setProject_no(23);
		pm.setJoin_member("narane");
		projectDao.projectJoin(pm);
	}
	
	///////test 업무 할당
	public void assignTask() throws ClassNotFoundException, SQLException {
		TaskVO task = new TaskVO();
		task.setProject_no(7);
		task.setTask_title("까까 맛난거로 사오기!");
		task.setTask_member("sarang");
		task.setTask_progress("To do");
		task.setDue_date("20130524");
		taskDao.assignTask(task);
	}
	
	////// test 업무 목록 보기
	public void taskList() throws ClassNotFoundException, SQLException {
		ArrayList<TaskVO> list = taskDao.taskList(7);
		System.out.println(list.get(0).getTask_title());
		System.out.println(list.get(1).getTask_title());
	}
	
	//// test 내 업무 목록 보기
	public void mySubtaskList() {
		TaskVO task = new TaskVO();
		task.setProject_no(4);
		task.setTask_member("헌규");
		ArrayList<TaskVO> list = taskDao.mySubtaskList(task);
		for (TaskVO taskVO : list) {
			System.out.println(taskVO.getTask_member() + taskVO.getTask_title() + taskVO.getTask_progress());
		}
	}
	
	///// test 업무 진척도 변경
	public void taskModifyProgress() throws ClassNotFoundException, SQLException {
		TaskVO task = new TaskVO();
		task.setProject_no(4);
		task.setTask_no(7);
		task.setTask_progress(EnumProgress.Doing.name());
		taskDao.taskModifyProgress(task);
	}
	
	/////// test 업무 하나 선택해서 보기
	public void taskSelect() throws ClassNotFoundException, SQLException {
		TaskVO task = new TaskVO(); 
		task.setProject_no(7);
		task.setTask_no(5);
		task = taskDao.taskSelect(task);
		System.out.println("task_no : " + task.getTask_no());
		System.out.println("task_title : " + task.getTask_title());
		System.out.println("task_member : " + task.getTask_member());
		System.out.println("task_progress : " + task.getTask_progress());
	}
	
	/// test 업무 삭제
	public void deleteTask() throws ClassNotFoundException, SQLException {
		TaskVO task = new TaskVO();
		task.setProject_no(4);
		task.setTask_no(1);
		taskDao.deleteTask(task);
	}
	
	// test 미팅 올리기
	public void insertMeeting() throws ClassNotFoundException, SQLException {
		MeetingVO meeting = new MeetingVO();
		meeting.setProject_no(7);
		meeting.setMeeting_title("두번째 모임결과요ㅠㅠ ");
		meeting.setCategory(EnumCategory.SCHEDULE.name());
		meeting.setMeeting_date("20130511");
		meeting.setLocation("NTH319");
		meeting.setContent("우리 별로 못 했어요" +
				"기능도 덜되고 UI도 미완성 ㅠㅠ." +
				"어떻게든 되겠쬬!");
		meeting.setWrite_member("HwangNara");
		taskDao.insertMeeting(meeting);
	}	
	
	// test 미팅 리스트 보기
	public void meetingList() throws ClassNotFoundException, SQLException {
		MeetingVO meeting = new MeetingVO();
		meeting.setProject_no(7);
		meeting.setCategory(EnumCategory.RECORD.name());
		ArrayList<MeetingVO>  list =meetingDao.meetingList(meeting);
		for (MeetingVO meeting2 : list) {
			System.out.println("project_no : "+ meeting2.getProject_no() + 
					", meeting_no : " + meeting2.getMeeting_no() +
					", meeing_location" + meeting2.getLocation() +
					", write_member" + meeting2.getWrite_member()
					);
		}
	}
	
	// test 아이디 중복 검사
	public void isExistId() throws ClassNotFoundException, SQLException {
		String id = "fg";
		boolean isExistId;
		isExistId = userDao.isExistId(id);
		System.out.println("이 아이디는 쓰이고 있나요?  답: " + isExistId);
	}
	
	// 로그인 사용자 정보 조회
	public void getUserInfo() throws ClassNotFoundException, SQLException {
		String id = "fllff";
		UserVO user = userDao.getUserInfo(id);
		System.out.println("id : " + user.getId() + 
				", pw : " + user.getPassword() + 
				", name : " + user.getName() + 
				", phone: " + user.getPhone());
	}
}
