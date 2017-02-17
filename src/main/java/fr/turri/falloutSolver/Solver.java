package fr.turri.falloutSolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solver {
	final private Map<String, Integer> _dataSet = new HashMap<>();
	
	public void addData(String word, Integer match) throws WordIncorrectSizeException{
		assertWordDoesntHaveIncorrectSize(word);
		_dataSet.put(word, match);
	}

	public List<Mismatch> testCandidate(String candidate) throws WordIncorrectSizeException {
		assertWordDoesntHaveIncorrectSize(candidate);
		List<Mismatch> result = new ArrayList<>();
		for(Entry<String, Integer> data : _dataSet.entrySet()){
			int actualCorrelation = computeCorrelation(data.getKey(), candidate);
			if ( actualCorrelation != data.getValue() ){
				result.add(new Mismatch(data.getKey(), data.getValue(), actualCorrelation));
			}
		}
		
		return result;
	}
	
	private void assertWordDoesntHaveIncorrectSize(String word) throws WordIncorrectSizeException{
		if ( _dataSet.size() > 0 && _dataSet.keySet().iterator().next().length() != word.length() ){
			throw new WordIncorrectSizeException();
		}
	}
	
	private int computeCorrelation(String w1, String w2){
		int counter = 0;
		for ( int i=0 ; i < w1.length() ; i++ ){
			if (w1.charAt(i) == w2.charAt(i)){
				counter++;
			}
		}
		return counter;
	}
}
