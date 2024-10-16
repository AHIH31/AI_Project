	package main;

	import java.util.*;

	public class Problem {
	    private String initialState;

	    public Problem(String initialState) {
	        this.initialState = initialState;
	    }

	    public String initialState() {
	        return initialState;
	    }

	    public boolean goalTest(String state) {
	        return state.matches("([a-z]+(e*),?)+");
	    }

	    public List<String> getOperators(String state) {
	        List<String> operators = new ArrayList<>();
	        return operators;
	    }

	    public String applyOperator(String state, String operator) {
	        return state;
	    }

	    public int getCost(String operator) {
	        return 1;
	    }
	}
