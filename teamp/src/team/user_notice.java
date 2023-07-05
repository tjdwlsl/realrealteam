package team;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class user_notice extends JPanel {
	private user_panel parent;

	private JPanel jp1, jp2;
	private JScrollPane jsp;
	private JTextArea not_tf;
	private JPanel panel;
	private JPanel panel_1;
	private JButton back_bt;
	private JLabel notice_lb;
	private JLabel lblNewLabel;
	private JTextField n_time;

	public void setn_time(LocalDateTime not_time) {
		if(not_time == null) {
			n_time.setText(null);
		}else {
			n_time.setText(not_time.toString());
		}
	}
	
	public void setn_content(String n_content) {
		not_tf.setText(n_content);
	}
	
	public user_notice(user_panel parent) {
		this();
		this.parent = parent;

		// 뒤로가기 버튼
		back_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("main");
			}
		});
	}

	public user_notice() {
		setSize(new Dimension(600, 600));
		setLayout(new BorderLayout(0, 0));

		jp1 = new JPanel();
		jp1.setBorder(new EmptyBorder(0, 0, 0, 0));
		jp1.setToolTipText("");
		jp1.setLayout(new GridLayout(2, 2, 0, 0));

		jp2 = new JPanel();
		jp2.setLayout(new BorderLayout(0, 0));
		jsp = new JScrollPane();
		jp2.add(jsp, BorderLayout.CENTER);

		add(jp1, BorderLayout.NORTH);
		
		panel = new JPanel();
		jp1.add(panel);
		
		back_bt = new JButton("  뒤로가기  ");
		back_bt.setSize(new Dimension(10, 10));
		back_bt.setHorizontalAlignment(SwingConstants.LEFT);
		back_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panel.add(back_bt);
		
		notice_lb = new JLabel("                   공지사항                                   ");
		notice_lb.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel.add(notice_lb);
		
		panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		jp1.add(panel_1);
		
		lblNewLabel = new JLabel("작성 시간 :");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panel_1.add(lblNewLabel);
		
		n_time = new JTextField();
		n_time.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		n_time.setEditable(false);
		panel_1.add(n_time);
		n_time.setColumns(15);
		add(jp2, BorderLayout.CENTER);
		
		not_tf = new JTextArea();
		not_tf.setEditable(false);
		not_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp2.add(not_tf, BorderLayout.CENTER);
	}
}
