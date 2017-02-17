package fr.turri.falloutSolver;

public class Mismatch {
	final private String _word;
	public String getWord(){ return _word; }
	
	final private Integer _expectedCorrelation;
	public Integer getExpectedCorrelation() { return _expectedCorrelation; }
	
	final private Integer _actualCorrelation;
	public Integer getActualCorrelation() { return _actualCorrelation; }
	
	public Mismatch(String word, Integer expectedCorrelation, Integer actualCorrelation){
		_word = word;
		_expectedCorrelation = expectedCorrelation;
		_actualCorrelation = actualCorrelation;
	}
}
