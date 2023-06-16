package application.enities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@AllArgsConstructor
@Getter

public abstract class LuogoDiIstallazioneSonda {

	private String indirizzo;
	private double lat;
	private double lon;

}
