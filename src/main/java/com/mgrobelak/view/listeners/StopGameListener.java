package com.mgrobelak.view.listeners;

/**
 * @author Marcin Grobelak
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mgrobelak.view.Runner;

public class StopGameListener extends AbstractListener implements ActionListener {
	public StopGameListener(Runner runner) {
		super(runner);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		runner.setLaunched(false);
	}
}
