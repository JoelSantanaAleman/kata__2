package software.ulpgc;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/26joe/Documents/is2_tsv/title.ratings.tsv");
        List<Rating> ratings = new TsvFileRatingReader(file).read();
        TreeMap<Double, Integer> votesByRating = new TreeMap<>();
        for(Rating rating : ratings){
            double averageRating = rating.getAverageRating();
            int numVotes = rating.getNumVotes();
            votesByRating.put(averageRating, votesByRating.getOrDefault(averageRating, 0) +numVotes);
        }
        for(Map.Entry<Double, Integer> entry : votesByRating.entrySet()){
            System.out.println("AverageRating: " + entry.getKey() + ", Total Votes: " + entry.getValue());
        }
    }
}
