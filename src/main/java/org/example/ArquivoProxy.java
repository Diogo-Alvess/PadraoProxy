package org.example;

public class ArquivoProxy implements IArquivo {

    private String nome;
    private Arquivo arquivoReal;

    public ArquivoProxy(String nome) {
        this.nome = nome;
    }

    private void carregarArquivoReal() {
        if (arquivoReal == null) {
            arquivoReal = ServidorArquivos.getArquivo(nome);
        }
    }

    @Override
    public String obterMetadados() {
        carregarArquivoReal();
        return arquivoReal.obterMetadados();
    }

    @Override
    public String abrirArquivo(Usuario usuario) {
        if (!usuario.isAdministrador()) {
            throw new IllegalArgumentException("Usuário não autorizado");
        }
        carregarArquivoReal();
        return arquivoReal.abrirArquivo(usuario);
    }
}

