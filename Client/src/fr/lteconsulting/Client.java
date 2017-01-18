package fr.lteconsulting;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;



public class Client
{
	public static void main( String[] args )
	{
		try
		{
			System.out.println( "Connexion au serveur" );
			Socket socket = new Socket( "127.0.0.1", 9090 );

			System.out.println( "Connect� au serveur" );

			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream( os );

			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream( is );

			// A partir d'une classe anonyme qui implemente Runnable
			Thread thread = new Thread( new Runnable()
			{
				@Override
				public void run()
				{
					try
					{
						while( true )
						{
							String reponse = ois.readUTF();
							System.out.println( "re�u : " + reponse );

							if( "!".equals( reponse ) )
								break;
						}
					}
					catch( Exception e )
					{
						e.printStackTrace();
					}
				}
			} );
			
			thread.start();

			while( true )
			{
				String message = Saisie.saisie( "message >" );
				oos.writeUTF( message );
				oos.flush();

				if( "!".equals( message ) )
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