package csee.narasarang.projmaker.UIcomponent;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * @author Hosung
 * @email indra622@gmail.com
 * @classname PMProjectSwitchPanel.java
 * @package csee.narasarang.projmaker.UIcomponent
 * @date 2013. 5. 4.오후 2:31:14
 * @purpose : 방 리스트와 방 안에 들어갔을때 전환되는 화면
 * 
 * @comment :
 * @hosung 여기 LIST패널 클래스 입력하면 됨
 * 
 */
public class ProjectSwitchPanel extends JPanel {
	private static ProjectSwitchPanel switchPanel = new ProjectSwitchPanel();

	public static ProjectSwitchPanel getInstance() {
		return switchPanel;
	}

	public ProjectSwitchPanel() {
		this.setLayout(new BorderLayout(10, 10));
		this.add(setScroll(new ProjectRoomsPanel()));
		this.setVisible(true);
	}

	public void switchToDetailPanel(int projectNum) {
		ProjectDetailPanel detail = new ProjectDetailPanel(projectNum);
		switchTo(detail);
	}

	public void switchToListPanel() {
		switchTo(setScroll(new ProjectRoomsPanel()));
	}

	private JScrollPane setScroll(JPanel panel) {
		JScrollPane jsp = new JScrollPane(panel,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.getVerticalScrollBar().setUnitIncrement(16);
		return jsp;
	}

	private void switchTo(JPanel panel) {
		MainPanel.getInstance().removeAll();
		MainPanel.getInstance().updateUI();
		MainPanel.getInstance().add(ProjectPanel.getInstance()); // ProjectPanel
																	// = EAST가
																	// 있는 panel
		ProjectPanel.getInstance().add(panel, BorderLayout.WEST);

	}

	private void switchTo(JScrollPane panel) {
		MainPanel.getInstance().removeAll();
		MainPanel.getInstance().updateUI();
		MainPanel.getInstance().add(ProjectPanel.getInstance()); // ProjectPanel
																	// = EAST가
																	// 있는 panel
		ProjectPanel.getInstance().add(panel, BorderLayout.WEST);

	}
}
