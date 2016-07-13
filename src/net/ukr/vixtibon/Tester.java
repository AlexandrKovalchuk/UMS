package net.ukr.vixtibon;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by alex on 28/09/2015.
 */

public class Tester {
    public static boolean test(Class<?>... ls) {
        System.out.println("Tester started");
        java.util.Date date = new Date();

        try (BufferedWriter f=new BufferedWriter(new FileWriter("UMS_Test_results_" + date.getTime() + ".txt"))){

            for (Class<?> cls : ls) {
                if (cls.isAnnotationPresent(ClassReadyForTest.class)){

                Method[] methods = cls.getDeclaredMethods();

                    for (Method method : methods) {
                        if (method.isAnnotationPresent(Test.class)) {
                            Boolean b = (Boolean) method.invoke(null, new Object[]{});
                            if (!b) {
                                f.write("!!!!!!!!!!!!!!!!! False for " + cls.getName() + " in method " + method.getName());
                                f.newLine();
                                System.out.println("!!!!!!!!!!!!!!!!! False for " + cls.getName() + " in method " + method.getName());
                                //return false;
                            }else if(b){
                                    f.write("_Passed for " + cls.getName() + " in method " + method.getName());
                                    f.newLine();
                                    System.out.println("_Passed for " +cls.getName()+ " in method " + method.getName());
                                //return true;
                            }
                        }
                    }
            }

            }
            System.out.println("Test complete");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }
}
