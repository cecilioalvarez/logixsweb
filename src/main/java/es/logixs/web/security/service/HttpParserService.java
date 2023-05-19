package es.logixs.web.security.service;

import es.logixs.web.security.mappings.UserAutenticated;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class HttpParserService {

    private long expiracion = 3600000; //esto es el tiempo de expiracion del token
    private String claveEncriptar = "superclave";

    // que es la que se denomina portador nos identifica el portador
    private String prefijoToken = "Bearer";

    //la cabecera en donde vamos a ubicar el token que es la cabecera de authorization
    private String cabeceraHttp = "Authorization";


    private TokenService tokenService; //usar el propio servicio de token que hemos desarrollado



    public void creaToken(HttpServletResponse response , String usuario) {

        String JWT = new TokenService().creaToken(usuario,claveEncriptar,new Date(System.currentTimeMillis()+expiracion));

        response.addHeader(cabeceraHttp, prefijoToken + " " + JWT);


    }

    public Authentication leeToken (HttpServletRequest request) {


        String token = request.getHeader(cabeceraHttp);
        //simplemente el hash completo del token
        System.out.println(token);



        if (token!=null) {
            String tokenReal=token.substring(token.indexOf(" ")+1);
            System.out.println("<"+tokenReal+">");
            String usuario = new TokenService().leeToken(tokenReal,claveEncriptar);
            if(usuario!=null) {

                return new UserAutenticated(usuario);

            }

        }


        return null;

    }


}
