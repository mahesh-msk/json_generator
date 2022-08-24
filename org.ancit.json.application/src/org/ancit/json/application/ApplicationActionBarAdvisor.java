package org.ancit.json.application;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
 private IContributionItem create;
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
   	 create = ContributionItemFactory.NEW_WIZARD_SHORTLIST.create(window);
   	
   	
   	
   }

   protected void fillMenuBar(IMenuManager menuBar) {
   	MenuManager manager=new MenuManager("File");
   	MenuManager manager2=new MenuManager("New");
   	manager2.add(create);
   	manager.add(manager2);
   	menuBar.add(manager);
   }
    
}
