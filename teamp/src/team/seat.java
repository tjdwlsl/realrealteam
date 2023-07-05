package team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class seat extends JPanel {
	private user_panel parent;

	private JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7;
	private JButton back_bt, seatChoiceBut;
	private JLabel seat_lb, seatUselabel;
	private JTextField jta1, jta2, jta3;
	private JLabel[] searArr;

	class myMouseAdapter extends MouseAdapter {
		JLabel jlParent;

		public myMouseAdapter(JLabel parent) {
			this.jlParent = parent;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (jlParent.getBackground() == Color.RED || jlParent.getBackground() == Color.YELLOW) {
				JOptionPane.showMessageDialog(getParent(), "좌석을 선택할 수 없습니다.", "좌석 선택 불가",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				int res = JOptionPane.showOptionDialog(null, "좌석을 선택하시겠습니까?", "좌석 선택 여부", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, null, null);
				if (res == 0) {
					parent.showCard("seat_com");
				} else if (res == 1) {
					// 그대로 있기
				} else {
					JOptionPane.showMessageDialog(getParent(), "좌석을 선택하세요", "좌석 미입력", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	};

	public seat(user_panel parent) {
		this();
		this.parent = parent;
		searArr = new JLabel[30];
		jp5.setLayout(new GridLayout(5, 6, 10, 10));

		Integer i = 0;
		for (JLabel jLabel : searArr) {
			jLabel = new JLabel();

			jLabel.setOpaque(true);
			jLabel.setBackground(new Color(255, 255, 255));
			jLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			jLabel.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel.setName((++i).toString());
			jLabel.setText(i.toString());
			jLabel.addMouseListener(new myMouseAdapter(jLabel));
			jp5.add(jLabel);
		}

		back_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("sel_time");
			}
		});

	}

	public seat() {
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(600, 600));

		jp1 = new JPanel();
		FlowLayout fl_jp1 = (FlowLayout) jp1.getLayout();
		fl_jp1.setHgap(15);
		fl_jp1.setAlignment(FlowLayout.LEFT);
		add(jp1, BorderLayout.NORTH);

		back_bt = new JButton("  뒤로가기  ");
		back_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp1.add(back_bt);

		jp2 = new JPanel();
		add(jp2, BorderLayout.CENTER);
		jp2.setLayout(new GridLayout(3, 0, 0, 0));

		jp3 = new JPanel();
		jp2.add(jp3);

		seat_lb = new JLabel("좌석 선택");
		seat_lb.setFont(new Font("맑은 고딕", Font.BOLD, 70));
		jp3.add(seat_lb);

		jp4 = new JPanel();
		jp2.add(jp4);
		jp4.setLayout(new GridLayout(0, 2, 0, 0));

		jp5 = new JPanel();
		jp5.setBorder(new EmptyBorder(10, 10, 10, 10));
		jp4.add(jp5);
		jp5.setLayout(new GridLayout(2, 2, 10, 10));

		jp6 = new JPanel();
		jp6.setBorder(new EmptyBorder(10, 30, 10, 30));
		jp4.add(jp6);
		jp6.setLayout(new GridLayout(3, 2, 0, 10));

		seatUselabel = new JLabel("자리 있음 : ");
		seatUselabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jp6.add(seatUselabel);

		jta1 = new JTextField();
		jta1.setBackground(Color.yellow);
		jta1.setEditable(false);
		jp6.add(jta1);
		jta1.setColumns(10);

		JLabel seatNullJlabel = new JLabel("자리 없음 : ");
		seatNullJlabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jp6.add(seatNullJlabel);

		jta2 = new JTextField();
		jta2.setBackground(Color.white);
		jp6.add(jta2);
		jta2.setColumns(10);

		JLabel seatCloseLabel = new JLabel("자리 닫힘 : ");
		seatCloseLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		jp6.add(seatCloseLabel);

		jta3 = new JTextField();
		jta3.setBackground(Color.red);
		jp6.add(jta3);
		jta3.setColumns(10);

		jp7 = new JPanel();
		jp7.setBorder(new EmptyBorder(40, 0, 0, 60));
		FlowLayout fl_jp7 = (FlowLayout) jp7.getLayout();
		fl_jp7.setVgap(20);
		fl_jp7.setHgap(27);
		fl_jp7.setAlignment(FlowLayout.RIGHT);
		jp2.add(jp7);

		seatChoiceBut = new JButton("  좌석선택  ");
		seatChoiceBut.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		jp7.add(seatChoiceBut);
	}
}
