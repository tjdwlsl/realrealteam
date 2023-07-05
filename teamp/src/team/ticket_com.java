package team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import mybatis.VO_ticketbuy;

public class ticket_com extends JPanel {
	private user_panel parent;

	private JPanel jp1, jp2, jp3;
	private JButton home_bt, mypage_bt, sel_seat, refund_bt;
	private JTextArea jta;

	public ticket_com(user_panel parent) {
		this();
		this.parent = parent;

		// 홈으로 가기 버튼
		home_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("main");
				jta.setText("");
			}
		});

		// 마이페이지 버튼
		mypage_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("mypage");
				((mypage)parent.getP("mypage")).setText();
				jta.setText("");
			}
		});

		// 좌석 선택 버튼
		sel_seat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("seat");
				jta.setText("");
			}
		});

		// 환불 버튼
		refund_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("refund");
				jta.setText("");
			}
		});
	}

	/**
	 * Create the panel.
	 */
	public ticket_com() {
		setPreferredSize(new Dimension(600, 600));
		setLayout(new GridLayout(3, 1));

		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel com = new JLabel("\r\n이용권 결제 완료");
		com.setVerticalAlignment(SwingConstants.BOTTOM);
		com.setHorizontalAlignment(SwingConstants.CENTER);
		com.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		jp1.add(com);

		jp2 = new JPanel();
		jp2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		jp2.setLayout(new BorderLayout(0, 0));

		jta = new JTextArea(5, 20);
		jta.setEditable(false);
		jta.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		jta.setBackground(Color.white);
		jta.setBorder(new LineBorder(Color.DARK_GRAY));
		jp2.add(jta);
		

		jp3 = new JPanel();

		home_bt = new JButton("  홈으로 이동  ");
		home_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp3.add(home_bt);

		mypage_bt = new JButton("  마이페이지  ");
		mypage_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp3.add(mypage_bt);

		sel_seat = new JButton("  좌석 선택  ");
		sel_seat.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp3.add(sel_seat);

		refund_bt = new JButton("  이용권 환불  ");
		refund_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp3.add(refund_bt);

		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.SOUTH);
	}
		
	  public void ticketCom() {
	  
	  jta.append("\n"); 
	  jta.append("이용권 구매 번호 : " + parent.getT_Vo().getBuy_num() + "\n"); 
	  jta.append("이용권 이름 : " + parent.getC_Vo().getTicket_id() + "\n");
	  jta.append("이용권 구매 날짜 : " + parent.getT_Vo().getBuy_date());	  
	  }
}
