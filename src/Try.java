import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Try {
	public static void main(String[] args) {
		
		int[] episodes = {5, 3, 6 };
		TVSeries series1 = new TVSeries("Rome", episodes);
		Episode episode1 = new Episode(series1, "TV-G", 60, 1, 1, "The Stolen Eagle", 23, 8, 44);
		System.out.println(episode1);
		System.out.println();
		System.out.println(episode1.getFullTitle());
		System.out.println();
		System.out.println(episode1.getItemDetails());
		String message = episode1.download();
		System.out.println(message);
		System.out.println("After download: ");
		System.out.println(episode1.getItemDetails());
	}
}
		



		

		