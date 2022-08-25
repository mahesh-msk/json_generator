/*
 * FILE:            Node1Dialog.java
 *
 * SW-COMPONENT:    org.ancit.json.ui
 *
 * DESCRIPTION:     -
 *
 * COPYRIGHT:       © 2015 - 2022 Robert Bosch GmbH
 *
 * The reproduction, distribution and utilization of this file as
 * well as the communication of its contents to others without express
 * authorization is prohibited. Offenders will be held liable for the
 * payment of damages. All rights reserved in the event of the grant
 * of a patent, utility model or design.
 */
package org.ancit.json.ui.dialog;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.nebula.widgets.calendarcombo.CalendarCombo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.ancit.json.ui.jet.JsonGenerator;

import Json.Node1;
import Json.Type;

public class Node1Dialog extends Dialog {
	private static class ViewerLabelProvider extends LabelProvider {
		@Override
		public Image getImage(Object element) {
			return super.getImage(element);
		}

		@Override
		public String getText(Object element) {
			if (element instanceof Type) {
				Type type = (Type) element;
				return type.getLiteral();
			}
			return null;
		}
	}

	private static class ContentProvider implements IStructuredContentProvider {
		@Override
		public Object[] getElements(Object inputElement) {
			return new Object[0];
		}

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	private Text text;
	private ComboViewer comboViewer;
	private Node1 node1;
	private CalendarCombo calendarCombo;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param node1
	 */
	public Node1Dialog(Shell parentShell, Node1 node1) {
		super(parentShell);
		this.node1 = node1;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = (GridLayout) container.getLayout();
		gridLayout.numColumns = 2;

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Name");

		text = new Text(container, SWT.BORDER);
		if (node1.getName() != null) {
			text.setText(node1.getName());
		}
		text.addModifyListener(e -> {

			if (text != null) {
				node1.setName(text.getText());
			}

		});
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblType = new Label(container, SWT.NONE);
		lblType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblType.setText("Type");
		List<Type> values = Type.VALUES;
		comboViewer = new ComboViewer(container, SWT.NONE);
		Combo combo = comboViewer.getCombo();

		if (node1.getType() != null) {
			combo.setText(node1.getType().getLiteral());
		}
		combo.addModifyListener(e -> {
			IStructuredSelection iStructuredSelection = (IStructuredSelection) comboViewer.getSelection();
			Type type = (Type) iStructuredSelection.getFirstElement();

			node1.setType(type);

		});
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setText("Date");

		calendarCombo = new CalendarCombo(container, SWT.NONE);
		calendarCombo.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {

				System.out.println(calendarCombo.getDate());

			}
		});
		calendarCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		comboViewer.setLabelProvider(new ViewerLabelProvider());
		comboViewer.setContentProvider(ArrayContentProvider.getInstance());
		comboViewer.setInput(values);
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button button = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		button.setText("Generate");
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected void okPressed() {
		// TODO Auto-generated method stub
		super.okPressed();
		JsonGenerator generator = new JsonGenerator();
		String generate = generator.generate(node1);
		FileExportDialog.export(generate);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

}
