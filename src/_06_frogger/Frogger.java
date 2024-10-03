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
		car1 = new Car(140, 100, 180, 7);
		car2 = new Car(100, 100, 150, 10);
		car3 = new Car(60, 100, 120, 13);
		frameRate(20);
	}

	@Override
	public void draw() {
		background(100,10,10);
		fill(27, 67, 50);
		System.out.println("draw called once");
		ellipse(hopX, hopY, 40, 40);
		ellipse(100,100,100,100);
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
	}
	public void keyPressed() {
		if(key == CODED){
			if(keyCode == UP)
			{
				hopY -= 5;
			}
			else if(keyCode == DOWN)
			{
				hopY += 5; 
			}
			else if(keyCode == RIGHT)
			{
				hopX += 5;
			}
			else if(keyCode == LEFT)
			{
				hopX -=5;
			}
		}
	}
	static public void main(String[] args) {
		PApplet.main(Frogger.class.getName());
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
			while(true) {
				x -= speed;
			}
		}
	}
}
