/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.mvc.model;

import patterns.mvc.model.facade.Grade;
import patterns.mvc.model.facade.impl.EnglishGrade;
import patterns.mvc.model.facade.impl.MathGrade;
import patterns.mvc.model.facade.impl.PhisicsGrade;
import patterns.singleton.RandomNumberGeneratorSingleton;

public class Student {
    private int id;
    private String name;
    private Grade mathGrade;
    private Grade englishGrade;
    private Grade phisicsGrade;
    public Student() {
        RandomNumberGeneratorSingleton rng = RandomNumberGeneratorSingleton.getInstance();
        id = rng.getNextId();
        name = "";
        mathGrade = new MathGrade();
        englishGrade = new EnglishGrade();
        phisicsGrade = new PhisicsGrade();
    }
    
    public Student(String name) {
        RandomNumberGeneratorSingleton rng = RandomNumberGeneratorSingleton.getInstance();
        id = rng.getNextId();
        this.name = name;
        mathGrade = new MathGrade();
        englishGrade = new EnglishGrade();
        phisicsGrade = new PhisicsGrade();
    }


    public Student(int id, String name) {
    		this.id = id;
        this.name = name;
        mathGrade = new MathGrade();
        englishGrade = new EnglishGrade();
        phisicsGrade = new PhisicsGrade();
	}

	public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        
        String toReturn = "";
        toReturn = "<br><b>" + name + "</b><br>" + 
        		 mathGrade + " " + 
        		 phisicsGrade + " " + 
        		 englishGrade; 
        return toReturn;
    }

	public Grade getMathGrade() {
		return mathGrade;
	}

	public void setMathGrade(Grade mathGrade) {
		this.mathGrade = mathGrade;
	}

	public Grade getEnglishGrade() {
		return englishGrade;
	}

	public void setEnglishGrade(Grade englishGrade) {
		this.englishGrade = englishGrade;
	}

	public Grade getPhisicsGrade() {
		return phisicsGrade;
	}

	public void setPhisicsGrade(Grade phisicsGrade) {
		this.phisicsGrade = phisicsGrade;
	}
    
    
    
}
