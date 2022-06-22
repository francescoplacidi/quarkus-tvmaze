package it.fra.test.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import it.fra.test.model.TvSerie;
import it.fra.test.proxy.TvSeriesProxy;

@Path("/tvseries")
public class TvSeriesResource {

    @RestClient
    TvSeriesProxy proxy;

    private List<TvSerie> tvSeries = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        TvSerie tvSerie = proxy.get("game of thrones");
        tvSeries.add(tvSerie);
        return Response.ok(tvSeries).build();
    }

}
