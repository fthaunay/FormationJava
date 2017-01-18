package fr.lteconsulting;


import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;


public class ClientBasique
{
	public static void main( String[] args )
	{
		try
		{
			System.out.println( "Connexion au serveur" );
			Socket socket = new Socket( "192.168.13.138"/* "ks387039.kimsufi.com" */, 9090 );

			System.out.println( "Connect� au serveur" );

			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream( os );

			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream( is );

			while( true )
			{
				String message = Saisie.saisie( "message >" );
				oos.writeUTF( message );
				oos.flush();

				System.out.println( ".... attente de la r�ponse ...." );

				String reponse = ois.readUTF();
				System.out.println( "reponse : " + reponse );

				if( "!".equals( reponse ) )
					break;
			}

			System.out.println( "Fin !" );

			ois.close();
			is.close();
			oos.close();
			os.close();
			socket.close();

			System.out.println( "Termin�" );
		}
		catch( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
