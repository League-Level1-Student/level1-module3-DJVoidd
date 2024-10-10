package _06_frogger;

import processing.core.PApplet;

public class Frogger extends PApplet {
	static final int WIDTH = 600;
	static final int HEIGHT = 400;
	int hopX = 300;
	int hopY = 200;
	Car car1;
	Car car2;
	Car car3;
	@Override
	public void settings() {
		size(WIDTH, HEIGHT);
	}

	@Override
	public void setup() {
		car1 = new Car(600, 150, 50, 7);
		car2 = new Car(600, 90, 50, 15);
		car3 = new Car(600, 40, 50, 13);
		frameRate(20);
	}

	@Override
	public void draw() {
		background(100,10,10);
		fill(27, 67, 50);
		ellipse(hopX, hopY, 40, 40);
		if (hopX < 0) {
			hopX = 0;
		}
		else if (hopX > 600) {
			hopX = 600;
		}
		else if (hopY < 0) {
			hopY = 0;	
		}	
		else if (hopY > 400) {
			hopY = 400;	
		}
		car1.display();
		car1.driveLeft();
		car2.display();
		car2.driveLeft();
		car3.display();
		car3.driveLeft();
		if (intersects(car1) == true) {
			hopX = 300;
			hopY = 300;
		}
		if (intersects(car2) == true) {
			hopX = 300;
			hopY = 300;
		}
		if (intersects(car3) == true) {
			hopX = 300;
			hopY = 300;
		}
	}
	public void keyPressed() {
		if(key == CODED){
			if(keyCode == UP)
			{
				hopY -= 7;
			}
			else if(keyCode == DOWN)
			{
				hopY += 7; 
			}
			else if(keyCode == RIGHT)
			{
				hopX += 7;
			}
			else if(keyCode == LEFT)
			{
				hopX -=7;
			}
		}
	}
	static public void main(String[] args) {
		PApplet.main(Frogger.class.getName());
	}
	boolean intersects(Car car) {
		if ((hopY > car.y && hopY < car.y+50) &&
				(hopX > car.x && hopX < car.x+car.size)) {
			return true;
		}
		else  {
			return false;
		}
	}
	class Car {
		int x;
		int y;
		int size;
		int speed;
		public Car(int carX, int carY, int carSize, int carSpeed) {
			this.x = carX;
			this.y = carY;
			this.size = carSize;
			this.speed = carSpeed;
		}
		void display()
		{
			fill(0,255,0);
			rect(x , y,  size, size);
		}
		public void driveLeft() {
			x -= speed;
			if (x<0) {
				x = 600;
			}
		}
	}
}