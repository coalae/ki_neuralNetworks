/* ANWENDUNG: die klasse testet den backpropagation-lern-algorithmus des neuronalen netzes für die ihm konstruktor übergebenen
werte und verkleinert mittels backpropagation die fehlerwerte */

public class NeuralNetTest {

	public static void main(String[] args) {

		/* neurales netz anlegen für die gewünschten werte und durchlaufen lassen, bis es ein gewisses eingegebenes
		 * abbruchkriterium (bzgl. errorE) erreicht. mittels der printNeuralNetInfo()-methode wir in jedem durchlauf 
		 * die information über alle bestandteile des neuralen netz ausgegeben, sodass man genau verfolgen kann, welche
		 * werte sich wann in welchem ausmass aendern, und wieviele durchlaeufe bis zum erreichen des eingegebenen 
		 * abbruchkriteriums durchgefuehrt werden muessen.
		 * in diesem fall (bei netz1) sind dies zB 8 durchlaeufe, bis der errorE unter den wert 0.020 faellt.
		*/
		NeuralNet netz1 = new NeuralNet(1.3, 0.5, 0.4, 1.0, 0.2, 0.4, 0.2, 0.9, 1.0, 0.8, 0.020);

		int countDurchlaeufeBisAbbruch=0;
		
		for(int i=0; netz1.getErrorE()==0 || netz1.getErrorE()>=netz1.getAbbruchwertOutputError();i++) {
			System.out.println("---------------------------------------------------------------------------------------------------------------" 
					+ "\n" + "DURCHLAUF " + (i+1) +":" + "\n");
			netz1.forwardPropagate();
			netz1.backPropagate();
			netz1.printNeuralNetInfo();
			countDurchlaeufeBisAbbruch++;
		}
		
		System.out.println("Bis zum Abbruch gab es " + countDurchlaeufeBisAbbruch + " Durchlaeufe." + "\n");
		
	}

}
