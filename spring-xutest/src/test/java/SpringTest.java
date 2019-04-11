import cyclic.ClassA;
import cyclic.ClassB;
import entity.Dog;
import entity.Outer;
import entity.Sun;
import lifecycle.LifeCycleBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactoryTests;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.tests.sample.beans.ITestBean;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Tests for combining the expression language and the p namespace. Due to the required EL dependency, this test is in
 * context module rather than the beans module.
 *
 * @author Arjen Poutsma
 */
public class SpringTest {
	private XmlBeanFactory xmlBeanFactory;

	@Before
	public void initXmlBeanFactory() {
		System.setProperty("spring.profiles.active", "dev");
		System.out.println("测试方法开始=====================");
		xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("springtest.xml"));
	}

	@After
	public void after() {
		System.out.println("\n============测试方法结束=============");
	}

	@Test
	public void testLifeCycle() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springtest.xml");
		LifeCycleBean myLifeCycle = applicationContext.getBean("myLifeCycleBean", LifeCycleBean.class);
		System.out.println("08---> bean可以被使用了，beanInfo：" + myLifeCycle.toString());
		((ClassPathXmlApplicationContext) applicationContext).destroy();
	}

	@Test
	public void test() {
		Outer outer = xmlBeanFactory.getBean("outer", Outer.class);
		outer.sayHello();
	}

	@Test
	public void test1() {
		System.out.println("测试无参构造器实例化bean");
		Dog dog = xmlBeanFactory.getBean("dog", Dog.class);
		dog.sayHello();
	}

	@Test
	public void test2() {
		System.out.println("测试有参构造器实例化bean");
		Dog dog = xmlBeanFactory.getBean("dog2", Dog.class);
		dog.sayHello();
	}

	@Test
	public void test3() {
		System.out.println("测试静态工厂方法实例化bean");
		Dog dog = xmlBeanFactory.getBean("dog3", Dog.class);
		dog.sayHello();
	}

	@Test
	public void test4() {
		System.out.println("测试实例工厂方法实例化bean");
		Dog dog = xmlBeanFactory.getBean("dog4", Dog.class);
		dog.sayHello();
	}

	@Test
	public void test5() {
		System.out.println("循环依赖问题");
		ClassA a =xmlBeanFactory.getBean("classA", ClassA.class);
		ClassB b =xmlBeanFactory.getBean("classB", ClassB.class);
		System.out.println(a);
		System.out.println(b);
	}

	@Test
	public void test6() {
		Sun sun = xmlBeanFactory.getBean("sun", Sun.class);
		sun.sayHello();
	}

}
