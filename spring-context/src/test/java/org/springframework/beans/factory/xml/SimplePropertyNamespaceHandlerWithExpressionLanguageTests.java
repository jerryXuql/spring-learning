/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.xml;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
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
public class SimplePropertyNamespaceHandlerWithExpressionLanguageTests {

	@Test
	public void combineWithExpressionLanguage() {
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("simplePropertyNamespaceHandlerWithExpressionLanguageTests.xml",
						getClass());
		ITestBean foo = applicationContext.getBean("foo", ITestBean.class);
		ITestBean bar = applicationContext.getBean("bar", ITestBean.class);
		assertEquals("Invalid name", "Baz", foo.getName());
		assertEquals("Invalid name", "Baz", bar.getName());
	}

	//后面均为自己增加的测试用例
	@Test
	public void testXmlBeanFactory() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("org/springframework/beans/factory/xml/simplePropertyNamespaceHandlerWithExpressionLanguageTests.xml"));
		ITestBean foo = (ITestBean) beanFactory.getBean("foo");
		System.out.println(foo.getName());
	}

	@Test
	public void testClassPathResource() {
		Resource resource = new ClassPathResource("org/springframework/beans/factory/xml/simplePropertyNamespaceHandlerWithExpressionLanguageTests.xml");
		print(resource);
	}

	@Test
	public void testClassPathResource2() {
		Resource resource = new ClassPathResource("simplePropertyNamespaceHandlerWithExpressionLanguageTests.xml",
				SimplePropertyNamespaceHandlerWithExpressionLanguageTests.class);
		print(resource);
	}

	@Test
	public void testClassPathResource3() {
		Resource resource = new ClassPathResource("org/springframework/beans/factory/xml/simplePropertyNamespaceHandlerWithExpressionLanguageTests.xml",
				SimplePropertyNamespaceHandlerWithExpressionLanguageTests.class.getClassLoader());
		print(resource);
	}

	private void print(Resource resource) {
		byte[] read = new byte[10];
		try {
			resource.getInputStream().read(read, 0, read.length);
			System.out.println(new String(read));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void testDefaultResourceLoader() {
		Resource resource = new DefaultResourceLoader().getResource("org/springframework/beans/factory/xml/simplePropertyNamespaceHandlerWithExpressionLanguageTests.xml");
		print(resource);
	}
}
