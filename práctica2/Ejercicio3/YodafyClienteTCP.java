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
import java.net.Socket;
import java.net.UnknownHostException;

public class YodafyClienteTCP {

	public static void main(String[] args) {

		byte []buferEnvio;
		byte []buferRecepcion=new byte[256];
		int bytesLeidos=0;

		// Nombre del host donde se ejecuta el servidor:
		String host="localhost";
		// Puerto en el que espera el servidor:
		int port=8989;

		// Socket para la conexión TCP
		Socket socketServicio=null;


		try {

			socketServicio = new Socket(host, port);

			//Ejercicio2
			PrintWriter outPrinter = new PrintWriter(socketServicio.getOutputStream(), true);
			BufferedReader inReader = new BufferedReader(new InputStreamReader(socketServicio.getInputStream()));


			// Creamos un socket que se conecte a "host" y "port":
			//////////////////////////////////////////////////////
			// socketServicio= ... (Completar)
			//////////////////////////////////////////////////////

			InputStream inputStream = socketServicio.getInputStream();
			OutputStream outputStream = socketServicio.getOutputStream();

			String bufferEnvio="Al monte del volcán debes ir sin demora";


			outPrinter.println(bufferEnvio);

			String cadenaLeida = inReader.readLine();


			// Mostremos la cadena de caracteres recibidos:
			System.out.println("Recibido: ");
			for(int i=0;i<cadenaLeida.length();i++){
				System.out.print((char)cadenaLeida.charAt(i));
			}

			System.out.print("\n");
			
			socketServicio.close();

			// Excepciones:
		} catch (UnknownHostException e) {
			System.err.println("Error: Nombre de host no encontrado.");
		} catch (IOException e) {
			System.err.println("Error de entrada/salida al abrir el socket.");
		}
	}
}
