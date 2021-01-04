

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CustomTest {
    String executeMethod() default "";
}

class Feature1 {
    @CustomTest
    void test1Feature1() {
        System.out.println("Inside Feature1 Test1");
    }

    @CustomTest
    void test2Feature1() {
        System.out.println("Inside Feature1 Test1");
    }
}

class Feature2 {
    @CustomTest
    void test1Feature2() {
        System.out.println("Inside Feature2 Test1");
    }

    @CustomTest
    void test2Feature2() {
        System.out.println("Inside Feature2 Test2");
    }
}

/*
This is why your test does not need main method, Your all test methods were discovered using @Test annotations at runtime
by Junit or TestNG runner (you can further dig into their repo). All method invocation happened through reflections.
*/

public class CustomTestRunner {
    public static void main(String[] args) {
        Set<Method> methodsAnnotatedWith = new Reflections(new MethodAnnotationsScanner())
                .getMethodsAnnotatedWith(CustomTest.class);
        for (Method method : methodsAnnotatedWith) {
            try {
                Object obj = method.getDeclaringClass().getDeclaredConstructors()[0].newInstance();
                method.invoke(obj);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

//                Output

//                Inside Feature2 Test1
//                Inside Feature2 Test2
//                Inside Feature1 Test1
//                Inside Feature1 Test1
