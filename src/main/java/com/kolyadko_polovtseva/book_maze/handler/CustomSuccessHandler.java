//package com.kolyadko_polovtseva.book_maze.handler;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.RedirectStrategy;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
///**
// * Created by DaryaKolyadko on 03.12.2016.
// */
//@Component
//public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//    private static final Logger LOG = LogManager.getLogger(CustomSuccessHandler.class);
//
//    private RedirectStrategy redirectStrategy;
//
//    @Override
//    protected void handle(HttpServletRequest request, HttpServletResponse response,
//                          Authentication authentication) throws IOException {
//        String targetUrl = determineTargetUrl(authentication);
//
//        if (response.isCommitted()) {
//           LOG.warn("Can't redirect because of response was committed.");
//            return;
//        }
//
//        redirectStrategy.sendRedirect(request, response, targetUrl);
//    }
//
//    /*
//     * This method extracts the roles of currently logged-in user and returns
//     * appropriate URL according to his role.
//     */
//    protected String determineTargetUrl(Authentication authentication) {
//        String url = "";
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        List<String> roles = new ArrayList<>();
//
//        for (GrantedAuthority a : authorities) {
//            roles.add(a.getAuthority());
//        }
//
//        if (isDba(roles)) {
//            url = "/db";
//        } else if (isAdmin(roles)) {
//            url = "/admin";
//        } else if (isUser(roles)) {
//            url = "/home";
//        } else {
//            url = "/accessDenied";
//        }
//
//        return url;
//    }
//
//    private boolean checkRole(List<String> roles, String role) {
//        return role.contains(role);
//    }
//
//    @Autowired
//    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
//        this.redirectStrategy = redirectStrategy;
//    }
//
//    protected RedirectStrategy getRedirectStrategy() {
//        return redirectStrategy;
//    }
//}