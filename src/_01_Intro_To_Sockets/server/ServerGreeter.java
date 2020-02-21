package _01_Intro_To_Sockets.server;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;

public class ServerGreeter extends Thread {
	ServerSocket ss;

	public ServerGreeter() throws IOException {
		ss = new ServerSocket(8080);
	}

	public void run() {
		boolean sos = true;
		while (sos) {
			try {
				System.out.println("Waiting for client to connect...");
				Socket sock = ss.accept();
				System.out.println("Client has connected!");
				DataInputStream dis = new DataInputStream(sock.getInputStream());
				System.out.println(dis.readUTF());
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
				dos.writeUTF(JOptionPane.showInputDialog(null, "Write a message you want to send to the client..."));
				sock.close();
			} catch (SocketTimeoutException e) {
				JOptionPane.showMessageDialog(null, "SocketTimeoutException");
				sos = false;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "IOException");
				sos = false;
			}
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
