package org.example;

import java.util.HashMap;
import java.util.Map;

public class ServidorArquivos {

    private static Map<String, Arquivo> arquivos = new HashMap<>();

    public static void addArquivo(Arquivo arquivo) {
        arquivos.put(arquivo.obterMetadados().split(" ")[0], arquivo);
    }

    public static Arquivo getArquivo(String nome) {
        return arquivos.get(nome);
    }
}