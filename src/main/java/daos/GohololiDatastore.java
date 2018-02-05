package daos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.StructuredQuery.Filter;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;

public class GohololiDatastore {

	private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

	public String getShijuhatte(String name) {

		Query<Entity> query;

		if(name.equals("ランダム")){
			query = Query.newEntityQueryBuilder()
					.setKind("shijuhatte")
					.setLimit(20)
					.build();

			Iterator<Entity> a =datastore.run(query);
			List<String> random = new ArrayList<String>();
			a.forEachRemaining(disc ->{
				random.add(disc.getString("discription"));
			});


			Collections.shuffle(random);
			return random.get(0);

		}else{
			Filter filter = PropertyFilter.eq("name", name);

			query = Query.newEntityQueryBuilder()
						.setKind("shijuhatte")
						.setFilter(filter)
						.setLimit(20)
						.build();
			  Iterator<Entity> a =datastore.run(query);

			  if(!a.hasNext()){
				  return "あなたにはまだ早いわ、ごめんね";
			  }

			  return a.next().getString("discription");
		}
	}
}
