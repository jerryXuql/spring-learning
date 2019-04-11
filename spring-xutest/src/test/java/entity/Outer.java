package entity;

public class Outer {
	private String name;
	private int age;

	private Inner inner;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Inner getInner() {
		return inner;
	}

	public void setInner(Inner inner) {
		this.inner = inner;
	}

	public void sayHello() {
		System.out.println("outer--->name:" + name + ",age:" + age);
		System.out.println("inner--->name:" + inner.getName() + ",age:" + inner.getAge());
	}
}
