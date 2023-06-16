package application;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import application.Factoryes.SondaViaGaribaldi;
import application.Factoryes.SondaViaVerdi;
import application.Factoryes.SondaViaVerga;
import application.Factoryes.SondeFactory;
import application.enities.CentroDiControllo;
import application.enities.Personale;
import application.enities.SistemaDiCaptagio;
import application.enities.Sonda;

@Component
public class GestioneIncendiRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// Testare applicazione con Observer
		// observerTest();

		// Testare applicazione con FactoryMethod
		factoryTest();
	}

	private static void observerTest() {
		Scanner scan = new Scanner(System.in);
//creo vigili
		Personale vigile1 = new Personale("Domenico", "Dattilo", LocalDate.of(1990, 8, 23));
		Personale vigile2 = new Personale("Daniele", "Verdi", LocalDate.of(2000, 10, 10));
		Personale vigile3 = new Personale("Giuseppe", "Rossi", LocalDate.of(1980, 5, 06));
		Personale vigile4 = new Personale("Giovanni", "Verga", LocalDate.of(1985, 1, 30));

//creo centro di controllo(caserma)
		CentroDiControllo cdc = new CentroDiControllo("via esempio n°2");

//assegno i vigili alla caserma
		cdc.addPersonale(vigile1);
		cdc.addPersonale(vigile2);
		cdc.addPersonale(vigile3);
		cdc.addPersonale(vigile4);

//creo sistema di captagio delle sonde e assegno la caserma a cui inviare l'allarme
		SistemaDiCaptagio captureSystem = new SistemaDiCaptagio(cdc);

//creo la sonda e gli inserisco il sistema di captagio
		Sonda sonda = new Sonda("via esempio n° 3", 45.546848, 48.975445, captureSystem);

		System.out.println("inserisci livello fumo: ");
		int livelloFumo = scan.nextInt();
		scan.nextLine();

//Rileva il fumo , in questo caso per scopo dimostrativo arriva dall'input
		sonda.setLivelloFumo(livelloFumo);

		scan.close();
	}

	private static void factoryTest() {
		Scanner scan = new Scanner(System.in);
//creo vigili
		Personale vigile1 = new Personale("Domenico", "Dattilo", LocalDate.of(1990, 8, 23));
		Personale vigile2 = new Personale("Daniele", "Verdi", LocalDate.of(2000, 10, 10));
		Personale vigile3 = new Personale("Giuseppe", "Rossi", LocalDate.of(1980, 5, 06));
		Personale vigile4 = new Personale("Giovanni", "Verga", LocalDate.of(1985, 1, 30));

//creo centro di controllo(caserma)
		CentroDiControllo cdc = new CentroDiControllo("via esempio n°2");

//assegno i vigili alla caserma
		cdc.addPersonale(vigile1);
		cdc.addPersonale(vigile2);
		cdc.addPersonale(vigile3);
		cdc.addPersonale(vigile4);

//creo sistema di captagio delle sonde e assegno la caserma a cui inviare l'allarme
		SistemaDiCaptagio captureSystem = new SistemaDiCaptagio(cdc);

//creo la sonda e gli indico la sonda da crearmi
		System.out.println("Scegli numero sonda: ");
		System.out.println("1. sonda di via Garibaldi");
		System.out.println("2. sonda di via Verdi");
		System.out.println("3. sonda di via Verga");

		int nSonda = scan.nextInt();
		scan.nextLine();
		SondeFactory sonda = null;
		try {
			sonda = setSonda(nSonda);
		} catch (Exception e) {

			e.printStackTrace();
		}

		System.out.println("inserisci livello fumo: ");
		int livelloFumo = scan.nextInt();
		scan.nextLine();

		sonda.run(captureSystem, livelloFumo);

		scan.close();
	}

	private static SondeFactory setSonda(int sensore) throws Exception {
		switch (sensore) {
		case 1:
			return new SondaViaGaribaldi();
		case 2:
			return new SondaViaVerdi();
		case 3:
			return new SondaViaVerga();
		default:
			throw new Exception();
		}
	}
}
