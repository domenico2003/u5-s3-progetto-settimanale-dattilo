package application.enities;

import java.util.ArrayList;
import java.util.List;

import application.interfaces.Observer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CentroDiControllo implements Observer {

	private String via;
	private List<Observer> listaPersonale = new ArrayList<>();
	private Sonda sondaAllarmata;

	public CentroDiControllo(String via) {
		this.via = via;
	}

	@Override
	public String toString() {
		return "CentroDiControllo [via=" + via + "]";
	}

	public void addPersonale(Personale p) {
		listaPersonale.add(p);
	}

	@Override
	public void allarme() {

		System.out.println("allarme preso in carica inviando personale: ");
		System.out.println("...");
		this.listaPersonale.forEach(pers -> {
			pers.sondaAllarmata(sondaAllarmata);
			pers.allarme();

		});

	}

	@Override
	public void sondaAllarmata(Sonda s) {
		this.sondaAllarmata = s;
	}

}
