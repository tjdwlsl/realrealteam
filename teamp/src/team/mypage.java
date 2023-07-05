package team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import mybatis.DAO;

public class mypage extends JPanel {
	private user_panel parent;

	private JPanel jp1, jp2, jp3, jp4, jp5;
	private JButton back_bt, qa_set_bt, refund_bt, password_set_bt, logout_bt, out_bt;
	private JLabel mp_lb;
	private JTextArea jta;

	public mypage(user_panel parent) {
		this();
		this.parent = parent;

		// 뒤로가기
		back_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("main");
				jta.setText("");
				((user_main) parent.getP("main")).initQaList();
				
			}
		});

		// q&a 작성 버튼
		qa_set_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("qa_set");
				jta.setText("");
				((user_main) parent.getP("main")).initQaList();
			}
		});

		// 환불 버튼
		refund_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("refund");
				jta.setText("");
				((user_main) parent.getP("main")).initQaList();
			}
		});

		// 비밀번호 변경 버튼
		password_set_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("set_pw");
				jta.setText("");
				((user_main) parent.getP("main")).initQaList();
			}
		});

		// 로그아웃 버튼
		logout_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(getParent(), "로그아웃 하시겠습니까?", "로그아웃",
						JOptionPane.OK_CANCEL_OPTION);
				if (res == 0) {
					JOptionPane.showMessageDialog(getParent(), "로그아웃 되었습니다.");
					parent.showCard("login");
					jta.setText("");
					((user_main) parent.getP("main")).initQaList();
				}
			}
		});

		// 회원탈퇴 버튼
		out_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(getParent(), "탈퇴 하시겠습니까?", "탈퇴", JOptionPane.OK_CANCEL_OPTION);
				while (res == 0) {
					String pw = JOptionPane.showInputDialog("비밀번호를 입력해주세요.");
					if (pw.equals("")) {
						JOptionPane.showMessageDialog(getParent(), "비밀번호를 입력해주세요.");
					} else if (!pw.equals(parent.getC_Vo().getUser_password())) {
						JOptionPane.showMessageDialog(getParent(), "비밀번호를 다시 입력해주세요.");
					} else if (pw.equals(parent.getC_Vo().getUser_password())) {
						parent.getC_Vo();
						JOptionPane.showMessageDialog(getParent(), "탈퇴 되었습니다. 그동안 감사했습니다.");
						DAO.getDelete(parent.getC_Vo().getUser_id());
						parent.setC_Vo(null);
						parent.showCard("login");
						jta.setText("");
						break;
					}
				}
			}
		});
	}

	public mypage() {
		setPreferredSize(new Dimension(600, 600));
		setLayout(new GridLayout(3, 1));

		jp1 = new JPanel();
		add(jp1, BorderLayout.NORTH);
		jp1.setLayout(new GridLayout(2, 1));

		jp2 = new JPanel();
		FlowLayout fl_jp2 = (FlowLayout) jp2.getLayout();
		fl_jp2.setAlignment(FlowLayout.LEFT);

		back_bt = new JButton("  뒤로가기  ");
		back_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		jp1.add(jp2);
		jp2.add(back_bt);

		jp3 = new JPanel();
		jp1.add(jp3);

		mp_lb = new JLabel("  마이페이지  ");
		mp_lb.setHorizontalAlignment(SwingConstants.CENTER);
		mp_lb.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		jp3.add(mp_lb);

		jp4 = new JPanel();
		jp4.setBorder(BorderFactory.createTitledBorder("  회원 정보  "));
		add(jp4);
		jp4.setLayout(new BorderLayout(0, 0));

		jta = new JTextArea(5, 30);
		jta.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		jta.setBackground(Color.white);
		jta.setEditable(false);
		jp4.add(jta);

		jp5 = new JPanel();
		add(jp5);

		qa_set_bt = new JButton("  Q&A 작성  ");
		qa_set_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp5.add(qa_set_bt);

		refund_bt = new JButton("  이용권 환불  ");
		refund_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		jp5.add(refund_bt);

		password_set_bt = new JButton("  비밀번호 변경  ");
		password_set_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp5.add(password_set_bt);

		logout_bt = new JButton("  로그아웃  ");
		logout_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp5.add(logout_bt);

		out_bt = new JButton("  회원탈퇴  ");
		out_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp5.add(out_bt);

		add(jp1, BorderLayout.NORTH);
		add(jp4, BorderLayout.CENTER);
		add(jp5, BorderLayout.SOUTH);
	}
	
	public void setText() {
		jta.append(""+"\n");
		jta.append("회원 아이디: " + parent.getC_Vo().getUser_id() + "\n");
		jta.append("회원 전화번호: " + parent.getC_Vo().getUser_phone() + "\n");
		if (parent.getC_Vo().getTicket_id() == null) {
			jta.append("보유 이용권: 없음\n");
		} else {
			jta.append("보유 이용권: " + parent.getC_Vo().getTicket_id() + "\n");
		}
		jta.append("포인트 잔액: " + parent.getC_Vo().getPoint() + "\n");
	}
}
