package com.microej.widget.compass;

import java.util.Random;

import com.microej.demo.watch.util.WatchImageLoader;

import ej.bon.TimerTask;
import ej.drawing.TransformPainter;
import ej.microui.display.GraphicsContext;
import ej.microui.display.ResourceImage;
import ej.mwt.Widget;
import ej.mwt.util.Size;


public class CompassWidget extends Widget {

	private final class UpdateTask extends TimerTask {
		private static final int STEPS_WITH_SAME_INCREMENT = 8;
		private static final int MAX_DEGREE = 90;
		private static final int MIN_DEGREE = 10;

		private final Random random;
		private boolean updateDegreeIncrement;
		private int animationStep;
		private float currentDegree;
		private float degreeIncrement;
		private long previousTime;

		private UpdateTask(int degree) {
			this.random = new Random(System.currentTimeMillis());
			setEnabled(true);
			this.currentDegree = degree;
			this.updateDegreeIncrement = true;
			this.previousTime = System.currentTimeMillis();
		}

		@Override
		public void run() {

			long currentTime = System.currentTimeMillis();
			float timeFactor = ((float) (currentTime - this.previousTime)) / 100;
			this.previousTime = currentTime;

			if (this.updateDegreeIncrement) {
				int degreeStep = this.random.nextInt(MAX_DEGREE) - MAX_DEGREE / 2;
				degreeStep = degreeStep + (degreeStep < 0 ? -MIN_DEGREE : MIN_DEGREE);
				degreeStep *= timeFactor;
				this.degreeIncrement = (float) degreeStep / STEPS_WITH_SAME_INCREMENT;
				this.animationStep = 0;
				this.updateDegreeIncrement = false;
			}

			int oldDegree = (int) this.currentDegree;
			this.currentDegree += this.degreeIncrement; 			this.currentDegree += FULL_ANGLE; 			this.currentDegree %= FULL_ANGLE; 			int newDeg = (int) this.currentDegree;
			if (newDeg != oldDegree) {
				setAngle(newDeg);
			} else {
								this.animationStep++;
			}

						this.animationStep++;
			if (this.animationStep >= (STEPS_WITH_SAME_INCREMENT / timeFactor)) {
				this.updateDegreeIncrement = true;
			}
		}
	}

	private static final int FULL_ANGLE = 360;

	private ResourceImage rotateImage;

	private int currentAngle;

	private final UpdateTask updateTask;
	private final String rotateImagePath;

	
	public CompassWidget(String rotateImagePath) {
		this.rotateImagePath = rotateImagePath;
		this.currentAngle = 0;
		this.updateTask = new UpdateTask(this.currentAngle);
	}

	@Override
	protected void renderContent(GraphicsContext g, int contentWidth, int contentHeight) {
		this.updateTask.run();
		TransformPainter.drawRotatedImageBilinear(g, this.rotateImage, 0, 0, contentWidth / 2, contentHeight / 2,
				this.currentAngle);
	}

	@Override
	protected void computeContentOptimalSize(Size size) {
		size.setSize(this.rotateImage.getWidth(), this.rotateImage.getHeight());
	}

	
	public void setAngle(int angle) {
		this.currentAngle = angle == 0 ? FULL_ANGLE : angle;
	}

	
	public int getAngle() {
		return this.currentAngle;
	}

	@Override
	protected void onAttached() {
		super.onAttached();
		this.rotateImage = WatchImageLoader.loadImage(this.rotateImagePath);
	}

	@Override
	protected void onDetached() {
		super.onDetached();
		this.rotateImage.close();
	}

	@Override
	public boolean isTransparent() {
		return false;
	}
}