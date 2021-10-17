package com.dudi.mflix.daos;

import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.*;
import static com.mongodb.client.model.Accumulators.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.bson.BsonNull;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.BsonField;
import com.mongodb.client.model.BucketOptions;
import com.mongodb.client.model.Facet;
import com.mongodb.client.model.Field;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.UnwindOptions;

@Component
public class MovieDao extends AbstractMFlixDao {

    public static String MOVIES_COLLECTION = "movies";

    private MongoCollection<Document> moviesCollection;

    @Autowired
    public MovieDao(MongoClient mongoClient, @Value("${spring.mongodb.database}") String databaseName) {
        super(mongoClient, databaseName);
        moviesCollection = db.getCollection(MOVIES_COLLECTION);
    }

    @SuppressWarnings("unchecked")
    private Bson buildLookupStage() {
        return null;

    }

    /**
     * movieId needs to be a hexadecimal string value. Otherwise it won't be possible to translate to
     * an ObjectID
     *
     * @param movieId - Movie object identifier
     * @return true if valid movieId.
     */
    private boolean validIdValue(String movieId) {
        //TODO> Ticket: Handling Errors - implement a way to catch a
        //any potential exceptions thrown while validating a movie id.
        //Check out this method's use in the method that follows.
        return true;
    }

    /**
     * Gets a movie object from the database.
     *
     * @param movieId - Movie identifier string.
     * @return Document object or null.
     */
    @SuppressWarnings("UnnecessaryLocalVariable")
    public Document getMovie(String movieId) {
        if (!validIdValue(movieId)) {
            return null;
        }

        List<Bson> pipeline = new ArrayList<>();
        // match stage to find movie
        Bson match = Aggregates.match(Filters.eq("_id", new ObjectId(movieId)));
        
        ArrayList<Document> results = new ArrayList<>();
        Bson queryFilter = Filters.eq("_id", new ObjectId(movieId));
		moviesCollection.find(queryFilter).into(results);
        
        
        pipeline.add(match);
        // TODO> Ticket: Get Comments - implement the lookup stage that allows the comments to
        // retrieved with Movies.
        Document movie = moviesCollection.aggregate(pipeline).first();

        return movie;
    }

    /**
     * Returns all movies within the defined limit and skip values using a default descending sort key
     * `tomatoes.viewer.numReviews`
     *
     * @param limit - max number of returned documents.
     * @param skip  - number of documents to be skipped.
     * @return list of documents.
     */
    @SuppressWarnings("UnnecessaryLocalVariable")
    public List<Document> getMovies(int limit, int skip) {
        String defaultSortKey = "tomatoes.viewer.numReviews";
        List<Document> movies =
                new ArrayList<>(getMovies(limit, skip, Sorts.descending(defaultSortKey)));
        return movies;
    }

    /**
     * Finds a limited amount of movies documents, for a given sort order.
     *
     * @param limit - max number of documents to be returned.
     * @param skip  - number of documents to be skipped.
     * @param sort  - result sorting criteria.
     * @return list of documents that sorted by the defined sort criteria.
     */
    public List<Document> getMovies(int limit, int skip, Bson sort) {

        List<Document> movies = new ArrayList<>();

        moviesCollection
                .find()
                .limit(limit)
                .skip(skip)
                .sort(sort)
                .iterator()
                .forEachRemaining(movies::add);

        return movies;
    }

    /**
     * For a given a country, return all the movies that match that country.
     *
     * @param country - Country string value to be matched.
     * @return List of matching Document objects.
     */
    public List<Document> getMoviesByCountry(String... country) {

        Bson queryFilter = new Document();
        Bson projection = new Document();
        //TODO> Ticket: Projection - implement the query and projection required by the unit test
        List<Document> movies = new ArrayList<>();

        return movies;
    }

    /**
     * This method will execute the following mongo shell query: db.movies.find({"$text": { "$search":
     * `keywords` }}, {"score": {"$meta": "textScore"}}).sort({"score": {"$meta": "textScore"}})
     *
     * @param limit    - integer value of number of documents to be limited to.
     * @param skip     - number of documents to be skipped.
     * @param keywords - text matching keywords or terms
     * @return List of query matching Document objects
     */
    public List<Document> getMoviesByText(int limit, int skip, String keywords) {
        Bson textFilter = Filters.text(keywords);
        Bson projection = Projections.metaTextScore("score");
        Bson sort = Sorts.metaTextScore("score");
        List<Document> movies = new ArrayList<>();
        moviesCollection
                .find(textFilter)
                .projection(projection)
                .sort(sort)
                .skip(skip)
                .limit(limit)
                .iterator()
                .forEachRemaining(movies::add);
        return movies;
    }

    /**
     * Finds all movies that contain any of the `casts` members, sorted in descending by the `sortKey`
     * field.
     *
     * @param sortKey - sort key.
     * @param limit   - number of documents to be returned.
     * @param skip    - number of documents to be skipped.
     * @param cast    - cast selector.
     * @return List of documents sorted by sortKey that match the cast selector.
     */
    public List<Document> getMoviesByCast(String sortKey, int limit, int skip, String... cast) {
        Bson castFilter = null;
        Bson sort = null;
        //TODO> Ticket: Subfield Text Search - implement the expected cast
        // filter and sort
        List<Document> movies = new ArrayList<>();
        moviesCollection
                .find(castFilter)
                .sort(sort)
                .limit(limit)
                .skip(skip)
                .iterator()
                .forEachRemaining(movies::add);
        return movies;
    }

    /**
     * Finds all movies that match the provide `genres`, sorted descending by the `sortKey` field.
     *
     * @param sortKey - sorting key string.
     * @param limit   - number of documents to be returned.
     * @param skip    - number of documents to be skipped
     * @param genres  - genres matching string vargs.
     * @return List of matching Document objects.
     */
    public List<Document> getMoviesByGenre(String sortKey, int limit, int skip, String... genres) {
        // query filter
        Bson castFilter = Filters.in("genres", genres);
        // sort key
        Bson sort = Sorts.descending(sortKey);
        List<Document> movies = new ArrayList<>();
        // TODO > Ticket: Paging - implement the necessary cursor methods to support simple
        // pagination like skip and limit in the code below
        moviesCollection.find(castFilter).sort(sort).iterator()
        .forEachRemaining(movies::add);
        return movies;
    }

    private ArrayList<Integer> runtimeBoundaries() {
        ArrayList<Integer> runtimeBoundaries = new ArrayList<>();
        runtimeBoundaries.add(0);
        runtimeBoundaries.add(60);
        runtimeBoundaries.add(90);
        runtimeBoundaries.add(120);
        runtimeBoundaries.add(180);
        return runtimeBoundaries;
    }

    private ArrayList<Integer> ratingBoundaries() {
        ArrayList<Integer> ratingBoundaries = new ArrayList<>();
        ratingBoundaries.add(0);
        ratingBoundaries.add(50);
        ratingBoundaries.add(70);
        ratingBoundaries.add(90);
        ratingBoundaries.add(100);
        return ratingBoundaries;
    }

    /**
     * This method is the java implementation of the following mongo shell aggregation pipeline {
     * "$bucket": { "groupBy": "$runtime", "boundaries": [0, 60, 90, 120, 180], "default": "other",
     * "output": { "count": {"$sum": 1} } } }
     */
    private Bson buildRuntimeBucketStage() {

        BucketOptions bucketOptions = new BucketOptions();
        bucketOptions.defaultBucket("other");
        BsonField count = new BsonField("count", new Document("$sum", 1));
        bucketOptions.output(count);
        return Aggregates.bucket("$runtime", runtimeBoundaries(), bucketOptions);
    }

    /*
    This method is the java implementation of the following mongo shell aggregation pipeline
    {
     "$bucket": {
       "groupBy": "$metacritic",
       "boundaries": [0, 50, 70, 90, 100],
       "default": "other",
       "output": {
       "count": {"$sum": 1}
       }
      }
     }
     */
    private Bson buildRatingBucketStage() {
        BucketOptions bucketOptions = new BucketOptions();
        bucketOptions.defaultBucket("other");
        BsonField count = new BsonField("count", new Document("$sum", 1));
        bucketOptions.output(count);
        return Aggregates.bucket("$metacritic", ratingBoundaries(), bucketOptions);
    }

    /**
     * This method is the java implementation of the following mongo shell aggregation pipeline
     * pipeline.aggregate([ {$match: {cast: {$in: ... }}}, {$sort: {tomatoes.viewer.numReviews: -1}},
     * {$skip: ... }, {$limit: ... }, {$facet:{ runtime: {$bucket: ...}, rating: {$bucket: ...},
     * movies: {$addFields: ...}, }} ])
     */
    public List<Document> getMoviesCastFaceted(int limit, int skip, String... cast) {
        List<Document> movies = new ArrayList<>();
        String sortKey = "tomatoes.viewer.numReviews";
        Bson skipStage = Aggregates.skip(skip);
        Bson matchStage = Aggregates.match(Filters.in("cast", cast));
        Bson sortStage = Aggregates.sort(Sorts.descending(sortKey));
        Bson limitStage = Aggregates.limit(limit);
        Bson facetStage = buildFacetStage();
        // Using a LinkedList to ensure insertion order
        List<Bson> pipeline = new LinkedList<>();

        // TODO > Ticket: Faceted Search - build the aggregation pipeline by adding all stages in the
        // correct order
        // Your job is to order the stages correctly in the pipeline.
        // Starting with the `matchStage` add the remaining stages.
        pipeline.add(matchStage);

        moviesCollection.aggregate(pipeline).iterator().forEachRemaining(movies::add);
        return movies;
    }

    /**
     * This method is the java implementation of the following mongo shell aggregation pipeline
     * pipeline.aggregate([ ..., {$facet:{ runtime: {$bucket: ...}, rating: {$bucket: ...}, movies:
     * {$addFields: ...}, }} ])
     *
     * @return Bson defining the $facet stage.
     */
    private Bson buildFacetStage() {

        return Aggregates.facet(
                new Facet("runtime", buildRuntimeBucketStage()),
                new Facet("rating", buildRatingBucketStage()),
                new Facet("movies", Aggregates.addFields(new Field("title", "$title"))));
    }

    /**
     * Counts the total amount of documents in the `movies` collection
     *
     * @return number of documents in the movies collection.
     */
    public long getMoviesCount() {
        return this.moviesCollection.countDocuments();
    }

    /**
     * Counts the number of documents matched by this text query
     *
     * @param keywords - set of keywords that match the query
     * @return number of matching documents.
     */
    public long getTextSearchCount(String keywords) {
        return this.moviesCollection.countDocuments(Filters.text(keywords));
    }

    /**
     * Counts the number of documents matched by this cast elements
     *
     * @param cast - cast string vargs.
     * @return number of matching documents.
     */
    public long getCastSearchCount(String... cast) {
        return this.moviesCollection.countDocuments(Filters.in("cast", cast));
    }

    /**
     * Counts the number of documents match genres filter.
     *
     * @param genres - genres string vargs.
     * @return number of matching documents.
     */
    public long getGenresSearchCount(String... genres) {
        return this.moviesCollection.countDocuments(Filters.in("genres", genres));
    }
    
    public List<Document> getMoviesByCastAndTitle(List<String> casts, List<String> titles) {
    	ArrayList<Document> results = new ArrayList<>();

    	/*
    	 * GET MOVIES BY TITLE AND CAST
    	 */
    	
    	// try 1
//    	Bson castsFilterQuery = Filters.eq("cast", casts);
//		Bson titlesFilterQuery = Filters.text("title", titles);
//		moviesCollection.find(Filters.and(
//				castsFilterQuery , titlesFilterQuery)).sort(Sorts.descending("year")).limit(10).projection(Projections.include("plot", "cast", "title", "year", "imdb")).into(results);
		
    	// try 2 
//		String cast = String.join(" ", casts);
//		String title = String.join(" ", titles);
//		Bson textFilter = Filters.text( "\"" + cast + "\""  + " " + title);
//		moviesCollection.find(textFilter).sort(Sorts.descending("year")).limit(10).projection(Projections.include("cast", "title", "year")).into(results);
		
		//return results;
		
		// ** Get all the movies containing 'Knight' keyword and then filter on cast 'Christian Bale'
		// ** Get Top 5 movies for each genre ["Horro", "Scifi", "Drama"]
    	List<Bson> pipeline = new ArrayList<Bson>();
    	pipeline.add(unwind("$genres", new UnwindOptions().preserveNullAndEmptyArrays(false)));
    	pipeline.add(match(in("genres","Animation", "Mystery")));
    	pipeline.add(project(fields(include("title", "genres"), computed("rating", "$imdb.rating"))));
    	pipeline.add(group("$genres", push("movies","$$ROOT")));
    	
    	pipeline.add(addFields(new Field("avgRating", "abasabdabba")));
    	
    	//pipeline.add(project(slice("movies", 3)));
    	pipeline.add(new Document("$project", new Document("movies", new Document("$slice", Arrays.asList("$movies", 3L)))));
    	
		Arrays.asList(
				new Document("$unwind", new Document("path", "$genres").append("includeArrayIndex", "arrayindex").append("preserveNullAndEmptyArrays", true)), 
			    new Document("$match", new Document("$expr", new Document("$in", Arrays.asList("$genres", Arrays.asList("Animation", "Mystery"))))), 
			    new Document("$project", new Document("_id", 0L).append("title", 1L).append("genres", 1L).append("year", 1L).append("rating", "$imdb.rating")), 
			    new Document("$group", new Document("_id", "$genres").append("movies", new Document("$push", "$$ROOT"))), 
			    new Document("$sort", new Document("movies.rating", 1L)), 
			    new Document("$addFields", new Document("avgRating", new Document("$avg", "$movies.rating"))), 
			    new Document("$project", new Document("movies", new Document("$slice", Arrays.asList("$movies", 3L))))
		);
		
		moviesCollection.aggregate(pipeline).into(results);
		return results;
    }
    
    private void getAllGenres() {
    	Arrays.asList(new Document("$unwind", 
    		    new Document("path", "$genres")
    		            .append("includeArrayIndex", "string")
    		            .append("preserveNullAndEmptyArrays", true)), 
    		    new Document("$group", 
    		    new Document("_id", 
    		    new BsonNull())
    		            .append("all_genres", 
    		    new Document("$addToSet", "$genres"))));
    	
//    		0:"Adventure"
//    		1:"Mystery"
//    		2:"Romance"
//    		3:"Family"
//    		4:"Biography"
//    		5:"News"
//    		6:"History"
//    		7:"Horror"
//    		8:"Sport"
//    		9:"Thriller"
//    		10:"Animation"
//    		11:"Musical"
//    		12:"Sci-Fi"
//    		13:"Fantasy"
//    		14:"Talk-Show"
//    		15:"War"
//    		16:"Short"
//    		17:"Film-Noir"
//    		18:"Drama"
//    		19:"Action"
//    		20:"Western"
//    		21:"Crime"
//    		22:"Music"
//    		23:"Comedy"
//    		24:"Documentary"
    }
    
    public void getAllCollectionCount() {
//    	{
//    	    $group: {
//    	       _id: null,
//    	       count: { $count: { } }
//    	    }
//    	  }
    }
}
