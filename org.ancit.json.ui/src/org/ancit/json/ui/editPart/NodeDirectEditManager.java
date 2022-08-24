package org.ancit.json.ui.editPart;

import org.eclipse.draw2d.Label;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;


public class NodeDirectEditManager extends DirectEditManager {

	private Label label;

	public NodeDirectEditManager(GraphicalEditPart source, Class editorType,
			CellEditorLocator locator, Label lbl) {
		super(source, editorType, locator);
		// TODO Auto-generated constructor stub
		 this.label = lbl;
	}

	@Override
	protected void initCellEditor() {
		String initialLabelText = label.getText();
	    getCellEditor().setValue(initialLabelText);
	    
	    System.out.println(getCellEditor().getValue());

	}

}
