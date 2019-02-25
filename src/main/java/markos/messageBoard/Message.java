package markos.messageBoard;

public class Message {

	private int type; //1=question and 2=answer
	private int id;
	private int parent;
	private String content;
	private String author;
	private String date;

	public Message(int type, String content, String author, String date) throws Exception {
		validContent(content);
	}
	
	public Message(int type, int id, int parent, String content, String author, String date) {

	}

	public int getId() {
		return (Integer) null;
	}


	public int getParent() {
		return (Integer) null;
	}

	public int getType() {
		return (Integer) null;
	}

	public String getAuthor() {
		return null;
	}

	public String getContent() {
		return null;
	}

	public String getAtuhor() {
		return null;
	}

	public String getDate() {
		return null;
	}

	public boolean validContent(String content) throws Exception {
		return true;
	}
}


