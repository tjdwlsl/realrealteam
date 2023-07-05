package team;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mybatis.DAO_notice;
import mybatis.DAO_qa;
import mybatis.VO_notice;
import mybatis.VO_point;
import mybatis.VO_qa;

public class user_main extends JPanel{
	private user_panel parent;

	private JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8, jp9, jp10, jp11, jp12, jp13, jp14, jp15;
	private JList qa_list, notice_list;
	private JScrollPane notice_sp, qa_sp;
	private JLabel cafe_name, welcome_lb;
	private JButton seat_bt, buy_bt, mypage_bt, point_bt;
	private JLabel notice_lb;
	private JLabel qa_lb;

	private List<VO_qa> list;
	private List<VO_notice> a_list;	
	private VO_qa currentqa;
	private VO_notice currentn;
	
	/**
	 * Create the panel.
	 */
	public user_main(user_panel parent) {
		this();
		this.parent = parent;

		// 좌석 선택 버튼
		seat_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("sel_time");
			}
		});

		// 이용권 구매 버튼
		buy_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("buy");
			}
		});

		// 마이페이지 버튼
		mypage_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("mypage");
				((mypage)parent.getP("mypage")).setText();
			}
		});

		point_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.showCard("point");	
				((user_point)parent.getP("point")).setP();
			}
		});

		// q&a 이동
		qa_list.addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = qa_list.getSelectedIndex();
				if(index != -1) {
				user_qa qa = (user_qa)parent.getP("qa");
                currentqa = list.get(index);
                qa.settitle(currentqa.getQ_title());
                qa.setcontent(currentqa.getQ_content());
                qa.setid(currentqa.getUser_id());
                qa.settime(currentqa.getQ_time().toString());
                qa.setA_title(currentqa.getA_title());                
                qa.setA_content(currentqa.getA_content());
                qa.setA_time(currentqa.getA_time());
                qa.setA_id(currentqa.getAdmin_id());
                
                if(currentqa.getUser_id().equals(parent.getC_Vo().getUser_id())) {
                	qa.set_qa_bt(true);
                }else {
                qa.set_qa_bt(false);
                }
                parent.showCard("qa");
				}                
			}
		});
		// 공지사항 이동
		notice_list.addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = notice_list.getSelectedIndex();
				if(index != -1) {
                user_notice notice = (user_notice)parent.getP("notice");
                currentn = a_list.get(index);
                notice.setn_content(currentn.getNot_content());
                notice.setn_time(currentn.getNot_time());
                parent.showCard("notice");
				}              
			}
		});
	
	}

	public user_main() {
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(600, 600));

		jp1 = new JPanel();
		add(jp1, BorderLayout.CENTER);
		jp1.setLayout(new GridLayout(0, 2, 0, 0));

		jp2 = new JPanel();
		jp1.add(jp2);
		jp2.setLayout(new BorderLayout(0, 0));

		jp3 = new JPanel();
		jp2.add(jp3);
		jp3.setLayout(new BorderLayout(0, 0));

		jp4 = new JPanel();
		jp4.setSize(new Dimension(0, 600));

		jp5 = new JPanel();
		jp4.add(jp5);
		jp5.setLayout(new GridLayout(3, 1, 0, 0));

		jp6 = new JPanel();
		jp5.add(jp6);
		jp6.setLayout(new GridLayout(0, 1, 0, 0));

		cafe_name = new JLabel("Mind Nest");
		cafe_name.setVerticalAlignment(SwingConstants.BOTTOM);
		cafe_name.setHorizontalAlignment(SwingConstants.CENTER);
		cafe_name.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		jp6.add(cafe_name);

		jp7 = new JPanel();
		jp7.setBorder(new EmptyBorder(40, 0, 0, 0));
		jp5.add(jp7);
		jp7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		welcome_lb = new JLabel();
		welcome_lb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		jp7.add(welcome_lb);

		jp8 = new JPanel();
		jp8.setBorder(new EmptyBorder(0, 50, 40, 50));
		jp5.add(jp8);
		jp8.setLayout(new GridLayout(0, 1, 0, 0));

		seat_bt = new JButton("  좌석 선택  ");
		seat_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp8.add(seat_bt);
		jp3.add(jp4);
		jp4.setLayout(new GridLayout(2, 1));

		jp13 = new JPanel();
		jp1.add(jp13);
		jp13.setLayout(new GridLayout(2, 0, 0, 0));

		jp14 = new JPanel();
		jp14.setBorder(new EmptyBorder(40, 20, 40, 20));
		jp13.add(jp14);
		jp14.setLayout(new BorderLayout(0, 0));

		jp4.add(jp5, BorderLayout.NORTH);

		jp9 = new JPanel();
		jp4.add(jp9);
		jp9.setLayout(new GridLayout(0, 1, 0, 0));

		jp10 = new JPanel();
		jp10.setBorder(new EmptyBorder(0, 50, 40, 50));
		jp9.add(jp10);
		jp10.setLayout(new GridLayout(0, 1, 0, 0));

		buy_bt = new JButton("  이용권 구매  ");
		buy_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp10.add(buy_bt);

		jp11 = new JPanel();
		jp11.setBorder(new EmptyBorder(0, 50, 40, 50));
		jp9.add(jp11);
		jp11.setLayout(new GridLayout(0, 1, 0, 0));

		point_bt = new JButton("포인트");
		point_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp11.add(point_bt);

		jp12 = new JPanel();
		jp12.setBorder(new EmptyBorder(0, 50, 40, 50));
		jp9.add(jp12);
		jp12.setLayout(new GridLayout(0, 1, 0, 0));

		mypage_bt = new JButton("  마이페이지  ");
		mypage_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jp12.add(mypage_bt);

		notice_list = new JList();
		notice_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		notice_list.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		notice_sp = new JScrollPane();
		notice_sp.setViewportView(notice_list);
		jp14.add(notice_sp, BorderLayout.CENTER);

		notice_lb = new JLabel("공지사항");
		notice_lb.setHorizontalAlignment(SwingConstants.CENTER);
		notice_lb.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jp14.add(notice_lb, BorderLayout.NORTH);

		jp15 = new JPanel();
		jp15.setBorder(new EmptyBorder(0, 20, 60, 20));
		jp13.add(jp15);
		jp15.setLayout(new BorderLayout(0, 0));

		qa_list = new JList();
		qa_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		qa_list.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		qa_sp = new JScrollPane();
		qa_sp.setViewportView(qa_list);
		jp15.add(qa_sp, BorderLayout.CENTER);

		qa_lb = new JLabel("Q&A");
		qa_lb.setHorizontalAlignment(SwingConstants.CENTER);
		qa_lb.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jp15.add(qa_lb, BorderLayout.NORTH);
	}
		
	public VO_qa getCurrentqa() {
		return currentqa;
	}

	public void setCurrentqa(VO_qa currentqa) {
		this.currentqa = currentqa;
	}
	
	public void setqalist(String[] arr) {
		qa_list.setListData(arr);
	}
	
	public void setalist(String[] arr) {
		notice_list.setListData(arr);
	}
	
	public void initQaList() {
       list = DAO_qa.getSelectAll();
       if(list.size() > 0) {
    	   String[] titleArr = new String[list.size()];
    	   int i = 0;
    	  for (VO_qa k : list) {
			titleArr[i++] = k.getQ_title();
		}
    	  qa_list.setListData(titleArr);
		}else {
			qa_list.setListData(new String[] {});
		}
}
	public void initnoticeList() {
		a_list = DAO_notice.getAll();
		if(a_list.size() > 0) {
			String[] titleArr = new String[a_list.size()];
			int i = 0;
			for (VO_notice k : a_list) {
				titleArr[i++] = k.getNot_title();
			}
			notice_list.setListData(titleArr);
		}else {
			notice_list.setListData(new String[] {});
		}
	}
	
	public void set_id(String id) {
			welcome_lb.setText(id + "님 환영합니다!");
	}
}
