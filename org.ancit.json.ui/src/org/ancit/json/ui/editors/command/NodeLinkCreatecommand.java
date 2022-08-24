package org.ancit.json.ui.editors.command;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;

import Json.Cluster;
import Json.Link;
import Json.Node;

public class NodeLinkCreatecommand extends Command {
	private EditPart source;
	private Link link;
	private EditPart target;
	private Node sourceNode;
	private Node targetNode;
	private Cluster cluster;

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		link.setSourceNode(sourceNode);
		link.setTargetNode(targetNode);

		 sourceNode.getSourceLink().add(link);
		
		 targetNode.getTargetLink().add(link);

		cluster.getNodeLink().add(link);
		

	

	}



	public void setSource(EditPart part) {
		this.source = part;
		sourceNode = (Node) part.getModel();
		

	}

	public void setLink(Link link, EditPart parent) {
		this.link = link;
		this.cluster=(Cluster)parent.getModel();

	}

	public void setTarget(EditPart host) {
		// TODO Auto-generated method stub
		this.target = host;
		targetNode = (Node)host.getModel();
		
	}

	public EditPart getSource() {
		return source;
	}

}
