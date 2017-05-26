package com.sf.codingcomp.velociraptor;

public class Velociraptor {

	private static final int TOP_SPEED = 40; // in miles per hour
	
	public int catchPrey(Prey prey, int startingSpeed) {
		int count=0;
		double fps=1.466667;          //mph converted to fps
		double closingIn=0;
		double preySpeed=prey.getTopSpeed();
		
		if (prey.getTopSpeed()> TOP_SPEED)
			return -1;
		else {
			for(int i=startingSpeed; i<=TOP_SPEED; i++){
				if(prey.getCurrentLead()<=0)
				return count;
				else{
					closingIn = ((preySpeed*(fps)) - (i*(fps)));
					prey.setCurrentLead(prey.getCurrentLead() + closingIn);
					count++;
				}
				}  // end for
			for (int i = TOP_SPEED-1; i>=0;i--){
				if(prey.getCurrentLead()<=0)
				return count;
				else{
					closingIn= ((preySpeed*(fps)) - (i*(fps)));
					prey.setCurrentLead(prey.getCurrentLead()+closingIn);
					count++;
				}
				}  // end for
		} // end else
		
		return -1;
	}
}
