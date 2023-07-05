package mybatis;

import java.io.Serializable;
import java.sql.Timestamp;

public class VO_point implements Serializable{
	private String point_num, user_id, point, p_attribute;
	private Timestamp charge_date;

	public String getPoint_num() {
		return point_num;
	}

	public void setPoint_num(String point_num) {
		this.point_num = point_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPoint() {		
		return point;		
	}

	public void setPoint(String point) {
		this.point = point;			
	}

	public String getP_attribute() {
		return p_attribute;
	}

	public void setP_attribute(String p_attribute) {
		this.p_attribute = p_attribute;
	}

	public Timestamp getCharge_date() {
		return charge_date;
	}

	public void setCharge_date(Timestamp charge_date) {
		this.charge_date = charge_date;
	}

}
