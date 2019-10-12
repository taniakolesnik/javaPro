package uk.co.taniakolesnik;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Saver {

    private Class<?> cls;

    public Saver(Class<?> cls) {
        this.cls = cls;



        }

    public void run(){
        if (cls.isAnnotationPresent(SaveTo.class)){
            System.out.println("not skipped");
            SaveTo saveTo = cls.getAnnotation(SaveTo.class);

            String path = saveTo.path();

            System.out.println(path);

           Method[] methods = cls.getDeclaredMethods();
            Arrays.stream(methods)
                    .filter(m->m.isAnnotationPresent(SaverMethod.class))
                    .forEach(m -> {
                        try {
                            System.out.println(m.getName());
                            Object object =cls.newInstance();
                            m.invoke(object, path);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    });
        } else {
            System.out.println("skipped");
        }

    }
}
