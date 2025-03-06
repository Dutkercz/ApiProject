package com.medvoll.ApiProject.controllers;

import com.medvoll.ApiProject.entities.consulta.ConsultaDadosDTO;
import com.medvoll.ApiProject.entities.consulta.ConsultaListagemDTO;
import com.medvoll.ApiProject.entities.enums.Especialidade;
import com.medvoll.ApiProject.services.ConsultaAgendamentoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.SpyBeans;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultaControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private JacksonTester<ConsultaDadosDTO> dadosJsonTest;
    @Autowired
    private JacksonTester<ConsultaListagemDTO> dadosListagemTest;
    @MockitoBean
    private ConsultaAgendamentoService agendamentoService;

    @Test
    @DisplayName("Deveria retornar erro Http 400 quando a informações forem inválidas")
    @WithMockUser //ingnora segurança e simula um user logado.
    void agendarConsultaCenario1() throws Exception {
        var response = mvc.perform(post("/consultas")).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria retornar 200 OK quando as informações forem válidas")
    @WithMockUser //ingnora segurança e simula um user logado.
    void agendarConsultaCenario2() throws Exception {
        var data = LocalDateTime.now().plusHours(1);
        var especialidade = Especialidade.DERMATOLOGIA;
        var dadosConsulta = new ConsultaListagemDTO(null, 1L, 2L, data, especialidade);

        when(agendamentoService.agendarConsulta(any())).thenReturn(dadosConsulta);

        var responseJson = mvc.perform(post("/consultas")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(dadosJsonTest.write(new ConsultaDadosDTO(1L, 2L, data, especialidade))
                        .getJson())
        ).andReturn().getResponse();

        assertThat(responseJson.getStatus()).isEqualTo(HttpStatus.OK.value());

        var jsonEsperado = dadosListagemTest.write(dadosConsulta).getJson();

        assertThat(responseJson.getContentAsString()).isEqualTo(jsonEsperado);
    }
}