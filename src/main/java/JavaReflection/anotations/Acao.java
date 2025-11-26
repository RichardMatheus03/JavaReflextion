package JavaReflection.anotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)   // apenas métodos
public @interface Acao {
}
