package fr.lteconsulting.doa;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;

import fr.lteconsulting.Contact;

// Pour être sûr de n'avoir qu'une seule liste
@Singleton
/**
 * classe d'acces aux données contact
 */

public class ContactDao {
	
	private int nextId = 55;
	
	private List<Contact> contacts  = new ArrayList<Contact>();
	
	public ContactDao(){
		contacts.add(new Contact(1, "Roge", "Roger", "15666"));
	}
	
	public List<Contact> getContacts(){
		return contacts;
	}
	
	public Contact getById(int id){
		for (Contact contact : contacts){
			if(contact.getId()== id){
				return contact;
			}
		}
		return null;
	}
	
	public Contact update(Contact contact){
		deleteById(contact.getId());
		contacts.add(contact);
		return contact;
	}
	
	public Contact create(Contact contact){
		contact.setId(nextId++);
		contacts.add(contact);
		return contact;
	}
	
	public void deleteById(int id){
		Contact contact = getById(id);
		if (contact == null){
			return;
		}
		contacts.remove(contact);
	}
}
