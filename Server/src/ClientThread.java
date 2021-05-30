import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ClientThread extends Thread {
	private Socket socket;
	@SuppressWarnings("unused")
	private int id;
	String clientSentence;
	String capitalizedSentence;

	public ClientThread(Socket socket, int id) {
		this.socket = socket;
		this.id = id;
	}

	public ClientThread() {
	}

	public void run() {
		try {
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
			while (true) {
				clientSentence = inFromClient.readLine();

				capitalizedSentence = clientSentence.toUpperCase();

				System.out.println("Sentence Capitalized : " + capitalizedSentence);
				outToClient.writeBytes(capitalizedSentence + '\n');

				if (clientSentence.equalsIgnoreCase("Close Socket")) {
					System.out.println("Connection Socket between the server and client is closed");
					System.out.println("===============================================");
					System.out.println("Server is Still Running......");
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String toString() {
		return "ClientThread [Socket = " + socket + ", ID = " + id + "]";
	}
}