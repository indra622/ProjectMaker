package csee.narasarang.projmaker.meeting;

/**
 * @author Hwang Nara
 * @email narahwang7@gmail.com
 * @classname Meeting.java
 * @package csee.narasarang.projmaker.meeting
 * @date 2013. 5. 25. 오전 1:30:55
 * @purpose :  미팅 관련 데이터를 담는 value object
 *
 * @comment :  attribute 대폭 수정
 * 
 */
public class MeetingVO {
	
	/**
	 * @uml.property  name="project_no"
	 */
	int project_no;
	/**
	 * @uml.property  name="meeting_title"
	 */
	String meeting_title;
	/**
	 * @uml.property  name="meeting_no"
	 */
	int meeting_no;
	/**
	 * @uml.property  name="category"
	 */
	String category;
	/**
	 * @uml.property  name="meeting_date"
	 */
	String meeting_date;
	/**
	 * @uml.property  name="location"
	 */
	String location;
	/**
	 * @uml.property  name="content"
	 */
	String content;
	/**
	 * @uml.property  name="write_member"
	 */
	String write_member;
	/**
	 * @uml.property  name="write_date"
	 */
	String write_date;
	/**
	 * @uml.property  name="modify_date"
	 */
	String modify_date;
	
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
	 * @uml.property  name="meeting_title"
	 */
	public String getMeeting_title() {
		return meeting_title;
	}
	/**
	 * @param meeting_title
	 * @uml.property  name="meeting_title"
	 */
	public void setMeeting_title(String meeting_title) {
		this.meeting_title = meeting_title;
	}
	/**
	 * @return
	 * @uml.property  name="meeting_no"
	 */
	public int getMeeting_no() {
		return meeting_no;
	}
	/**
	 * @param meeting_no
	 * @uml.property  name="meeting_no"
	 */
	public void setMeeting_no(int meeting_no) {
		this.meeting_no = meeting_no;
	}
	/**
	 * @return
	 * @uml.property  name="category"
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category
	 * @uml.property  name="category"
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return
	 * @uml.property  name="meeting_date"
	 */
	public String getMeeting_date() {
		return meeting_date;
	}
	/**
	 * @param meeting_date
	 * @uml.property  name="meeting_date"
	 */
	public void setMeeting_date(String meeting_date) {
		this.meeting_date = meeting_date;
	}
	/**
	 * @return
	 * @uml.property  name="location"
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location
	 * @uml.property  name="location"
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return
	 * @uml.property  name="content"
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content
	 * @uml.property  name="content"
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return
	 * @uml.property  name="write_member"
	 */
	public String getWrite_member() {
		return write_member;
	}
	/**
	 * @param write_member
	 * @uml.property  name="write_member"
	 */
	public void setWrite_member(String write_member) {
		this.write_member = write_member;
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
	/**
	 * @return
	 * @uml.property  name="modify_date"
	 */
	public String getModify_date() {
		return modify_date;
	}
	/**
	 * @param modify_date
	 * @uml.property  name="modify_date"
	 */
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}

}