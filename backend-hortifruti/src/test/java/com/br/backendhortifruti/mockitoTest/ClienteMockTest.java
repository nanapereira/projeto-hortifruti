package com.br.backendhortifruti.mockitoTest;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.br.backendhortifruti.model.entity.Cliente;
import com.br.backendhortifruti.model.repository.ClienteRepository;
import com.br.backendhortifruti.model.service.impl.ClienteServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ClienteMockTest {
	
	@Mock
	private ClienteRepository clienteRepository;
	
	@InjectMocks
	private ClienteServiceImpl clienteServiceImpl;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@DisplayName("Cadastrar um novo cliente")
	@Test
	public void incluirClienteMockTest() {
		Cliente cliente = new Cliente();
		
		when(clienteRepository.save(Mockito.any(Cliente.class))).thenReturn(cliente);
		
		cliente.setNome("Inajara Pereira");
		cliente.setTipo('F');
		cliente.setDocumento("063.785.409-85");
		cliente.setTelefone("99999999999");
		
		Cliente clienteResponse = clienteServiceImpl.incluirCliente(cliente);
		assertEquals(clienteResponse.getNome(), "Inajara Pereira");
		assertEquals(clienteResponse.getTipo(), 'F');
		assertEquals(clienteResponse.getDocumento(), "063.785.409-85");
		assertEquals(clienteResponse.getTelefone(), "99999999999");
	}
	
	@DisplayName("Alterar cliente")
	@Test
	public void alterarClienteMockTest() {
		Cliente cliente = new Cliente();
		
		when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente)); 
		when(clienteRepository.save(Mockito.any(Cliente.class))).thenReturn(cliente);
		
		cliente.setNome("Bruna Lima");
		cliente.setTipo('F');
		cliente.setDocumento("072.097.771-13");
		cliente.setTelefone("99999999999");
		
		Cliente clienteResponse = clienteServiceImpl.alterarCliente(cliente, 1);
		assertEquals(clienteResponse.getNome(), "Bruna Lima");
		assertEquals(clienteResponse.getTipo(), 'F');
		assertEquals(clienteResponse.getDocumento(), "072.097.771-13");
		assertEquals(clienteResponse.getTelefone(), "99999999999");
	} 
	
	@DisplayName("Consultar lista de clientes")
	@Test
	public void consultarClientesTest() {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		when(clienteRepository.findAll()).thenReturn(listaClientes);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Bruna Lima");
		cliente.setTipo('F');
		cliente.setDocumento("072.097.771-13");
		cliente.setTelefone("99999999999");
		listaClientes.add(cliente);
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Joaozinho Silva");
		cliente1.setTipo('F');
		cliente1.setDocumento("072.097.771-13");
		cliente1.setTelefone("111111111");
		listaClientes.add(cliente1);
		
		List<Cliente> clienteResponse = clienteServiceImpl.consultarClientes();
		assertNotNull(clienteResponse);
		assertThat(listaClientes.size() == 2);
	}
	
	@DisplayName("Consultar cliente por ID")
	@Test
	public void consultarClienteMockTest() {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		
		when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente));
		Cliente clienteResponse = clienteServiceImpl.consultarCliente(1);
		assertNotNull(clienteResponse);
		assertThat(cliente.getId() == 1);
	}
	
	@DisplayName("Consultar cliente por documento")
	@Test
	public void consultarClientePorDocumentoMockTest() {
		Cliente cliente = new Cliente();
		cliente.setDocumento("605.737.218-04");
		
		when(clienteRepository.findByDocumento("605.737.218-04")).thenReturn(Optional.of(cliente));
		Cliente clienteResponse = clienteServiceImpl.consultarClientePorDocumento("605.737.218-04");
		assertNotNull(clienteResponse);
		assertThat(cliente.getDocumento() == "605.737.218-04");
	}
}