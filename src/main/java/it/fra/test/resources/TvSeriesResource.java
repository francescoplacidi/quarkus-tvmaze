package it.fra.test.resources;

import it.fra.test.proxy.TvEpisodesProxy;
import it.fra.test.proxy.TvSeriesProxy;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/tvseries")
public class TvSeriesResource {

    @Inject
    @RestClient
    TvSeriesProxy tvSeriesProxy;

    @Inject
    @RestClient
    TvEpisodesProxy tvEpisodesProxy;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByTitle(final @QueryParam("title") String title) {
        final var tvSerie = tvSeriesProxy.get(title);
        tvSerie.setEpisodes(tvEpisodesProxy.getEpisodes(tvSerie.getId()));
        return Response.ok(tvSerie).build();
    }

}
