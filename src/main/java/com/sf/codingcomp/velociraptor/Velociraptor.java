 /** Copyright 2017 David Arnold
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 **/

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
