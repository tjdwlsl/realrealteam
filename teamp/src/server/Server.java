package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
	private ServerSocket ss = null;
	
	public Server() {
		try {
			ss = new ServerSocket(10016);
			System.out.println("대기해");
			new Thread(this).start();
		} catch (Exception e) {
		
		}
		
	}
	@Override
	public void run() {
		while(true) {
			try {
				Socket s = ss.accept();
				CpClient cc = new CpClient(s, this);
				cc.start();
			} catch (Exception e) {
			
			}
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}
	
	
}
