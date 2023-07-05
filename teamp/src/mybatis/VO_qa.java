package mybatis;

import java.io.Serializable;
import java.sql.Timestamp;

public class VO_qa implements Serializable{
	private String qa_num, user_id, q_title, q_content, a_title, a_content, admin_id;
	private Timestamp q_time,a_time ;
	
	public String getQa_num() {
		return qa_num;
	}
	public void setQa_num(String qa_num) {
		this.qa_num = qa_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public String getA_title() {
		return a_title;
	}
	public void setA_title(String a_title) {
		this.a_title = a_title;
	}
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public Timestamp getQ_time() {
		return q_time;
	}
	public void setQ_time(Timestamp q_time2) {
		this.q_time = q_time2;
	}
	public Timestamp getA_time() {
		return a_time;
	}
	public void setA_time(Timestamp a_time) {
		this.a_time = a_time;
	}

	
}
