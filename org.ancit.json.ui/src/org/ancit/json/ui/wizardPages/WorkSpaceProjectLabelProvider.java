package org.ancit.json.ui.wizardPages;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.LabelProvider;

public class WorkSpaceProjectLabelProvider extends LabelProvider {
	@Override
	public String getText(Object element) {
		// TODO Auto-generated method stub
		if (element instanceof IProject) {
			IProject project = (IProject) element;
			return project.getName();
			
		}
		return super.getText(element);
	}

}
