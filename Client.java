import java.net.*;
import java.io.*;

public class Client {

	private Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream output = null;
	private DataInputStream input2 = null;

	public Client(String address, int port) {

		try{
			// Estb. connection
			socket = new Socket(address, port);
			System.out.println("Connected ");

			input = new DataInputStream(System.in);

			output = new DataOutputStream(socket.getOutputStream());
		}catch(UnknownHostException u) {
			System.out.println(u);
		}catch(IOException i) {
			System.out.println(i);
		}

		String line = "";

		do {

			try{
				line = input.readLine();
				output.writeUTF(line);

				
				input2 = new DataInputStream(socket.getInputStream());


				line = input2.readUTF();
				System.out.println(line);



			}catch(IOException i ) {
				System.out.println(i);
			}
		}while(!line.equals("over"));

		try{
			// Closing the connection.
			input.close();
			output.close();
			socket.close();
		}catch(IOException i) {
			System.out.println(i);
		}

	}

	public static void main(String[] args) {
		
		Client client = new Client("127.0.0.1", 5000);
	}

}