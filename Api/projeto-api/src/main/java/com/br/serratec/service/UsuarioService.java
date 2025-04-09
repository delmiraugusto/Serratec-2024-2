package com.br.serratec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.serratec.config.MailConfig;
import com.br.serratec.dto.UsuarioRequestDTO;
import com.br.serratec.dto.UsuarioResponseDTO;
import com.br.serratec.entity.Usuario;
import com.br.serratec.exception.EmailException;
import com.br.serratec.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private MailConfig mailConfig;
	
	public List<UsuarioResponseDTO> listar(){
		List<Usuario> usuarios =  repository.findAll();
		List<UsuarioResponseDTO> dtos = new ArrayList<>();
		for (Usuario usuario : usuarios) {
			dtos.add(new UsuarioResponseDTO(usuario));
		}
		return dtos;
	}
	
	public UsuarioRequestDTO inserir(Usuario usuario) {
		Optional <Usuario> u = repository.findByEmail(usuario.getEmail());
		if(u.isPresent()) {
			throw new EmailException("Email existente!");
		}
			usuario.setSenha(encoder.encode(usuario.getSenha()));
			usuario = repository.save(usuario);
			mailConfig.sendEmail(usuario.getEmail(), "Confirmação de cadastro", usuario.toString());
			return new UsuarioRequestDTO(repository.save(usuario));
	}
}