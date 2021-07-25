public class CustomObject {

	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomObject(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// Implement a Set on this class
	// If name is same, it should return same object

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (obj.getClass() != getClass())
			return false;
		if (!(obj instanceof CustomObject))
			return false;
		CustomObject co = (CustomObject) obj;
		if (this.getName() == co.getName())
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		int hashVar = someHashFunc(this.getName());
		return hashVar;
	}

	private int someHashFunc(String str) {
		return 0;
	}
}