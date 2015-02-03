package csee.narasarang.projmaker.iterator;

import java.sql.SQLException;
import java.util.ArrayList;

import csee.narasarang.projmaker.DAO.DAO;
import csee.narasarang.projmaker.project.ProjectVO;
import csee.narasarang.projmaker.project.ProjectManager;

public class ProjectCollection implements AbstractCollection {
	/**
	 * @uml.property  name="projectList"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="csee.narasarang.projmaker.project.ProjectVO"
	 */
	private ArrayList<ProjectVO> projectList;
	//private int last = 0;
	/**
	 * @uml.property  name="dao"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	DAO dao = new ProjectManager();
	
	// ProjectCollection 생성과 동시에 DAO를 통하여 project list 전체를 projectList로 받아옴
	public ProjectCollection() {
		try {
			this.projectList = dao.projectList(); // project list 를 받아옴
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	// 해당 index의 project 반환 
	public ProjectVO getProjectAt(int index) {
		return projectList.get(index);
	}

	public void appendProject(ProjectVO project) {
		
		//last++;
	}

	public int getLength() {
		return projectList.size();
	}

	@Override
	public ItemIterator iterator() {
		// TODO Auto-generated method stub
		return new ConcreteIterator(this);
	}
	
	}
