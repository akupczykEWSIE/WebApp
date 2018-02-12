package patterns.mvc.model.facade.impl;

import patterns.mvc.model.facade.Grade;
import patterns.singleton.RandomNumberGeneratorSingleton;

public class EnglishGrade extends Grade{

	public EnglishGrade() {
		RandomNumberGeneratorSingleton rng = RandomNumberGeneratorSingleton.getInstance();
		this.setScore(rng.getRandomGrade());
	}
	
	public EnglishGrade(double score) {
		this.setScore(score);
	}
	
	@Override
	public String getSubject() {
		return "Angielski";
	}

	public static Object getName() {
		return "Angielski";
	}

}
