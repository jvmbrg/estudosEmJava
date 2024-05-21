package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Comment;
import entities.Post;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String content="I'm going to visit wonderful country";
		String title = "Traveling to New Zelandia";
		Integer likes = 12;
		
		Comment comment1 = new Comment("Have a nice trip");
		Comment comment2 = new Comment("Wow! That's awesome!");
		Post post = new Post(sdf.parse("21/06/2018 13:05:44"), content, title, likes);
		post.addComment(comment1);
		post.addComment(comment2);
		System.out.println(post.toString());
		
		
	}

}
