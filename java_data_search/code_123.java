package com.liferay.portal.search.geolocation;

import java.util.Collections;
import java.util.List;


public class MultiLineStringShape extends Shape {

	@Override
	public <T> T accept(ShapeTranslator<T> shapeTranslator) {
		return shapeTranslator.translate(this);
	}

	public List<LineStringShape> getLineStringShapes() {
		return _lineStringShapes;
	}

	protected MultiLineStringShape(
		List<Coordinate> coordinates, List<LineStringShape> lineStringShapes) {

		super(coordinates);

		_lineStringShapes = Collections.unmodifiableList(lineStringShapes);
	}

	private final List<LineStringShape> _lineStringShapes;

}