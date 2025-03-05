package assignment.servlets.entity;

public class Dept {
	
	private int id;
	private String name;
	private String location;
	
	
	public Dept() {}
	public Dept(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		
	}

	
	public static DeptBuilder builder() {
		return new DeptBuilder(new Dept());
	}
	
	public static class DeptBuilder{
		private Dept dept;
		public DeptBuilder(Dept d) {
			this.dept=d;
		}
		public Dept build() {
			return dept;
		}
		
		public DeptBuilder id(int id) {
			dept.setId(id);
			return this;
		}
		public DeptBuilder name(String name) {
			dept.setName(name);
			return this;
		}
		public DeptBuilder location(String location) {
			dept.setLocation(location);
			return this;
		}
		
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	

}
