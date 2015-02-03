package csee.narasarang.projmaker.project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import csee.narasarang.projmaker.DAO.DAO;
import csee.narasarang.projmaker.DAO.SqlSessionManager;
import csee.narasarang.projmaker.meeting.MeetingVO;
import csee.narasarang.projmaker.task.TaskVO;
import csee.narasarang.projmaker.user.UserVO;

public class ProjectManager implements DAO{
	private static SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	static SqlSession session = sqlSessionFactory.openSession();
	
	// 프로젝트 <전체> 목록보기
	@SuppressWarnings("unchecked")
	public ArrayList<ProjectVO> projectList() throws SQLException, ClassNotFoundException {
		List<ProjectVO> list =  session.selectList("ProjectMapper.projectList");
		System.out.println(list.size());
		return (ArrayList<ProjectVO>) list;
	}
	
	// 프로젝트 <참여> 목록 보기
	@SuppressWarnings("unchecked")
	public ArrayList<ProjectVO> projectJoinList() throws SQLException, ClassNotFoundException {
		List<ProjectVO> list =  session.selectList("ProjectMapper.projectJoinList");
		return (ArrayList<ProjectVO>) list;
	}
	
	// 프로젝트 <미참여> 목록 보기
	@SuppressWarnings("unchecked")
	public ArrayList<ProjectVO> projectNotJoinList() throws SQLException, ClassNotFoundException {
		List<ProjectVO> list =  session.selectList("ProjectMapper.projectNotJoinList");
		return (ArrayList<ProjectVO>) list;
	}
	
	// 프로젝트 생성
	public void createProject(ProjectVO project) {
		session.insert("ProjectMapper.createProject", project);
		session.insert("ProjectMapper.createProjectMember", project);
		session.commit();
	}
	
	// 프로젝트 참여 여부
	public boolean alreadyJoinedProject(ProjectMemberVO projectMember) {
		boolean alreadyJoin = (int) session.selectOne("ProjectMapper.alreadyJoinedProject.", projectMember) != 0;
		return alreadyJoin;
	}
	
	// 프로젝트 참여
	public void projectJoin(ProjectMemberVO pm) {
		session.insert("ProjectMapper.projectJoin", pm);
		session.insert("ProjectMapper.projectMemberUpdate", pm);
		session.commit();		
	}

	@Override
	public boolean login(UserVO user) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addMember(UserVO user) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExistId(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserVO getUserInfo(String id) {
		// TODO Auto-generated method stub
		return null;
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
	public ArrayList<TaskVO> mySubtaskList(TaskVO taskInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTask(TaskVO taskInfo) {
		// TODO Auto-generated method stub
	}




}
