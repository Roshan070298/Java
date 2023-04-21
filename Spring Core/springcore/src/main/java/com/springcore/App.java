package com.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "This uses setter method" );
       ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
       Student student1=(Student) context.getBean("student1");
       Student student2=(Student) context.getBean("student2");
       Student student3=(Student) context.getBean("student3");
       System.out.print(student1);
       System.out.print(student2);
       System.out.print(student3);
    }
}
