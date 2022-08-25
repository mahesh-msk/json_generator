/*
 * FILE:            Node2Dialog.java
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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.ancit.json.ui.jet.JsonGenerator;

import Json.Node2;
import Json.Type;

public class Node2Dialog extends Dialog {
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

	private Node2 node2;
	private Text text;
	private ComboViewer comboViewer;
	private DateTime dateTime;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param node2
	 */
	public Node2Dialog(Shell parentShell, Node2 node2) {
		super(parentShell);
		this.node2 = node2;
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
		if (node2.getName() != null) {
			text.setText(node2.getName());
		}
		text.addModifyListener(e -> {

			if (text != null) {
				node2.setName(text.getText());
			}

		});
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblType = new Label(container, SWT.NONE);
		lblType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblType.setText("Type");
		List<Type> values = Type.VALUES;
		comboViewer = new ComboViewer(container, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		if (node2.getType().getLiteral() != null) {
			combo.setText(node2.getType().getLiteral());
		}
		combo.addModifyListener(e -> {
			IStructuredSelection iStructuredSelection = (IStructuredSelection) comboViewer.getSelection();
			Type type = (Type) iStructuredSelection.getFirstElement();

			node2.setType(type);

		});
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setText("Date");

		dateTime = new DateTime(container, SWT.BORDER);
		if (node2.getDate() != null) {
			dateTime.setData(node2.getDate());
		}

		dateTime.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseExit(MouseEvent e) {

				int day = dateTime.getDay();
				int month = dateTime.getMonth();
				int year = dateTime.getYear();
				String startDate = "day" + "/" + month + "/" + year;
				DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
				try {
					Date date = df.parse(startDate);

					node2.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		dateTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		// DateTime dateTime = new DateTime(container, SWT.BORDER);

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
		String generate = generator.generate(node2);
		FileExportDialog.export(generate);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

}
