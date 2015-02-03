package csee.narasarang.projmaker.UIcomponent;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * @author Hosung
 * @email indra622@gmail.com
 * @classname PMProjectDetailPanel.java
 * @package csee.narasarang.projmaker.UIcomponent
 * @date 2013. 5. 3.오후 9:07:52
 * @purpose : print SubTask and Meeting Schedule 
 *
 * @comment : 
 * 			@hosung 헥헥 이거 만들기 힘들다 ㅠㅠ 헌규야 여기 East에 너가 만들어놓은 그리드 적용해줘
 *
 */
public class ProjectDetailPanel extends JPanel{
	/**
	 * @uml.property  name="projectNum"
	 */
	private int projectNum;
//	private static ProjectDetailPanel detailPanel = new ProjectDetailPanel();
//	public static ProjectDetailPanel getInstance(){ return detailPanel;}
	
	
	public ProjectDetailPanel(int projectNum){
		this.projectNum = projectNum;
		this.setLayout(new BorderLayout(1,1));
		this.add(new SubTaskPanel(projectNum), BorderLayout.NORTH);
		this.add(new MeetingPanel(projectNum), BorderLayout.SOUTH);
		
	}
	
	
}
