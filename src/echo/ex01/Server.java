package echo.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
	
		ServerSocket serverSocket = new ServerSocket();
		
		// bind: IP, port 설정
		serverSocket.bind(new InetSocketAddress("192.168.0.12", 1001));
		
		System.out.println("<서버 시작>");
		System.out.println("=================================");
		System.out.println("연결을 기다리고 있습니다.");
		
		// accept: 대기하고 있다가 요청이 오면 실행 (소켓 생성 그리고 주소 전달)
		Socket socket = serverSocket.accept();
		
		System.out.println("연결을 기다리고 있습니다.");
		
		// 메시지 받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		// 메시지 보내기용 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter isw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(isw);
		
		// 메시지 받기
		String str = br.readLine();
		System.out.println("서버가 받은 메시지: "+str);
		
		// 메시지 보내기
		String msg = "서버에서 보내는 메시지";
		bw.write(msg);
		bw.newLine();
		bw.flush();
		
		
		socket.close();
		serverSocket.close();
		
	}
}
