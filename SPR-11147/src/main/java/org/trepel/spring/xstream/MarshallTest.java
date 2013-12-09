package org.trepel.spring.xstream;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

public class MarshallTest {

    private Data data = new Data();

    public FileReader saveData(Marshaller marshaller, File path) throws IOException {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(path);
            marshaller.marshal(data, new StreamResult(os));
        } finally {
            if (os != null) {
                os.close();
            }
        }
        return new FileReader(path);
    }

    public void loadData(Unmarshaller unmarshaller, File path) throws IOException {
        FileInputStream is = null;
        try {
            is = new FileInputStream(path);
            this.data = (Data) unmarshaller.unmarshal(new StreamSource(is));
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    private static String readFile(FileReader fr) throws IOException {
        StringBuilder sb = new StringBuilder();
        while(fr.ready()) {
            sb.append((char)fr.read());
        }
        return sb.toString().replace("<", "&lt;").replace(">", "&gt;");
    }

    public static Collection<Report> test(File path, ApplicationContext appContext) throws IOException {
        Collection<Report> reports = new ArrayList<Report>();
        try {
            System.out.println("test");
            MarshallTest application = (MarshallTest) appContext.getBean("application");
            application.data.setName("data");
            application.data.setId(1);
            application.data.setEntries(new String[2]);
            application.data.getEntries()[0] = "foo";
            application.data.getEntries()[1] = "bar";
            Data orig = application.data;
            Marshaller m = null;

            //XStream
            try {
                m = (Marshaller) appContext.getBean("xstreamMarshaller");
                FileReader fr = application.saveData(m, path);
                application.loadData((Unmarshaller) m, path);
                reports.add(new Report(readFile(fr), "XStream: " + (orig.equals(application.data) ? "success:" : "failed:") + application.data));
            } catch (BeansException ex) {
                reports.add(new Report(null, ex.toString()));
            } catch (Exception ex) {
                reports.add(new Report(null, "XStream marshalling ended with exception " + ex));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reports;
    }
}
