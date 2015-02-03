package csee.narasarang.projmaker.meeting;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import csee.narasarang.projmaker.DAO.DAO;
import csee.narasarang.projmaker.DAO.SqlSessionManager;
import csee.narasarang.projmaker.project.ProjectVO;
import csee.narasarang.projmaker.project.ProjectMemberVO;
import csee.narasarang.projmaker.task.TaskVO;
import csee.narasarang.projmaker.user.UserVO;

public class MeetingManager implements DAO{
	private static SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	 static SqlSession session = sqlSessionFactory.openSession();
	 
	// 미팅(스케줄 or 레코드) 올리기
		public void insertMeeting(MeetingVO meeting) {
			session.insert("MeetingMapper.insertMeeting", meeting);
			session.commit();
		}

		// 미팅 목록 보기
		@SuppressWarnings("unchecked")
		public ArrayList<MeetingVO> meetingList(MeetingVO meeting) {
			List<MeetingVO> list =  session.selectList("MeetingMapper.meetingList", meeting);
			return (ArrayList<MeetingVO>) list;
		}

		@Override
		public boolean login(UserVO user) throws SQLException,
				ClassNotFoundException {
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
