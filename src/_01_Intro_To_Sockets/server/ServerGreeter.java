package _01_Intro_To_Sockets.server;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;

public class ServerGreeter extends Thread {
	ServerSocket ss;

	public ServerGreeter() throws IOException {
		ss = new ServerSocket(8081);
	}

	public void run() {
		boolean sos = true;
		try {
			System.out.println("Server: Waiting for client to connect...");
			Socket sock = ss.accept();
			System.out.println("Server: Client has connected!");
			while (sos) {
				DataInputStream dis = new DataInputStream(sock.getInputStream());
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
				dos.writeUTF(JOptionPane.showInputDialog(null, "Client: " + dis.readUTF(), "Message from client!", 1));
			}
			sock.close();
		} catch (SocketTimeoutException e) {
			System.out.println("Server: disconnected (SocketTimeoutException)");
			sos = false;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Server: disconnected (IOException)");
			sos = false;
		}
	}

	public static void main(String[] args) {
		Thread th = new Thread(() -> {
			try {
				ServerGreeter sg = new ServerGreeter();
				sg.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		th.start();
	}
}
