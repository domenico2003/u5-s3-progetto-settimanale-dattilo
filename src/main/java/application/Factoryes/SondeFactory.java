package application.Factoryes;

import application.enities.SistemaDiCaptagio;
import application.enities.Sonda;
import lombok.Getter;

@Getter
public abstract class SondeFactory {

	public void run(SistemaDiCaptagio sdc, int livelloFumo) {
		Sonda sonda = creaSonda(sdc);
		sonda.setLivelloFumo(livelloFumo);
	}

	public abstract Sonda creaSonda(SistemaDiCaptagio sdc);

}
