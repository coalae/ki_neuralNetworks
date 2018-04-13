
/* ANWENDUNG: die klasse implementiert das neurale netz aus der aufgabe 1, d.h. ein neurales netz mit backpropagation lern-algorithmus.
 * die klasse besteht aus den inputs A und B und aus den neuronen C, D und E, worauf der output folgt.
 * die werte der inputs werden im constructor übergeben.
 * die werte der initialen gewichtungen wAC, wBD, wBC, wAD, wCE und wDE werden im constructor übergeben.
 * die lernrate wird im constructor übergeben.
 * die aktivierungsfunktion der neuronen ist eine sigmoidfunktion, d.h. 1/(1+e^(-t)
 * der zielwert (target) wird im constructor übergeben.
 * die werte neuronC, neuronD, neuronE werden angelegt, mit null initialisiert und erst durch berechnung im rahmen der forwardpropagation zugewiesen.
 * die werte outC, outD, outE sind die werte der neuronen nach der berücksichtigung der sigmoidfunktion.
 */

public class NeuralNet {
	
	// instanzvariablen
	private double inputA;
	private double inputB;
	private double wAC;
	private double wBC;
	private double wAD;
	private double wBD;
	private double wCE;
	private double wDE;
	private double lernrate;
	private double zielwert;
	private double neuronC;
	private double neuronD;
	private double neuronE;
	private double outC;
	private double outD;
	private double outE;
	private double errorC;
	private double errorD;
	private double errorE;
	private double abbruchwertOutputError;
	
	
	// constructor
	public NeuralNet(double inputA, double inputB, double wAC, double wBC, double wAD, double wBD, double wCE, double wDE, double lernrate, double zielwert, double abbruchwertOutputError) {
		setInputA(inputA);
		setInputB(inputB);
		setwAC(wAC);
		setwBC(wBC);
		setwAD(wAD);
		setwBD(wBD);
		setwCE(wCE);
		setwDE(wDE);
		setLernrate(lernrate);
		setZielwert(zielwert);
		this.neuronC=0;
		this.neuronD=0;
		this.neuronE=0;
		this.outC=0;
		this.outD=0;
		this.outE=0;
		this.setErrorC(0);
		this.setErrorD(0);
		this.setErrorE(0);
		setAbbruchwertOutputError(abbruchwertOutputError);
	}

	// getter & setter
	public double getInputA() {
		return inputA;
	}

	public void setInputA(double inputA) {
		if(inputA<=0) {
			throw new IllegalArgumentException("Der Wert sollte groesser Null sein.");
		}
		this.inputA = inputA;
	}

	public double getInputB() {
		return inputB;
	}

	public void setInputB(double inputB) {
		if(inputB<=0) {
			throw new IllegalArgumentException("Der Wert sollte groesser Null sein.");
		}
		this.inputB = inputB;
	}

	public double getwAC() {
		return wAC;
	}

	public void setwAC(double wAC) {
		if(wAC<=0) {
			throw new IllegalArgumentException("Der Wert sollte groesser Null sein.");
		}
		this.wAC = wAC;
	}

	public double getwBC() {
		return wBC;
	}

	public void setwBC(double wBC) {
		if(wBC<=0) {
			throw new IllegalArgumentException("Der Wert sollte groesser Null sein.");
		}
		this.wBC = wBC;
	}

	public double getwAD() {
		return wAD;
	}

	public void setwAD(double wAD) {
		if(wAD<=0) {
			throw new IllegalArgumentException("Der Wert sollte groesser Null sein.");
		}
		this.wAD = wAD;
	}

	public double getwBD() {
		return wBD;
	}

	public void setwBD(double wBD) {
		if(wBD<=0) {
			throw new IllegalArgumentException("Der Wert sollte groesser Null sein.");
		}
		this.wBD = wBD;
	}

	public double getwCE() {
		return wCE;
	}

	public void setwCE(double wCE) {
		if(wCE<=0) {
			throw new IllegalArgumentException("Der Wert sollte groesser Null sein.");
		}
		this.wCE = wCE;
	}


	public double getwDE() {
		return wDE;
	}

	public void setwDE(double wDE) {
		if(wDE<=0) {
			throw new IllegalArgumentException("Der Wert sollte groesser Null sein.");
		}
		this.wDE = wDE;
	}
	
	public double getLernrate() {
		return lernrate;
	}

	public void setLernrate(double lernrate) {
		if(lernrate<=0) {
			throw new IllegalArgumentException("Der Wert sollte groesser Null sein.");
		}
		this.lernrate = lernrate;
	}

	public double getZielwert() {
		return zielwert;
	}

	public void setZielwert(double zielwert) {
		if(zielwert<=0) {
			throw new IllegalArgumentException("Der Wert sollte groesser Null sein.");
		}
		this.zielwert = zielwert;
	}	

	public double getNeuronC() {
		return neuronC;
	}

	public void setNeuronC(double neuronC) {
		this.neuronC = neuronC;
	}

	public double getNeuronD() {
		return neuronD;
	}

	public void setNeuronD(double neuronD) {
		this.neuronD = neuronD;
	}

	public double getNeuronE() {
		return neuronE;
	}

	public void setNeuronE(double neuronE) {
		this.neuronE = neuronE;
	}

	public double getOutC() {
		return outC;
	}

	public void setOutC(double outC) {
		this.outC = outC;
	}

	public double getOutD() {
		return outD;
	}

	public void setOutD(double outD) {
		this.outD = outD;
	}

	public double getOutE() {
		return outE;
	}

	public void setOutE(double outE) {
		this.outE = outE;
	}
	
	public double getErrorC() {
		return errorC;
	}

	public void setErrorC(double errorC) {
		this.errorC = errorC;
	}

	public double getErrorD() {
		return errorD;
	}

	public void setErrorD(double errorD) {
		this.errorD = errorD;
	}

	public double getErrorE() {
		return errorE;
	}

	public void setErrorE(double errorE) {
		this.errorE = errorE;
	}

	public double getAbbruchwertOutputError() {
		return abbruchwertOutputError;
	}

	public void setAbbruchwertOutputError(double abbruchwertOutputError) {
		this.abbruchwertOutputError = abbruchwertOutputError;
	}

	// weitere methoden
	// forward-propagation durch das neurale netz machen
	public void forwardPropagate() {
		
		// neuron C und anwendung der sigmoidfunktion
		neuronC = inputA*wAC + inputB*wBC;
		outC = 1/(1+Math.exp(-neuronC)); 
		// neuron D und anwendung der sigmoidfunktion
		neuronD = inputA*wAD + inputB*wBD;
		outD = 1/(1+Math.exp(-neuronD));
		// neuron E und anwendung der sigmoidfunktion
		neuronE = outC*wCE + outD*wDE;
		outE = 1/(1+Math.exp(-neuronE));
	}
	
	// backward-propagation durch das neurale netz machen
	public void backPropagate() {
		
		// output error (von neuron E) unter berücksichtigung der sigmoidfunktion
		errorE = (zielwert - outE) * outE * (1-outE);
		// neue gewichtungen der output layer
		double wCEneu = this.wCE + (errorE*lernrate*outC);
		this.setwCE(wCEneu);
		
		double wDEneu = this.wDE + (errorE*lernrate*outD);
		this.setwDE(wDEneu);
		
		// hidden layer errors (von neuron C und D) unter berücksichtigung der sigmoidfunktion
		errorC = outC * (1-outC) * (errorE*wDE);
		errorD = outD * (1-outD) * (errorE*wCE);
		// neue gewichtungen der hidden layer
		double wACneu = this.wAC + (errorC*lernrate*inputA);
		this.setwAC(wACneu);
		
		double wBCneu = this.wBC + (errorC*lernrate*inputB);
		this.setwBC(wBCneu);
		
		double wADneu = this.wAD + (errorD*lernrate*inputA);
		this.setwAD(wADneu);
		
		double wBDneu = this.wBD + (errorD*lernrate*inputB);
		this.setwBD(wBDneu);
	}
	
	// gibt infos über das neurale netz aus
	public void printNeuralNetInfo() {
		
		System.out.println("Input A: " + inputA + "." + " Input B: " + inputB + "." + "\n"); 
		System.out.println("Lernrate: " + lernrate + "." + "\n");
		System.out.println("Zielwert: " + zielwert + "." + "\n" + "\n");
		
		System.out.println("GEWICHTUNGEN:" + "\n");
		System.out.println("wAC: " + wAC + "\n");
		System.out.println("wBC: " + wBC + "\n");
		System.out.println("wAD: " + wAD + "\n");
		System.out.println("wBD: " + wBD + "\n");
		System.out.println("wCE: " + wCE + "\n");
		System.out.println("wDE: " + wDE + "\n" + "\n");

		System.out.println("NEURONEN:" + "\n");
		System.out.println("Neuron C: " + neuronC +". " + "Neuron C (nach Sigmoidfunktion): " + outC + "." + "\n");
		System.out.println("Neuron D: " + neuronD +". " + "Neuron D (nach Sigmoidfunktion): " + outD + "." + "\n");
		System.out.println("Neuron E: " + neuronE +". " + "Neuron E (nach Sigmoidfunktion): " + outE + "." + "\n" + "\n");

		System.out.println("ERRORS:" + "\n");
		System.out.println("Error C: " + errorC + "." + "\n");
		System.out.println("Error D: " + errorD + "." + "\n");
		System.out.println("Error E: " + errorE + "." + "\n");		
	}

}
