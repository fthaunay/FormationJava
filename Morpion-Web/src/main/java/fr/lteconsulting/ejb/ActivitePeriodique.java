package fr.lteconsulting.ejb;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

import fr.lteconsulting.doa.PartieDao;

@Singleton
public class ActivitePeriodique {
	
	@EJB
	private PartieDao partieDao;
	
	//@Schedule(second= "*/5", minute = "*", hour = "*", persistent = false)
	 public void faitUnTruc(){
		 System.out.println("timer: j'efface les vieilles parties");
		 partieDao.deleteOldEndedParties();
	 }

}

