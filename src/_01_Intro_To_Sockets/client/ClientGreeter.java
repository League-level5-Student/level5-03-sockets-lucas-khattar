package _01_Intro_To_Sockets.client;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;

public class ClientGreeter {

	public static void main(String[] args) {

	}

	public void start() {
		String ip = "192.168.7.128";
		int port = 8081;
		boolean sos = true;
		try {
			System.out.println("Client: Connecting to server...");
			Socket sock = new Socket(ip, port);
			System.out.println("Client: Connected to server!");
			DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
			dos.writeUTF(JOptionPane.showInputDialog(null,
					"Welcome! Type in the box below for what you would like to send!"));
			while (sos) {
				DataInputStream dis = new DataInputStream(sock.getInputStream());
				dos.writeUTF(JOptionPane.showInputDialog(null, "Server: " + dis.readUTF(), "Message from server!", 1));
			}
			sock.close();
		} catch (IOException e) {
			System.out.println("Client: disconnected (IOException)");
			sos = false;
		}
	}
}
