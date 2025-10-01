public class Editor {
    private EventManager events;

    public Editor() {
        this.events = new EventManager();
    }


    public void openFile(String ruta){
        events.notify("open", ruta);
    }
    public void saveFile(String ruta){
        events.notify("email", ruta);
    }

    public EventManager getEventManager() {
        return events;
    }
}
