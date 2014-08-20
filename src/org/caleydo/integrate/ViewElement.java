/*******************************************************************************
 * Caleydo - Visualization for Molecular Biology - http://caleydo.org
 * Copyright (c) The Caleydo Team. All rights reserved.
 * Licensed under the new BSD license, available at http://caleydo.org/license
 *******************************************************************************/
package org.caleydo.integrate;

import org.caleydo.core.util.color.Color;
import org.caleydo.core.view.opengl.layout2.GLElementContainer;
import org.caleydo.core.view.opengl.layout2.GLGraphics;
import org.caleydo.core.view.opengl.layout2.PickableGLElement;
import org.caleydo.core.view.opengl.layout2.layout.GLLayouts;
import org.caleydo.core.view.opengl.picking.Pick;

/**
 * using the normal GLElement hierarchy
 *
 * @author Samuel Gratzl
 *
 */
public class ViewElement extends GLElementContainer {
	/**
	 *
	 */
	public ViewElement() {
		super(GLLayouts.flowHorizontal(10));
		for (int i = 0; i < 10; ++i) {
			this.add(new Pickable());
		}
	}
	@Override
	protected void renderImpl(GLGraphics g, float w, float h) {
		g.color(Color.YELLOW).fillRect(0, 0, w, h);
		super.renderImpl(g, w, h);
	}
}

class Pickable extends PickableGLElement {
	private boolean mouseOver = false;

	@Override
	protected void renderImpl(GLGraphics g, float w, float h) {
		g.color(mouseOver ? Color.BLUE : Color.GREEN).fillRect(0, 0, w, h);
		super.renderImpl(g, w, h);
	}

	@Override
	public String getTooltip() {
		return "A tooltip";
	}

	@Override
	protected void onMouseOver(Pick pick) {
		mouseOver = true;
		repaint();
		super.onMouseOver(pick);
	}

	@Override
	protected void onMouseOut(Pick pick) {
		mouseOver = false;
		repaint();
		super.onMouseOut(pick);
	}
}
