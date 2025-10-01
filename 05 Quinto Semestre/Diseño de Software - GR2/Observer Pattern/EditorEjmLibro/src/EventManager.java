
import java.util.HashMap;

public class EventManager {
    private HashMap<String,Listener> listenersHashMap;
    public EventManager() {
    this.listenersHashMap = new HashMap<>();
    }
    public void suscribe(String typeEvent, Listener listener) {
        listenersHashMap.put(typeEvent, listener);
    }
    public void unsubscribe(String typeEvent, Listener listener) {
        listenersHashMap.remove(typeEvent, listener);
    }
    public void notify(String typeEvent, String data) {
        listenersHashMap.get(typeEvent).update(data);
    }
}
