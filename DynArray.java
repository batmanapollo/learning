public class DynArray<T>
{

    private static final int MIN_CAPACITY = 2;
    private static final int MIN_FULLNESS_PERCENTAGE = 50;

    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(MIN_CAPACITY);
    }

    public void makeArray(int new_capacity)
    {
        var tmp = (T[]) Array.newInstance(this.clazz, new_capacity);
        if (array != null) {
            for (int i = 0; i < count; i++) {
                tmp[i] = array[i];
            }
        }
        array = tmp;
        capacity = new_capacity;
    }

    public T getItem(int index)
    {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void append(T itm)
    {
        if (count == capacity) {
            var newCapacity = capacity * 2;
            makeArray(newCapacity);
        }

        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index)
    {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count) {
            append(itm);
            return;
        }
        if (count == capacity) {
            var newCapacity = capacity * 2;
            makeArray(newCapacity);
        }
        for (int i = count + 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = itm;
        count++;
    }

    public void remove(int index)
    {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        array[count - 1] = null;

        count--;

        if (count >= MIN_CAPACITY && (double) capacity / count > (100 / MIN_FULLNESS_PERCENTAGE)) {
            var newCapacity = capacity / 1.5;
            makeArray((int) newCapacity);
        }
    }

}
