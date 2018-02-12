/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.mvc.model.facade;

public abstract class Grade {
	private double score;
	
    public double getScore() {
    		return score;
    };

    public abstract String getSubject();
    
    public void setScore(double score) {
    		this.score = score;
    };
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return getSubject() + ": " + score;
    }
    
}
