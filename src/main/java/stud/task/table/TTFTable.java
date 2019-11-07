package stud.task.table;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TTFTable {
    TypeTTFTable value();
    TypeTTFTable[] dependencies() default {};
}
