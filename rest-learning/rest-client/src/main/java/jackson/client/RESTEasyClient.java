package jackson.client;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.management.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;
import java.lang.management.ManagementFactory;
import java.net.URI;

/**
 * https://examples.javacodegeeks.com/enterprise-java/rest/resteasy/json-example-with-resteasy-jackson/
 */
@Named("restControlBean")
@RequestScoped
public class RESTEasyClient {

    private String statusMsg = "";

    public void sendMessage() {
        Student st = new Student("Catain", "Hook", 10, 12);
        try {

            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(buildTargetURI());

            Response response = target.request().post(Entity.entity(st, MediaType.APPLICATION_JSON));

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }


            System.out.println("Server response :");
//            System.out.println(response.readEntity(Student.class).toString());
            System.out.println(response.readEntity(String.class));
            response.close();
            this.statusMsg = "Message was successfully sent!";
        } catch (Exception e) {
            this.statusMsg = e.getMessage();
            e.printStackTrace();
        }


    }

    private URI buildTargetURI() throws MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException {
        return UriBuilder.fromPath("rest-server/stud/jsonServices/send")
                .host(obtainTargetHost())
                .scheme("http")
                .port(obtainTargetPort())
                .build();
    }

    private String obtainTargetHost() throws MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException {
        return (String) ManagementFactory.getPlatformMBeanServer().getAttribute(new ObjectName("jboss.as:interface=public"), "inet-address");
    }

    private int obtainTargetPort() throws MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException {
        return (int) ManagementFactory.getPlatformMBeanServer().getAttribute(new ObjectName("jboss.as:socket-binding-group=standard-sockets,socket-binding=http"), "port");
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
}
