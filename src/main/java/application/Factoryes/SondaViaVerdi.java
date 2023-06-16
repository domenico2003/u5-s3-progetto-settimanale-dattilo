package application.Factoryes;

import application.enities.SistemaDiCaptagio;
import application.enities.Sonda;

public class SondaViaVerdi extends SondeFactory {

	@Override
	public Sonda creaSonda(SistemaDiCaptagio sdc) {

		return new Sonda("via verdi", 12.342343, 10.2432434, sdc);
	}

}
