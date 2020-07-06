package com.mgrobelak.view.listeners;

/**
 * @author Marcin Grobelak
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mgrobelak.view.GameSettings;
import com.mgrobelak.view.Runner;

public class GameSettingsListener extends AbstractListener implements ActionListener {

	public GameSettingsListener(Runner runner) {
		super(runner);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		new GameSettings(runner);
	}
}
