package team;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import mybatis.DAO;
import server.Protocol;


public class user_frame extends JFrame implements Runnable {
	private CardLayout cl;
	private JPanel contentPane;
	private user_panel panel;
	private Socket s;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	

	/**
	 * 1 Launch the application.
	 */
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_frame frame = new user_frame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public user_frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mind Nest StudyCafe");
		setBounds(0, 0, 600, 600);

		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(600, 600));

		setContentPane(contentPane);

		FlowLayout fl_contentPane = new FlowLayout(FlowLayout.CENTER, 5, 5);
		contentPane.setLayout(fl_contentPane);

		JPanel cl_p = new JPanel();
		cl_p.setPreferredSize(new Dimension(600, 600));
		contentPane.add(cl_p);
		cl = new CardLayout();
		cl_p.setLayout(cl);

		panel = new user_panel(this);
		cl_p.add("second", panel);
		connected();
		
	}
	public boolean connected() {
		boolean value = true;
		try {
			s = new Socket("192.168.0.56", 10016);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
			new Thread(this).start();
			return value;
		} catch (Exception e) {
		}
		return false;
	}
	
	public boolean sendProtocol(Protocol input) {
		boolean result = true;
		try {
			out.writeObject(input);
			out.flush();
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	private void closed() {
		try {
			out.close();
			in.close();
			s.close();
			System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public void run() {
		esc: while (true) {
			try {
				Object obj = in.readObject();
				if (obj != null) {
					Protocol p = (Protocol) obj;
					switch (p.getCmd()) {
					// 종료
					case 0:
						break esc;
					// 로그인
					case 1: 
						panel.showCard("main");
						break;
					// 회원가입(중복확인)
					case 2:
						if(p.getMsg().equals("중복")) {
							JOptionPane.showInternalMessageDialog(getParent(), "이미 가입 되어있는 아이디입니다.\\n 다시 입력해주세요.");
						}else {
							JOptionPane.showInternalMessageDialog(getParent(), "사용 가능한 아이디입니다.");
						}break;
						
					// 회원가입(회원가입 버튼)
					case 3:
						if(p.getMsg().equals("가입완료")) {
							JOptionPane.showInternalMessageDialog(getParent(), "Mind Nest에 오신 것을 환영합니다!");
						}else if(p.getMsg().equals("못함")){
							JOptionPane.showInternalMessageDialog(getParent(), "가입 몬해요");
						}
						break;
						
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		closed();
	}
}
