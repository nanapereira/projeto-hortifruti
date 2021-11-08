package com.br.backendhortifruti.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.backendhortifruti.model.Produto;
import com.br.backendhortifruti.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	private ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Produto>> consultarProdutos() {
        return new ResponseEntity<>(produtoService.consultarProdutos(), HttpStatus.OK);
    }

	@PostMapping("")
	public ResponseEntity<Produto> incluirProduto(@RequestBody Produto produto){
		return new ResponseEntity<Produto>(produtoService.incluirProduto(produto), HttpStatus.CREATED);		
	}
	
}