package com.dudi.mflix.daos.utils;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.dudi.mflix.daos.AbstractMFlixDao;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class MoviesSearchUtil extends AbstractMFlixDao {

	  public static String MOVIES_COLLECTION = "movies";

	  private MongoCollection<Document> moviesCollection;
	
	protected MoviesSearchUtil(MongoClient mongoClient, String databaseName) {
		super(mongoClient, databaseName);
		moviesCollection = db.getCollection(MOVIES_COLLECTION);
	}

	public ArrayList<Document> getMovieByCastAndTitle(List<String> casts, List<String> titles) {
		Bson castsFilterQuery = Filters.in("cast", casts);
		Bson titlesFilterQuery = Filters.in("title", titles);
		
		ArrayList<Document> results = new ArrayList<>();
		moviesCollection.find(Filters.and(castsFilterQuery, titlesFilterQuery)).into(results);
		return results;
	}
	
}
