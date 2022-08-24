package org.ancit.json.application;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		layout.addView(IPageLayout.ID_PROJECT_EXPLORER,IPageLayout.LEFT ,0.33f, IPageLayout.ID_EDITOR_AREA);
		layout.addView(IPageLayout.ID_OUTLINE, IPageLayout.BOTTOM, 0.5f, IPageLayout.ID_PROJECT_EXPLORER);
	}
}
