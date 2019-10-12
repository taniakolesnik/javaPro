package uk.co.taniakolesnik;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            Class<?> cls = ClassOne.class;
            Method[] methods = cls.getDeclaredMethods();
            Arrays.stream(methods)
                    .filter(Main::isPresent)
                    .forEach(m -> {
                        try {
                            m.invoke(new ClassOne(), m.getAnnotation(Test.class).a(),  m.getAnnotation(Test.class).b());
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isPresent (Method method){
        return method.isAnnotationPresent(Test.class);
    }
}