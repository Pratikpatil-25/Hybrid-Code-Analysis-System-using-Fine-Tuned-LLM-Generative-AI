package com.vaadin.flow.data.provider;

import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.function.SerializableComparator;
import com.vaadin.flow.function.SerializablePredicate;


public final class DataViewUtils {

    private static final String COMPONENT_IN_MEMORY_FILTER_KEY = "component-in-memory-filter-key";
    private static final String COMPONENT_IN_MEMORY_SORTING_KEY = "component-in-memory-sorting-key";

    private DataViewUtils() {
            }

    
    @SuppressWarnings("unchecked")
    public static <T> Optional<SerializablePredicate<T>> getComponentFilter(
            Component component) {
        return Optional.ofNullable((SerializablePredicate<T>) ComponentUtil
                .getData(component, COMPONENT_IN_MEMORY_FILTER_KEY));
    }

    
    @SuppressWarnings("unchecked")
    public static <T> Optional<SerializableComparator<T>> getComponentSortComparator(
            Component component) {
        return Optional.ofNullable((SerializableComparator<T>) ComponentUtil
                .getData(component, COMPONENT_IN_MEMORY_SORTING_KEY));
    }

    
    public static <T> void setComponentFilter(Component component,
            SerializablePredicate<T> filter) {
        ComponentUtil.setData(component, COMPONENT_IN_MEMORY_FILTER_KEY,
                filter);
    }

    
    public static <T> void setComponentSortComparator(Component component,
            SerializableComparator<T> sortComparator) {
        ComponentUtil.setData(component, COMPONENT_IN_MEMORY_SORTING_KEY,
                sortComparator);
    }

    
    public static void removeComponentFilterAndSortComparator(
            Component component) {
        setComponentFilter(component, null);
        setComponentSortComparator(component, null);
    }

    
    @SuppressWarnings({ "rawtypes" })
    public static Query getQuery(Component component) {
        return getQuery(component, true);
    }

    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Query getQuery(Component component, boolean withSorting) {
        final Optional<SerializablePredicate<Object>> filter = DataViewUtils
                .getComponentFilter(component);

        final Optional<SerializableComparator<Object>> sorting = withSorting
                ? DataViewUtils.getComponentSortComparator(component)
                : Optional.empty();

        return new Query(0, Integer.MAX_VALUE, null, sorting.orElse(null),
                filter.orElse(null));
    }
}