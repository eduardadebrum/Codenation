package challenge;


public class CriptografiaCesariana implements Criptografia {

    private static final Integer INICIO_ASCII_MINUSCULA = 97;
    private static final Integer FIM_ASCII_MINUSCULA = 122;

    @Override
    public String criptografar(String texto) {
        return processTexto(texto, 3);
    }

    @Override
    public String descriptografar(String texto) {
        return processTexto(texto, -3);
    }


    private String processTexto(String texto, int casa) {
        validarFormatacaoTexto(texto);
        String textoVelho = texto.toLowerCase();
        StringBuilder textoNovo = new StringBuilder();

        for (int i = 0; i < textoVelho.length(); i++) {
            int caracter = textoVelho.charAt(i);
            int novaPosicao = isNumeroOuEspaco(caracter) ? caracter : caracter + casa;
            textoNovo.append((char) novaPosicao);
        }

        return textoNovo.toString();
    }

    private void validarFormatacaoTexto(String texto) {
        if (texto == null) {
            throw new NullPointerException();
        }

        if (texto.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumeroOuEspaco(int posicao) {
        return posicao < INICIO_ASCII_MINUSCULA || posicao > FIM_ASCII_MINUSCULA;
    }
}
