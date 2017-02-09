package edu.jalc.inclass.bottle;

import edu.jalc.inclass.label.SodaBottleLabel;
import edu.jalc.inclass.lid.SodaBottleLid;
import edu.jalc.inclass.liquid.Soda;

public class SodaBottle {

	private final double capacity;
	private SodaBottleLid lid;
	private Soda soda;
	private final SodaBottleLabel label;

	private SodaBottle() throws Exception {
		this.capacity = 0;
		this.setLid(null);
		this.soda = null;
		this.label = null;
	}

	SodaBottle(double capacity, SodaBottleLid lid, Soda soda, SodaBottleLabel label) throws Exception {
		this.capacity = capacity;
		this.setLid(lid);
		this.setSoda(soda);
		this.label = label;
	}

	double getCapacity(){ return capacity; }
	SodaBottleLid getLid(){	return this.lid; }
	Soda getSoda(){ return this.soda; }
	SodaBottleLabel getLabel(){ return this.label; }

	SodaBottle setLid(SodaBottleLid lid) throws Exception {
		if(lid == null) throw new Exception("SodaBottleLid cannot be null");
		this.lid = lid;
		return this;
	}

	SodaBottle setSoda(Soda soda){
		this.soda = soda;
		return this;
	}
}
