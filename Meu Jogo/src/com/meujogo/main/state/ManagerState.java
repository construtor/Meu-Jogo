package com.meujogo.main.state;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

public class ManagerState {

	private Map<String, State>map;
	private State currentState;
	
	public ManagerState(){
		map = new HashMap<String, State>();
		
	}
	
	public void addState(State state){
		map.put(state.getName().toUpperCase(), state);
		state.init();
		if (currentState==null){
			state.enter();
			currentState=state;
		}
	}
	
	public void setState(String name){
		State state = map.get(name.toUpperCase());
		if (state==null){
			System.out.println("State <"+name+"> does not exist!");
			return;
		}
		currentState.exit();
		state.enter();
		currentState = state;
	}
	
	public void tick(){
		currentState.tick(this);
	}
	
	public void render(Graphics g){
		currentState.render(g);
	}
}
