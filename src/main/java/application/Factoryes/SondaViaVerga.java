package application.Factoryes;

import application.enities.SistemaDiCaptagio;
import application.enities.Sonda;

public class SondaViaVerga extends SondeFactory {

	@Override
	public Sonda creaSonda(SistemaDiCaptagio sdc) {
		return new Sonda("via Verga", 13.8909, 19.09875, sdc);

	}

}
