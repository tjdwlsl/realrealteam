package mybatis;

import java.io.Serializable;
import java.sql.Timestamp;

public class VO_ticketbuy implements Serializable{
	private String buy_num, user_id, ticket_id, price;
	private Timestamp buy_date, res_date;
	
	public String getBuy_num() {
		return buy_num;
	}
	public void setBuy_num(String buy_num) {
		this.buy_num = buy_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Timestamp getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(Timestamp buy_date) {
		this.buy_date = buy_date;
	}
	public Timestamp getRes_date() {
		return res_date;
	}
	public void setRes_date(Timestamp res_date) {
		this.res_date = res_date;
	}
}
