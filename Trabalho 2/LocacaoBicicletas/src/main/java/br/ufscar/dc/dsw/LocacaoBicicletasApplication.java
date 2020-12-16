package br.ufscar.dc.dsw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ufscar.dc.dsw.domain.*;
import br.ufscar.dc.dsw.dao.*;

@SpringBootApplication
public class LocacaoBicicletasApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocacaoBicicletasApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, IClienteDAO clienteDAO, ILocadoraDAO locadoraDAO, ILocacaoDAO locacaoDAO) {
		return (args) -> {
						
			Usuario user = new Usuario();
			user.setUsername("admin");
			user.setPassword("admin");
			user.setRole("admin");
			user.setEnabled(true);
			usuarioDAO.save(user);

			Cliente c1 = new Cliente();
			c1.setUsername("alice@gmail.com");
			c1.setPassword("alice");
			c1.setRole("cliente");
			c1.setEnabled(true);
			c1.setCPF("111.222.333-44");
			c1.setNome("Alice");
			c1.setTelefone("00900000000");
			c1.setGenero("F");
			c1.setDataNascimento("01/01/1970");
			usuarioDAO.save(c1);

			Cliente c2 = new Cliente();
			c2.setUsername("bob@gmail.com");
			c2.setPassword("bob");
			c2.setRole("cliente");
			c2.setEnabled(true);
			c2.setCPF("111.222.333-55");
			c2.setNome("Bob");
			c2.setTelefone("00900000000");
			c2.setGenero("M");
			c2.setDataNascimento("01/01/1970");
			usuarioDAO.save(c2);

			Locadora locadora1 = new Locadora();
			locadora1.setUsername("locadora_a@gmail.com");
			locadora1.setPassword("locadora_a");
			locadora1.setRole("locadora");
			locadora1.setEnabled(true);
			locadora1.setCNPJ("11.222.333/4444-55");
			locadora1.setNome("Locadora A");
			locadora1.setCidade("São Carlos");
			usuarioDAO.save(locadora1);

			Locadora locadora2 = new Locadora();
			locadora2.setUsername("locadora_b@gmail.com");
			locadora2.setPassword("locadora_b");
			locadora2.setRole("locadora");
			locadora2.setEnabled(true);
			locadora2.setCNPJ("11.222.333/4444-66");
			locadora2.setNome("Locadora B");
			locadora2.setCidade("Matão");
			usuarioDAO.save(locadora2);
			
			Locacao locacao1 = new Locacao();
			locacao1.setDataReserva("01/01/2021 13h");
			locacao1.setCliente(c1);
			locacao1.setLocadora(locadora1);
			locacaoDAO.save(locacao1);

			Locacao locacao2 = new Locacao();
			locacao2.setDataReserva("02/01/2021 13h");
			locacao2.setCliente(c1);
			locacao2.setLocadora(locadora2);
			locacaoDAO.save(locacao2);

			Locacao locacao3 = new Locacao();
			locacao3.setDataReserva("01/01/2021 14h");
			locacao3.setCliente(c2);
			locacao3.setLocadora(locadora2);
			locacaoDAO.save(locacao3);
		};
	}
}
