//
// YodafyServidorIterativo
// (CC) jjramos, 2012
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class YodafyClienteTCP {

	public static void main(String[] args) {

        	InetAddress direccion = null;
       		
		DatagramPacket paquete;
		       		
		byte[] bufer = new byte[256];
			
		DatagramSocket socket;
			
		socket = new DatagramSocket();
		try {
			direccion = InetAddress.getByName("localhost");
        	} catch (UnknownHostException e) {
            		System.err.println("Error: Nombre de host no encontrado.");
        	}
		direccion = InetAddress.getByName("localhost");

		String cadenaEnvio = "Al monte del volcan debes ir sin demora";

		bufer = cadenaEnvio.getBytes();

		paquete = new DatagramPacket(bufer, bufer.length, direccion, puerto);
		
		socket.send(paquete);
	
		paquete = new DatagramPacket(bufer, bufer.length);

		socket.receive(paquete);
		
		byte [] cadenaLeida = paquete.getData();

			
		System.out.println("Recibido: ");
		for(int i=0;i<cadenaLeina.length;i++){
			System.out.print((char)cadenaLeida[i]);
		}

		System.out.print("\n");
			
		socket.close();

	}
}
