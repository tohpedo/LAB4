import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.ws.rs.core.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.core.Application;
import com.fasterxml.jackson.core.JsonProcessingException; 
import com.fasterxml.jackson.databind.ObjectMapper; 


@Path("/")
public class TodoMessages{
	
	private static final long serialVersionUID = 1L;
	private TodoMessageList messages = new TodoMessageList();

	public TodoMessages() {
	}

	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/create")
	public Response createMessage(@FormParam("id") String p_id, @FormParam("message") String p_message){
		int id = Integer.parseInt(p_id);
		List<TodoMessage> m = messages.getMessages();
		TodoMessage tm = new TodoMessage();
		tm.setMessage(p_message);
		tm.setId(id);
		m.add(tm);
		messages.setMessages(m);
		ServerResponse s = new ServerResponse();
		s.code = "Success";
		s.message = "You have successfully inserted your message!";
		String json = "";
		try {
			json = new ObjectMapper().writeValueAsString(s);
		} catch (Exception e) {
			return Response.status(500).build();
		}
		return Response.ok(json,"application/json").build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/all/json")
	public Response getAllmessageJSON() {
		return Response.ok(messages, "application/json").build();
	}
/*
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/create")
	public Response createMessage(@PathParam("id") String p_id, @PathParam("message") String p_message) {
		int id = Integer.parseInt(p_id);
		List<TodoMessage> m = messages.getMessages();
		TodoMessage tm = new TodoMessage();
		tm.setMessage(p_message);
		tm.setId(id);
		m.add(tm);
		messages.setMessages(m);
		return Response.ok("Message created successfully", "application/json").build();
	}
*/	
	
	
	
	
	
	private JAXBElement<TodoMessage> toXml(TodoMessage message){
		return new JAXBElement<TodoMessage>(new QName("todoMessage"), TodoMessage.class, message);
	}
	
	/*
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/json/{id: [0-9]+}")
	public Response getIdmessageJSON(@PathParam("id") String p_id) {
		int id = Integer.parseInt(p_id);
		String message = messages.get(id);
		return Response.ok(message, "application/json").build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML})
	@Path("/xml/id: [0-9]+")
	public Response getIdmessageXML(@PathParam("id") String p_id) {
		int id = Integer.parseInt(p_id);
		return Response.ok(message, "application/xml").build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/all/json")
	public Response getAllmessageJSON() {
		return Response.ok(messages, "application/json").build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML })
	@Path("/all/xml")
	public Response getAllmessageXML() {
		return Response.ok(messages, "application/xml").build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/create")
	public Response createMessage(@PathParam("id") String p_id, @PathParam("message") String p_message) {
		int id = Integer.parseInt(p_id);
		List<TodoMessage> m = messages.getMessages();
		TodoMessage tm = new TodoMessage();
		tm.setMessage(p_message);
		tm.setId(id);
		m.add(tm);
		messages.setMessages(m);
		return Response.ok("Message created successfully", "application/json").build();
	}

	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/delete")
	public Response deleteId(@PathParam("id") String p_id) {
		int id = Integer.parseInt(p_id);
		int index = messages.findMessage(id);
		List<TodoMessage> m = messages.getMessages();
		m.remove(index);
		messages.setMessages(m);
		return Response.ok("Message deleted successfully", "application/json").build();
	}
	*/
	

}
