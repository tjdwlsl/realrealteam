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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import server.Protocol;

public class user_login extends JPanel {
	private user_panel parent;
	
	private JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7;
	private JTextField id_tf;
	private JButton login_bt, join_bt, pwf_bt, idf_bt;
	private JLabel name_lb;
	private JPasswordField pw_tf;

	public user_login(user_panel parent) {
		this();
		this.parent = parent;

		// 로그인 버튼
		login_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(parent.getFrame().connected()) {					
					login_s();
				}
			}
		});

		// 회원가입 버튼
		join_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("join");
				id_tf.setText("");
				pw_tf.setText("");
			}
		});

		// 비밀번호 찾기 버튼
		pwf_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("pwf");
				id_tf.setText("");
				pw_tf.setText("");
			}
		});

		// 아이디 찾기 버튼
		idf_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("idf");
				id_tf.setText("");
				pw_tf.setText("");
			}
		});

		pw_tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(parent.getFrame().connected()) {					
					login_s();
				}
			}
		});
		

	}

	public user_login() {
		setBorder(new EmptyBorder(50, 0, 0, 0));
		setPreferredSize(new Dimension(600, 600));
		setLayout(new GridLayout(3, 1));

		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(0, 1, 0, 0));
		name_lb = new JLabel("Mind Nest StudyCafe");
		name_lb.setVerticalAlignment(SwingConstants.BOTTOM);
		name_lb.setHorizontalAlignment(SwingConstants.CENTER);
		name_lb.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		jp1.add(name_lb);

		jp2 = new JPanel(new GridLayout(2, 1));
		jp2.setBorder(new EmptyBorder(30, 0, 0, 0));

		jp3 = new JPanel();
		jp3.setBorder(new EmptyBorder(40, 0, 0, 0));
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("아이디 :   ");
		jp3.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		id_tf = new JTextField();
		jp3.add(id_tf);
		id_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		id_tf.setColumns(10);

		jp2.add(jp3);

		jp4 = new JPanel();
		jp4.setBorder(new EmptyBorder(40, 0, 0, 0));
		jp4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_2 = new JLabel("비밀번호 : ");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jp4.add(lblNewLabel_2);
		pw_tf = new JPasswordField();
		pw_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pw_tf.setColumns(10);
		jp4.add(pw_tf);

		jp2.add(jp4);

		jp5 = new JPanel(new GridLayout(2, 1));

		jp6 = new JPanel();

		jp7 = new JPanel();
		jp7.setBorder(new EmptyBorder(0, 100, 0, 70));
		jp7.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		join_bt = new JButton("  회원가입  ");
		join_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp7.add(join_bt);

		idf_bt = new JButton("  아이디 찾기  ");
		idf_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp7.add(idf_bt);

		pwf_bt = new JButton("  비밀번호 찾기  ");
		pwf_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp7.add(pwf_bt);

		jp5.add(jp6);
		jp6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));

		login_bt = new JButton("   로그인   ");
		login_bt.setVerticalAlignment(SwingConstants.BOTTOM);
		login_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp6.add(login_bt);
		jp5.add(jp7);

		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		add(jp5, BorderLayout.SOUTH);
	}
	
	public void login_s() {
		String id = id_tf.getText();
		//VO vo = DAO.getOne(id);
		String pw = new String(pw_tf.getPassword());
		Protocol p = new Protocol();
		p.setCmd(1);
		p.setId(id);
		p.setPw(pw);
		parent.getFrame().sendProtocol(p);
//		if (id.equals("") || pw.equals("")) {
//			JOptionPane.showMessageDialog(getParent(), "아이디, 비밀번호 전부 입력해주세요.");
//		} else if (vo != null && pw.equals(vo.getUser_password())) {
//			JOptionPane.showMessageDialog(getParent(), "로그인 되었습니다. 환영합니다!");
//			parent.showCard("main");
//			id_tf.setText("");
//			pw_tf.setText("");
//			parent.setC_Vo(vo);
//			((user_main) parent.getP("main")).initQaList();
//			((user_main) parent.getP("main")).initnoticeList();
//			((user_main)parent.getP("main")).set_id(id);
//		} else if (vo == null) {
//			JOptionPane.showMessageDialog(getParent(), "아이디가 없습니다. 다시 입력해주세요.");
//			id_tf.setText("");
//			pw_tf.setText("");
//			id_tf.requestFocus();
//		} else if (!pw.equals(vo.getUser_password())) {
//			JOptionPane.showMessageDialog(getParent(), "비밀번호가 틀렸습니다. 다시 입력해주세요.");
//			pw_tf.setText("");
//			pw_tf.requestFocus();
//		}
	}
}
