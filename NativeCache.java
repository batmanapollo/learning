import java.lang.reflect.Array;
import java.util.function.Predicate;

class NativeCache<T>
{
    public int size;
    public int step;
    public String [] slots;
    public T [] values;
    public int [] hits;

    public NativeCache(int sz, int stp, Class clazz)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        hits = new int[size];
        for (int i = 0; i < size; i++) hits[i] = 0;
    }

    public int hashFun(String key)
    {
        return key.getBytes().length % size;
    }

    public void put(String key, T value)
    {
        var slot = seekSlot(key);
        slots[slot] = key;
        values[slot] = value;
        if (slots[slot] != null) {
            hits[slot] = 0;
        }
    }

    public boolean isKey(String key)
    {
        int slot = seekSlot(key, i -> slots[i].equals(key));
        return slot >= 0;
    }

    public T get(String key)
    {
        int slot = seekSlot(key, i -> key.equals(slots[i]));
        if (slot >= 0) {
            hits[slot]++;
            return values[slot];
        }
        return null;
    }

    private int seekSlot(String key) {
        int slot = seekSlot(key, i -> key.equals(slots[i]) || slots[i] == null);
        if (slot >= 0) {
            return slot;
        }
        int slotWithMinHits = findSlotWithMinHits();
        return seekSlot(key, i -> hits[i] == slotWithMinHits);
    }

    private int findSlotWithMinHits() {
        int min = hits[0];
        for (int i = 1; i < size; i++) {
            if (hits[i] < min) {
                min = hits[i];
            }
        }
        return min;
    }

    private int seekSlot(String key, Predicate<Integer> indexPredicate) {
        int count = 0;
        for (int i = hashFun(key); count < size;) {
            if (indexPredicate.test(i)) {
                return i;
            }

            i = i + step;
            if (i >= size) i = i - size;
            count++;
        }

        return -1;
    }

}
