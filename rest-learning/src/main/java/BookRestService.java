import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * Created by Ponomarenko.Volodymyr on 28. 11. 2017.
 */
@Path("/book")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class BookRestService {
    @PersistenceContext(unitName = "learningREST")
    private EntityManager em;
    @Context
    private UriInfo uriInfo;

    @POST
    public Response createBook(Book book) {
        if (book == null)
            throw new BadRequestException();
        em.persist(book);
        URI bookUri = uriInfo.getAbsolutePathBuilder().path(book.getId()).build();
        return Response.created(bookUri).build();
    }

    @GET
    @Path("{id}")
    public Response getBook(@PathParam("id") String id) {
        Book book = em.find(Book.class, id);
        if (book == null)
            throw new NotFoundException();
        return Response.ok(book).build();
    }

    @GET
    public Response getBooks() {
        TypedQuery<Book> query = em.createNamedQuery(Book.FIND_ALL, Book.class);
        Books books = new Books(query.getResultList());
        return Response.ok(books).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteBook(@PathParam("id") String id) {
        Book book = em.find(Book.class, id);
        if (book == null)
            throw new NotFoundException();
        em.remove(book);
        return Response.noContent().build();
    }
}
