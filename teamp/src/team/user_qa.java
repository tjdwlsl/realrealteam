package team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mybatis.DAO;
import mybatis.DAO_qa;
import mybatis.VO;
import mybatis.VO_qa;

public class user_qa extends JPanel {
	private user_panel parent;

	private JButton back_bt;
	private JTextField title_tf, id_tf, time_tf;
	private JPanel jp1, jp2, panel_2, jp3, jp5, jp4, jp6, jp8;
	private JScrollPane scrollPane_1, scrollPane;
	private JTextArea qatf, a_tf;
	private JButton update_bt;
	private JButton delete_bt;
	private JPanel jp7;
	private JLabel a_title_lb;
	private JTextField a_title_fd;
	private JLabel a_id_lb;
	private JTextField a_id_fd;
	private JLabel a_time_lb;
	private JTextField a_time_fd;
	private VO_qa vo_q;
	private Timestamp q_time;
	
	private List<VO_qa> list;
	
	public void settitle(String title) {
		title_tf.setText(title);
	}
	public void setcontent(String content) {
		qatf.setText(content);
	}
	public void setid(String id) {
		id_tf.setText(id);
	}
	public void settime(String timestamp) {
		time_tf.setText(timestamp);
	}
	public void setA_content(String A_content) {
		a_tf.setText(A_content);
	}
	public void setA_title(String A_title) {
		a_title_fd.setText(A_title);
	}
	public void setA_id(String A_id) {
		a_id_fd.setText(A_id);
	}
	public void setA_time(Timestamp timestamp) {
		if(timestamp == null) {
			a_time_fd.setText(null);
		}else {
		a_time_fd.setText(timestamp.toString());
		}
	}

	public user_qa(user_panel parent) {
		this();
		this.parent = parent;

		// 뒤로가기 버튼
		back_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("main");
				((user_main)parent.getP("main")).initQaList();
				update_bt.setText("수정");
				qatf.setEditable(false);
				title_tf.setEditable(false);
			}
		});
		// 수정 버튼
		update_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String txt = qatf.getText();
				JButton obj = (JButton) (e.getSource());
				String msg = obj.getText();
				q_time = new Timestamp(System.currentTimeMillis());
				if (txt != null) {
					int res = JOptionPane.showConfirmDialog(getParent(), "작성하신 내용을 수정하시겠습니까?", "수정",
							JOptionPane.OK_CANCEL_OPTION);
					if (res == 0) {
						String qa = qatf.getText();
					//	String id = id_tf.getText();
						qatf.setEditable(true);
						title_tf.setEditable(true);
						update_bt.setText("수정완료");
						if (qa.equals("")) {
							JOptionPane.showMessageDialog(getParent(), "수정하실 내용을 입력해주세요.");
						} else if (msg.equals("수정완료")) {
							vo_q = new VO_qa();
							vo_q.setQ_title(title_tf.getText());
							vo_q.setQ_time(q_time);
							vo_q.setQ_content(qatf.getText());
							vo_q.setQa_num(((user_main)(parent.getP("main"))).getCurrentqa().getQa_num());
							DAO_qa.getUpdate(vo_q);
							JOptionPane.showMessageDialog(getParent(), "내용이 수정되었습니다.");
							parent.showCard("main");
							qatf.setEditable(false);
							title_tf.setEditable(false);
							update_bt.setText("수정");
							((user_main)parent.getP("main")).initQaList();
						}
						}
					}
			}
		});

		// 삭제 버튼
		delete_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String txt = qatf.getText();
				if (txt != null) {
					int res = JOptionPane.showConfirmDialog(getParent(), "작성하신 내용을 삭제하시겠습니까?", "삭제",
							JOptionPane.OK_CANCEL_OPTION);
					if (res == 0) {
				 int result = DAO_qa.getDelete(((user_main)parent.getP("main")).getCurrentqa().getQa_num());	
						if(result > 0) {
						JOptionPane.showMessageDialog(getParent(), "삭제가 완료되었습니다.");
						parent.showCard("main");	
						((user_main)parent.getP("main")).initQaList();				
						}
					}
				}
			}
		});
	}

	public user_qa() {
		setSize(new Dimension(600, 600));
		setLayout(new BorderLayout(0, 0));

		jp1 = new JPanel();
		jp1.setBorder(new EmptyBorder(0, 5, 0, 0));
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		back_bt = new JButton("  뒤로가기  ");
		back_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp1.add(back_bt);
		add(jp1, BorderLayout.NORTH);

		JLabel qa_lb = new JLabel("                   Q&A               ");
		qa_lb.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jp1.add(qa_lb);
		
				update_bt = new JButton("  수정  ");
				update_bt.setHorizontalAlignment(SwingConstants.RIGHT);
				jp1.add(update_bt);
				update_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
				
				delete_bt = new JButton("  삭제  ");
				delete_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
				jp1.add(delete_bt);

		jp2 = new JPanel();
		add(jp2, BorderLayout.CENTER);
		jp2.setLayout(new GridLayout(2, 1, 0, 0));

		panel_2 = new JPanel();
		jp2.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		jp3 = new JPanel();
		panel_2.add(jp3, BorderLayout.NORTH);

		JLabel title_lb = new JLabel("글제목 : ");
		title_tf = new JTextField();
		title_tf.setEditable(false);
		title_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		title_tf.setBackground(Color.white);
		jp3.add(title_lb);
		jp3.add(title_tf);
		title_tf.setColumns(10);

		JLabel id_lb = new JLabel("작성자 : ");
		id_tf = new JTextField();
		id_tf.setEditable(false);
		id_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		id_tf.setBackground(Color.white);
		jp3.add(id_lb);
		jp3.add(id_tf);
		id_tf.setColumns(10);

		JLabel time_lb = new JLabel("작성시간 : ");
		time_tf = new JTextField();
		time_tf.setEditable(false);
		time_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		time_tf.setBackground(Color.white);
		jp3.add(time_lb);
		jp3.add(time_tf);
		time_tf.setColumns(10);

		jp4 = new JPanel();
		panel_2.add(jp4, BorderLayout.CENTER);
		jp4.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		jp4.add(scrollPane);

		qatf = new JTextArea();
		qatf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		qatf.setBackground(Color.white);
		scrollPane.setViewportView(qatf);
		qatf.setEditable(false);

		jp5 = new JPanel();
		jp2.add(jp5);
		jp5.setLayout(new BorderLayout(0, 0));

		jp6 = new JPanel();
		jp6.setBorder(new EmptyBorder(10, 0, 10, 0));
		jp5.add(jp6, BorderLayout.NORTH);
		jp6.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel answer = new JLabel("             답변             ");
		answer.setHorizontalAlignment(SwingConstants.CENTER);
		answer.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jp6.add(answer);
		
		jp7 = new JPanel();
		jp6.add(jp7);
		
		a_title_lb = new JLabel("글제목 : ");
		jp7.add(a_title_lb);
		
		a_title_fd = new JTextField();
		a_title_fd.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		a_title_fd.setBackground(Color.white);		
		a_title_fd.setEditable(false);
		a_title_fd.setColumns(10);
		jp7.add(a_title_fd);
		
		a_id_lb = new JLabel("작성자 : ");
		jp7.add(a_id_lb);
		
		a_id_fd = new JTextField();
		a_id_fd.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		a_id_fd.setBackground(Color.white);
		a_id_fd.setEditable(false);
		a_id_fd.setColumns(10);
		jp7.add(a_id_fd);
		
		a_time_lb = new JLabel("작성시간 : ");
		jp7.add(a_time_lb);
		
		a_time_fd = new JTextField();
		a_time_fd.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		a_time_fd.setBackground(Color.white);
		a_time_fd.setBackground(Color.white);
		a_time_fd.setEditable(false);
		a_time_fd.setColumns(10);
		jp7.add(a_time_fd);

		jp8 = new JPanel();
		jp5.add(jp8, BorderLayout.CENTER);
		jp8.setLayout(new BorderLayout(0, 0));

		scrollPane_1 = new JScrollPane();
		jp8.add(scrollPane_1);

		a_tf = new JTextArea();
		a_tf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		a_tf.setBackground(Color.white);
		a_tf.setEditable(false);
		scrollPane_1.setViewportView(a_tf);
	}
	
	public void set_qa_bt(boolean enable) {
		update_bt.setEnabled(enable);
		delete_bt.setEnabled(enable);
	}
}
