package team;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import mybatis.DAO_point;
import mybatis.VO_point;

public class point_refund extends JPanel {
	private user_panel parent;

	private JTextField refund_tf;
	private JPanel jp1, jp2, jp3, jp4, jp5;
	private JButton back_bt, refund_bt;
	private Timestamp time;

	public point_refund(user_panel parent) {
		this();
		this.parent = parent;

		// 뒤로가기 버튼
		back_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("point");
				refund_tf.setText("");
			}
		});

		// 환불버튼
		refund_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(getParent(), "포인트를 환불 받으시겠습니까?", "포인트 환불",
						JOptionPane.OK_CANCEL_OPTION);
				time = new Timestamp(System.currentTimeMillis());
				while (res == 0) {
					String set = JOptionPane.showInputDialog("포인트 입력 : ");
					if (set == null) {
						break;
					} else if (set.equals("")) {
						JOptionPane.showMessageDialog(getParent(), "포인트를 입력해주세요.");
					} else if (set != null) {
						String num = "[0-9]+";
						if (set.matches(num)) {
							JOptionPane.showMessageDialog(getParent(), set + "포인트 환불이 완료되었습니다.");
							VO_point vo = new VO_point();
							vo.setCharge_date(time);
							vo.setP_attribute("환불");
							vo.setPoint("-" + set);
							vo.setUser_id(parent.getC_Vo().getUser_id());
							DAO_point.getPInsert(vo);
							int sum = Integer.parseInt(parent.getC_Vo().getPoint()) + Integer.parseInt("-" + set);
							parent.getC_Vo().setPoint(Integer.toString(sum));
							refund_tf();
							parent.showCard("point");
							break;
						} else {
							JOptionPane.showMessageDialog(getParent(), "숫자만 입력해주세요.");
						}
					}
				}
			}
		});
	}

	/**
	 * Create the panel.
	 */
	public point_refund() {
		setPreferredSize(new Dimension(600, 600));
		setLayout(new GridLayout(3, 1));

		jp1 = new JPanel();
		add(jp1);
		jp1.setLayout(new GridLayout(2, 1, 0, 0));

		jp2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) jp2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		jp1.add(jp2);

		back_bt = new JButton("  뒤로가기  ");
		back_bt.setVerticalAlignment(SwingConstants.TOP);
		back_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		back_bt.setAlignmentY(1.0f);
		back_bt.setAlignmentX(1.0f);
		jp2.add(back_bt);

		jp3 = new JPanel();
		jp3.setBorder(new EmptyBorder(20, 0, 0, 0));
		jp1.add(jp3);

		JLabel refund_lb_1 = new JLabel("포인트 환불");
		refund_lb_1.setHorizontalAlignment(SwingConstants.CENTER);
		refund_lb_1.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		jp3.add(refund_lb_1);

		jp4 = new JPanel();
		jp4.setBorder(new EmptyBorder(90, 0, 0, 0));
		add(jp4);
		jp4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel point_lb = new JLabel("현재 포인트 : ");
		point_lb.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		jp4.add(point_lb);

		refund_tf = new JTextField();
		refund_tf.setEditable(false);
		refund_tf.setHorizontalAlignment(SwingConstants.CENTER);
		refund_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		refund_tf.setBackground(Color.white);
		jp4.add(refund_tf);
		refund_tf.setColumns(10);

		jp5 = new JPanel();
		add(jp5);
		jp5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		refund_bt = new JButton("  포인트 환불  ");
		refund_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp5.add(refund_bt);
	}

	public void refund_tf() {
		refund_tf.setText(parent.getC_Vo().getPoint());
	}
}
