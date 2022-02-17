package com.dudi.ppmtool.daos;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dudi.ppmtool.entity.Project;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;

@Component
public class ProjectDao extends AbstractPPMToolDao {

	public static String PROJECT_COLLECTION = "projects";

	private MongoCollection<Project> projectCollection;
	
	private CodecRegistry pojoCodecRegistry;

	@Autowired
	protected ProjectDao(MongoClient mongoClient, @Value("${spring.mongodb.database}") String databaseName) {
		super(mongoClient, databaseName);
		this.pojoCodecRegistry =
                fromRegistries(
                        MongoClientSettings.getDefaultCodecRegistry(),
                        fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        this.projectCollection =
                db.getCollection(PROJECT_COLLECTION, Project.class).withCodecRegistry(pojoCodecRegistry);
	}

	public Project createProject(Project project) {
		projectCollection.insertOne(project);
		
//		Bson filter = eq("_id", project.getId());
//		ReplaceOptions options = new ReplaceOptions().upsert(true);
//		UpdateResult replaceOne = projectCollection.replaceOne(filter, project, options);
		
		return project;
	}

	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();
		 FindIterable<Project> findProjects = projectCollection.find();
		 return findProjects.into(projects);
	}
	
	public Project getProject(String id) {
		Project project = projectCollection.find(new Document("projectIdentifier", id)).first();
		return project;
	}
	
	public Project updateProject(Project project) {
		Bson filter = eq("projectIdentifier", project.getProjectIdentifier());
		FindOneAndUpdateOptions optionAfter = new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER);
		Project newVersion = projectCollection.findOneAndReplace(filter, project);
		
		return newVersion;

	}

}
