package com.example.demo.controller;

import com.example.demo.Enum.RoleUser;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.entity.dto.AuthenticationDTO;
import com.example.demo.entity.dto.LoginResponseDTO;
import com.example.demo.entity.dto.RegistrarDTO;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.TokenService;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data){
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(userNamePassword);
        UsuarioEntity user= (UsuarioEntity) auth.getPrincipal();
        var token = tokenService.generateToken(user);

        return ResponseEntity.ok(new LoginResponseDTO(token, user));
    }

    @PostMapping("/registrar")
    public  ResponseEntity<UsuarioEntity> registrar(@RequestBody @Valid RegistrarDTO data){
        if(this.usuarioRepository.findByEmail(data.getLogin()) != null){
            ResponseEntity.badRequest().build();
        }
        else {
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.getSenha());
            UsuarioEntity newUser = new UsuarioEntity(data.getNome(), data.getLogin(), encryptedPassword, RoleUser.USER);
            this.usuarioRepository.save(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
            //return ResponseEntity.ok().build();
        }
        return null;
    }

}
