package csee.narasarang.projmaker.task;

/**
 * @author Hwang Nara
 * @email narahwang7@gmail.com
 * @classname Task.java
 * @package csee.narasarang.projmaker.task
 * @date 2013. 5. 21. 오후 11:56:28
 * @purpose :  Task(업무) 관련 Value Object
 *
 * @comment : 오늘 대폭 수정
 * 
 */
public class TaskVO {
	
	/**
	 * @uml.property  name="project_no"
	 */
	int project_no;
	/**
	 * @uml.property  name="task_title"
	 */
	String task_title;
	/**
	 * @uml.property  name="task_no"
	 */
	int task_no;
	/**
	 * @uml.property  name="task_member"
	 */
	String task_member;
	/**
	 * @uml.property  name="task_progress"
	 */
	String task_progress;
	/**
	 * @uml.property  name="due_date"
	 */
	String due_date;
	/**
	 * @uml.property  name="write_date"
	 */
	String write_date;
	/**
	 * @return
	 * @uml.property  name="project_no"
	 */
	public int getProject_no() {
		return project_no;
	}
	/**
	 * @param project_no
	 * @uml.property  name="project_no"
	 */
	public void setProject_no(int project_no) {
		this.project_no = project_no;
	}
	/**
	 * @return
	 * @uml.property  name="task_title"
	 */
	public String getTask_title() {
		return task_title;
	}
	/**
	 * @param task_title
	 * @uml.property  name="task_title"
	 */
	public void setTask_title(String task_title) {
		this.task_title = task_title;
	}
	/**
	 * @return
	 * @uml.property  name="task_no"
	 */
	public int getTask_no() {
		return task_no;
	}
	/**
	 * @param task_no
	 * @uml.property  name="task_no"
	 */
	public void setTask_no(int task_no) {
		this.task_no = task_no;
	}
	/**
	 * @return
	 * @uml.property  name="task_member"
	 */
	public String getTask_member() {
		return task_member;
	}
	/**
	 * @param task_member
	 * @uml.property  name="task_member"
	 */
	public void setTask_member(String task_member) {
		this.task_member = task_member;
	}
	/**
	 * @return
	 * @uml.property  name="task_progress"
	 */
	public String getTask_progress() {
		return task_progress;
	}
	/**
	 * @param task_progress
	 * @uml.property  name="task_progress"
	 */
	public void setTask_progress(String task_progress) {
		this.task_progress = task_progress;
	}
	/**
	 * @return
	 * @uml.property  name="due_date"
	 */
	public String getDue_date() {
		return due_date;
	}
	/**
	 * @param due_date
	 * @uml.property  name="due_date"
	 */
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	/**
	 * @return
	 * @uml.property  name="write_date"
	 */
	public String getWrite_date() {
		return write_date;
	}
	/**
	 * @param write_date
	 * @uml.property  name="write_date"
	 */
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	
}