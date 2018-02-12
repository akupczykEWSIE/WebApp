package patterns.mvc.model.facade.impl;

import patterns.mvc.model.facade.Grade;
import patterns.singleton.RandomNumberGeneratorSingleton;

public class PhisicsGrade extends Grade {

	
	public PhisicsGrade() {
		RandomNumberGeneratorSingleton rng = RandomNumberGeneratorSingleton.getInstance();
		this.setScore(rng.getRandomGrade());
	}
	public PhisicsGrade(double score) {
		this.setScore(score);
	}
	@Override
	public String getSubject() {
		return "Fizyka";
	}

	public static String getName() {
		return "Fizyka";
	}

}
