import java.net.*;
import java.io.*;
import java.util.*;

public class Server {

	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream input = null;
	private DataOutputStream output = null;
	private DataInputStream input2 = null;

	public Server(int port) {

		try{
			// Strating server and waiting for a client.
			server = new ServerSocket(port);
			System.out.println("Server Started");

			System.out.println("Waiting for a client....");

			socket = server.accept();
			System.out.println("Client Accepted !");

			//Taking input from client socket
			input = new DataInputStream(socket.getInputStream());

			output = new DataOutputStream(socket.getOutputStream());

			String line = "";

			while(!line.equals("over")) {

				try{

					line = input.readUTF();
					System.out.println(line);

					// Scanner input2 = new Scanner(System.in);
					input2 = new DataInputStream(socket.getInputStream());

					line = input2.readLine();
					output.writeUTF(line);


				}catch(IOException i) {
					System.out.println(i);

				}
			}
			System.out.println("Closing connection ....");

			socket.close();
			input.close();
			output.close();


		}catch(IOException i) {
			System.out.println(i);
		}
	}


	public static void main(String[] args) {
		Server server = new Server(5000);

	}

}

