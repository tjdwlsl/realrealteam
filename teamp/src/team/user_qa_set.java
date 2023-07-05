package team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mybatis.DAO_qa;
import mybatis.VO_qa;

public class user_qa_set extends JPanel {
	private user_panel parent;

	private JButton back_bt, reg_bt;
	private JTextField title_tf;
	private JPanel panel, panel_1, panel_2, panel_4, panel_3, panel_5, panel_6, panel_7;
	private JScrollPane scrollPane_1, scrollPane;
	private JTextArea qatf, textArea_1;
	private Timestamp time;

	/**
	 * Create the panel.
	 */
	public user_qa_set(user_panel parent) {
		this();
		this.parent = parent;

		// 뒤로가기 버튼
		back_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((mypage) parent.getP("mypage")).setText();
				parent.showCard("mypage");
				qatf.setText("");
				title_tf.setText("");
			}
		});
		// 등록 버튼
		reg_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String txt = qatf.getText();
				String title = title_tf.getText();
				time = new Timestamp(System.currentTimeMillis());
				
				if (txt.equals("")) {
					JOptionPane.showMessageDialog(getParent(), "문의글을 작성해주세요.");
				} else if (title.equals("")) {
					JOptionPane.showMessageDialog(getParent(), "제목을 작성해주세요.");
				} else if (txt != null) {
					int res = JOptionPane.showConfirmDialog(getParent(), "작성하신 내용을 등록하시겠습니까?", "문의작성",
							JOptionPane.OK_CANCEL_OPTION);
					if (res == 0) {
						JOptionPane.showMessageDialog(getParent(), "등록이 완료되었습니다.");						
						VO_qa vo = new VO_qa();
						vo.setUser_id(parent.getC_Vo().getUser_id());
						vo.setQ_time(time);
						vo.setQ_title(title);
						vo.setQ_content(txt);
						vo.setA_content(title);
						vo.setA_time(time);
						vo.setA_title(title);
						vo.setAdmin_id(title);
						DAO_qa.getInsert(vo);
						parent.showCard("main");
						((user_main)parent.getP("main")).initQaList();
						title_tf.setText("");
						qatf.setText("");
					}
				}
			}
		});
	}

	public user_qa_set() {
		setSize(new Dimension(600, 600));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 10, 0, 0));

		back_bt = new JButton("  뒤로가기  ");
		panel.setLayout(new BorderLayout(0, 20));
		back_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		back_bt.setHorizontalAlignment(SwingConstants.LEFT);
		back_bt.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.add(back_bt, BorderLayout.WEST);
		add(panel, BorderLayout.NORTH);

		JLabel qa_lb = new JLabel("                        Q&A");
		qa_lb.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel.add(qa_lb, BorderLayout.CENTER);

		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));

		panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.NORTH);

		JLabel title_lb = new JLabel("글제목 : ");
		title_lb.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		title_tf = new JTextField();
		title_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		title_tf.setBackground(Color.white);
		panel_4.add(title_lb);
		panel_4.add(title_tf);
		title_tf.setColumns(20);

		panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_5.add(scrollPane);

		qatf = new JTextArea();
		qatf.setBackground(Color.white);
		scrollPane.setViewportView(qatf);

		panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(10, 0, 10, 10));
		panel_3.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BorderLayout(0, 0));

		reg_bt = new JButton("      등록      ");
		reg_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		reg_bt.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(reg_bt, BorderLayout.EAST);

		panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));

		scrollPane_1 = new JScrollPane();
		panel_7.add(scrollPane_1);

		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBackground(Color.white);
		scrollPane_1.setViewportView(textArea_1);
	}

}
