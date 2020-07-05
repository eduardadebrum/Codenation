package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	private static final Integer LIMIT_NUMBER = 350;

	public static List<Integer> fibonacci() {
		List<Integer> numbers = new ArrayList<>();
		Fibonnaci fibonnaci = new Fibonnaci(0, 1, null);

		numbers.add(fibonnaci.getPrevious());
		numbers.add(fibonnaci.getCurrent());

		while (fibonnaci.getCurrent() < LIMIT_NUMBER) {

			fibonnaci.setResult(fibonnaci.getPrevious() + fibonnaci.getCurrent());
			fibonnaci.setPrevious(fibonnaci.getCurrent());
			fibonnaci.setCurrent(fibonnaci.getResult());
			numbers.add(fibonnaci.getResult());
		}

		return numbers;
	}

	public static Boolean isFibonacci(Integer number) {
		return fibonacci().contains(number);
	}

}