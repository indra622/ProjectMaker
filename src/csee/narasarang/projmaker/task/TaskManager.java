package csee.narasarang.projmaker.task;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import csee.narasarang.projmaker.DAO.DAO;
import csee.narasarang.projmaker.DAO.SqlSessionManager;
import csee.narasarang.projmaker.meeting.MeetingVO;
import csee.narasarang.projmaker.project.ProjectVO;
import csee.narasarang.projmaker.project.ProjectMemberVO;
import csee.narasarang.projmaker.user.UserVO;

public class TaskManager implements DAO {
	private static SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	static SqlSession session = sqlSessionFactory.openSession();
		
	//업무 할당
		public void assignTask(TaskVO task) {
			session.insert("TaskMapper.assignTask", task);
			session.commit();		
		}

		// 업무 목록 보기
		@SuppressWarnings("unchecked")
		public  ArrayList<TaskVO> taskList(int project_no) {
			List<TaskVO> list =  session.selectList("TaskMapper.taskList", project_no);
			return (ArrayList<TaskVO>) list;
		}
		
		// 업무 하나 선택 보기
		public TaskVO taskSelect(TaskVO taskInfo) {
			TaskVO task = (TaskVO) session.selectOne("TaskMapper.taskSelect", taskInfo);
			return task;
		}
		
		// 업무 진행도 변경
		public void taskModifyProgress(TaskVO taskInfo) {
			session.update("TaskMapper.taskModifyProgress", taskInfo);
			session.commit();
		}
		
		// 나의 업무 목록 보기
		@SuppressWarnings("unchecked")
		public ArrayList<TaskVO> mySubtaskList(TaskVO taskInfo) {
			List<TaskVO> list =  session.selectList("TaskMapper.mySubtaskList", taskInfo);
			return (ArrayList<TaskVO>) list;
		}	
		
		// 업무 삭제
		public void deleteTask(TaskVO taskInfo) {
			session.delete("TaskMapper.deleteTask", taskInfo);
			session.commit();
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
			// TODO Auto-generated method stub
			return false;
		}
}
