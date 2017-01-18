package anywheresoftware.mongo;

import org.bson.conversions.Bson;

import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map.MyMap;

@Hide
public class MongoUtils {
	public static List ListFromIterable(Iterable<?> it) {
		List l1 = new List();
		l1.Initialize();
		for (Object s : it) {
			l1.Add(s);
		}
		return l1;
	}
	
	public static Bson MapToBson(MyMap map) {
		if (map == null)
			return null;
		return new MapCodec.MyMapBson(map);
	}
	
}
