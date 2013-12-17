package cn.edu.bjut.help.core.cons;

public enum MessageType {

	TEXT("TEXT", (short) 0),
	AUDIO("AUDIO", (short) 1);
	
	private Short value;
	private String description;
	
	private MessageType(String description, Short value) {
		this.value = value;
		this.description = description;
	}

	public Short getValue() {
		return value;
	}

	public void setValue(Short value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
