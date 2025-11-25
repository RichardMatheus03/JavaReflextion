package com.seuprojeto;

import com.seuprojeto.estruturas.LinkedList;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            // O arquivo precisa estar no diretório que está sendo executado o programa
            List<String> linhas = Files.readAllLines(Path.of("dados.txt"));

            for (String linha : linhas) {
                System.out.println("Linha: " + linha);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }
}
