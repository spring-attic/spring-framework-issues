/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.trepel.spring.xstream;

/**
 *
 * @author igilany
 */
public class Report {

    String status;

    String marshalledObject;

    public String getMarshalledObject() {
        return marshalledObject;
    }

    public void setMarshalledObject(String marshalledObject) {
        this.marshalledObject = marshalledObject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Report(String marshalledObject, String status) {
        this.status = status;
        this.marshalledObject = marshalledObject;
    }

    

}
