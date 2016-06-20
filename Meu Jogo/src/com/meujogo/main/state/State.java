package com.meujogo.main.state;

import java.awt.Graphics;

public interface State {

	public void init();
	public void enter();
	public void tick(ManagerState managerState);
	public void render(Graphics g);
	public void exit();
	public String getName();
}
