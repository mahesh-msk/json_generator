package org.ancit.json.ui.wizardPages;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;


public class JsonWizardPage extends WizardPage{
	private Text text;
	private Button btnRadioButton_1;
	private Combo cmbExistingProject;
	private String projectName;
	private String fileName;
	private ComboViewer comboViewer;
	private Button btnExistingProject;
	private Button btnNewProject;

	public JsonWizardPage(String pageName) {
		super(pageName);
		setPageComplete(false);
		setTitle("Create New Json Model");

		setDescription("Please fill  the follwing to proceed");
	}

	@Override
	public void createControl(Composite parent) {
		setPageComplete(false);
		Composite composite = new Composite(parent, SWT.NONE);

		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));
		Label lblNewLabel = new Label(composite, SWT.LEFT);
		lblNewLabel.setText("File Name");

		final Text txtFileName = new Text(composite, SWT.BORDER);
		txtFileName.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

				setFileName(txtFileName.getText());
				validatePageComplete();
			}
		});
		txtFileName.setLayoutData(new GridData(SWT.FILL, SWT.LEFT, true, false, 1, 1));

		btnExistingProject = new Button(composite, SWT.RADIO);
		btnExistingProject.setText("Existing Project");
		btnExistingProject.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setEnabled(false);
				cmbExistingProject.setEnabled(true);

			}
		});

		btnExistingProject.setSelection(true);

		btnNewProject = new Button(composite, SWT.RADIO);
		btnNewProject.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setEnabled(true);
				cmbExistingProject.setEnabled(false);
			}
		});
		btnNewProject.setText("Create New Project");

		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setText("Project Name");

		text = new Text(composite, SWT.BORDER);
		text.setEnabled(false);
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// setMessage("", WizardPage.WARNING);
				if (!text.getText().isEmpty()) {

					System.out.println(text.getText());

					setProjectName(text.getText());
					validatePageComplete();

				}

			}
		});
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblSelectYourProject = new Label(composite, SWT.NONE);
		lblSelectYourProject.setText("Select your Project");

		comboViewer = new ComboViewer(composite, SWT.NONE);
		cmbExistingProject = comboViewer.getCombo();
		cmbExistingProject.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));
		cmbExistingProject.setEnabled(true);
		cmbExistingProject.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				validatePageComplete();

			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();

		comboViewer.setContentProvider(ArrayContentProvider.getInstance());
		comboViewer.setLabelProvider(new WorkSpaceProjectLabelProvider());
		comboViewer.setInput(projects);

		setControl(composite);

	}

	protected void validatePageComplete() {
		if (btnExistingProject.getSelection()) {
			if (comboViewer.getSelection().isEmpty() || fileName.isEmpty()) {
				setPageComplete(false);
				return;
			}
			IStructuredSelection selection = (IStructuredSelection) comboViewer
					.getSelection();
			IProject project = (IProject) selection.getFirstElement();

			IFile file = project.getFile(getFileName() + ".ed");
			if (file.exists()) {
				setPageComplete(false);
				setErrorMessage("File with the same already exists !");
				
			} else {

				setPageComplete(true);
				setErrorMessage(null);
				setProjectName(project.getName());
			}
		} else {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectName());
			if(project.exists()) {
				setPageComplete(false);
				setErrorMessage("Project with the same already exists !");
			} else {
				setPageComplete(true);
				setErrorMessage(null);
				setProjectName(project.getName());
			}
		}
	}

	
public String getProjectName() {
	return projectName;
}

public void setProjectName(String string) {
	this.projectName = string;
}

public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}
}

