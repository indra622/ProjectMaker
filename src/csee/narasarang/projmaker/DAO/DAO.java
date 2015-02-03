package csee.narasarang.projmaker.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import csee.narasarang.projmaker.meeting.MeetingVO;
import csee.narasarang.projmaker.project.ProjectVO;
import csee.narasarang.projmaker.project.ProjectMemberVO;
import csee.narasarang.projmaker.task.TaskVO;
import csee.narasarang.projmaker.user.*;


/**
 * @author Hwang Nara
 * @email narahwang7@gmail.com
 * @classname PMRegisterDAO.java
 * @package csee.narasarang.projmaker.DAO
 * @date 2013. 5. 7. 오후 11:26:47
 * @purpose : Database 에 접속해서 insert, select, delete, update 등을 수행한다.
 *
 * @comment : DAO 관련
 * 
 */

public interface DAO {
	
	/* User */
	// 로그인
	public abstract boolean login(UserVO user) throws SQLException, ClassNotFoundException;
	// 새 맴버 등록
	public abstract void addMember(UserVO user) throws ClassNotFoundException, SQLException;	
	// 아이디 중복 체크. 중복이면 true 반환
	public abstract boolean isExistId(String id);
	// 로그인 사용자 정보 조회
	public abstract UserVO getUserInfo(String id);
	
	
	/* Project */
	// 프로젝트 <전체> 목록보기
	public abstract ArrayList<ProjectVO> projectList() throws SQLException, ClassNotFoundException;
	// 프로젝트 <참여> 목록 보기
	public abstract ArrayList<ProjectVO> projectJoinList() throws SQLException, ClassNotFoundException;
	// 프로젝트 <미참여> 목록 보기
	public abstract ArrayList<ProjectVO> projectNotJoinList() throws SQLException, ClassNotFoundException;
	// 프로젝트 생성
	public abstract void createProject(ProjectVO project);
	// 프로젝트 참여 여부
	public abstract boolean alreadyJoinedProject(ProjectMemberVO projectMember);
	// 프로젝트 참여
	public abstract void projectJoin(ProjectMemberVO pm);


	/* Task */
	// 업무 할당
	public abstract void assignTask(TaskVO task);
	// 업무 목록 보기
	public abstract ArrayList<TaskVO> taskList(int project_no);
	// 업무 하나 선택 보기
	public abstract TaskVO taskSelect(TaskVO taskInfo);
	// 업무 진행도 변경
	public abstract void taskModifyProgress(TaskVO taskInfo);
	// 나의 업무 목록 보기
	public abstract ArrayList<TaskVO> mySubtaskList(TaskVO taskInfo);
	// 업무 삭제
	public abstract void deleteTask(TaskVO taskInfo);
	
	/* Meeting */
	// 미팅(스케줄 or 레코드) 올리기
	public abstract void insertMeeting(MeetingVO meeting);
	// 미팅 목록 보기
	public abstract ArrayList<MeetingVO> meetingList(MeetingVO meeting);

}
