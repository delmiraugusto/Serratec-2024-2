package br.com.serratec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.DTO.ProdutoRequestDTO;
import br.com.serratec.DTO.ProdutoResponseDTO;
import br.com.serratec.entity.Categoria;
import br.com.serratec.entity.Produto;
import br.com.serratec.repository.CategoriaRepository;
import br.com.serratec.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	 public List<ProdutoResponseDTO> listar() {
	        List<Produto> produtos = produtoRepository.findAll();
	        List<ProdutoResponseDTO> produtoResponseDTOs = new ArrayList<>();
	        for (Produto produto : produtos) {
	            ProdutoResponseDTO dto = new ProdutoResponseDTO(produto);
	            produtoResponseDTOs.add(dto);
	        }
	        return produtoResponseDTOs;
	    }
	 
	 @Transactional
		public ProdutoResponseDTO inserir(ProdutoRequestDTO dto) {
			Optional<Categoria> categorias = categoriaRepository.findById(dto.getNomeCategoria());
			Produto produtos = new Produto();
			if (categorias.isPresent()) {
				produtos.setCategoria(categorias.get());
			}
			else {
				throw new EntityNotFoundException("Categoria não existente");
			}
			produtos.setNome(dto.getNomeProduto());
			produtos.setValor(dto.getValorProduto());
			produtos.setQuantidadeEstoque(dto.getQtdEstoque());
			produtoRepository.save(produtos);
			
			return new ProdutoResponseDTO(produtos);
		}
	 
	 @Transactional
	 public ProdutoResponseDTO alterar(Long id, ProdutoRequestDTO dto) {
	     Produto produto = produtoRepository.findById(id)
	         .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
	     
	     produto.setNome(dto.getNomeProduto());
	     produto.setValor(dto.getValorProduto());
	     produto.setQuantidadeEstoque(dto.getQtdEstoque());
	     
	     produtoRepository.save(produto);
	     
	     return new ProdutoResponseDTO(produto);
	 }
	 
}