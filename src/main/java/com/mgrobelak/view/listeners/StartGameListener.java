package com.mgrobelak.view.listeners;

/**
 * @author Marcin Grobelak
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mgrobelak.view.Runner;

public class StartGameListener extends AbstractListener implements ActionListener {

	public StartGameListener(Runner runner) {
		super(runner);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (!runner.getLaunched()) {
			runner.setLaunched(true);
			Thread thread = new Thread(runner);
			thread.start();
		}
	}
}
