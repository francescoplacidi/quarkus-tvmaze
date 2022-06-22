package it.fra.test.resources;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import it.fra.test.model.TvSerie;
import it.fra.test.proxy.TvSeriesProxy;

@Path("/tvseries")
public class TvSeriesResource {

    @Inject
    @RestClient
    TvSeriesProxy proxy;

    private List<TvSerie> tvSeries = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByTitle(final @QueryParam("title") String title) {
        TvSerie tvSerie = proxy.get(title);
        tvSeries.add(tvSerie);
        return Response.ok(tvSeries).build();
    }

}
