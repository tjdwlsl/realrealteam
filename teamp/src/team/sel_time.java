package team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.raven.datechooser.DateChooser;

public class sel_time extends JPanel {
	private user_panel parent;

	private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9, panel10;
	private DateChooser date;
	private JButton backBtn, choiceBtn;
	private JComboBox<String> useTimeJcom, startTimeJcom;

	/**
	 * Create the panel.
	 */
	public sel_time(user_panel parent) {
		this();
		this.parent = parent;

		// 시작시간 콤보박스 리스너
		startTimeJcom.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// 정보 저장
			}
		});

		// 사용시간 콤보박스 리스너
		useTimeJcom.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// 정보 저장
			}
		});

		// 뒤로가기 버튼 리스너
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("main");
				date.toDay();
				useTimeJcom.setSelectedIndex(0);
				startTimeJcom.setSelectedIndex(0);
			}
		});

		// 선택 버튼 리스너
		choiceBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showOptionDialog(null, "@@월 @@일 @@시간을 선택하시겠습니까?", "날짜/시간 선택",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
				if (res == 0) {
					parent.showCard("seat");
				} else if (res == 1) {
					// 날짜/시간 선택창 남아있기
				}
			}
		});
	}

	public sel_time() {
		setPreferredSize(new Dimension(600, 600));
		setLayout(new BorderLayout(0, 0));

		panel1 = new JPanel();
		add(panel1, BorderLayout.NORTH);
		panel1.setLayout(new BorderLayout(10, 10));

		panel2 = new JPanel();
		panel2.setBorder(new EmptyBorder(10, 20, 0, 0));
		panel1.add(panel2, BorderLayout.WEST);
		panel2.setLayout(new BorderLayout(0, 0));

		backBtn = new JButton("뒤로가기");
		backBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panel2.add(backBtn, BorderLayout.NORTH);

		panel3 = new JPanel();
		panel3.setBorder(new EmptyBorder(10, 0, 0, 60));
		panel1.add(panel3, BorderLayout.CENTER);
		panel3.setLayout(new BorderLayout(0, 10));

		JLabel dateChoiceLabel = new JLabel("날짜/시간 선택");
		dateChoiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateChoiceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		panel3.add(dateChoiceLabel, BorderLayout.NORTH);

		panel4 = new JPanel();

		add(panel4, BorderLayout.CENTER);
		panel4.setLayout(new GridLayout(1, 2, 0, 0));

		panel5 = new JPanel();
		panel5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel4.add(panel5);
		panel5.setLayout(new BorderLayout(0, 0));

		date = new DateChooser();
		panel5.add(date, BorderLayout.CENTER);

		panel6 = new JPanel();
		panel6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel4.add(panel6);
		panel6.setLayout(new GridLayout(3, 1));

		panel7 = new JPanel();
		panel6.add(panel7);
		panel7.setLayout(new GridLayout(2, 1, 0, 0));

		panel8 = new JPanel();
		panel8.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel7.add(panel8);

		JLabel startTimeLabel = new JLabel("시작시간 : ");
		startTimeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		panel8.add(startTimeLabel);

		String[] startTimeArr = { "00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00",
				"04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30",
				"10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00",
				"15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30",
				"21:00", "21:30", "22:00", "22:30", "23:00", "23:30" };
		startTimeJcom = new JComboBox<>(startTimeArr);

		panel8.add(startTimeJcom);

		panel9 = new JPanel();
		panel9.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel7.add(panel9);

		JLabel useTimeLabel = new JLabel("사용 시간 : ");
		useTimeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel9.add(useTimeLabel);

		String[] useTimeArr = { "1시간", "2시간", "3시간", "4시간", "5시간", "6시간", "7시간", "8시간", "9시간", "10시간", "11시간", "12시간" };
		useTimeJcom = new JComboBox<>(useTimeArr);
		panel9.add(useTimeJcom);

		panel10 = new JPanel();
		panel6.add(panel10);

		choiceBtn = new JButton("  선택  ");
		choiceBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panel10.add(choiceBtn);
	}
}
