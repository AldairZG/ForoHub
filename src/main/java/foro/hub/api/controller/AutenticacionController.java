package foro.hub.api.controller;

import foro.hub.api.domain.usuario.DatosAutenticaUsuario;
import foro.hub.api.domain.usuario.Usuario;
import foro.hub.api.infra.security.DatosJWTToken;
import foro.hub.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;;

    @PostMapping
    public ResponseEntity autenticaUsuario(@RequestBody @Valid DatosAutenticaUsuario datosAutenticaUsuario){
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticaUsuario.nombre(),
                datosAutenticaUsuario.contrasena());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }

}
