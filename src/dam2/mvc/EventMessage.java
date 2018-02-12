package proven.dam2.mvc;

public class EventMessage {
	public enum EventAction {
		INSERT, UPDATE, REMOVE, FIND_ONE, FIND_MULTIPLE
	}
	public enum EventType {
		OK, FAIL
	}
	public enum EventTarget {
		ARTICLE, CUSTOMER, SUPPLIER, USER
	}	
	private EventAction action;
	private EventType type;
	private EventTarget target;
	private Object data;
	
	// Constructors.
	
	public EventMessage(EventAction action, EventType type, EventTarget target,
			Object data) {
		this.action = action;
		this.type = type;
		this.target = target;
		this.data = data;
	}
	
	// Getters and setters.
	
	public EventAction getAction() {
		return action;
	}
	public void setAction(EventAction action) {
		this.action = action;
	}
	public EventType getType() {
		return type;
	}
	public void setType(EventType type) {
		this.type = type;
	}
	public EventTarget getTarget() {
		return target;
	}
	public void setTarget(EventTarget target) {
		this.target = target;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	// Methods.
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("event [action=");
		builder.append(action);
		builder.append(", type=");
		builder.append(type);
		builder.append(", target=");
		builder.append(target);
		builder.append(", data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}
	
	
}
