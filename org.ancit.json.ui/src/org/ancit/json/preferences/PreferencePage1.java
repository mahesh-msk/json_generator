package org.ancit.json.preferences;

import org.ancit.json.ui.Activator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PreferencePage1 extends PreferencePage implements
		IWorkbenchPreferencePage {
	private Text text;
	private Text text_1;
	private String open1;
	private String open;
	private String string;
	private String string2;
	/**
	 * @wbp.parser.constructor
	 */
	public PreferencePage1() {
		setMessage("");
		// TODO Auto-generated constructor stub
	}

	public PreferencePage1(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public PreferencePage1(String title, ImageDescriptor image) {
		super(title, image);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub
string = Activator.getDefault().getPreferenceStore().getString("Path");
string2 = Activator.getDefault().getPreferenceStore().getString("StorageLocation");

	}

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(3, false));
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Set Image Location");
		
		text = new Text(composite, SWT.BORDER);
		if (string!=null) {
			text.setText(string);
		}
		
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnBrowse = new Button(composite, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog=new FileDialog(Display.getDefault().getActiveShell());
				open = dialog.open();
				text.setText(open);
				
			}
		});
		btnBrowse.setText("Browse");
		
		
		
		return null;
	}
	@Override
	protected void performApply() {
		// TODO Auto-generated method stub
		super.performApply();
		Activator.getDefault().getPreferenceStore().setValue("Path",open);
		
	}
	@Override
	protected void performDefaults() {
		// TODO Auto-generated method stub
		super.performDefaults();
		String path = Platform.getInstallLocation().getURL().getPath()+"images";
		

		Activator.getDefault().getPreferenceStore().setValue("Path",path);
		text.setText(path);
	}

}
