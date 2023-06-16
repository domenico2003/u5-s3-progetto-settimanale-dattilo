package application.Factoryes;

import application.enities.SistemaDiCaptagio;
import application.enities.Sonda;

public class SondaViaGaribaldi extends SondeFactory {

	@Override
	public Sonda creaSonda(SistemaDiCaptagio sdc) {
		return new Sonda("via Garibaldi", 66.1488684, 50.51568484, sdc);

	}

}
