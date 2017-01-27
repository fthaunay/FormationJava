package fr.lteconsulting.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.lteconsulting.Contact;
import fr.lteconsulting.doa.ContactDao;

@Path("contacts")
public class ContactsWebService {

	@EJB
	ContactDao contactDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Contact> getContacts() {
		return contactDao.getContacts();
	}

	// Une méthode qui renvoie un contact en le recherchant par ID
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Contact getContact(@PathParam("id") int id) {
		return contactDao.getById(id);
	}

	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteContact(@PathParam("id") int id) {
		contactDao.deleteById(id);
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Contact update(Contact contact){
		return contactDao.update(contact);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Contact create(Contact contact){
		return contactDao.create(contact);
	}
}
