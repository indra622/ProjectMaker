package csee.narasarang.projmaker.task;

import java.util.ArrayList;

import csee.narasarang.projmaker.DAO.DAO;
import csee.narasarang.projmaker.UIcomponent.MainPanel;
import csee.narasarang.projmaker.UIcomponent.table.SubTaskTable;
import csee.narasarang.projmaker.user.UserVO;

public class MyTask extends SubTaskTable {
	UserVO userVO = MainPanel.getInstance().user;
	int projectNum;
	DAO dao = new TaskManager();
	
	private String[][] taskListForTable(ArrayList<TaskVO> taskList){
		String[][] datas = null;
		
		//2차원동적할당
		datas = new String[taskList.size()][];
		for(int i = 0; i < taskList.size() ; i++)
		datas[i] = new String[4];
		
		for(int i = 0; i < taskList.size(); i++){

			if(taskList.get(i).getTask_member().equals(userVO.getName())){
			datas[i][0] = taskList.get(i).getTask_title();
			datas[i][1] = taskList.get(i).getTask_progress();
			datas[i][2] = taskList.get(i).getTask_member();
			datas[i][3] = taskList.get(i).getDue_date();
			}
			else
				continue;
			System.out.println(datas[i][0] + datas[i][1] + datas[i][2] + datas[i][3]);
		}
		return datas;
	}

}
