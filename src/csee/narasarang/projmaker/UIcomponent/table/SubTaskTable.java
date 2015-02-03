package csee.narasarang.projmaker.UIcomponent.table;

import java.util.ArrayList;

import csee.narasarang.projmaker.DAO.DAO;
import csee.narasarang.projmaker.task.TaskVO;
import csee.narasarang.projmaker.task.TaskManager;

/**
 * @author Hosung
 * @email indra622@gmail.com
 * @classname PMSubTaskTable.java
 * @package csee.narasarang.projmaker.UIcomponent.table
 * @date 2013. 5. 4.오후 4:34:29
 * @purpose : table maker
 *
 * @comment : 
 * 			@hosung 아 이거 팩토리 메소드 패턴 사용해서 할 수 있을 것 같은데 써버리면 안될 것 같아서 일단 패스
 * 			@hosung 고의적으로 일단 하나에 쑤셔넣겠음 ㅋㅋㅋㅋㅋㅋㅋㅋ
 *
 */
public class SubTaskTable extends Table{
	
	/**
	 * @uml.property  name="colNames" multiplicity="(0 -1)" dimension="1"
	 */
	String[] colNames = {"Task", "isDone", "Assigned", "Due"};
	/**
	 * @uml.property  name="projectNum"
	 */
	int projectNum;
	/**
	 * @uml.property  name="dao"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	DAO dao = new TaskManager();
	
	public SubTaskTable() {
		// TODO Auto-generated constructor stub
	}
	
	private SubTaskTable(String[] colNames, String[][] datas, int width, int height){
		
		super(colNames, datas, width, height);
	}
	private String[][] taskListForTable(ArrayList<TaskVO> taskList){
		String[][] datas = null;
		System.out.println(projectNum +"task사이즈:"+ taskList.size());
		
		//2차원동적할당
		datas = new String[taskList.size()][];
		for(int i = 0; i < taskList.size() ; i++)
		datas[i] = new String[4];
		
		for(int i = 0; i < taskList.size(); i++){

			datas[i][0] = taskList.get(i).getTask_title();
			datas[i][1] = taskList.get(i).getTask_progress();
			datas[i][2] = taskList.get(i).getTask_member();
			datas[i][3] = taskList.get(i).getDue_date();
			System.out.println(datas[i][0] + datas[i][1] + datas[i][2] + datas[i][3]);
		}
		return datas;
	}
	public Table makeTable(){
		return new SubTaskTable(colNames, taskListForTable(dao.taskList(projectNum)), 450,150);
	}
	/**
	 * @param projectNum
	 * @uml.property  name="projectNum"
	 */
	public void setProjectNum(int projectNum){
		this.projectNum = projectNum;
	}
}
