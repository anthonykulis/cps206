package edu.jalc.inclass.bottle;

import edu.jalc.inclass.lid.SodaBottleLid;

public class SodaBottle {

	private final double capacity;
	private SodaBottleLid lid;

	private SodaBottle() throws Exception {
		this.capacity = 0;
		this.setLid(null);
	}

	SodaBottle(double capacity, SodaBottleLid lid) throws Exception {
		this.capacity = capacity;
		this.setLid(lid);
	}

	double getCapacity(){ return capacity; }

	SodaBottleLid getLid(){	return this.lid; }

	SodaBottle setLid(SodaBottleLid lid) throws Exception {
		if(lid == null) throw new Exception("SodaBottleLid cannot be null");
		this.lid = lid;
		return this;
	}
}
