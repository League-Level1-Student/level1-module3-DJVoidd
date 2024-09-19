package _04_netflix;

public class NetflixRunner {
	public static void main(String[] args) {
		Movie movie1 = new Movie("Interesting movie", 5);
		Movie movie2 = new Movie("Interesting movie 2: Super interesting", 6);
		Movie movie3 = new Movie("Interesting movie 3: Super Duper intersting", 7);
		Movie movie4 = new Movie("Interesting movie 4: Just alright", 3);
		Movie movie5 = new Movie("Interesting movie 5: Below average", 2);
		movie1.getTicketPrice();
		movie2.getTicketPrice();
		movie3.getTicketPrice();
		movie4.getTicketPrice();
		movie5.getTicketPrice();
		NetflixQueue queue = new NetflixQueue();
		queue.addMovie(movie1);
		queue.addMovie(movie2);
		queue.addMovie(movie3);
		queue.addMovie(movie4);
		queue.addMovie(movie5);
		queue.printMovies();
		System.out.println("The best movie is " + queue.getBestMovie() + "!");
		System.out.println("The second best movie is " + queue.getMovie(1) + "!");
	}
}
