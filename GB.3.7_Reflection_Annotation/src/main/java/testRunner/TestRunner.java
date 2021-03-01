package testRunner;

import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.PageEntry;
import annotations.Test;
import exceptions.AssertEqualsException;
import exceptions.NoFindTestsClasses;
import org.apache.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestRunner {

    private static final Logger logger = Logger.getLogger(TestRunner.class);

    public static void main(String[] args) {

        Set<Class<?>> testsClasses = getTestsClasses();
        for (Class<?> tClass : testsClasses) {
            start(tClass);
        }
    }

    /**
     * Запуск прогона тестов
     *
     * @param tClass тестируемый класс
     */
    public static void start(Class<?> tClass) {
        Method[] methods = tClass.getDeclaredMethods();

        // Проверка BeforeAfterSuites на кол-во
        checkCountBeforeAfterSuites(methods);

        // Выполнение BeforeSuite, если есть
        runBeforeSuite(tClass, methods);

        // Выполнение тестов
        runTests(tClass, methods);

        // Выполнение AfterSuite
        runAfterSuite(tClass, methods);
    }

    /**
     * Получение тестовых классов
     *
     * @return тестовые классы
     */
    private static Set<Class<?>> getTestsClasses() {
        Reflections reflections = new Reflections("tests", new TypeAnnotationsScanner());

        Set<Class<?>> typesAnnotatedWith;

        try {
            typesAnnotatedWith = reflections.getTypesAnnotatedWith(PageEntry.class, true);
        } catch (Exception ignore) {
            logger.info("Тестовые классы не найдены");
            throw new NoFindTestsClasses("Тестовые классы не найдены");
        }

        return typesAnnotatedWith;
    }

    /**
     * Если BeforeClass или AfterClass аннотаций указано больше, чем по 1
     *
     * @param methods все методы в классе
     */
    private static void checkCountBeforeAfterSuites(Method[] methods) {
        int countBeforeAfterSuite = 0;

        for (Method o : methods) {
            if ((o.getDeclaredAnnotation(BeforeSuite.class) != null) || (o.getDeclaredAnnotation(AfterSuite.class) != null))
                countBeforeAfterSuite++;
            if (countBeforeAfterSuite > 2) {
                logger.info(String.format("Превышен лимит аннотаций BeforeClass || AfterClass [%s]", countBeforeAfterSuite));
                throw new RuntimeException(String.format("Превышен лимит аннотаций BeforeClass || AfterClass [%s]", countBeforeAfterSuite));
            }
        }
    }

    /**
     * Запуск BeforeSuite
     *
     * @param tClass  класс
     * @param methods методы в классе
     */
    private static void runBeforeSuite(Class<?> tClass, Method[] methods) {
        for (Method o : methods) {
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                try {
                    o.invoke(tClass.newInstance());
                    logger.info("Выполнение before метода");
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NullPointerException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    /**
     * Запуск AfterSuite
     *
     * @param tClass  класс
     * @param methods методы в классе
     */
    private static void runAfterSuite(Class<?> tClass, Method[] methods) {
        for (Method o : methods) {
            if (o.isAnnotationPresent(AfterSuite.class)) {
                try {
                    o.invoke(tClass.newInstance());
                    logger.info("Выполнение after метода");
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NullPointerException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    /**
     * Запуск тестов с аннотацией @Test
     *
     * @param tClass  класс
     * @param methods методы
     */
    private static void runTests(Class<?> tClass, Method[] methods) {

        // Получаем сортированную мапу, где ключ - order, value - method
        Map<Integer, Method> treeMapOfPriorityTestRun = testPriority(methods);

        // Запуск тестов
        ArrayList<Method> sortedListOfMethods = new ArrayList<>(treeMapOfPriorityTestRun.values());
        for (Method method : sortedListOfMethods) {
            try {
                Boolean testResult = (Boolean) method.invoke(tClass.newInstance());
                if (testResult) {
                    logger.info(String.format("Тест %s прошёл проверку", method.getName()));
                } else try {
                    throw new AssertEqualsException(String.format("Тест: %s не прошёл", method.getName()));
                } catch (AssertEqualsException e) {
                    e.printStackTrace();
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NullPointerException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * Получаем последовательно выполнение тестов
     *
     * @param methods методы
     * @return TreeMap последовательность методотов, ключ - order
     */
    private static Map<Integer, Method> testPriority(Method[] methods) {
        Map<Integer, Method> treeMapOfPriorityTestRun = new TreeMap<>();
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == Test.class) {
                    Test test = (Test) annotation;
                    treeMapOfPriorityTestRun.put(test.order(), method);
                }
            }
        }
        return treeMapOfPriorityTestRun;
    }
}
