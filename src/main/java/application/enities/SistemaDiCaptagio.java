package application.enities;

import java.util.ArrayList;
import java.util.List;

import application.interfaces.Observer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SistemaDiCaptagio implements Observer {

	private List<Sonda> sonde = new ArrayList<>();
	private Observer centroDiControllo;

	@Override
	public void allarme() {

		System.out.println("inviando allarme  al centro di controllo: ");
		System.out.println("...");
		sonde.forEach(s -> {

			centroDiControllo.sondaAllarmata(s);
			centroDiControllo.allarme();

		});

	}

	@Override
	public void sondaAllarmata(Sonda s) {
		sonde.add(s);

	}

	public SistemaDiCaptagio(Observer centroDiControllo) {

		this.centroDiControllo = centroDiControllo;
	}

}
