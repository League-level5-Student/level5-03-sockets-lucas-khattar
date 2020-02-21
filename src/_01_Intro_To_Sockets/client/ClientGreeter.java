package _01_Intro_To_Sockets.client;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;

public class ClientGreeter {

	public static void main(String[] args) {
		String ip = "192.168.7.128";
		int port = 8080;
		try {
			Socket sock = new Socket(ip, port);
			DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
			dos.writeUTF(JOptionPane.showInputDialog(null, "Write a message you want to send to the server..."));
			DataInputStream dis = new DataInputStream(sock.getInputStream());
			System.out.println(dis.readUTF());
			sock.close();
		} catch (IOException e) {
		}
	}
}
