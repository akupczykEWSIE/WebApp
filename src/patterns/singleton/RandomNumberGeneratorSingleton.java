/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.singleton;

import java.util.Random;

public class RandomNumberGeneratorSingleton {
    private static RandomNumberGeneratorSingleton indexGeneratorSingleton;
    private Random rand;
    private int index;
    private RandomNumberGeneratorSingleton() {
        super();
        index = 1;
        rand = new Random();
    }
    
    public static RandomNumberGeneratorSingleton getInstance() {
        if (indexGeneratorSingleton == null) {
            indexGeneratorSingleton = new RandomNumberGeneratorSingleton();
        }
        return indexGeneratorSingleton;
    }
    
    
    public int getNextId() {
        return index++;
    }
    
    public double getRandomGrade() {
    		double grade = (double) rand.nextInt(7);
    		grade /= 2;
    		grade += 2.5;
    		if (grade < 3.0) {
    			grade = 2.0;
    		}
    		return grade;
    		
    		
    }
    
}
