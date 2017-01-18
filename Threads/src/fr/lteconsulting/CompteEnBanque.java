package fr.lteconsulting;

public class CompteEnBanque {
	private int solde;

	public CompteEnBanque(int solde) {
		super();
		this.solde = solde;
	}
	
	public synchronized void retrait(int montant){
		solde -=montant;
	}
	
	public int getSolde(){
		return solde;
	}

}
