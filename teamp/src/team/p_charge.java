package team;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
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

import mybatis.DAO_point;
import mybatis.VO_point;

import java.awt.GridLayout;
import java.awt.FlowLayout;

public class p_charge extends JPanel {
	private user_panel parent;
	private JPanel jp1, jp2, jp3, jp4;
	private JButton back_bt, charge_bt;
	private JLabel jlb2;
	private JTextField charge_tf;
	private JLabel jlb1;
	private Timestamp time;

	/**
	 * Create the panel.
	 */
	public p_charge(user_panel parent) {
		this();
		this.parent = parent;

		// 뒤로가기 버튼
		back_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("point");
				charge_tf.setText("");
			}
		});

		// 충전하기 버튼
		charge_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			charge();
			}
		});

		charge_tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				charge();
			}
		});

	}

	public p_charge() {
		setPreferredSize(new Dimension(600, 600));
		setLayout(new BorderLayout(0, 0));
		setLayout(new GridLayout(4, 1, 0, 0));

		jp1 = new JPanel();
		FlowLayout fl_jp1 = (FlowLayout) jp1.getLayout();
		fl_jp1.setAlignment(FlowLayout.LEFT);
		add(jp1, BorderLayout.NORTH);

		back_bt = new JButton("  뒤로가기  ");
		back_bt.setVerticalAlignment(SwingConstants.TOP);
		back_bt.setHorizontalAlignment(SwingConstants.LEFT);
		back_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp1.add(back_bt);

		jp2 = new JPanel();
		add(jp2, BorderLayout.NORTH);

		jlb1 = new JLabel("포인트 충전");
		jlb1.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		jlb1.setHorizontalAlignment(SwingConstants.CENTER);
		jp2.add(jlb1);

		jp3 = new JPanel();
		jp3.setBorder(new EmptyBorder(30, 0, 0, 0));
		add(jp3, BorderLayout.NORTH);
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		jlb2 = new JLabel("포인트 충전 : ");
		jp3.add(jlb2);
		jlb2.setHorizontalAlignment(SwingConstants.RIGHT);
		jlb2.setFont(new Font("맑은 고딕", Font.BOLD, 25));

		charge_tf = new JTextField();
		jp3.add(charge_tf);
		charge_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		charge_tf.setColumns(10);

		jp4 = new JPanel();
		add(jp4, BorderLayout.SOUTH);

		charge_bt = new JButton("  충전하기  ");
		jp4.add(charge_bt);
		charge_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
	}
	
	public void charge() {
		String charge = charge_tf.getText();
		String num = "[0-9]+";
		time = new Timestamp(System.currentTimeMillis());
		if (charge.equals("")) {
			JOptionPane.showMessageDialog(getParent(), "충전할 포인트를 입력해주세요.");
		} else if (!charge.matches(num)) {
			JOptionPane.showMessageDialog(getParent(), "숫자만 입력해주세요.");
			charge_tf.setText("");
			charge_tf.requestFocus();
		} else {
			JOptionPane.showMessageDialog(getParent(), charge + "포인트를 충전했습니다.");
			VO_point vo = new VO_point();
			vo.setCharge_date(time);
			vo.setP_attribute("충전");
			vo.setPoint(charge);
			vo.setUser_id(parent.getC_Vo().getUser_id());
			DAO_point.getPInsert(vo);
			int sum = Integer.parseInt(parent.getC_Vo().getPoint()) + Integer.parseInt(charge);
			parent.getC_Vo().setPoint(Integer.toString(sum));
			((user_point)parent.getP("point")).setP();
			parent.showCard("point");
			charge_tf.setText("");
		}
	}
}
