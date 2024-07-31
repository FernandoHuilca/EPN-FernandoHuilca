// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        DirectMappingCache cacheSimulator = new DirectMappingCache();

        cacheSimulator.accessMemory(14);
        cacheSimulator.accessMemory(15);
        cacheSimulator.accessMemory(22);
        cacheSimulator.accessMemory(15);
        cacheSimulator.accessMemory(14); // This should be a hit


    }
}