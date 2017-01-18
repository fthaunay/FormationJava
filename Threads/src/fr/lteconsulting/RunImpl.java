package fr.lteconsulting;

public class RunImpl implements Runnable
{
	private CompteEnBanque compte;

	public RunImpl(CompteEnBanque compte) {
		super();
		this.compte = compte;
	}

	public void run()
	{
		for( int i = 0; i < 5000; i++ )
		{
			compte.retrait( 1 );
		}
	}

	
}
