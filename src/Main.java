public class Main {

	public static void main(String[] args) throws Exception {

		// Tworzenie danych
		DataCreation.utworzDane();
		//TODO printy z metod z miniprojektu 1
		System.out.println("Audiobook.showExtent() ");
		Audiobook.showExtent();
		System.out.println("Audiobook.znajdzBraki() ");
		System.out.println(Audiobook.znajdzBraki());
	}}
