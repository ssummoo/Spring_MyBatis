package kr.co.softsoldesk.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.softsoldesk.beans.JdbcBean;
import kr.co.softsoldesk.config.BeanConfigClass;
import kr.co.softsoldesk.mapper.MapperInterface;


public class MainClass {

   public static void main(String[] args) {

     System.out.println("==================================JAVA==================================");
     AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(BeanConfigClass.class);
     
    MapperInterface mapper=ctx.getBean("test_mapper", MapperInterface.class);
    
    //insert
    /*     
     */
    JdbcBean bean2=new JdbcBean();
    bean2.setInt_data(11);
    bean2.setStr_data("SpringFramework");
    mapper.insert_data(bean2);
    System.out.println("저장완료");
    
    //Select
    List<JdbcBean> list=mapper.select_data();
    for(JdbcBean bean1 : list) {
    	System.out.print("int_data : "+bean1.getInt_data());
		System.out.print("str_data : "+bean1.getStr_data());
    }
    
    //Update 
    JdbcBean bean3 =new JdbcBean();
    bean3.setInt_data(10);
    bean3.setStr_data("JSP");
    mapper.update_data(bean3);
    
    //Delete
    mapper.delete_data(11);
    
     ctx.close();
   }
   
}