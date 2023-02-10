package com.kgisl.onetomany;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FetchData {
    public static void main(String[] args) {
        try (StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build()) {
            Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
              
            SessionFactory factory=meta.getSessionFactoryBuilder().build();  
            Session session=factory.openSession();  
                
            // TypedQuery query=session.createQuery("from Question");    
            // List<Questions> list=query.getResultList();   
            TypedQuery query =session.createQuery("from Questions");
            List<Questions> list = query.getResultList(); 
                
            Iterator<Questions> itr=list.iterator();   
            while(itr.hasNext()){    
                Questions q=itr.next();    
                System.out.println("Question Name: "+q.getQuestion());    
                    
                //printing answers    
                List<Answers> list2=q.getAnswer();    
                Iterator<Answers> itr2=list2.iterator();    
               while(itr2.hasNext())  
               {  
                Answers a=itr2.next();  
                    System.out.println(a.getAnswername()+":"+a.getPostedBy());  
                }    
            }  
            session.close();
        } catch (HibernateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        System.out.println("success");  
        
    }
    
    
}
