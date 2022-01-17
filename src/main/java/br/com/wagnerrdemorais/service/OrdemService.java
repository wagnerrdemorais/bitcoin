package br.com.wagnerrdemorais.service;

import br.com.wagnerrdemorais.model.Ordem;
import br.com.wagnerrdemorais.model.Usuario;
import br.com.wagnerrdemorais.repository.OrdemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.util.Date;
import java.util.Optional;

@ApplicationScoped
public class OrdemService {

    @Inject
    OrdemRepository ordemRepository;

    public void inserir(SecurityContext securityContext, Ordem ordem) {

        int userId = ordem.getUserId();

        Optional<Usuario> usuarioOptional = Usuario.findByIdOptional(userId);
        Usuario usuario = usuarioOptional.orElseThrow();

        if (!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())) {
            throw new RuntimeException("usuario logado diferente do user id.");
        }

        ordem.setData(new Date());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }
}
