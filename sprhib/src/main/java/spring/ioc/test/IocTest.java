package spring.ioc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ioc.SimpleInterest;
import spring.ioc.UtilsBean;

class IocTest {
	
	@Test
	void testutils() {
		ClassPathXmlApplicationContext utils = new ClassPathXmlApplicationContext("utils.xml");
		UtilsBean bean = (UtilsBean) utils.getBean("utils");
		System.out.println("Set of Names = "+bean.getNames());
		bean.getNames().forEach(n -> System.out.println(n));
		bean.getPoints().forEach(p -> System.out.println(p));
		System.out.println(bean.getNumbers());
		System.out.println(bean.getProps());
		try {
			SimpleInterest si = (SimpleInterest) utils.getBean("siAbs");
			System.out.println(si.compute(200, 3, 4));
			fail("No Exception Thrown....");
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		SimpleInterest si = (SimpleInterest) utils.getBean("si");
		System.out.println(si.compute(200, 3, 4));
		
	}
	
	@Test
	void testParentChild() {
		ClassPathXmlApplicationContext parent = new ClassPathXmlApplicationContext("parent.xml");
		ClassPathXmlApplicationContext child = new ClassPathXmlApplicationContext
				(new String[] {"child.xml"},parent);
		System.out.println("Parent Child"+child.getBean("line"));
		
	}

	@Test
	void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ioc.xml");
		SimpleInterest si = (SimpleInterest) ctx.getBean("si");
		assertEquals(200, si.compute(200, 20, 5));
		System.out.println(ctx.getBean("p"));
		System.out.println(ctx.getBean("p1"));
		System.out.println(ctx.getBean("l"));
		System.out.println(ctx.getBean("line"));
		System.out.println(ctx.getBean("line1"));
		System.out.println("Line 2 "+ctx.getBean("line2"));
		ctx.close();
	}

}
