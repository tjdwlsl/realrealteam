package team;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mybatis.DAO;
import mybatis.VO;
import server.Protocol;

public class user_join extends JPanel {
	private user_panel parent;

	private JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8, jp9, jp10, jp11, jp12, jp13, jp14, jp15;
	private JTextField id_tf, phone_tf;
	private JPasswordField pw_tf, pw_tf2;
	private JButton double_bt, join_bt, back_bt;
	private JPanel jp16;
	private Timestamp time;

	/**
	 * Create the panel.
	 */
	public user_join(user_panel parent) {
		this();
		this.parent = parent;
		// 중복확인 버튼
		double_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = id_tf.getText();
				//VO vo = DAO.getOne(id);
				String eng = "[a-z]+";
				Protocol p = new Protocol();
				p.setCmd(2);
				p.setId(id);
				parent.getFrame().sendProtocol(p); 
//				if (id.equals("")) {
//					JOptionPane.showMessageDialog(getParent(), "아이디를 입력해주세요.");
//
//				} else if (!id.equalsIgnoreCase(eng)) {
//					JOptionPane.showMessageDialog(getParent(), "아이디는 영어만 입력 가능합니다.");
//					id_tf.setText("");
//					id_tf.requestFocus();
//
//				} else if (vo != null) {
//					JOptionPane.showMessageDialog(getParent(), "이미 가입 되어있는 아이디입니다.\n 다시 입력해주세요.");
//					id_tf.setText("");
//					id_tf.requestFocus();
//				} else if (vo == null) {
//					int res = JOptionPane.showConfirmDialog(getParent(), "사용 가능한 아이디입니다.", "중복확인 완료",
//							JOptionPane.OK_CANCEL_OPTION);
//					if (res == 0) {
//						phone_tf.requestFocus();
//					} else if (res == 2 || res == -1) {
//						id_tf.setText("");
//						id_tf.requestFocus();
//					}
//				}
			}
		});

		// 회원가입 버튼
		join_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = id_tf.getText();
				String phone = phone_tf.getText();
				String pw = new String(pw_tf.getPassword());
				String pwf = new String(pw_tf2.getPassword());
				String num = "[0-9]+";
				//String eng = "[a-z]+";
				time = new Timestamp(System.currentTimeMillis());
				VO vo = DAO.getOne(id);
				Protocol p = new Protocol();
				p.setCmd(3);
				p.setId(id);
				p.setPhone(phone);
				p.setPw(pwf);
				parent.getFrame().sendProtocol(p);

//				if (id.equals("") || phone.equals("") || pw.equals("") || pwf.equals("")) {
//					JOptionPane.showMessageDialog(getParent(), "전부 입력해주세요.");
//
//					//
////				} else if (!pw.equalsIgnoreCase(eng) || !pwf.equalsIgnoreCase(eng)) {
////					JOptionPane.showMessageDialog(getParent(), "전부 영어만 입력해주세요.");
////					id_tf.setText("");
////					id_tf.requestFocus();
////					pw_tf.setText("");
////					pw_tf2.setText("");
//					//
//
//				} else if (pw.length() < 6) {
//					JOptionPane.showMessageDialog(getParent(), "비밀번호는 6자리 이상 입력해주세요.");
//					pw_tf.setText("");
//					pw_tf2.setText("");
//					pw_tf.requestFocus();
//				} else if (phone.length() < 11 || !phone.matches(num)) {
//					JOptionPane.showMessageDialog(getParent(), "핸드폰 번호는 숫자만 010부터 모두 입력해주세요.");
//					phone_tf.setText("");
//					phone_tf.requestFocus();
//				} else if (id.equals(pw) || id.equals(pwf)) {
//					JOptionPane.showMessageDialog(getParent(), "아이디와 비밀번호는 다르게 해주세요.");
//					pw_tf.setText("");
//					pw_tf2.setText("");
//					pw_tf.requestFocus();
//				} else if (vo != null) {
//					JOptionPane.showMessageDialog(getParent(), "이미 가입 되어있는 아이디입니다.\n 다시 입력해주세요.");
//					id_tf.setText("");
//					id_tf.requestFocus();
//				} else if (!pw.equals(pwf)) {
//					JOptionPane.showMessageDialog(getParent(), "비밀번호가 다릅니다. 다시 입력해주세요.");
//					pw_tf.setText("");
//					pw_tf2.setText("");
//					pw_tf.requestFocus();
//				} else {
//					JOptionPane.showMessageDialog(getParent(), i	d + "님 Mind Nest에 오신 것을 환영합니다!");
//
//					VO vo2 = new VO();
//					vo2.setUser_id(id);
//					vo2.setUser_password(pw);
//					vo2.setUser_phone(phone);
//					vo2.setJoin_date(time);
//					vo2.setPoint("0");
//
//					int res = DAO.getInsert(vo2);
//
//					parent.showCard("login");
//					id_tf.setText("");
//					pw_tf.setText("");
//					pw_tf2.setText("");
//					phone_tf.setText("");
//				}
			}
		});
		// 뒤로가기 버튼
		back_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("login");
				id_tf.setText("");
				pw_tf.setText("");
				pw_tf2.setText("");
				phone_tf.setText("");
			}
		});
	}

	public user_join() {

		setPreferredSize(new Dimension(600, 600));
		setBorder(new EmptyBorder(50, 0, 0, 0));
		setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		add(lblNewLabel, BorderLayout.NORTH);

		jp1 = new JPanel();
		add(jp1, BorderLayout.CENTER);
		jp1.setLayout(new BorderLayout(0, 0));

		jp2 = new JPanel();
		jp1.add(jp2, BorderLayout.CENTER);
		jp2.setLayout(new BorderLayout(0, 0));

		jp3 = new JPanel();
		jp3.setBorder(new EmptyBorder(100, 30, 80, 30));
		jp2.add(jp3, BorderLayout.CENTER);
		jp3.setLayout(new GridLayout(5, 2));

		jp4 = new JPanel();
		jp3.add(jp4);
		jp4.setLayout(new GridLayout(0, 2, 0, 0));

		jp5 = new JPanel();
		FlowLayout fl_jp5 = (FlowLayout) jp5.getLayout();
		fl_jp5.setAlignment(FlowLayout.RIGHT);
		jp4.add(jp5);

		JLabel id_lb = new JLabel("아이디 : ");
		id_lb.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jp5.add(id_lb);

		jp6 = new JPanel();
		FlowLayout fl_jp6 = (FlowLayout) jp6.getLayout();
		fl_jp6.setAlignment(FlowLayout.LEFT);
		jp4.add(jp6);

		id_tf = new JTextField();
		id_tf.setHorizontalAlignment(SwingConstants.LEFT);
		id_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp6.add(id_tf);
		id_tf.setColumns(11);

		double_bt = new JButton("중복확인");
		jp6.add(double_bt);
		double_bt.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		jp7 = new JPanel();
		jp3.add(jp7);
		jp7.setLayout(new GridLayout(0, 2, 0, 0));

		jp8 = new JPanel();
		FlowLayout fl_jp8 = (FlowLayout) jp8.getLayout();
		fl_jp8.setAlignment(FlowLayout.RIGHT);
		jp7.add(jp8);

		JLabel lblNewLabel_2 = new JLabel("핸드폰 번호 : ");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jp8.add(lblNewLabel_2);

		jp9 = new JPanel();
		FlowLayout fl_jp9 = (FlowLayout) jp9.getLayout();
		fl_jp9.setAlignment(FlowLayout.LEFT);
		jp7.add(jp9);

		phone_tf = new JTextField();
		phone_tf.setHorizontalAlignment(SwingConstants.LEFT);
		phone_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp9.add(phone_tf);
		phone_tf.setColumns(11);

		jp10 = new JPanel();
		jp3.add(jp10);
		jp10.setLayout(new GridLayout(0, 2, 0, 0));

		jp11 = new JPanel();
		FlowLayout fl_jp11 = (FlowLayout) jp11.getLayout();
		fl_jp11.setAlignment(FlowLayout.RIGHT);
		jp10.add(jp11);

		JLabel lblNewLabel_3 = new JLabel("비밀번호 : ");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jp11.add(lblNewLabel_3);

		jp12 = new JPanel();
		FlowLayout fl_jp12 = (FlowLayout) jp12.getLayout();
		fl_jp12.setAlignment(FlowLayout.LEFT);
		jp10.add(jp12);

		pw_tf = new JPasswordField();
		pw_tf.setToolTipText("비밀번호 6자리 이상 입력해주세요.");
		pw_tf.setHorizontalAlignment(SwingConstants.LEFT);
		pw_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp12.add(pw_tf);
		pw_tf.setColumns(11);

		jp13 = new JPanel();
		jp3.add(jp13);
		jp13.setLayout(new GridLayout(0, 2, 0, 0));

		jp14 = new JPanel();
		FlowLayout fl_jp14 = (FlowLayout) jp14.getLayout();
		fl_jp14.setAlignment(FlowLayout.RIGHT);
		jp13.add(jp14);

		JLabel lblNewLabel_4 = new JLabel("비밀번호 확인 : ");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jp14.add(lblNewLabel_4);

		jp15 = new JPanel();
		FlowLayout fl_jp15 = (FlowLayout) jp15.getLayout();
		fl_jp15.setAlignment(FlowLayout.LEFT);
		jp13.add(jp15);

		pw_tf2 = new JPasswordField();
		pw_tf2.setHorizontalAlignment(SwingConstants.LEFT);
		pw_tf2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp15.add(pw_tf2);
		pw_tf2.setColumns(11);

		jp16 = new JPanel();
		jp3.add(jp16);

		join_bt = new JButton("  회원가입  ");
		join_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp16.add(join_bt);

		back_bt = new JButton("  뒤로가기  ");
		back_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp16.add(back_bt);
	}
}
