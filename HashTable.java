public class HashTable
{
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        return value.getBytes().length % size;
    }

    public int seekSlot(String value)
    {
        int count = 0;
        for (int i = hashFun(value); count < size;) {
            if (slots[i] == null) {
                return i;
            }

            i = i + step;
            if (i >= size) i = i - size;
            count++;
        }

        return -1;
    }

    public int put(String value)
    {
        var slot = seekSlot(value);
        if (slot >= 0) {
            slots[slot] = value;
            return slot;
        }
        return -1;
    }

    public int find(String value)
    {
        for(int i=0; i<size; i++) {
            if (slots[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
