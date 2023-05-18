package es.logixs.web.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.logixs.web.security.mappings.User;
import es.logixs.web.security.service.HttpParserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterLogin extends AbstractAuthenticationProcessingFilter {

    private HttpParserService httpParserService;


    public FilterLogin(String url , AuthenticationManager manager) {

        super(url);
        System.out.println("entra por aqui aqui");
        System.out.println(manager);
        httpParserService= new HttpParserService();
        setAuthenticationManager(manager);

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {


        //lee el usuario y la clave de una peticion post en la cual los adjuntemos via json

        System.out.println("entramos en intentar autenticar");
        User usuario = new ObjectMapper().readValue(request.getInputStream(),User.class);
        UsernamePasswordAuthenticationToken usuarioSpring = new UsernamePasswordAuthenticationToken(usuario.getName(), usuario.getPassword());
        return getAuthenticationManager().authenticate(usuarioSpring);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication autentication) throws IOException, ServletException {

        System.out.println("entramos en exito");
        String nombreUsuario= autentication.getName();
        httpParserService.creaToken(response, nombreUsuario);

    }





}
