package com.medvoll.ApiProject.repositories;

import com.medvoll.ApiProject.entities.consulta.Consulta;
import com.medvoll.ApiProject.entities.endereco.EnderecoDTO;
import com.medvoll.ApiProject.entities.enums.Especialidade;
import com.medvoll.ApiProject.entities.medico.Medico;
import com.medvoll.ApiProject.entities.medico.MedicoDTO;
import com.medvoll.ApiProject.entities.paciente.Paciente;
import com.medvoll.ApiProject.entities.paciente.PacienteDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //configura para usar o mesmo
                                                    //banco de dados da aplicação.
@ActiveProfiles("test")
class MedicoRepositoryTest {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("Deveria devolver null quando o unico médico cadastrado não está disponível na data")
    void escolherMedicoAleatorioDisponivelCenario1() {
        //given ou arrange
        var proximaSegundaAs10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10, 0);
        var medico = cadastrarMedico("Medico", "@medico.com", "123456", Especialidade.CARDIOLOGIA);
        var paciente = cadastrarPaciente("Paciente", "@paciente.com", "00000000");
        cadastrarConsulta(medico, paciente, proximaSegundaAs10);

        //when ou act
        var medicoLivre =  medicoRepository.escolherMedicoAleatorioDisponivel(Especialidade.CARDIOLOGIA, proximaSegundaAs10);

        //then ou assert
        assertThat(medicoLivre).isNull();
    }

    @Test
    @DisplayName("Deveria devolver MEDICO quando ele estiver disponível na data")
    void escolherMedicoAleatorioDisponivelCenario2() {
        //given ou arrange
        var proximaSegundaAs10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10, 0);
        var medico = cadastrarMedico("Medico", "@medico.com", "123456", Especialidade.CARDIOLOGIA);

        //when
        var medicoLivre =  medicoRepository.escolherMedicoAleatorioDisponivel(Especialidade.CARDIOLOGIA, proximaSegundaAs10);

        //then
        assertThat(medicoLivre).isEqualTo(medico);
    }

    //Criando contrutores

    private void cadastrarConsulta(Medico medico, Paciente paciente, LocalDateTime data) {
        em.persist(new Consulta(null, medico, paciente, data));
    }

    private Medico cadastrarMedico(String nome, String email, String crm, Especialidade especialidade) {
        var medico = new Medico(dadosMedico(nome, email, crm, especialidade));
        em.persist(medico);
        return medico;
    }

    private Paciente cadastrarPaciente(String nome, String email, String cpf) {
        var paciente = new Paciente(dadosPaciente(nome, email, cpf));
        em.persist(paciente);
        return paciente;
    }

    private MedicoDTO dadosMedico(String nome, String email, String crm, Especialidade especialidade) {
        return new MedicoDTO(
                nome,
                email,
                "61999999999",
                crm,
                especialidade,
                dadosEndereco()
        );
    }

    private PacienteDTO dadosPaciente(String nome, String email, String cpf) {
        return new PacienteDTO(
                nome,
                email,
                "61999999999",
                cpf,
                dadosEndereco()
        );
    }

    private EnderecoDTO dadosEndereco() {
        return new EnderecoDTO(
                "rua xpto",
                "bairro",
                "00000000",
                "Brasilia",
                "DF",
                null,
                null
        );
    }


}