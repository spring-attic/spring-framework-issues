package org.springframework.jira;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BadBean {

    private List<String> addressLists = new ArrayList<String>();
    private String hostPort;
    private String hostName;
    private Date connectionTime;
    
    public void setAddress(int index, String addr) {
        addressLists.add(index, addr);
    }
    
    public void setAddress(String addr){
        addressLists.add(addr);
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
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("BadBean-context.xml", BadBean.class); 
        BadBean conn2 = (BadBean)ctx.getBean("conn2");
        ctx.close();
        System.out.println("DONE!");
    }
}
