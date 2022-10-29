package com.java.recode.global.security.util;

import com.java.recode.global.security.auth.AuthDetails;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static AuthDetails getCurrentUser() {
        return (AuthDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
