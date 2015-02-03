package csee.narasarang.projmaker.user;

/**
 * @author Hwang Nara
 * @email narahwang7@gmail.com
 * @classname User.java
 * @package csee.narasarang.projmaker.user
 * @modify date 2013. 5. 7. 오후 11:32:24
 * @purpose : User 정보를 담아오는 VO 
 *
 * @comment : name 추가, is_captain 삭제 
 * 
 */
public class UserVO {
	/**
	 * @uml.property  name="id"
	 */
	String id;
	/**
	 * @uml.property  name="password"
	 */
	String password;
	/**
	 * @uml.property  name="email"
	 */
	String email;
	/**
	 * @uml.property  name="phone"
	 */
	String phone;
	/**
	 * @uml.property  name="name"
	 */
	String name;
	/**
	 * @uml.property  name="registry_date"
	 */
	String registry_date;
	
	/**
	 * @return
	 * @uml.property  name="id"
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id
	 * @uml.property  name="id"
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return
	 * @uml.property  name="password"
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password
	 * @uml.property  name="password"
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return
	 * @uml.property  name="email"
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email
	 * @uml.property  name="email"
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return
	 * @uml.property  name="phone"
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone
	 * @uml.property  name="phone"
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return
	 * @uml.property  name="registry_date"
	 */
	public String getRegistry_date() {
		return registry_date;
	}
	/**
	 * @param registry_date
	 * @uml.property  name="registry_date"
	 */
	public void setRegistry_date(String registry_date) {
		this.registry_date = registry_date;
	}
	
}
