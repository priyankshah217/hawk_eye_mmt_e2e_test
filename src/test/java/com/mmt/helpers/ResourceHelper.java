package com.mmt.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.mmt.annotations.Data;
import com.mmt.annotations.Locators;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reflections.Reflections;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;

public class ResourceHelper {

    public static <T> T getData(String dataFileName) {
        return getResourceObject(dataFileName, Data.class);
    }

    public static <T> T getLocators(String dataFileName) {
        return getResourceObject(dataFileName, Locators.class);
    }

    private static <T> T getResourceObject(String resourceFileName, Class<? extends Annotation> annotation) {
        InputStream resourceAsStream = getInputStream(resourceFileName);
        Class<?> selectedClass = getSelectedClass(resourceFileName, annotation);
        return getResourceObjectFor(resourceAsStream, selectedClass);
    }

    @Nullable
    @SuppressWarnings("unchecked")
    private static <T> T getResourceObjectFor(InputStream resourceAsStream, Class<?> selectedClass) {
        T instance = null;
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            instance = (T) objectMapper.readValue(resourceAsStream, selectedClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instance;
    }

    private static Class<?> getSelectedClass(String resourceFileName, Class<? extends Annotation> annotation) {
        String requiredClassName = getRequiredDataClassName(resourceFileName);
        String packageName = "com.mmt";
        Reflections reflections = new Reflections(packageName);
        return reflections.getTypesAnnotatedWith(annotation)
                .stream()
                .filter(c -> c.getName().toLowerCase().contains(requiredClassName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Locator file is not present"));
    }

    private static String getRequiredDataClassName(String resourceFileName) {
        return resourceFileName.split(File.separator)[1].split("\\.")[0];
    }

    @NotNull
    private static InputStream getInputStream(String resourceFileName) {
        InputStream resourceAsStream = ResourceHelper.class.getClassLoader().getResourceAsStream(resourceFileName);
        if (resourceAsStream == null) {
            throw new RuntimeException("Invalid resource file: " + resourceFileName);
        }
        return resourceAsStream;
    }
}
