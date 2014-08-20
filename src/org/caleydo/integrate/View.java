package org.caleydo.integrate;

import org.caleydo.core.view.opengl.layout2.GLSandBox;
import org.caleydo.core.view.opengl.layout2.layout.GLPadding;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class View extends ViewPart {
	public static final String ID = "TestMiniCaleydo.view";

	@Override
	public void createPartControl(Composite parent) {
		// using a sandbox as a widget is the simplest method to integrate a gl window
		GLSandBox s = new GLSandBox(parent, new ViewElement(), GLPadding.ZERO);
	}

	@Override
	public void setFocus() {

	}
}