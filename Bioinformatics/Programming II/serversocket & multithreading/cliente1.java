import java.io.*;
import java.net.*;

public class Cliente1
{
	public static void main(String[] args) throws IOException
	{
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try
		{
			socket = new Socket("localhost", 6789);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}
		catch( UnknownHostException e)
		{
			System.err.println("No hallo el host...");
			System.exit(1);
		}
		catch(IOException e)
		{
			System.err.println("No logre inicializar conexion con localhost.");
			System.exit(1);
		}

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String delServ, delCliente;

		//delServ = in.readLine();
		//System.out.println(delServ);

		while((delServ = in.readLine()) != null)
		{
			System.out.println(delServ);
			if(delServ.equals("Nos vemos."))
			{
				break;
			}
			delCliente = stdin.readLine();
			if(delCliente != null)
			{
				System.out.println("Cliente: " + delCliente);
				out.println(delCliente);
				//out.flush();
			}
		}
		
		out.close();
		in.close();
		stdin.close();
		socket.close();
		
	}
}

