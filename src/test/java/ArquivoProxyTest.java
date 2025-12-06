package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArquivoProxyTest {

    @BeforeEach
    void setup() {
        ServidorArquivos.addArquivo(
                new Arquivo("Relatorio.pdf", 2048, "Conteúdo confidencial do relatório.")
        );

        ServidorArquivos.addArquivo(
                new Arquivo("VideoAula.mp4", 150000, "Fluxo de bytes do vídeo...")
        );
    }

    @Test
    void deveRetornarMetadadosArquivo() {
        ArquivoProxy arquivo = new ArquivoProxy("Relatorio.pdf");

        assertEquals("Relatorio.pdf (2048 KB)", arquivo.obterMetadados());
    }

    @Test
    void deveAbrirArquivoParaAdministrador() {
        Usuario admin = new Usuario("Carlos", true);
        ArquivoProxy arquivo = new ArquivoProxy("VideoAula.mp4");

        assertEquals("Fluxo de bytes do vídeo...", arquivo.abrirArquivo(admin));
    }

    @Test
    void deveLancarExcecaoParaUsuarioNaoAutorizado() {
        try {
            Usuario user = new Usuario("Paulo", false);
            ArquivoProxy arquivo = new ArquivoProxy("Relatorio.pdf");

            arquivo.abrirArquivo(user);
            fail("Era esperada uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Usuário não autorizado", e.getMessage());
        }
    }
}