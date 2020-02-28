package _02_Chat_Application;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import _00_Click_Chat.networking.Server;
import _01_Intro_To_Sockets.client.ClientGreeter;
import _01_Intro_To_Sockets.server.ServerGreeter;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp {
	ServerGreeter server;
	ClientGreeter client;

	public static void main(String[] args) throws IOException {
		new ChatApp();
	}

	public ChatApp() throws IOException {
		int pool = JOptionPane.showConfirmDialog(null, "Would you like to host a connection?", null,
				JOptionPane.YES_NO_OPTION);
		if (pool == JOptionPane.YES_NO_OPTION) {
			server = new ServerGreeter();
			server.start();
		} else {
			client = new ClientGreeter();
			client.start();
		}
	}
}