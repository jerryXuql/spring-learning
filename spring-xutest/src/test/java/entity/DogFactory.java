package entity;

public class DogFactory {
	public Dog newInstance(String name, int age) {
		return new Dog(name, age);
	}
}
