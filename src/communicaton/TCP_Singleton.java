package communicaton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import model.Remember;
import view.Main;

public class TCP_Singleton extends Thread{

	private Socket sock;
	private BufferedReader bufferR;
	private BufferedWriter bufferW;
	
	private Main main;
	
	public TCP_Singleton(Main main) {
		this.main = main;
	}
	//enlace de recepción
	public void run() {
		try {
			ServerSocket server = new ServerSocket(5000);
			System.out.println("Waiting");
			this.sock = server.accept();
			
			InputStream s = sock.getInputStream();
			InputStreamReader sr = new InputStreamReader(s);
			this.bufferR = new BufferedReader(sr);
			
			OutputStream os = sock.getOutputStream();
			OutputStreamWriter sw = new OutputStreamWriter(os);
			this.bufferW = new BufferedWriter(sw);
			
			while(true) {
				messageRecived();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitingConexion() {
		this.start();
	}
	
	public void sendMessage(String message) {
		new Thread(
				() ->{
					try {
						bufferW.write(message + "\n");
						bufferW.flush();
					}catch (IOException e){
						e.printStackTrace();
					}
				}
				
				).start();
	}
	
	private void messageRecived() throws IOException {
		// TODO Auto-generated method stub
		String rem = bufferR.readLine();
		main.setArrayRemember(rem.split(","));
		float posX = Float.parseFloat(main.getArrayRemember()[0]);
		float posY = Float.parseFloat(main.getArrayRemember()[1]);
		String remember = main.getArrayRemember()[2];
		String relevance = main.getArrayRemember()[3];
		
		main.getList().add(new Remember(posX, posY, remember, relevance));
		
	}
	
	public void closeConexion() {
		try {
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
