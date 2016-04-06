import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "todoMessageList")
public class TodoMessageList {

	@XmlElementWrapper(name="todoMessage")
	private List<TodoMessage> messages;
	private int messageCount = 0;
	
	public List<TodoMessage> getMessages() {
		return messages;
	}
	public void setMessages(List<TodoMessage> messages) {
		this.messages = messages;
		this.setMessageCount(messages.size());
	}
	public int getMessageCount() {
		return messageCount;
	}
	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}
	//HELPER METHOD TO GET INDEX IN MESSAGE LIST
	public int findMessage(int p_id){
		for(int i = 0; i < messages.size(); i++){
			if(messages.get(i).getId() == p_id){
				return i;
			}
		}
		return 0; 
	}
}