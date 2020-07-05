package challenge;

import java.util.*;

public class Estacionamento {

    private static final int TOTAL_VAGAS = 10;
    private static final int TOTAL_PONTOS_SUSPENSAO = 20;
    private static final int MAIOR_IDADE = 18;

    private List<Carro> carros = new ArrayList<>();

    public void estacionar(Carro carro) {
        validarCarroAutonomo(carro);
        validarCarteiraMotorista(carro.getMotorista());
        verificarVagas(carro);
    }

    private void validarCarteiraMotorista(Motorista motorista) {
        if (motorista.getIdade() < MAIOR_IDADE) throw new EstacionamentoException("Motorista Menor");
        if (motorista.getPontos() > TOTAL_PONTOS_SUSPENSAO) throw new EstacionamentoException("Carteira Suspensa");

    }

    private void verificarVagas(Carro carro) {
        if (carrosEstacionados() == TOTAL_VAGAS) {

            Carro estacionado = carros.stream()
                    .filter(car -> Objects.nonNull(car.getMotorista()) && car.getMotorista().getIdade() < 55)
                    .findFirst()
                    .orElseThrow(() -> new EstacionamentoException("Sair do estacionamento"));

            carros.remove(estacionado);
            carros.add(carro);

        } else {
            carros.add(carro);
        }


    }

    private void validarCarroAutonomo(Carro carro) {
        if (carro.getMotorista() == null) throw new EstacionamentoException("Motorista Autonomo");
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carros.contains(carro);
    }
}
