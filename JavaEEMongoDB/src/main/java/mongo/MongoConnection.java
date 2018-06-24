package mongo;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import java.util.logging.Logger;
import java.util.logging.Level;
import static java.lang.String.format;


public class MongoConnection {

    private static Logger logger = Logger.getLogger(MongoConnection.class.getName());
    private static MongoConnection instance = new MongoConnection();

    private MongoClient mongo = null;
    private Datastore datastore = null;
    private Morphia morphia = null;

    private MongoConnection() {}

    public MongoClient getMongo() throws RuntimeException {
        if (mongo == null) {
            logger.info("Starting mongo");
            MongoClientOptions.Builder options = MongoClientOptions.builder()
                    .connectionsPerHost(4)
                    .maxConnectionIdleTime(60 * 1000)
                    .maxConnectionLifeTime(120 * 1000);

            MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017/test", options);

            logger.info("About to connect to MongoDB@" + uri.toString());

            try {
                mongo = new MongoClient(uri);
                mongo.setWriteConcern(WriteConcern.ACKNOWLEDGED);
            } catch (MongoException e) {
                logger.log(Level.SEVERE,"An error occoured when connecting to MongoDB", e);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "An error occoured when connecting to MongoDB", e);
            }

            mongo.setWriteConcern(WriteConcern.ACKNOWLEDGED);
        }

        return mongo;
    }

    public Morphia getMorphia() {
        if (morphia == null) {
            logger.info("Starting Morphia");
            morphia = new Morphia();

            logger.info(format("Mapping classes from package: %s", "models"));
            morphia.mapPackage("models");
        }

        return morphia;
    }

    public Datastore getDatastore() {
        if (datastore == null) {
            String dbName = "testdb";
            logger.info(format("Starting DataStore on DB: %s", dbName));
            datastore = getMorphia().createDatastore(getMongo(), dbName);
        }

        return datastore;
    }

    public void init() {
        logger.info("Bootstraping");
        getMongo();
        getMorphia();
        getDatastore();
    }

    public void close() {
        logger.info("Closing MongoDB connection");
        if (mongo != null) {
            try {
                mongo.close();
                logger.info("Nulling the connection dependency objects");
                mongo = null;
                morphia = null;
                datastore = null;
            } catch (Exception e) {
                logger.log(Level.SEVERE, format("An error occurred when closing the MongoDB connection\n%s", e.getMessage()));
            }
        } else {
            logger.warning("mongo object was null, wouldn't close connection");
        }
    }

    public static MongoConnection getInstance() {
        return instance;
    }
}
