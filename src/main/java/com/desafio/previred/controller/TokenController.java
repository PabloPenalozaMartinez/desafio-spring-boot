package com.desafio.previred.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.previred.security.JWTUtil;

@RestController
public class TokenController {
	
    @Autowired
    private JWTUtil jwtUtil;
	
	@GetMapping("/token/{nombreUsuario}")
    public ResponseEntity<String> obtenerToken(@PathVariable("nombreUsuario") String nombreUsuario){
		return new ResponseEntity(jwtUtil.generateToken(nombreUsuario), HttpStatus.OK);
    }
	
}
