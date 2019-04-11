package entity;

public class DogStaticFactory {
	public static Dog newInstance(String name, int age) {
		return new Dog(name, age);
	}
}
