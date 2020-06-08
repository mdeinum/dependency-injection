package biz.deinum.moneytransfer.field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public abstract class ReflectionUtil {

    private static final Logger log = LoggerFactory.getLogger(ReflectionUtil.class);

    private ReflectionUtil() {}

    /**
     * Set the value of the {@code field} for the given {@code target} with the given {@code value}. The lookup
     * is done on a name basis.
     */
    public static void setFieldsByName(Object target, Map<String, Object> context) {
        var fields = target.getClass().getDeclaredFields();

        Stream.of(fields)
                .filter(it -> Objects.isNull(getField(it, target)))
                .forEach(it -> {
                    var name = it.getName();
                    var value = context.get(name);
                    if (value == null || !it.getType().isAssignableFrom(value.getClass())) {
                        var msg = String.format("Cannot inject '%s' into field '%s' of '%s'", value, name, target.getClass());
                        throw new IllegalStateException(msg);
                    } else {
                        setField(it, target, value);
                    }
                });
    }

    /**
     * Set the value of the {@code field} for the given {@code target} with the given {@code type}. The lookup
     * is done on a type basis.
     */
    public static void setFieldsByType(Object target, Map<String, Object> context) {
        Field[] fields = target.getClass().getDeclaredFields();

        for (Object value : context.values()) {
            Stream.of(fields)
                    .filter(it -> it.getType().isAssignableFrom(value.getClass()))
                    .filter(it -> Objects.isNull(getField(it, target)))
                    .forEach(it -> setField(it, target, value));
        }
    }

    private static Object getField(Field field, Object target) {
        field.setAccessible(true);
        try {
            log.info("Getting field '{}' of '{}' '", field.getName(), target);
            return field.get(target);
        } catch (IllegalAccessException e) {
            var msg = String.format("Cannot get field: %s of: %s", field, target.getClass());
            throw new IllegalStateException(msg, e);
        }
    }

    private static void setField(Field field, Object target, Object value) {
        field.setAccessible(true);
        try {
            log.info("Setting field '{}' of '{}' to '{}'", field.getName(), target, value);
            field.set(target, value);
        } catch (IllegalAccessException e) {
            var msg = String.format("Cannot set field: %s with value: %s", field, value);
            throw new IllegalStateException(msg, e);
        }
    }
}
