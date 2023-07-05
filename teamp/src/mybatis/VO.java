package mybatis;

import java.io.Serializable;
import java.sql.Timestamp;

public class VO implements Serializable{
	private String user_id, user_phone, user_password, point, ticket_id, ticket_buy_num;
	private Timestamp join_date;
	
	public String getTicket_buy_num() {
		return ticket_buy_num;
	}

	public void setTicket_buy_num(String ticket_buy_num) {
		this.ticket_buy_num = ticket_buy_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public Timestamp getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Timestamp time) {
		this.join_date = time;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
}
