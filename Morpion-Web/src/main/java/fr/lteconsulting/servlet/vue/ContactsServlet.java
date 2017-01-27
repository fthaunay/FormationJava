package fr.lteconsulting.servlet.vue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.Contact;

@WebServlet("/contacts")
public class ContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// cette Servlet doit retourner une liste de contacts 
	// chaque contact a id, nom, prenom et telephone
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO génerer plusieurs contacts
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		for (int i=0;i<10;++i){
			contacts.add(new Contact(i, "toto"+i,"titi"+i, "06"+i+"1489789" )); 
		}
	
		
		String lesContacts = "["+contactToJson(contacts.get(0)) +",";
		for (int i=1; i<9; ++i){
			lesContacts += contactToJson(contacts.get(i)) +",";
		}
		lesContacts += contactToJson(contacts.get(9))+"]";
		
		response.getWriter().print(lesContacts);
	}
	
	
	
	
	// produit la représentation JSON d'un contact dont on fournit les propriétés en paramètres
	private String contactToJson(Contact contact){
		
		return "{"
				+ "\"id\": "+contact.getId()+","
				+ "\"prenom\": \""+contact.getPrenom()+"\","
				+ "\"nom\": \""+contact.getNom()+"\","
				+ "\"telephone\":\""+contact.getTelephone()+"\""
				+ "}";
	}
}

