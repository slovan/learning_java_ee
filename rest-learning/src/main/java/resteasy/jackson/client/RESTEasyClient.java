package resteasy.jackson.client;

import resteasy.jackson.Student;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
            // get
//            Client client = ClientBuilder.newClient();
//            WebTarget target = client.target("http://localhost:8080/rest-learning/stud/jsonServices/print/James");
//            Student st2 = target.request().get(Student.class);
//            System.out.println(st2.toString());

            // post
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:8080/rest-learning/stud/jsonServices/send");

            Response response = target.request().post(Entity.entity(st, MediaType.APPLICATION_JSON));

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }


            System.out.println("Server response : \n");
            System.out.println(response.readEntity(String.class));
            response.close();
            this.statusMsg = "Message was successfully sent!";
        } catch (Exception e) {
            this.statusMsg = e.getMessage();
            e.printStackTrace();
        }


    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
}
