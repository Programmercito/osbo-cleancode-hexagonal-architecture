package com.nisum.appsample.controlers;

import com.nisum.appsample.model.entities.Usuario;
import com.nisum.appsample.model.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esta clase proporciona un controlador para el endpoint "/user". El método
 * "insert" se utiliza para crear un nuevo usuario.
 * @author programmercito
*/
@RestController
@Validated
public class UsuarioController {

    @Autowired
    UsuarioService userservice;

    /**
     * Este método se utiliza para crear un nuevo usuario.
     *
     * @param usuario El usuario que se va a crear.
     * @return Un objeto ResponseEntity que contiene el usuario creado.
     */
    @Operation(summary = "Crear un nuevo usuario")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity insert(@Valid @RequestBody Usuario usuario) {
        Usuario user = userservice.save(usuario);
        return ResponseEntity.ok(user);
    }

}
