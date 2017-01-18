package anywheresoftware.mongo;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.collections.Map.MyMap;

import com.mongodb.client.MongoDatabase;

/**
 * Provides access to a database.
 */
@ShortName("MongoDatabase")
public class MongoDatabaseWrapper extends AbsObjectWrapper<MongoDatabase>{
	/**
	 * Deletes the database.
	 */
	public void Drop() {
		getObject().drop();
	}
	/**
	 * Returns a MongoCollection. Creates the collection if it does not already exist.
	 */
	public MongoCollectionWrapper GetCollection(String CollectionName) {
		return (MongoCollectionWrapper)AbsObjectWrapper.ConvertToWrapper(new MongoCollectionWrapper(), getObject().getCollection(CollectionName, MyMap.class));
	}
	/**
	 * Gets the database name.
	 */
	public String getName() {
		return getObject().getName();
	}
	/**
	 * Lists the collections names.
	 */
	public List getCollectionNames() {
		return MongoUtils.ListFromIterable(getObject().listCollectionNames());
	}
	/**
	 * Runs a database command.
	 */
	public Map RunCommand(Map Command) {
		return (Map)AbsObjectWrapper.ConvertToWrapper(new Map(), getObject().runCommand(MongoUtils.MapToBson(Command.getObject()), MyMap.class));
	}
	
}
