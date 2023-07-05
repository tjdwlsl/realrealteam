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

public class set_pw extends JPanel {
	private user_panel parent;

	private JPanel jp1, jp1_1, jp1_2, jp2, present, set, check, jp3;
	private JButton back_bt, set_bt;
	private JPasswordField present_fd, set_fd, check_fd;

	public set_pw(user_panel parent) {
		this();
		this.parent = parent;

		// 뒤로가기 버튼
		back_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("mypage");
				((mypage) parent.getP("mypage")).setText();
				present_fd.setText("");
				set_fd.setText("");
				check_fd.setText("");
			}
		});

		// 비밀번호 변경 버튼
		set_bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String pw_n = new String(present_fd.getPassword());
				String pw_s = new String(set_fd.getPassword());
				String pw_c = new String(check_fd.getPassword());

				if (pw_n.equals("") || pw_s.equals("") || pw_c.equals("")) {
					JOptionPane.showMessageDialog(getParent(), "현재 비밀번호와 변경할 비밀번호 모두 입력해주세요.");
					present_fd.setText("");
					set_fd.setText("");
					check_fd.setText("");
					present_fd.requestFocus();

				} else if (pw_n.equals(pw_s)) {
					JOptionPane.showMessageDialog(getParent(), "입력하신 비밀번호가 현재 비밀번호와 같습니다.");
					present_fd.setText("");
					set_fd.setText("");
					check_fd.setText("");
					present_fd.requestFocus();
				} else if (pw_s.equals(pw_c)) {
					int res = JOptionPane.showConfirmDialog(getParent(), "비밀번호를 변경하시겠습니까?", "비밀번호 변경",
							JOptionPane.OK_CANCEL_OPTION);
					if (res == 0) {
						JOptionPane.showMessageDialog(getParent(), "비밀번호가 변경되었습니다.");
						parent.showCard("mypage");
						present_fd.setText("");
						set_fd.setText("");
						check_fd.setText("");
					}
				} else if (!pw_s.equals(pw_c)) {
					JOptionPane.showMessageDialog(getParent(), "입력하신 비밀번호가 다릅니다.");
					set_fd.setText("");
					check_fd.setText("");
					set_fd.requestFocus();
				}
			}
		});
	}

	/**
	 * Create the panel.
	 */
	public set_pw() {
		setPreferredSize(new Dimension(600, 600));
		setLayout(new GridLayout(3, 1));

		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(2, 1));

		jp1_1 = new JPanel();
		FlowLayout fl_jp1_1 = (FlowLayout) jp1_1.getLayout();
		fl_jp1_1.setAlignment(FlowLayout.LEFT);
		jp1.add(jp1_1);

		back_bt = new JButton("  뒤로가기  ");
		back_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp1_1.add(back_bt);

		jp1_2 = new JPanel();
		jp1.add(jp1_2);

		JLabel setpw_bt = new JLabel("비밀번호 변경");
		setpw_bt.setHorizontalAlignment(SwingConstants.CENTER);
		setpw_bt.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		jp1_2.add(setpw_bt);

		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(3, 1));

		present = new JPanel();
		jp2.add(present);

		JLabel present_pw = new JLabel("현재 비밀번호 :    ");
		present_pw.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		present_pw.setHorizontalAlignment(SwingConstants.LEFT);
		present.add(present_pw);

		present_fd = new JPasswordField();
		present_fd.setHorizontalAlignment(SwingConstants.LEFT);
		present_fd.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		present.add(present_fd);
		present_fd.setColumns(20);

		set = new JPanel();
		jp2.add(set);

		JLabel set_pw = new JLabel("변경할 비밀번호 : ");
		set_pw.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		set.add(set_pw);

		set_fd = new JPasswordField();
		set_fd.setHorizontalAlignment(SwingConstants.LEFT);
		set_fd.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		set.add(set_fd);
		set_fd.setColumns(20);

		check = new JPanel();
		jp2.add(check);

		JLabel check_pw = new JLabel("비밀번호 확인 :     ");
		check_pw.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		check.add(check_pw);

		check_fd = new JPasswordField();
		check_fd.setHorizontalAlignment(SwingConstants.LEFT);
		check_fd.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		check.add(check_fd);
		check_fd.setColumns(20);

		jp3 = new JPanel();

		set_bt = new JButton("  비밀번호 변경  ");
		set_bt.setVerticalAlignment(SwingConstants.BOTTOM);
		set_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp3.add(set_bt);

		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.SOUTH);
	}
}
