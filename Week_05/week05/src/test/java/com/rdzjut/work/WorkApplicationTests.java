package com.rdzjut.work;

import com.rdzjut.work.class09.AnnotationBeanDemo;
import com.rdzjut.work.class09.XmlBeanDemo;
import com.rdzjut.work.class10.hikari.Employee;
import com.rdzjut.work.class10.hikari.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

@SpringBootTest
class WorkApplicationTests {

    @Resource
    private EmployeeService employeeService;

    @Test
    void contextLoads() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AnnotationBeanDemo beanDemo01 = (AnnotationBeanDemo)context.getBean("annotationBeanDemo");
        System.out.println("-----------注解方式构造bean打印---"+beanDemo01.toString());


        XmlBeanDemo beanDemo02 = (XmlBeanDemo)context.getBean("xmlBeanDemo");
        System.out.println("-----------xml方式构造bean打印---"+beanDemo02.toString());
    }

    @Test
    void contextLoads1() {
        try {
            //新增/修改
            Employee user = new Employee();
            user.setId(1L);
            user.setEmployeeName("rendzjut");
            user.setEmployeeAge("23");
            employeeService.addOrUpdate(user);

            //查询单条记录
            Employee tmpUser = employeeService.find(1L);
            System.out.println(tmpUser.toString());

            //删除
            employeeService.delete(1L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
