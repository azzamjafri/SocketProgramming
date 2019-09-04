import java.net.*;
import java.io.*;

public class Server {

	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream input = null;

	public Server(int port) {

		try{
			// Strating server and waiting for a client.
			server = new ServerSocket(port);
			System.out.println("Server Started");

			System.out.println("Waiting for a client....");

			socket = server.accept();
			System.out.println("Client Accepted !");

			//Taking input from client socket
			input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

			String line = "";

			while(!line.equals("Over") || !line.equals("over")) {

				try{
					line = input.readUTF();
					System.out.println(line);
				}catch(IOException i) {
					System.out.println(i);

				}
			}
			System.out.println("Closing connection ....");

			socket.close();
			input.close();


		}catch(IOException i) {
			System.out.println(i);
		}
	}


	public static void main(String[] args) {
		Server server = new Server(5000);

	}

}

