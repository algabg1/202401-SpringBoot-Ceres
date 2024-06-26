package com.example.demo.utils;

import com.example.demo.Enum.TipoProjetoEnum;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

/**
 *
 */
public abstract class Utils{
    /**
     *
     * @param value
     * @param enumClass
     * @return
     * @param <E>
     */
    public static <E extends Enum<E>> boolean findMatchEnum(String value, Class<E> enumClass) {
        for (E constant : enumClass.getEnumConstants()) {
            if (constant.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
