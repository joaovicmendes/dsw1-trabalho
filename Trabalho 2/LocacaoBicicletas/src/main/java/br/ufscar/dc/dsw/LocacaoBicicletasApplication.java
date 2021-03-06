package br.ufscar.dc.dsw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import br.ufscar.dc.dsw.domain.*;
import br.ufscar.dc.dsw.dao.*;

@SpringBootApplication
public class LocacaoBicicletasApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocacaoBicicletasApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, IClienteDAO clienteDAO, ILocadoraDAO locadoraDAO, ILocacaoDAO locacaoDAO, BCryptPasswordEncoder encoder) {
		return (args) -> {
						
			Usuario user = new Usuario();
			user.setUsername("admin");
			user.setPassword(encoder.encode("admin"));
			user.setRole("ROLE_ADMIN");
			user.setEnabled(true);
			usuarioDAO.save(user);

			Cliente c1 = new Cliente();
			c1.setUsername("alice@gmail.com");
			c1.setPassword(encoder.encode("alice"));
			c1.setRole("ROLE_CLIENTE");
			c1.setEnabled(true);
			c1.setCPF("111.222.333-44");
			c1.setNome("Alice");
			c1.setTelefone("00 9 0000-0000");
			c1.setGenero("F");
			c1.setDataNascimento("01/01/1970");
			usuarioDAO.save(c1);

			Cliente c2 = new Cliente();
			c2.setUsername("bob@gmail.com");
			c2.setPassword(encoder.encode("bob"));
			c2.setRole("ROLE_CLIENTE");
			c2.setEnabled(true);
			c2.setCPF("111.222.333-55");
			c2.setNome("Bob");
			c2.setTelefone("00 9 0000-0000");
			c2.setGenero("M");
			c2.setDataNascimento("01/01/1970");
			usuarioDAO.save(c2);

			Locadora locadora1 = new Locadora();
			locadora1.setUsername("locadora_a@gmail.com");
			locadora1.setPassword(encoder.encode("locadora_a"));
			locadora1.setRole("ROLE_LOCADORA");
			locadora1.setEnabled(true);
			locadora1.setCNPJ("11.222.333/4444-55");
			locadora1.setNome("Locadora A");
			locadora1.setCidade("São Carlos");
			usuarioDAO.save(locadora1);

			Locadora locadora2 = new Locadora();
			locadora2.setUsername("locadora_b@gmail.com");
			locadora2.setPassword(encoder.encode("locadora_b"));
			locadora2.setRole("ROLE_LOCADORA");
			locadora2.setEnabled(true);
			locadora2.setCNPJ("11.222.333/4444-66");
			locadora2.setNome("Locadora B");
			locadora2.setCidade("Matão");
			usuarioDAO.save(locadora2);
			
			Locacao locacao1 = new Locacao();
			locacao1.setDataReserva("2021-01-01");
			locacao1.setHoraReserva(13);
			locacao1.setCliente(c1);
			locacao1.setLocadora(locadora1);
			locacaoDAO.save(locacao1);

			Locacao locacao2 = new Locacao();
			locacao2.setDataReserva("2021-02-02");
			locacao2.setHoraReserva(14);
			locacao2.setCliente(c1);
			locacao2.setLocadora(locadora2);
			locacaoDAO.save(locacao2);

			Locacao locacao3 = new Locacao();
			locacao3.setDataReserva("2021-03-03");
			locacao3.setHoraReserva(15);
			locacao3.setCliente(c2);
			locacao3.setLocadora(locadora2);
			locacaoDAO.save(locacao3);
		};
	}
}
