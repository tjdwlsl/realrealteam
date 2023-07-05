package team;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class refund extends JPanel {
	private user_panel parent;

	private JTextField use_tf;
	private JPanel jp1, jp2, jp3, jp4, jp5;
	private JButton back_bt, refund_bt;

	public refund(user_panel parent) {
		this();
		this.parent = parent;

		// 뒤로가기 버튼
		back_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.showCard("mypage");
				((mypage) parent.getP("mypage")).setText();
			}
		});

		// 환불버튼
		refund_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showOptionDialog(getParent(), "이용권을 환불 하시겠습니까?", "환불 선택",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
				if (res == 0) {
					JOptionPane.showMessageDialog(getParent(), "환불 되었습니다.");
					parent.showCard("main");
				}
			}
		});
	}

	/**
	 * Create the panel.
	 */
	public refund() {
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(600, 600));

		// 첫번째 패널
		jp1 = new JPanel();
		FlowLayout fl_jp1 = (FlowLayout) jp1.getLayout();
		fl_jp1.setVgap(15);
		fl_jp1.setHgap(15);
		fl_jp1.setAlignment(FlowLayout.LEFT);

		back_bt = new JButton("  뒤로가기  ");
		back_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp1.add(back_bt);

		add(jp1, BorderLayout.NORTH);

		// 두번째 패널(row=3, GridLayout)
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(3, 1));
		add(jp2, BorderLayout.CENTER);

		// 두번째 패널에 붙일 첫번째 패널(2-1)
		jp3 = new JPanel();
		FlowLayout fl_jp3 = (FlowLayout) jp3.getLayout();
		fl_jp3.setVgap(15);

		JLabel refund_lb = new JLabel("이용권 환불");
		refund_lb.setFont(new Font("맑은 고딕", Font.BOLD, 60));
		// 패널 2-1에 붙일 refundLabel(환불 라벨)
		jp3.add(refund_lb);
		jp2.add(jp3);

		// 두번째 패널에 붙일 두번째 패널(2-2)
		jp4 = new JPanel();
		FlowLayout fl_jp4 = (FlowLayout) jp4.getLayout();
		fl_jp4.setVgap(15);

		JLabel use_lb = new JLabel("현재 이용중인 이용권 : ");
		use_lb.setFont(new Font("맑은 고딕", Font.BOLD, 30));

		use_tf = new JTextField();
		use_tf.setEditable(false);
		use_tf.setBackground(Color.white);
		use_tf.setColumns(15);
		use_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		// 패널 2-2에 붙일 이용권 라벨(useLabel)
		jp4.add(use_lb);
		// 패널 2-2에 붙일 이용권 필드(useTextField)
		jp4.add(use_tf);

		jp2.add(jp4);

		// 두번째 패널에 붙일 세번째 패널(2-3)
		jp5 = new JPanel();
		FlowLayout fl_jp5 = (FlowLayout) jp5.getLayout();
		fl_jp5.setVgap(30);
		fl_jp5.setHgap(50);
		fl_jp5.setAlignment(FlowLayout.RIGHT);
		// 패널 2-3에 붙일 환불 버튼(refundBut)
		refund_bt = new JButton("  이용권 환불  ");
		refund_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp5.add(refund_bt);

		jp2.add(jp5);
	}
}
