package by.tms.tkach.lesson40.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class IdentityUtils {

    private static Long INITIAL = 1L;

    public Long generateId() {
        return INITIAL++;
    }
}
