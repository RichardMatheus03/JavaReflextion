package JavaReflection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import JavaReflection.estruturas.*;
import JavaReflection.anotations.*;
import JavaReflection.processors.*;

public class Main {

    // Método responsável por receber o dado (Linha do arquivo dados.txt) e chamar as funções com a annotation @acao
    public static void rodarProcessos(String dado) {
        Class<?> clazz = Operacoes.class;

        if (clazz.isAnnotationPresent(Processar.class)) {

            for (Method m : clazz.getDeclaredMethods()) {

                // Se encontrar a annotation acao; Executa o método passando o dado como parametro
                if (m.isAnnotationPresent(Acao.class)) {

                    try {

                        Object op = clazz.getDeclaredConstructor().newInstance();
                        m.invoke(op, dado);

                    } catch (NoSuchMethodException e) {
                        System.out.println("Erro: A classe não possui um construtor padrão.");
                        e.printStackTrace();

                    } catch (InstantiationException e) {
                        System.out.println("Erro ao instanciar a classe (classe abstrata ou erro interno).");
                        e.printStackTrace();

                    } catch (IllegalAccessException e) {
                        System.out.println("Erro de acesso ao construtor (Para construtor privado).");
                        e.printStackTrace();

                    } catch (InvocationTargetException e) {
                        System.out.println("Erro ao executar o construtor (exceção dentro do construtor).");
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("A annotation @Processar não está presente na classe Operacoes.");
        }

    }

    public static void main(String[] args) {

        // LinkedList criada manualmente, onde ficará armazenado os dados lidos
        LinkedList<Integer> listaDados = new LinkedList<>();

        try {

            // O arquivo precisa estar no diretório que está sendo executado o programa
            List<String> linhas = Files.readAllLines(Path.of("dados.txt"));
            for (String linha : linhas) {
                try {
                    int valor = Integer.parseInt(linha.trim());
                    listaDados.add(valor);

                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido ignorado pois não é um int compatível: " + linha);
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        // Iterando sobre cada elemento armazenado na estrutura de dados: Lista encadeada
        Node<Integer> current = listaDados.getHead();
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }

    }
}
