public class Main {

	public static void main(String[] args) throws Exception {

		// Tworzenie danych
		DataCreation.utworzDane();

		System.out.println("AUDIOBOOKI:");
		Audiobook.showExtent();
		System.out.println();

		System.out.println("BRAKI MAGAZYNOWE:");
		System.out.println(Audiobook.znajdzBraki());


	}}
