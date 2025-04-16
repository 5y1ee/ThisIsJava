package ch19.sec03.exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

	private static ServerSocket serverSocket = null;
	
	public static void main(String[] args) {
		System.out.println("-----------------q to exit----------------------");
		
		startServer();
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String key = scanner.nextLine();
			if (key.toLowerCase().equals("q")) {
				break;
			}
		}
		scanner.close();
		
		stopServer();
		
	}
	
	public static void startServer() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작됨");
					
					while (true) {
						System.out.println("\n[서버] 연결 요청 기다림\n");
						
						Socket socket = serverSocket.accept();
						
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[서버]" + isa.getHostName() + "의 연결 요청을 수락함.");
						
						
						// 데이터 받기
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						String message = dis.readUTF();
						
						// 데이터 보내기
						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
						dos.writeUTF(message);
						dos.flush();
						System.out.println("[서버] 받은 데이터를 다시 보냄 : " + message);
						
						// 연결 끊기
						socket.close();
						System.out.println("[서버]" + isa.getHostString() + "의 연결을 끊음.");
					}
					
				} catch (IOException e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		
		thread.start();
		
		
	}
	
	public static void stopServer() {
		try {
			serverSocket.close();
			System.out.println("[서버] 종료됨");
		} catch (IOException e1) {}
	}
}
