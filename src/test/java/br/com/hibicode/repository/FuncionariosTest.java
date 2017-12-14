package br.com.hibicode.repository;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.hibicode.model.Funcionario;
import com.hibicode.repository.Funcionarios;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@ActiveProfiles("test")
public class FuncionariosTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private Funcionarios funcionarios;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = webAppContextSetup(webApplicationContext).alwaysDo(print()).build();
		funcionarios.deleteAllInBatch();
	}

	@Test
	public void deve_pesquisar_funcionario_por_nome() throws Exception {
		Funcionario maria = new Funcionario();
		maria.setNome("Maria Correia");
		maria.setCpf("800.819.326-34");
		maria.setEmail("mariac@email.com");
		funcionarios.save(maria);
		
		mockMvc.perform(get("/funcionarios/search/findByNome?nome={nome}", "Correia")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$._embedded.funcionarios", hasSize(1)))
		.andExpect(jsonPath("$._embedded.funcionarios[0].nome", is("Maria Correia")));
	}
	
	
}
