package application.enities;

import application.interfaces.Observer;
import lombok.Getter;

@Getter

public class Sonda extends LuogoDiIstallazioneSonda implements Observer {

	private int livelloFumo = 0;
	private Observer sistemaDiCaptagio;

	public Sonda(String indirizzo, double lat, double lon, SistemaDiCaptagio system) {
		super(indirizzo, lat, lon);
		this.sistemaDiCaptagio = system;
	}

	public void setLivelloFumo(int livelloFumo) {
		System.out.println();
		this.livelloFumo = livelloFumo;
		if (livelloFumo > 5) {
			System.out.println("Allarme Registrato: ");
			System.out.println("...");
			allarme();
		} else {
			System.out.println("livello fumo non sufficentemente alto per far scattare l'allarme");
		}
	}

	@Override
	public String toString() {
		return "indirizzo=" + this.getIndirizzo() + ", lat=" + this.getLat() + ", lon=" + this.getLon()
				+ ", livello fumo: " + livelloFumo;
	}

	@Override
	public void allarme() {
		sistemaDiCaptagio.sondaAllarmata(this);
		sistemaDiCaptagio.allarme();
	}

	@Override
	public void sondaAllarmata(Sonda s) {

	}
}
