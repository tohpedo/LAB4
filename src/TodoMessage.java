import javax.xml.bind.annotation.*;



@XmlRootElement(name = "todoMessage")
@XmlType(propOrder ={"id","message"})
public class TodoMessage {
	private int id;
	private String message;
	
	public TodoMessage(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString(){
		return "Message #" + this.id + ": " + this.message;
	}
	
}
