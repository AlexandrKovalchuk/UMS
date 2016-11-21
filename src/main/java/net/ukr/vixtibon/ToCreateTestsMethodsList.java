package net.ukr.vixtibon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;

/**
 * Created by a_kovalchuk on 28.09.2015.
 */

public class ToCreateTestsMethodsList {
    public static void test(Class<?>... ls) {
        try (BufferedWriter f=new BufferedWriter(new FileWriter("UMS_Methods_for_test.txt"))){

            for (Class<?> cls : ls) {
                if (cls.isAnnotationPresent(ClassReadyForTest.class)){

                    Method[] methods = cls.getDeclaredMethods();

                    for (Method method : methods) {
                        if (method.isAnnotationPresent(Test.class)) {
                        }else{
                            f.write("test class " + cls.getName() + " --- method for testing : " + method.getName());
                            f.newLine();
                        }
                    }
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

