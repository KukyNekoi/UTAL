import java.io.*;
import java.net.*;

public class Servidor1
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket sserv = null;
		try
		{
			sserv = new ServerSocket(6789);
		}
		catch(IOException e)
		{
			System.err.println("No se puede escuchar en el puerto: 6789");
			System.exit(1);
		}

		Socket scliente = null;
		try
		{
			scliente = sserv.accept();
		}
		catch(IOException e)
		{
			System.err.println("Fallo el accept.");
			System.exit(1);
		}
		
		PrintWriter out = new PrintWriter(scliente.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(scliente.getInputStream()));
		
		String entrada, salida;

		salida = new String("Server: Hola, soy el server!");
		out.println(salida);
		//out.flush();
		
		while((entrada = in.readLine()) != null) 
		{ 
			if(Integer.parseInt(entrada) > 0)
			{
				salida = String.valueOf("Server: Sigue!");
				out.println(salida);
				//out.flush();
			}
			else
			{
				break;
			}
		}

		out.println("Nos vemos.");
		//out.flush();
		out.close();
		in.close();
		scliente.close();
		sserv.close();

		
		
		
	}
}

