package edu.jalc.inclass.cocacola.material.bottle;

import edu.jalc.inclass.cocacola.material.label.SodaBottleLabel;
import edu.jalc.inclass.cocacola.material.lid.SodaBottleLid;
import edu.jalc.inclass.cocacola.product.liquid.Soda;

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

	public SodaBottle(double capacity, SodaBottleLid lid, Soda soda, SodaBottleLabel label) throws Exception {
		this.capacity = capacity;
		this.setLid(lid);
		this.setSoda(soda);
		this.label = label;
	}

	public double getCapacity(){ return capacity; }
	public SodaBottleLid getLid(){	return this.lid; }
	public Soda getSoda(){ return this.soda; }
	public SodaBottleLabel getLabel(){ return this.label; }

	public SodaBottle setLid(SodaBottleLid lid) throws Exception {
		if(lid == null) throw new Exception("SodaBottleLid cannot be null");
		this.lid = lid;
		return this;
	}

	public SodaBottle setSoda(Soda soda){
		this.soda = soda;
		return this;
	}
}
