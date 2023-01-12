import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    public boolean userAdd(String username,String password,String fullName,String email){
        //Initializing the connection with MongoDB
        try {
            //Initializing the client details
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            //Creating a new Database
            MongoDatabase database = mongoClient.getDatabase("CV_Generating_System");

            //Hiding the mongodb logger details
            Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
            mongoLogger.setLevel(Level.SEVERE);

            //Creating a new collection for seats
            MongoCollection collectionNew = database.getCollection("Users");
            Document userDetails = new Document("Username",username);
            userDetails.append("Password",password);
            userDetails.append("FullName",fullName);
            userDetails.append("Email",email);
            collectionNew.insertOne(userDetails);
            Functions.confirmAlert("Data Saved Successfully");
            return true;
        }catch (Exception e){
            Functions.errorAlert("Data Saving Error!!");
            return false;
        }
    }

    public String getFullNameByUsernamePswd(String username,String password){
        try{
            //Connection details
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            //Selecting the database
            MongoDatabase database = mongoClient.getDatabase("CV_Generating_System");

            //Creating the collection
            MongoCollection collection = database.getCollection("Users");

            //Disabling the connection log messages
            Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
            Logger mongoCom = Logger.getLogger("com.mongodb");
            mongoCom.setLevel(Level.OFF);
            mongoLogger.setLevel(Level.OFF);

            //Creating a cursor to get document data from database
            MongoCursor<Document> cursor = collection.find().iterator();
            for (;;) {
                //line by line will be retrieve to doc
                Document doc = cursor.next();
                String checkUsername = doc.getString("Username");
                String checkPassword = doc.getString("Password");
                if (username.equals(checkUsername) && password.equals(checkPassword)){
                    return checkPassword;
                }
            }
        }catch (Exception e){
            return "";
        }
    }

    public boolean addUserDetails(String[] userArr){
        //Initializing the connection with MongoDB
        try {
            //Initializing the client details
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            //Creating a new Database
            MongoDatabase database = mongoClient.getDatabase("CV_Generating_System");

            //Hiding the mongodb logger details
            Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
            mongoLogger.setLevel(Level.SEVERE);

            //Creating a new collection for seats
            MongoCollection collectionNew = database.getCollection("User_Details");
            Document userDetails = new Document("Username",userArr[0]);
            userDetails.append("fullName",userArr[2]);
            userDetails.append("about",userArr[3]);
            userDetails.append("workXp ",userArr[4] );
            userDetails.append("education",userArr[5]);
            userDetails.append("mobileNo",userArr[6]);
            userDetails.append("email",userArr[7]);
            userDetails.append("area",userArr[8]);
            userDetails.append("linkedln",userArr[9]);
            userDetails.append("skill1",userArr[10]);
            userDetails.append("skill2",userArr[11]);
            userDetails.append("skill3",userArr[12]);
            userDetails.append("lang1",userArr[13]);
            userDetails.append("lang2",userArr[14]);
            userDetails.append("lang3",userArr[15]);
            userDetails.append("hobby1",userArr[16]);
            userDetails.append("hobby2",userArr[17]);
            userDetails.append("hobby3",userArr[18]);

            collectionNew.insertOne(userDetails);
            Functions.confirmAlert("Data Saved Successfully");
            return true;
        }catch (Exception e){
            Functions.errorAlert("Data Saving Error!!");
            return false;
        }
    }
    public void loadUserData(String username){
        try{
            //Connection details
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            //Selecting the database
            MongoDatabase database = mongoClient.getDatabase("CV_Generating_System");

            //Creating the collection
            MongoCollection collection = database.getCollection("User_Details");

            //Disabling the connection log messages
            Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
            Logger mongoCom = Logger.getLogger("com.mongodb");
            mongoCom.setLevel(Level.OFF);
            mongoLogger.setLevel(Level.OFF);

            //Creating a cursor to get document data from database
            MongoCursor<Document> cursor = collection.find().iterator();
            for (;;) {
                //line by line will be retrieve to doc
                Document doc = cursor.next();
                String checkUsername = doc.getString("Username");
                if (username.equals(checkUsername)){
                    String checkval = doc.getString("workXp");
                    User.setAllUserDetails(doc.getString("fullName"),doc.getString("about"),doc.getString("workXp "),doc.getString("education"),doc.getString("mobileNo")
                            ,doc.getString("email"),doc.getString("area"),doc.getString("linkedln"),doc.getString("skill1"),doc.getString("skill2")
                            ,doc.getString("skill3"),doc.getString("lang1"),doc.getString("lang2"),doc.getString("lang3"),doc.getString("hobby1")
                            ,doc.getString("hobby2"),doc.getString("hobby3"));
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(e);
            //Functions.errorAlert("Data Loading Error!!!!");
        }
    }
}
