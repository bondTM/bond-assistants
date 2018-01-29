package daos;

import java.util.Iterator;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.StructuredQuery.OrderBy;

public class SutechanDatastore {

	DatastoreOptions data = DatastoreOptions.newBuilder().setProjectId("crafty-ring-191614").build();
	private final Datastore datastore = data.getService();
//	private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
	private final KeyFactory keyFactory = datastore.newKeyFactory().setKind("bots");

	public Key addTask(String description) {
		  Key key = datastore.allocateId(keyFactory.newKey());
		  Entity line = Entity.newBuilder(key)
		      .set("name", "すてちゃん")
		      .set("intent", "lines")
		      .set("input",description)
		      .set("createDatetime", Timestamp.now())
		      .build();
		  datastore.put(line);
		  return key;
		}


	public String listTasks() {
		  Query<Entity> query =
		      Query.newEntityQueryBuilder().setKind("bots")
		      .setOrderBy(OrderBy.desc("createDatetime"))
		      .setLimit(1)
		      .build();
		  Iterator<Entity> a =datastore.run(query);

		  return a.next().getString("input");
		}







}
