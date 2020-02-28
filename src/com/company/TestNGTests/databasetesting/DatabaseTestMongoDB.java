package databasetesting;

import org.bson.Document;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

// Instalattion process that I used - https://www.freecodecamp.org/news/learn-mongodb-a4ce205e7739/
public class DatabaseTestMongoDB {

    MongoClient mongoClient = null;
    MongoDatabase db = null;

    @BeforeClass
    public void beforeClass() {
        try {
            // STEP 1: Connect to database
            mongoClient = new MongoClient("localhost", 27017);
            db = mongoClient.getDatabase("users");
            System.out.println("Connect to database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @Test
    public void test() throws Exception {
        try {
            // STEP 2: Get Collection
            MongoCollection<Document> table = db.getCollection("myCollection");
            // STEP 3: Extract Data
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("name", "julia");
            FindIterable<Document> cursor = table.find(searchQuery);

            // STEP 4: Iterate over data
            for (Document obj : cursor) {
                String location = obj.getString("location");
                System.out.println(location);
                System.out.println("*************************");
                System.out.println(obj.toString());

            // We can use this if we have the data from de UI to validate against the data of the DB
                Assert.assertEquals("", "");
            }

        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
    }
}
