package com.kgisl.onetomany;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {
    public static void main(String[] args) {
        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
      
    SessionFactory factory=meta.getSessionFactoryBuilder().build();  
    Session session=factory.openSession();  
      
    Transaction t=session.beginTransaction();  
    
    Answers ans = new Answers();
    ans.setAnswername("Java is developed by James cosling");
    ans.setPostedBy("Babu Prasath");
    Answers ans2 = new Answers();
    ans2.setAnswername("Servlet is an inbuild method of Java");
    ans2.setPostedBy("Neerkathalingam");
    ArrayList<Answers> list = new ArrayList<Answers>();
   
    list.add(ans);
    ArrayList<Answers> list2 = new ArrayList<Answers>();
    list2.add(ans2);
    Questions q = new Questions();
    q.setQuestion("What is java");
    q.setAnswer(list);
    Questions q2 = new Questions();
    q2.setQuestion("What is Servlet?");
    q2.setAnswer(list2);
    session.persist(q);
    session.persist(q2);
    t.commit();
    factory.close();
    session.close();
    }
    
}
