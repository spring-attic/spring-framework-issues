package org.springframework.jira;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class GoodBean {

    private ArrayList<String> addressLists = new ArrayList<String>();
    private String hostPort;
    private String hostName;
    private Date connectionTime;
   
    public void setAddress(String addr){
        addressLists.add(addr);
    }
    
    public void setAddress(int index, String addr) {
        addressLists.add(index, addr);
    }

    
    public String getAddress(int index){
        return addressLists.get(index);
    }
    
    public String getAddress() {
        return addressLists.get(0);
    }
    
    public void setHostPort(String hostPort){
        this.hostPort = hostPort;
    }
    
    public String getHostPort(){
        return this.hostPort;
    }
    
    public void setHostName(String hostname){
        this.hostName = hostname;
    }
    
    public String getHostName() {
		return hostName;
	}

    public Date getConnectionTime(){
        return connectionTime;
    }
    
    public static void main(String[] args){
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("GoodBean-context.xml", GoodBean.class); 
        GoodBean conn1 = (GoodBean)ctx.getBean("conn1");
        ctx.close();
        System.out.println("DONE!");
    }
}
