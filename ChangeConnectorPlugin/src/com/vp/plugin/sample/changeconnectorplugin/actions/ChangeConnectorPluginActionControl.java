package com.vp.plugin.sample.changeconnectorplugin.actions;

import com.vp.plugin.ApplicationManager;
import com.vp.plugin.action.VPAction;
import com.vp.plugin.action.VPActionController;
import com.vp.plugin.diagram.IConnectorUIModel;
import com.vp.plugin.diagram.IDiagramElement;
import com.vp.plugin.diagram.IDiagramUIModel;
import com.vp.plugin.diagram.connector.IAssociationUIModel;

public class ChangeConnectorPluginActionControl implements VPActionController {
	
	public void performAction(VPAction arg0) {
		IDiagramUIModel diagram = ApplicationManager.instance().getDiagramManager().getActiveDiagram();
		IDiagramElement[] elements = diagram.toDiagramElementArray();
		for (IDiagramElement element : elements) {
			if (element instanceof IAssociationUIModel) {
				IAssociationUIModel associationShape = (IAssociationUIModel) element;
							
				if (IConnectorUIModel.CS_ARC == associationShape.getConnectorStyle()) {
					associationShape.setConnectorStyle(IConnectorUIModel.CS_ROUND_RECTILINEAR);
				} else {
					associationShape.setConnectorStyle(IConnectorUIModel.CS_ARC);					
				}
			}
		}
	}

	@Override
	public void update(VPAction arg0) {
		// TODO Auto-generated method stub
		
	}

}
