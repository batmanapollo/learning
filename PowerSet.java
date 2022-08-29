public class PowerSet
{

    public int slotsSize;
    public final int step = 13;
    public String [] slots;
    public int size;

    public PowerSet()
    {
        slotsSize = 20000;
        slots = new String[slotsSize];
        for(int i=0; i<slotsSize; i++) slots[i] = null;
        size = 0;
    }

    public PowerSet(int slotsSize) {
        this.slotsSize = slotsSize;
        slots = new String[slotsSize];
        for(int i=0; i<slotsSize; i++) slots[i] = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public int hashFun(String value)
    {
        return value.getBytes().length % slotsSize;
    }

    public int seekSlot(String value)
    {
        int count = 0;
        for (int i = hashFun(value); count < slotsSize;) {
            if (slots[i] == null || slots[i].equals(value)) {
                return i;
            }

            i = i + step;
            if (i >= slotsSize) i = i - slotsSize;
            count++;
        }

        return -1;
    }

    public void put(String value)
    {
        int slot = seekSlot(value);
        if (slot >= 0 && slots[slot] == null) {
            slots[slot] = value;
            size++;
        }
    }

    public boolean get(String value)
    {
        int slot = seekSlot(value);
        return slot >= 0 &&  slots[slot] != null;
    }

    public boolean remove(String value)
    {
        int slot = seekSlot(value);
        if (slot >= 0 && slots[slot] != null) {
            slots[slot] = null;
            size--;
            return true;
        }
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        var r = new PowerSet();
        for (int i = 0; i < slotsSize; i++) {
            var value = slots[i];
            if (value != null && set2.get(value)) r.put(value);
        }
        return r;
    }

    public PowerSet union(PowerSet set2)
    {
        var r = new PowerSet(this.slots.length + set2.slots.length);
        for (int i = 0; i < slotsSize; i++) {
            var value = slots[i];
            if (value != null) {
                r.put(value);
            }
        }
        for (int i = 0; i < set2.slotsSize; i++) {
            var value = set2.slots[i];
            if (value != null) {
                r.put(value);
            }
        }
        return r;
    }

    public PowerSet difference(PowerSet set2)
    {
        var r = new PowerSet();
        for (int i = 0; i < slotsSize; i++) {
            var value = slots[i];
            if (value != null && !set2.get(value)) r.put(value);
        }
        return r;
    }

    public boolean isSubset(PowerSet set2)
    {
        for (int i = 0; i < set2.slotsSize; i++) {
            var value = set2.slots[i];
            if (value != null && !get(value)) return false;
        }
        return true;
    }
}
