package br.com.wagnerrdemorais.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

@QuarkusTest
class UsuarioTest {

    @Test
    public void testarSeFindByIdOptRetornaUsuarioCorreto() {
        PanacheMock.mock(Usuario.class);

        Usuario u = new Usuario();
        Optional<PanacheEntityBase> optionalUsuario = Optional.of(u);

        Mockito.when(Usuario.findByIdOptional(2)).thenReturn(optionalUsuario);

        Assertions.assertSame(u, Usuario.findByIdOptional(2).get());
    }

}