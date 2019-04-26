/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import javax.net.ssl.SSLException;

/**
 *
 * @author NAFIS
 */
public class Server extends Thread{
	private int port;
	
	public Server(int port) {
		this.port = port;
	}
	
	public void run() {
		try {
			Communication com = new Communication(port);
		} catch (SSLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Server Starts.");
	}
}
