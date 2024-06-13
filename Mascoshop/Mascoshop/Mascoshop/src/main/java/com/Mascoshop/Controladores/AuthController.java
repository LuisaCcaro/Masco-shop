package com.Mascoshop.Controladores;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Mascoshop.Entidades.Rol;
import com.Mascoshop.Entidades.Usuario;
import com.Mascoshop.Repositorios.RepositorioUsuario;

@RestController
public class AuthController {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @PostMapping("/login")
    public ResponseMessage login(@RequestBody UsuarioRequest request) {
        Usuario usuario = repositorioUsuario.findByNombreUsuario(request.getNombreUsuario());
        if (usuario != null && usuario.getContrasena().equals(request.getContrasena())) {
            return new ResponseMessage("login exitoso");
        } else {
            return new ResponseMessage("credenciales incorrectas");
        }
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody UsuarioRequest request) {
        try {
            Rol rolCliente = new Rol();
            rolCliente.setIdRol(3);
            Usuario nuevoUsuario = new Usuario(
                0, request.getNombre(),
                request.getApellido(),
                request.getCorreo(),
                request.getContrasena(),
                request.getNombreUsuario(),
                request.getDireccion(),
                request.getTelefono(), rolCliente, null
            );
            // Realiza la validación y persistencia del usuario en la base de datos
            Usuario nuevoUsuarioPersistido = repositorioUsuario.save(nuevoUsuario);
    
            // Devuelve la respuesta adecuada según el resultado de la operación de persistencia
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
        } catch (DataIntegrityViolationException ex) {
            ex.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "El usuario ya existe en la base de datos.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error al crear el usuario: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
    


    public static class UsuarioRequest {
        private String nombre;
        private String apellido;
        private String correo;
        private String contrasena;
        private String nombreUsuario;
        private String direccion;
        private String telefono;
        private Rol rol;

        // Getters y setters
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getContrasena() {
            return contrasena;
        }

        public void setContrasena(String contrasena) {
            this.contrasena = contrasena;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public void setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public Rol getRol() {
            return rol;
        }

        public void setRol(Rol rol) {
            this.rol = rol;
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

