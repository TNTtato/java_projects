package com.springapp.proyjav.controllers;

import com.springapp.proyjav.dao.UsuarioDAO;
import com.springapp.proyjav.models.Usuario;
import com.springapp.proyjav.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDAO usuariodao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value="api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable long id) {
        Usuario user = new Usuario();
        user.setId(id);
        user.setNombre("Gustavo");
        user.setApellido("Penaranda");
        user.setEmail("penarandagustavo5@gmail.com");
        user.setTelefono("3196800087");
        user.setPassword("Alonso18!");
        return user;
    }

    @RequestMapping(value="api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token) {
        if (!validarToken(token)) return null;
        return usuariodao.getUsuarios();
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    @RequestMapping(value="api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
        //seguridad hashes
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuariodao.registrar(usuario);
    }

    @RequestMapping(value="api/usuarios/A")
    public Usuario editUsuario() {
        Usuario user = new Usuario();
        user.setNombre("Gustavo");
        user.setApellido("Penaranda");
        user.setEmail("penarandagustavo5@gmail.com");
        user.setTelefono("3196800087");
        user.setPassword("Alonso18!");
        return user;
    }

    @RequestMapping(value="api/usuarios/{id}", method = RequestMethod.DELETE)
    public void delUsuario(@RequestHeader(value = "Authorization") String token,
            @PathVariable Long id) {
        if (!validarToken(token)) return;
        usuariodao.eliminar(id);
    }

}
