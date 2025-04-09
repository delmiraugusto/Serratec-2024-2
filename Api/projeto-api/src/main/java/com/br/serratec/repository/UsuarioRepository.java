package com.br.serratec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.serratec.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByNome(String nome);
	
	Optional<Usuario> findByEmail(String email);
}
