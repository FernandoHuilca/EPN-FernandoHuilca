import java.util.HashMap;
import java.util.Map;

public class DirectMappingCache {
    private static final int CACHE_SIZE = 8;
    private static final int BLOCK_SIZE = 4;

    private CacheLine[] cache;
    private Map<Integer, Integer> mainMemory;

    public DirectMappingCache() {
        cache = new CacheLine[CACHE_SIZE];
        for (int i = 0; i < CACHE_SIZE; i++) {
            cache[i] = new CacheLine();
        }

        mainMemory = new HashMap<>();
        for (int i = 0; i < 64; i++) {
            mainMemory.put(i, i * 10); // Just filling the main memory with some values
        }
    }

    public void accessMemory(int address) {
        int index = (address / BLOCK_SIZE) % CACHE_SIZE;
        int tag = address / (BLOCK_SIZE * CACHE_SIZE);

        CacheLine line = cache[index];

        if (line.valid && line.tag == tag) {
            System.out.println("Cache hit! Address: " + address + " Data: " + line.data);
        } else {
            System.out.println("Cache miss! Loading data from main memory.");
            line.valid = true;
            line.tag = tag;
            line.data = mainMemory.get(address);
            System.out.println("Address: " + address + " Data: " + line.data);
        }
    }
}