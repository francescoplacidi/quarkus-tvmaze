package it.fra.test.proxy;

import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import it.fra.test.model.Episode;

@Path("shows")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface TvEpisodesProxy {

    @GET
    @Path("{id}/episodes")
    List<Episode> getEpisodes(@PathParam("id") Long id);

}
