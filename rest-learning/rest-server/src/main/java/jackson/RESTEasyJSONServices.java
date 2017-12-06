package jackson;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by Ponomarenko.Volodymyr on 29. 11. 2017.
 *
 * for testing use URL: http://localhost:8080/rest-server/stud/jsonServices/print/James
 */
@Path("jsonServices")
public class RESTEasyJSONServices {

    @GET
    @Path("/print/{name}")
    @Produces("application/json")
    public Student produceJSON(@PathParam("name") String name) {
        Student st = new Student(name, "Marco", 19, 12);
        return st;
    }

    @POST
    @Path("/send")
    @Consumes("application/json")
    @Produces("application/json")
    public Response consumeJSON(Student student) {
        System.out.println(student.toString());
        student.setAge(20);
        String output = student.toString();

        return Response.status(200).entity(output).build();
    }
}
