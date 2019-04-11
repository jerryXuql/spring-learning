package lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.naming.spi.InitialContextFactory;

public class LifeCycleBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

	private String name;
	private int age;

	@Override
	public void setBeanName(String name) {
		System.out.println("01---> BeanNameAware接口被调用，获取到的beanName：" + name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("02---> BeanFactoryAware接口被调用");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("03--->ApplicationContextAware接口被调用");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("05---> InitializingBean接口被调用");
	}

	public void myInit() {
		System.out.println("06---> myInit方法被调用");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("09---> DisposableBean接口被调用");
	}

	public void myDestory() {
		System.out.println("10--->自定义Destroy-method方法被调用");
	}

	@Override
	public String toString() {
		return "LifeCycleBean{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

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
}
