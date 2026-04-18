package org.geogebra.common.geogebra3D.kernel3D.algos;

import org.geogebra.common.geogebra3D.kernel3D.geos.GeoLine3D;
import org.geogebra.common.geogebra3D.kernel3D.geos.GeoPoint3D;
import org.geogebra.common.kernel.Construction;
import org.geogebra.common.kernel.Kernel;
import org.geogebra.common.kernel.algos.AlgoTangentLineND;
import org.geogebra.common.kernel.geos.GeoLine;
import org.geogebra.common.kernel.kernelND.GeoConicND;
import org.geogebra.common.kernel.kernelND.GeoLineND;
import org.geogebra.common.kernel.matrix.Coords;
import org.geogebra.common.util.DoubleUtil;


public class AlgoTangentLine3D extends AlgoTangentLineND {
	private Coords direction;
	private Coords direction3D;

	public AlgoTangentLine3D(Construction cons, String[] labels, GeoLineND g,
			GeoConicND c) {
		super(cons, labels, g, c);
	}

	@Override
	protected void initDiameterAndDirection() {
						diameter = new GeoLine(cons);
		algoIntersect = new AlgoIntersectLineIncludedConic3D(cons, diameter, c);
						cons.removeFromConstructionList(algoIntersect);
		tangentPoints = algoIntersect.getIntersectionPoints();
	}

	@Override
	protected void setTangents() {
		tangents = new GeoLine3D[2];
		tangents[0] = new GeoLine3D(cons);
		tangents[1] = new GeoLine3D(cons);
		((GeoLine3D) tangents[0]).setStartPoint(tangentPoints[0]);
		((GeoLine3D) tangents[1]).setStartPoint(tangentPoints[1]);
	}

	
	@Override
	public void initForNearToRelationship() {
				
		Coords firstTangentPoint = tangentPoints[0].getInhomCoordsInD3();

		if (!((GeoLine3D) tangents[0]).isOnFullLine(firstTangentPoint,
				Kernel.MIN_PRECISION)) {
			algoIntersect.initForNearToRelationship();

						algoIntersect.setIntersectionPoint(0, tangentPoints[1]);

						((GeoPoint3D) tangentPoints[1]).setCoords(firstTangentPoint);
			algoIntersect.setIntersectionPoint(1, tangentPoints[1]);
		}
	}

	@Override
	protected boolean checkUndefined() {
		if (super.checkUndefined()) {
			return true;
		}

		direction3D = g.getDirectionInD3();
		direction = c.getCoordSys().getNormalProjection(direction3D)[1];
		return !DoubleUtil.isZero(direction.getZ());
	}

	@Override
	protected void updateDiameterLine() {

		c.diameterLine(direction.getX(), direction.getY(), diameter);
	}

	@Override
	protected void updateTangent(int index) {
		((GeoLine3D) tangents[index]).setCoord(
				tangentPoints[index].getInhomCoordsInD3(), direction3D);
	}

	@Override
	protected void updateTangentParabola() {

		Coords c0 = tangentPoints[0].getInhomCoordsInD3();
		Coords c1 = tangentPoints[1].getInhomCoordsInD3();

		if (c0.isDefined()) {
			((GeoLine3D) tangents[0]).setCoord(c0, direction3D);
		} else {
			((GeoLine3D) tangents[0]).setCoord(c1, direction3D);
		}

		((GeoLine3D) tangents[1]).setUndefined();

	}
}