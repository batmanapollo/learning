import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
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

    public void put(String key, T value)
    {
        for (int i = 0; i < size; i++) {
            if (slots[i].equals(key) || slots[i] == null) {
                slots[i] = key;
                values[i] = value;
            }
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
