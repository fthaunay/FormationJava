package fr.lteconsulting;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Test {
	public static void main(String[] args) throws InterruptedException {
	//	TestThread t = new TestThread("A");
	//	TestThread t2 = new TestThread("  B");

	//	t.start();
	//	t2.start();
		

		CompteEnBanque compte = new CompteEnBanque( 5000 );

		Thread t3 = new Thread( new RunImpl( compte ) );
		Thread t4 = new Thread( new RunImpl( compte ) );
		
		t3.start();
		t4.start();

		// on attend que les 2 threads soient termin�es
		t3.join();
		t4.join();

		System.out.println( "solde du compte (� priori -5000): " + compte.getSolde() );
		
		//ConcurrentLinkedQueue<String> queue;
	}
}
