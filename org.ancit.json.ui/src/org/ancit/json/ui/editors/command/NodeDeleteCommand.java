package org.ancit.json.ui.editors.command;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;

import Json.Cluster;
import Json.Link;
import Json.Node1;
import Json.Node2;
import Json.Node3;
import Json.Node4;
import Json.Node5;

public class NodeDeleteCommand extends Command {

	private Node1 node1;
	private Node5 node5;
	private Node4 node4;
	private Node3 node3;
	private Node2 node2;
	private Cluster cluster;
	private Object model;
	private EditPart parent;

	

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		super.execute();
		/*
		 * EList<OrganizationLink> sourceLink = thing.getSourceLink();
		 * EList<OrganizationLink> targetLink = thing.getTargetLink(); for
		 * (OrganizationLink organizationLink : sourceLink) {
		 * organizationLink.getTargetOrganization
		 * ().getTargetLink().remove(organizationLink);
		 * epd.getOrganizationLinks().remove(organizationLink); } for
		 * (OrganizationLink organizationLink1 : targetLink) {
		 * organizationLink1.
		 * getSourceOrganization().getSourceLink().remove(organizationLink1);
		 * epd.getOrganizationLinks().remove(organizationLink1); }
		 * 
		 * sourceLink.clear(); targetLink.clear();
		 * 
		 * epd.getOrganizations().remove(thing);
		 */
		if (model instanceof Node1) {
			node1 = (Node1) model;
			EList<Link> sourceLink = node1.getSourceLink();
			for (Link link : sourceLink) {
				link.getTargetNode().getTargetLink().remove(link);
				cluster.getNodeLink().remove(link);

			}
			EList<Link> targetLink = node1.getTargetLink();
			for (Link link : targetLink) {
				link.getSourceNode().getSourceLink().remove(link);
				cluster.getNodeLink().remove(link);

			}
			cluster.setNode1(null);
		} else if (model instanceof Node2) {
			node2 = (Node2) model;
			EList<Link> sourceLink = node2.getSourceLink();
			for (Link link : sourceLink) {
				link.getTargetNode().getTargetLink().remove(link);
				cluster.getNodeLink().remove(link);
			}
			EList<Link> targetLink = node2.getTargetLink();
			for (Link link : targetLink) {
				link.getSourceNode().getSourceLink().remove(link);
				cluster.getNodeLink().remove(link);
			}
			cluster.setNode2(null);
		} else if (model instanceof Node3) {
			node3 = (Node3) model;
			EList<Link> sourceLink = node3.getSourceLink();
			for (Link link : sourceLink) {
				link.getTargetNode().getTargetLink().remove(link);
				cluster.getNodeLink().remove(link);
			}
			EList<Link> targetLink = node3.getTargetLink();
			for (Link link : targetLink) {
				link.getSourceNode().getSourceLink().remove(link);
				cluster.getNodeLink().remove(link);
			}
			cluster.setNode3(null);
		} else if (model instanceof Node4) {
			node4 = (Node4) model;
			EList<Link> sourceLink = node4.getSourceLink();
			for (Link link : sourceLink) {
				link.getTargetNode().getTargetLink().remove(link);
				cluster.getNodeLink().remove(link);
			}
			EList<Link> targetLink = node4.getTargetLink();
			for (Link link : targetLink) {
				link.getSourceNode().getSourceLink().remove(link);
				cluster.getNodeLink().remove(link);
			}
			cluster.setNode4(null);

		} else if (model instanceof Node5) {
			node5 = (Node5) model;
			EList<Link> sourceLink = node5.getSourceLink();
			for (Link link : sourceLink) {
				link.getTargetNode().getTargetLink().remove(link);
				cluster.getNodeLink().remove(link);
			}
			EList<Link> targetLink = node5.getTargetLink();
			for (Link link : targetLink) {
				link.getSourceNode().getSourceLink().remove(link);
				cluster.getNodeLink().remove(link);
			}
			cluster.setNode5(null);
		}

	}

	public void setThing(Object model, EditPart parent) {
		// TODO Auto-generated method stub
		this.parent=parent;
		this.cluster = (Cluster) parent.getModel();
		this.model = model;
		
	}



}
