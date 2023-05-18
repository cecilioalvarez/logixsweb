package es.logixs.web.security.filters;

import es.logixs.web.security.service.HttpParserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class FilterJWTAuthentication extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // asumimos que recibimos un token , que es nuestro token jwt con el usuario que necesitamos
        Authentication authentication = new HttpParserService().leeToken((HttpServletRequest)request);

        //asigna token de autenticacion que acabamos de validar con el servicio httpparser
        System.out.println("llega al filtro de authenticacion");
        System.out.println(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request,response);


    }
}
