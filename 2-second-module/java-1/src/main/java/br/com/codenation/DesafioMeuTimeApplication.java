package br.com.codenation;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

    private List<Time> times = new ArrayList<>();

    private List<Jogador> jogadores = new ArrayList<>();

    @Desafio("incluirTime")
    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        Time team = times.stream().filter(time -> time.getId().equals(id)).findFirst().orElse(null);
        if (team != null) throw new IdentificadorUtilizadoException();
        times.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
    }

    @Desafio("incluirJogador")
    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        Jogador jogador = jogadores.stream().filter(jog -> jog.getId().equals(id)).findFirst().orElse(null);
        if (jogador != null) throw new IdentificadorUtilizadoException();
        validateExistsTime(idTime);
        jogadores.add(new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
    }

    @Desafio("definirCapitao")
    public void definirCapitao(Long idJogador) {
        Jogador jogador = buscarJogador(idJogador);
        Time time = buscarTime(jogador.getIdTime());
        time.setIdCapitao(idJogador);
    }

    @Desafio("buscarCapitaoDoTime")
    public Long buscarCapitaoDoTime(Long idTime) {
        Time time = buscarTime(idTime);
        if(time.getIdCapitao() == null) throw new CapitaoNaoInformadoException();

        Jogador jogador = buscarJogador(time.getIdCapitao());
        return jogador.getId();
    }

    @Desafio("buscarNomeJogador")
    public String buscarNomeJogador(Long idJogador) {
        Jogador result = buscarJogador(idJogador);
        return result.getNome();
    }

    @Desafio("buscarNomeTime")
    public String buscarNomeTime(Long idTime) {
        Time result = buscarTime(idTime);
        return result.getNome();
    }

    @Desafio("buscarJogadoresDoTime")
    public List<Long> buscarJogadoresDoTime(Long idTime) {
        validateExistsTime(idTime);

        return jogadores.stream().filter(jogador -> jogador.getIdTime().equals(idTime))
                .sorted(Comparator.comparing(Jogador::getId))
                .map(Jogador::getId)
                .collect(Collectors.toList());
    }

    @Desafio("buscarMelhorJogadorDoTime")
    public Long buscarMelhorJogadorDoTime(Long idTime) {
        validateExistsTime(idTime);

        Optional<Jogador> max = jogadores.stream()
                .filter(jogador -> jogador.getIdTime().equals(idTime))
                .max(Comparator.comparing(Jogador::getNivelHabilidade));

        return max.get().getId();
    }

    @Desafio("buscarJogadorMaisVelho")
    public Long buscarJogadorMaisVelho(Long idTime) {
        validateExistsTime(idTime);

        return jogadores.stream()
                .filter(jogador -> jogador.getIdTime().equals(idTime))
                .min(Comparator.comparing(Jogador::getDataNascimento).thenComparing(Jogador::getId))
                .map(Jogador::getId).get();
    }

    @Desafio("buscarTimes")
    public List<Long> buscarTimes() {
        if (times == null || times.isEmpty()) {
            return new ArrayList<>();
        }

        return times.stream()
                .sorted(Comparator.comparing(Time::getId))
                .map(Time::getId).collect(Collectors.toList());
    }

    @Desafio("buscarJogadorMaiorSalario")
    public Long buscarJogadorMaiorSalario(Long idTime) {
        validateExistsTime(idTime);
        Optional<Long> idJogador = jogadores.stream()
                .filter(jogador -> jogador.getIdTime().equals(idTime))
                .max(Comparator.comparing(Jogador::getSalario))
                .map(Jogador::getId);

        return idJogador.get();
    }

    @Desafio("buscarSalarioDoJogador")
    public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        Jogador jogador = buscarJogador(idJogador);
        return jogador.getSalario();
    }


    @Desafio("buscarTopJogadores")
    public List<Long> buscarTopJogadores(Integer top) {
        return jogadores.stream()
                .sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed().thenComparing(Jogador::getId))
                .limit(top)
                .map(Jogador::getId)
                .collect(Collectors.toList());
    }

    @Desafio("buscarCorCamisaTimeDeFora")
    public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
        Time daCasa = buscarTime(timeDaCasa);
        Time deFora = buscarTime(timeDeFora);

        return daCasa.getCorUniformePrincipal().equals(deFora.getCorUniformePrincipal())
                ? deFora.getCorUniformeSecundario() : deFora.getCorUniformePrincipal();
    }

    private Time buscarTime(Long timeDaCasa) {
        return times.stream().filter(time -> time.getId().equals(timeDaCasa)).findFirst()
                .orElseThrow(TimeNaoEncontradoException::new);
    }

    private Jogador buscarJogador(Long idJogador) {
        return jogadores.stream()
                .filter(jogador -> jogador.getId().equals(idJogador))
                .findFirst().orElseThrow(JogadorNaoEncontradoException::new);
    }

    private void validateExistsTime(Long idTime) {
        boolean existsTime = times.stream().anyMatch(time -> time.getId().equals(idTime));
        if (!existsTime) {
            throw new TimeNaoEncontradoException();
        }
    }
}