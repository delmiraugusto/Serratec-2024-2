package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Cliente;
import br.com.serratec.entity.Endereco;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
