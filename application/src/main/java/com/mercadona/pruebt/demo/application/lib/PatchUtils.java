package com.mercadona.pruebt.demo.application.lib;

import com.mercadona.pruebt.demo.application.exceptions.ErrorCode;
import com.mercadona.pruebt.demo.application.exceptions.PruebatException;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;

@UtilityClass
public class PatchUtils {

  public static <T> void patchObject(T target, T patch) {
    if (target == null || patch == null) {
      return;
    }

    Class<?> clazz = patch.getClass();
    for (Field field : clazz.getDeclaredFields()) {
      field.setAccessible(true);
      try {
        Object value = field.get(patch);

        if (value != null) {
          field.set(target, value);
        }

      } catch (IllegalAccessException e) {
        throw new PruebatException(ErrorCode.PATCH_EXCEPTION, field.getName(), e);
      }
    }
  }
}
