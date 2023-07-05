package team;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class seat_com extends JPanel {
	private user_panel parent;

	private JPanel jp1, jp2, jp3, jp4;
	private JTextArea jta;
	private JScrollPane jsp;
	private JButton home_bt, mypage_bt;

	/**
	 * Create the panel.
	 */
	public seat_com(user_panel parent) {
		this();
		this.parent = parent;

		// 홈으로 이동 버튼
		home_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.showCard("main");
			}
		});

		// 마이페이지 이동 버튼
		mypage_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.showCard("mypage");
				((mypage)parent.getP("mypage")).setText();
			}
		});
	}

	public seat_com() {
		setLayout(new GridLayout(0, 1));
		setPreferredSize(new Dimension(600, 600));

		jp1 = new JPanel();
		add(jp1);
		jp1.setLayout(new GridLayout(0, 1));

		JLabel seat_lb = new JLabel("좌석 선택 완료");
		seat_lb.setHorizontalAlignment(SwingConstants.CENTER);
		seat_lb.setFont(new Font("맑은 고딕", Font.PLAIN, 60));
		jp1.add(seat_lb);

		jp2 = new JPanel();
		jp2.setBorder(new EmptyBorder(0, 30, 20, 70));
		add(jp2);
		jp2.setLayout(new GridLayout(1, 0, 0, 0));

		jp3 = new JPanel();
		jta = new JTextArea(10, 15);
		jta.setTabSize(10);
		jta.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jta.setBackground(Color.white);
		jta.setEditable(false);
		jsp = new JScrollPane(jta, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jp3.add(jsp);
		jp2.add(jp3);

		jp4 = new JPanel();
		jp2.add(jp4);
		jp4.setLayout(new GridLayout(3, 20, 20, 30));

		home_bt = new JButton("홈으로 이동");
		home_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp4.add(home_bt);

		mypage_bt = new JButton("마이 페이지");
		mypage_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp4.add(mypage_bt);
	}

}
