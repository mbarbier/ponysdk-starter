package com.ponysdk.starter.client;

import java.util.Date;

import com.ponysdk.core.UIContext;
import com.ponysdk.core.main.EntryPoint;
import com.ponysdk.ui.server.basic.PButton;
import com.ponysdk.ui.server.basic.PFlowPanel;
import com.ponysdk.ui.server.basic.PLabel;
import com.ponysdk.ui.server.basic.PRootLayoutPanel;
import com.ponysdk.ui.server.basic.PTextBox;
import com.ponysdk.ui.server.basic.event.PClickEvent;
import com.ponysdk.ui.server.basic.event.PClickHandler;

public class StarterEntryPoint implements EntryPoint {

	@Override
	public void start(UIContext uiContext) {
		final PFlowPanel flow = new PFlowPanel();
		final PTextBox textbox = new PTextBox();
		final PButton button = new PButton("Say hello");
		final PLabel label = new PLabel();

		flow.add(textbox);
		flow.add(button);
		flow.add(label);

		textbox.setPlaceholder("Enter your name...");
		
		button.addClickHandler(new PClickHandler() {

			@Override
			public void onClick(PClickEvent event) {
				label.setText("Hello " + textbox.getValue() + "! It is "
						+ new Date().toString() + " on the server.");
			}
		});

		PRootLayoutPanel.get().add(flow);
	}

	@Override
	public void restart(UIContext uiContext) {
		start(uiContext);
	}

}
