package day2;

public class Car implements Cloneable{

	private String make;
	private String model;
	private String varient;
	private int year;
	private int version;
	
	//clone
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	//equals method
	//Home work make unit test for equals method
	public boolean equals(Object obj) {
		//if obj is a car
		if(!(obj instanceof Car)) return false;
		Car car = (Car)obj;
		//compare obj with this 
		return year == car.year && version == car.version && make.equals(car.make)
				&& model.equals(car.model) && varient.equals(car.varient);
		
	}
	
	//learn concept of run time string and compile time string
	
	
	//Hashcode method
	@Override
	public int hashCode() {
		return (toString()+"Car").hashCode();
	}
	
	public Car() {
		
	}
	
	@Override
	public String toString() {
//		return make + " " + model + " " + varient+ " "  +year+ " Version " + version;
	return new StringBuilder()
			.append(make)
			.append(" ")
			.append(model)
			.append(" ")
			.append(varient)
			.append(" ")
			.append(year)
			.append(" Version ")
			.append(version)
			.toString();
	
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVarient() {
		return varient;
	}

	public void setVarient(String varient) {
		this.varient = varient;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Car(String make, String model, String varient, int year, int version) {
		super();
		this.make = make;
		this.model = model;
		this.varient = varient;
		this.year = year;
		this.version = version;
	}
	
	
	public static CarBuilder builder() {
		return new CarBuilder(new Car());
	}
	
	//Builder design pattern ex
	
	public static class CarBuilder{
		private Car car ;
		public CarBuilder(Car car) {
			this.car=car;
		}
		public Car build(){
			return car;
		}
		
		public CarBuilder make(String make) {
			car.setMake(make);
			return this;
		}
		public CarBuilder model(String model) {
			car.setModel(model);
			return this;
		}
		public CarBuilder varient(String varient) {
			car.setVarient(varient);
			return this;
		}
		public CarBuilder year(int year) {
			car.setYear(year);
			return this;
		}
		public CarBuilder version(int version) {
			car.setVersion(version);
			return this;
		}
		
	}
	
	
	
	
}
