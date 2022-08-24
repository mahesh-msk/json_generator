package org.ancit.json.ui.wizard;

import org.ancit.json.ui.wizardPages.JsonWizardPage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import Json.JsonFactory;
import Json.JsonModel;

public class JsonWizard extends Wizard implements INewWizard {
private JsonWizardPage jsonWizardPage;
private ResourceSetImpl resourceSet;
	public JsonWizard() {
		// TODO Auto-generated constructor stub
		setWindowTitle("");
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}
	@Override
	public void addPages() {
		// TODO Auto-generated method stub
		super.addPages();
		jsonWizardPage = new JsonWizardPage("Sample");
		addPage(jsonWizardPage);
	}

	@Override
	public boolean performFinish() {

		// TODO Auto-generated method stub
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		System.out.println(jsonWizardPage.getProjectName());
		
		IProject project = root.getProject(jsonWizardPage.getProjectName());
		if (project.exists()) {
			
			
			
				
				 IFile file = project.getFile(jsonWizardPage.getFileName()+".json");
					byte[] bytes = "File contents".getBytes();
					InputStream source = new ByteArrayInputStream(bytes);
					try {
						file.create(source, IResource.NONE, null);
						
						
						resourceSet = new ResourceSetImpl();
						Resource resource = resourceSet.createResource(URI.createFileURI(file.getLocation().toOSString()));
						resource.getContents().add(JsonFactory.eINSTANCE.createJsonModel());
						resource.save(null);
					
						 IWorkbenchPage page = PlatformUI.getWorkbench()
						            .getActiveWorkbenchWindow().getActivePage();
						IDE.openEditor(page,file);
						
						
					} catch (CoreException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
				 
				 
				
				
			
				 
			
			
			
		} else {
			try {
				project.create(null);
				project.open(null);
				IFile file = project.getFile(jsonWizardPage.getFileName()+".json");
				byte[] bytes = "File contents".getBytes();
				InputStream source = new ByteArrayInputStream(bytes);
				file.create(source, IResource.NONE, null);

				resourceSet = new ResourceSetImpl();
				Resource resource = resourceSet.createResource(URI.createFileURI(file.getLocation().toOSString()));
				resource.getContents().add(JsonFactory.eINSTANCE.createJsonModel());
				resource.save(null);
			
				 IWorkbenchPage page = PlatformUI.getWorkbench()
				            .getActiveWorkbenchWindow().getActivePage();
				IDE.openEditor(page,file);
				

			} catch (Exception e) {

			}

		}
		
		
		
		return true;
	
	}

}
