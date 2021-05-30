import java.net.*;
import java.util.ArrayList;

class TCP_Server {
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String argv[]) throws Exception {
		System.out.println("Server is ON......");
		String clientSentence;
		String capitalizedSentence;
		ArrayList<ClientThread> arr = new ArrayList<ClientThread>();
		int id = 1;

		ServerSocket welcomeSocket = new ServerSocket(56789);

		while (true) {

			System.out.println("Waiting for connection.......");

			Socket connectionSocket1 = welcomeSocket.accept();

			System.out.println("Server is now connected to the Client");

			ClientThread thread = new ClientThread(connectionSocket1, id);
			arr.add(thread);
//			System.out.println(arr.toString());
			id++;
			thread.start();

		}
	}
}