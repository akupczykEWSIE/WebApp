package patterns.mvc.model.facade.impl;

import patterns.mvc.model.facade.Grade;
import patterns.singleton.RandomNumberGeneratorSingleton;

public class MathGrade extends Grade {


	public MathGrade() {
		RandomNumberGeneratorSingleton rng = RandomNumberGeneratorSingleton.getInstance();
		this.setScore(rng.getRandomGrade());
	}
	
	public MathGrade(double score) {
		this.setScore(score);
	}
	@Override
	public String getSubject() {
		return "Matematyka";
	}

	public static String getName() {
		return "Matematyka";
	}

}
