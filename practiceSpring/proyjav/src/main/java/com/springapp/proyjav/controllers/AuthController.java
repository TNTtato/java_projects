package com.springapp.proyjav.controllers;

import com.springapp.proyjav.dao.UsuarioDAO;
import com.springapp.proyjav.models.Usuario;
import com.springapp.proyjav.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDAO usuariodao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value="api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {
        Usuario usuarioLoggeado = usuariodao.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLoggeado != null) {
            String tokenJWT = jwtUtil.create(String.valueOf(usuarioLoggeado.getId()), usuarioLoggeado.getEmail());
            return tokenJWT;
        }
        return "FAIL";
    }
}
