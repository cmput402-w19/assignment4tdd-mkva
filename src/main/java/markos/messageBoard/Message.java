package markos.messageBoard;

import org.apache.commons.lang3.StringUtils;

public class Message {

	private int type; //1=question and 2=answer
	private int id;
	private int parent;
	private String content;
	private String author;
	private String date;

	public Message(int type, String content, String author, String date) throws Exception {
		this.type = type;
		this.author = author;
		this.date = date;

		try {
			if(validContent(content))
				this.content = content;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	public Message(int type, int id, int parent, String content, String author, String date) {
		this.type = type;
		this.id = id;
		this.parent = parent;
		this.content = content;
		this.author = author;
		this.date = date;

	}

	public int getId() {
		return this.id;
	}


	public int getParent() {
		return (Integer) null;
	}

	public int getType() {
		return this.type;
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
		Exception emptyContent = new Exception("Invalid post! Posts must have a content.");
		Exception onlyWhiteSpaceContent = new Exception("Invalid post! Posts must not be composed only"
				+ " of white spaces.");

		// check if content is empty
		if(content.isEmpty())
			throw emptyContent;

		if(StringUtils.isBlank(content))
			throw onlyWhiteSpaceContent;

		return true;
	}
}


