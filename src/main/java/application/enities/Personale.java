package application.enities;

import java.time.LocalDate;

import application.interfaces.Observer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Personale implements Observer {
	private String nome;
	private String Cognome;
	private LocalDate dataDiNascita;
	private Sonda sonda;

	@Override
	public void allarme() {

		System.out.println(this.nome + " " + this.Cognome + " interviene alla sonda con i seguenti dati : \n" + sonda);
		System.out.println();

	}

	@Override
	public void sondaAllarmata(Sonda s) {
		this.sonda = s;

	}

	public Personale(String nome, String cognome, LocalDate dataDiNascita) {
		super();
		this.nome = nome;
		Cognome = cognome;
		this.dataDiNascita = dataDiNascita;
	}

}
