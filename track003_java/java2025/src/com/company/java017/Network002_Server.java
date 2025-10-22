package com.company.java017;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;


///////////////////////////////////////////////////////
// 프로그램기준 읽기 (InputStream > [프로그램] > OutpuStream) 말하기
class Sender extends Thread{			//작업 수행 클래스
	Socket socket;
	DataOutputStream out;
	String who;
	SimpleDateFormat sdf;
	
	
	
	public Sender() {		
	}
	public Sender(Socket socket) {
		this.socket = socket;	// 상대방의 정보
		
		try {
			out = new DataOutputStream(socket.getOutputStream());	// 말하기 기능 키기 
			out.writeUTF("hello......start! >> ");
			// 1. who + 시간
			this.who = "[" + (socket.getPort()==703 ? "Client" : "Server");	// ##
			this.sdf = new SimpleDateFormat("  hh:mm:ss]");					// ##
			
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	
	@Override public void run() {		//작업 수행 클래스 todo
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in))	;	//키보드로 써서 말하기. Scanner 써도됨.
		try {
		while(out != null) {			// 연결이 되어 있다면....
			String data = br.readLine();			// 쓴거 읽어들이고
			String time = sdf.format(System.currentTimeMillis()); // ## 
				out.writeUTF(who+time+data);		// 출력
				}		
			} catch (IOException e) {
				System.out.println("통신을 마무리 합니다. >> " + socket);
				//e.printStackTrace();
			}finally {
				try {
					if(out != null) { out.close(); }
					if(br != null) { br.close(); }
					if(!socket.isClosed()) { socket.close(); }
					
				}
					catch (IOException e) { e.printStackTrace(); }
					}	
	}

}
// 상담사 (서버의 소켓) 		- [말하기 + 듣기]
// 고객 	(클라이언트의 소켓) 	- [말하기 + 듣기]
///////////////////////////////////////////////////////
class Receiver extends Thread{
	Socket socket;
	DataInputStream in;
	public Receiver(Socket socket) {
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());	//들을 준비
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	public Receiver() {}
	
	@Override public void run() {
		
			try {
				while(in != null) {					//실시간으로 계속 듣기
				System.out.println(in.readUTF());		
				}
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("통신을 마무리 합니다. >> " + socket);
			}finally {
				try {
					if(in != null) { in.close(); }
					if(!socket.isClosed()) { socket.close(); }
					
				}
					catch (IOException e) { e.printStackTrace(); }
					}
			}
}


///////////////////////////////////////////////////////
public class Network002_Server {
	public static void main(String[] args) {
		// 1. 서버소켓 (as 센터) [,,,,]
		ServerSocket ascenter = null;
		Socket socket;
		
		// 2. localhost(127.0.0.1) / port(80웹,443웹보안)
		try {
			ascenter = new ServerSocket(703);
			System.out.println("[서버] 1. 서버준비완료 A/S 센터 오픈....");
			
			
		} catch (IOException e) { e.printStackTrace(); }
		
		// 3. 클라이언트 요청(accept) 대기 (요청오면 상담사(socket) 수락 및 연결)
		try {
			System.out.println("[서버] 2. 고객기다리는중....");			// 포트 이미 열어놨는데 다시 f11(실행) 하면 오류 발생
			socket = ascenter.accept();		// 1. 연결요청 대기중 올때까지 stop ,,, 연결이 오면 수락할게 (socket으로 연결)
			
			
			
			// 4. 데이터 주고 받기
			System.out.println("[서버] 4. 고객님 연락와서 상담사(socket)랑 연결");
			Thread sender = new Sender(socket); sender.start();
			Thread receiver = new Receiver(socket);	receiver.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		

	}
}
/****
1. HTTP 통신 - 단방향 통신 (CLIENT [요청]이 있을때, 서버가 [응답]하고 연결이 종료 방식) / JSP, SPRING
2. SOCKET 통신 - 양방향 통신 (특정[포트]를 통해 [실시간]으로 정보 주고받기 - TCP/UDP) / 
3. SOCKET 통신흐름
 1) 서버소켓 (as센터), 포트 바인딩(특정문 열어놓기)
 2) 클라이언트 연결 요청, 수락
 3) 클라이언트 연결(socket) 상담사가 읽어들이기(InputStream > 프로그램기준 > OutpuStream) 말하기
 4) 말하고 주고받기

****/
