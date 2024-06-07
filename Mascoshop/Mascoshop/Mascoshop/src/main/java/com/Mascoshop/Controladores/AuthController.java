package com.Mascoshop.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Mascoshop.Entidades.Usuario;
import com.Mascoshop.Repositorios.RepositorioUsuario;

@RestController
public class AuthController {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @PostMapping("/login")
    public ResponseMessage login(@RequestBody UsuarioRequest request) {
        Usuario usuario = repositorioUsuario.findByNombreUsuario(request.getUsername());
        if (usuario != null && usuario.getContrasena().equals(request.getPassword())) {
            return new ResponseMessage("login exitoso");
        } else {
            return new ResponseMessage("credenciales incorrectas");
        }
    }

    public static class UsuarioRequest {
        private String username;
        private String password;

        // Getters y setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class ResponseMessage {
        private String message;

        public ResponseMessage(String message) {
            this.message = message;
        }

        // Getter para message
        public String getMessage() {
            return message;
        }
    }
}

