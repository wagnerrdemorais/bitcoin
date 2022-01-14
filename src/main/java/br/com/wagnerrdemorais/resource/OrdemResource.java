package br.com.wagnerrdemorais.resource;

import br.com.wagnerrdemorais.model.Ordem;
import br.com.wagnerrdemorais.repository.OrdemRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("/ordens")
public class OrdemResource {

    @Inject
    OrdemRepository ordemRepository;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Ordem ordem) {
        ordem.setData(new Date());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }
}
