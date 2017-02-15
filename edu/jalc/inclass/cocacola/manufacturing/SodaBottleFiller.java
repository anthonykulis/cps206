package edu.jalc.inclass.cocacola.manufacturing;

import edu.jalc.inclass.cocacola.material.bottle.SodaBottle;

public class SodaBottleFiller {

	private static SodaBottleFiller sodaBottleFiller;

	private SodaBottleFiller(){
		// purposely hidden from consumption
	}

	public static SodaBottleFiller getInstance(){
		if(sodaBottleFiller == null) sodaBottleFiller = new SodaBottleFiller();
		return sodaBottleFiller;
	}

	public void fillSoda(SodaBottle sodaBottle){
		sodaBottle.getSoda().setVolume(sodaBottle.getCapacity());
	}
}
