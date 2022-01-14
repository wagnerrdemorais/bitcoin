package br.com.wagnerrdemorais.service;

import br.com.wagnerrdemorais.model.Bitcoin;
import br.com.wagnerrdemorais.resource.BitcoinResource;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;

@Path("/bitcoins")
@RegisterRestClient(configKey = "bitcoin-api")
public interface BitcoinService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    default List<Bitcoin> listar(){
        Bitcoin bit = new Bitcoin();
        bit.setData(LocalDate.now());
        bit.setId(1L);
        bit.setPreco(200.00);
        bit.setTipo("TipoTal");

        return List.of(bit);
    };
}
