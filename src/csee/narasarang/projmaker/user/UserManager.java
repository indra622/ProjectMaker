package csee.narasarang.projmaker.user;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import csee.narasarang.projmaker.DAO.DAO;
import csee.narasarang.projmaker.DAO.SqlSessionManager;
import csee.narasarang.projmaker.meeting.MeetingVO;
import csee.narasarang.projmaker.project.ProjectVO;
import csee.narasarang.projmaker.project.ProjectMemberVO;
import csee.narasarang.projmaker.task.TaskVO;

public class UserManager implements DAO{
	private static SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	 static SqlSession session = sqlSessionFactory.openSession();
	 
	// 로그인
	public boolean login(UserVO user) throws SQLException, ClassNotFoundException {
		boolean  loginOk = (int) session.selectOne("UserMapper.login", user) !=  0;
		return loginOk;
	}
	
	// 새 맴버 등록
	public  void addMember(UserVO user) throws ClassNotFoundException, SQLException {
		session.insert("UserMapper.addMember", user);
		session.commit();
	}
		
	// 아이디 중복 체크. 중복이면 true 반환
	public boolean isExistId(String id) {
		boolean isExist = (int) session.selectOne("UserMapper.isExistId", id) != 0;
		return isExist;
	}
	
	// 로그인 사용자 정보 조회
	public UserVO getUserInfo(String id) {
		UserVO user = (UserVO)session.selectOne("UserMapper.getUserInfo", id);
		return user;
	}

	@Override
	public ArrayList<ProjectVO> projectList() throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProjectVO> projectJoinList() throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProjectVO> projectNotJoinList() throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createProject(ProjectVO project) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void projectJoin(ProjectMemberVO pm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignTask(TaskVO task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<TaskVO> taskList(int project_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskVO taskSelect(TaskVO taskInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void taskModifyProgress(TaskVO taskInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertMeeting(MeetingVO meeting) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<MeetingVO> meetingList(MeetingVO meeting) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alreadyJoinedProject(ProjectMemberVO projectMember) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<TaskVO> mySubtaskList(TaskVO taskInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTask(TaskVO taskInfo) {
		// TODO Auto-generated method stub
	}
}
