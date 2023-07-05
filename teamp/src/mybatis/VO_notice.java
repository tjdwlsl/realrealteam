package mybatis;

import java.io.Serializable;
import java.time.LocalDateTime;

public class VO_notice implements Serializable{
	
	private String not_num, admin_id, not_title, not_content;
	private LocalDateTime not_time;
	
	public String getNot_num() {
		return not_num;
	}
	public void setNot_num(String not_num) {
		this.not_num = not_num;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getNot_title() {
		return not_title;
	}
	public void setNot_title(String not_title) {
		this.not_title = not_title;
	}
	public String getNot_content() {
		return not_content;
	}
	public void setNot_content(String not_content) {
		this.not_content = not_content;
	}
	public LocalDateTime getNot_time() {
		return not_time;
	}
	public void setNot_time(LocalDateTime not_time) {
		this.not_time = not_time;
	}
}
