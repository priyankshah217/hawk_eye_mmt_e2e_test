package com.mmt.helpers;

import com.mmt.annotations.Page;
import com.mmt.annotations.PageComponent;
import com.mmt.ui_layer.components.search.SearchComponent;
import com.mmt.ui_layer.pages.base.UILayer;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class PageHelper {

    @SuppressWarnings("unchecked")
    public static <T extends UILayer> T getPage(String pageName) {
        Reflections reflections = new Reflections("com.mmt");
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Page.class);
        Class<?> componentClass = typesAnnotatedWith
                .stream()
                .filter(aClass -> aClass.getName().toLowerCase().contains(pageName.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Page is not present"));
        try {
            return (T) componentClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T extends SearchComponent> T getSearchComponent(String componentName) {
        Reflections reflections = new Reflections("com.mmt");
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(PageComponent.class);
        Class<?> componentClass = typesAnnotatedWith
                .stream()
                .filter(aClass -> aClass.getName().toLowerCase().contains(componentName.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Search Category Not Present"));
        try {
            return (T) componentClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}