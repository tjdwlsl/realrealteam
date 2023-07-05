package team;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mybatis.DAO;
import mybatis.VO;

public class user_pwf extends JPanel {
	private user_panel parent;
	
	private JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8, jp9;
	private JTextField id_tf;
	private JTextField phone_tf;
	private JButton pwf_bt, back_bt;

	/**
	 * Create the panel.
	 */
	public user_pwf(user_panel parent) {
		this();
		this.parent = parent;
		
		// 뒤로가기 버튼
		back_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("login");
				phone_tf.setText("");
			}
		});
		
		// 비밀번호 찾기 버튼
		pwf_bt.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {			
				find_pw();
			}
		});
		
		phone_tf.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				find_pw();
			}
		});
	}
public user_pwf() {
	setBorder(new EmptyBorder(50, 0, 0, 0));
	setLayout(new BorderLayout(0, 0));
	setPreferredSize(new Dimension(600, 600));
	
	JLabel lblNewLabel = new JLabel("비밀번호 찾기");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));
	add(lblNewLabel, BorderLayout.NORTH);
	
	 jp1 = new JPanel();
	add(jp1, BorderLayout.CENTER);
	jp1.setLayout(new BorderLayout(0, 0));
	
	 jp2 = new JPanel();
	jp2.setBorder(new EmptyBorder(85, 70, 85, 70));
	jp1.add(jp2, BorderLayout.NORTH);
	jp2.setLayout(new GridLayout(2, 0, 0, 0));
	
	 jp3 = new JPanel();
	jp3.setBorder(new EmptyBorder(10, 0, 30, 0));
	jp2.add(jp3);
	jp3.setLayout(new GridLayout(0, 2, 0, 0));
	
	 jp4 = new JPanel();
	FlowLayout fl_jp4 = (FlowLayout) jp4.getLayout();
	fl_jp4.setAlignment(FlowLayout.RIGHT);
	jp3.add(jp4);
	
	JLabel lblNewLabel_1 = new JLabel("아이디 : ");
	jp4.add(lblNewLabel_1);
	lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
	
	 jp5 = new JPanel();
	FlowLayout fl_jp5 = (FlowLayout) jp5.getLayout();
	fl_jp5.setAlignment(FlowLayout.LEFT);
	jp3.add(jp5);
	
	id_tf = new JTextField();
	jp5.add(id_tf);
	id_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
	id_tf.setColumns(10);
	
	 jp6 = new JPanel();
	jp6.setBorder(new EmptyBorder(30, 0, 0, 0));
	jp2.add(jp6);
	jp6.setLayout(new GridLayout(0, 2, 0, 0));
	
	 jp7 = new JPanel();
	FlowLayout fl_jp7 = (FlowLayout) jp7.getLayout();
	fl_jp7.setAlignment(FlowLayout.RIGHT);
	jp6.add(jp7);
	
	JLabel lblNewLabel_2 = new JLabel("핸드폰번호 :  ");
	jp7.add(lblNewLabel_2);
	lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 25));
	
	 jp8 = new JPanel();
	FlowLayout fl_jp8 = (FlowLayout) jp8.getLayout();
	fl_jp8.setAlignment(FlowLayout.LEFT);
	jp6.add(jp8);
	
	phone_tf = new JTextField();
	jp8.add(phone_tf);
	phone_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
	phone_tf.setColumns(10);
	
	 jp9 = new JPanel();
	jp9.setBorder(new EmptyBorder(0, 130, 100, 0));
	jp1.add(jp9, BorderLayout.SOUTH);
	
	pwf_bt = new JButton("  비밀번호 찾기  ");
	pwf_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
	jp9.add(pwf_bt);
	
	back_bt = new JButton("  뒤로가기  ");
	back_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
	jp9.add(back_bt);
}

public void find_pw() {
	String id = id_tf.getText();
	String phone = phone_tf.getText();
	VO vo = new VO();
	vo.setUser_id(id);
	vo.setUser_phone(phone);
	VO vo2 = DAO.getPwf(vo);
	String num = "[0-9]+";		
	if(id.equals("") || phone.equals("")) {
		JOptionPane.showMessageDialog(getParent(), "아이디, 핸드폰 번호 전부 입력해주세요.");
	}else if (phone.length() < 11 || !phone.matches(num)) {
			JOptionPane.showMessageDialog(getParent(), "핸드폰 번호는 숫자만 010부터 모두 입력해주세요.");
			phone_tf.setText("");
			phone_tf.requestFocus();
	}else if(vo2.getUser_id().equals(id)){					
		JOptionPane.showMessageDialog(getParent(), id +"님의 비밀번호는" + vo2.getUser_password() + "입니다.");
		parent.showCard("login");
		phone_tf.setText("");				
	}
	}
}

