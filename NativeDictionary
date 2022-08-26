import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public int step = 3;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    {
        return key.getBytes().length % size;
    }

    public boolean isKey(String key)
    {
        int index = getIndex(key);
        return index >= 0;
    }

    public int seekSlot(String key)
    {
        int count = 0;
        for (int i = hashFun(key); count < size;) {
            if (slots[i] == null) {
                return i;
            }

            i = i + step;
            if (i >= size) i = i - size;
            count++;
        }

        return -1;
    }

    public void put(String key, T value)
    {
        var slot = seekSlot(key);
        if (slot >= 0) {
            slots[slot] = key;
            values[slot] = value;
        }
    }

    public T get(String key)
    {
        int index = getIndex(key);
        if (index >= 0) {
            return values[index];
        }
        return null;
    }
    
    private int getIndex(String key) {
        for (int i = 0; i < size; i++) {
            if (slots[i] == key) {
                return i;
            }
        }
        return -1;
    }

}
