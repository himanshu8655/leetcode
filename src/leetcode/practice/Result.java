package leetcode.practice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.net.http.*;
import java.net.URI;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.google.gson.*;



public class Result {
	
	public static void main(String args[]) {
		System.out.println(Result.bestInGenre("hello"));
	}

   
     static class TvSeries{
        int page;
        int per_page;
        int total;
        List<Data> data;  // MUST be a List
        TvSeries(){
        }
     }
     static class Data{
        String name;
        String runtime_of_series;
        String certificate;
        String genre;
        double imdb_rating;
        String overview;
        int no_of_votes;
        int id;        Data(){}
        @Override
        public String toString() {
        	// TODO Auto-generated method stub
            return name + " | " + genre + " | " + imdb_rating;
        }
     }
     
    public static String bestInGenre(String genre) {
        HttpClient client = HttpClient.newHttpClient();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
//        System.out.println("->" +map.pollFirstEntry().getKey());
//        System.out.println("->" +map.pollFirstEntry().getKey());
        System.out.println("->" +map.pollLastEntry().getKey());
        map.firstEntry();
        TreeMap<String, String> treemap = new TreeMap<>();
        int pageNo = 1;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonmock.hackerrank.com/api/tvseries?page="+pageNo)).GET().build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            Gson gson = new Gson();
            TvSeries tv =  gson.fromJson(response.body(), TvSeries.class);
            
        }catch(Exception e){}
            return "";
    }

}
