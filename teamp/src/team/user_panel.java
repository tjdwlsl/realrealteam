package team;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.TreeMap;

import javax.swing.JPanel;

import mybatis.DAO;
import mybatis.DAO_ticketbuy;
import mybatis.VO;
import mybatis.VO_ticketbuy;

public class user_panel extends JPanel {
	private CardLayout cl;
	private JPanel cl_p;
	private mypage mypage;
	private set_pw set_pw;
	private ticket_buy buy;
	private ticket_com com;
	private refund refund;
	private seat seat;
	private sel_time sel_time;
	private seat_com seat_com;
	private user_main main;

	private user_login login;
	private user_pwf pwf;
	private user_join join;
	private user_notice notice;
	private user_qa_set qa_set;
	private user_qa qa;
	private user_idf idf;
	private point_refund p_refund;
	private user_point point;
	private p_charge charge;
	private VO c_Vo;
	private VO_ticketbuy t_Vo;
	private user_frame frame;
	private TreeMap<String, JPanel> cardp;

	/**
	 * Create the panel.
	 */
	public user_panel(user_frame frame) {
		this();
		this.frame = frame;
	}

	public user_panel() {
		setPreferredSize(new Dimension(600, 600));
		setLayout(new BorderLayout());

		cl_p = new JPanel();
		add(cl_p, BorderLayout.CENTER);

		cl = new CardLayout();
		cl_p.setLayout(cl);

		mypage = new mypage(this);
		cl_p.add("mypage", mypage);

		set_pw = new set_pw(this);
		cl_p.add("set_pw", set_pw);

		buy = new ticket_buy(this);
		cl_p.add("buy", buy);

		com = new ticket_com(this);
		cl_p.add("com", com);

		seat = new seat(this);
		cl_p.add("seat", seat);

		sel_time = new sel_time(this);
		cl_p.add("sel_time", sel_time);

		refund = new refund(this);
		cl_p.add("refund", refund);

		seat_com = new seat_com(this);
		cl_p.add("seat_com", seat_com);

		main = new user_main(this);
		cl_p.add("main", main);

		login = new user_login(this);
		cl_p.add("login", login);

		pwf = new user_pwf(this);
		cl_p.add("pwf", pwf);

		join = new user_join(this);
		cl_p.add("join", join);

		notice = new user_notice(this);
		cl_p.add("notice", notice);

		qa_set = new user_qa_set(this);
		cl_p.add("qa_set", qa_set);

		qa = new user_qa(this);
		cl_p.add("qa", qa);

		idf = new user_idf(this);
		cl_p.add("idf", idf);

		p_refund = new point_refund(this);
		cl_p.add("p_refund", p_refund);

		point = new user_point(this);
		cl_p.add("point", point);

		charge = new p_charge(this);
		cl_p.add("charge", charge);

		cl.show(cl_p, "login");

		cardp = new TreeMap<>();
		cardp.put("login", login);
		cardp.put("mypage", mypage);
		cardp.put("set_pw", set_pw);
		cardp.put("buy", buy);
		cardp.put("com", com);
		cardp.put("seat", seat);
		cardp.put("sel_time", sel_time);
		cardp.put("refund", refund);
		cardp.put("seat_com", seat_com);
		cardp.put("main", main);
		cardp.put("pwf", pwf);
		cardp.put("join", join);
		cardp.put("notice", notice);
		cardp.put("qa_set", qa_set);
		cardp.put("qa", qa);
		cardp.put("idf", idf);
		cardp.put("p_refund", p_refund);
		cardp.put("point", point);
		cardp.put("charge", charge);
	}

	public JPanel getP(String card_name) {
		return cardp.get(card_name);
	}

	public VO getC_Vo() {
		   if(c_Vo != null) {
	            c_Vo = DAO.getOne(c_Vo.getUser_id());
	        }
	        return c_Vo;
	}

	public void setC_Vo(VO c_Vo) {
		this.c_Vo = c_Vo;
	}
	
	public VO_ticketbuy getT_Vo() {
		if(c_Vo != null) {
			if(c_Vo.getTicket_buy_num() != null) {
			t_Vo = DAO_ticketbuy.tOne(c_Vo.getTicket_buy_num());
		}
		}
		return t_Vo;
	}
	
	public void setT_Vo(VO_ticketbuy t_Vo) {
		this.t_Vo = t_Vo;
	}

	public void showCard(String cardName) {
		cl.show(cl_p, cardName);
	}
	public user_frame getFrame() {
		return frame;
	}
}