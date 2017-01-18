package fr.lteconsulting;

public class TestThread extends Thread {
	public TestThread(String name){
		super(name);
	}

	@Override
	// méthode principale du thread
	public void run(){
		for(int i = 0; i < 10; i++)
		{
			System.out.println(getName());

			// attente de 50 millisencondes
			try {
				sleep( 50 );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // il faut gérer InterruptedException
		}
	}
}
