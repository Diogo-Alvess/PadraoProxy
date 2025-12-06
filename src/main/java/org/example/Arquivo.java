package org.example;

public class Arquivo implements IArquivo {

    private String nome;
    private long tamanhoKB;
    private String conteudo;

    public Arquivo(String nome, long tamanhoKB, String conteudo) {
        this.nome = nome;
        this.tamanhoKB = tamanhoKB;
        this.conteudo = conteudo;
    }

    @Override
    public String obterMetadados() {
        return nome + " (" + tamanhoKB + " KB)";
    }

    @Override
    public String abrirArquivo(Usuario usuario) {
        return this.conteudo;
    }
}
