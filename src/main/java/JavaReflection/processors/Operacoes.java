package JavaReflection.processors;

import JavaReflection.anotations.*;

@Processar
public class Operacoes {

    @Acao
    public void dobrar(int x) {
        System.out.println(x * 2);
    }

    @Acao
    public void imprimir(int x) {
        System.out.println(x);
    }

    public void nuncaVaiSerChamado(int x) {
        System.out.println("Este método nunca será chamado pois não possui a annotation");
    }

}
