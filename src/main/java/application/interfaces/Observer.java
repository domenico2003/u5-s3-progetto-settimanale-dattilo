package application.interfaces;

import application.enities.Sonda;

public interface Observer {

	public void allarme();

	public void sondaAllarmata(Sonda s);
}
