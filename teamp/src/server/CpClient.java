package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import mybatis.DAO;
import mybatis.VO;
import team.user_panel;

public class CpClient extends Thread {
	private Socket s = null;
	private ObjectOutputStream out = null;
	private ObjectInputStream in = null;
	private Server server = null;

	public CpClient(Socket s, Server server) {
		this.s = s;
		this.server = server;
		try {
			in = new ObjectInputStream(s.getInputStream());
			out = new ObjectOutputStream(s.getOutputStream());
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
						out.writeObject(p);
						out.flush();
						break esc;
					// 로그인
					case 1:
						if (p.getId() != null && p.getId().length() > 0) {
							VO vo = DAO.getOne(p.getId());
							if ((vo != null && p.getPw().equals(vo.getUser_password()))) {
								out.writeObject(p);
								out.flush();
							}
						}
						break;
					// 회원가입(중복확인)
					case 2:
						if (p.getId() != null && p.getId().length() > 0) {
							VO vo = DAO.getOne(p.getId());
							if(vo != null) {
								p.setMsg("중복");
								out.writeObject(p);
								out.flush();
							}else if(vo == null){
								p.setMsg("중복아님");
								out.writeObject(p);
								out.flush();
							}
						}break;
					//회원가입(회원가입 완료)
					case 3:
						 {
					
					}
						break;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

}
