public class BloomFilter
{
    public int filter_len;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
    }

    public int hash1(String str1)
    {
        return hash(str1, 17);
    }
    public int hash2(String str1)
    {
        return hash(str1, 223);
    }

    private int hash(String str, int salt) {
        int hash = 0;
        for(int i=0; i<str.length(); i++)
        {
            int code = (int)str.charAt(i);
            hash = hash * salt + code;
        }
        return hash % 32;
    }

    public void add(String str1)
    {
        var hash1 = hash1(str1);
        setOne(hash1);
        var hash2 = hash2(str1);
        setOne(hash2);
    }

    public boolean isValue(String str1)
    {
        var hash1 = hash1(str1);
        if (getBit(hash1) == 0) {
            return false;
        }
        var hash2 = hash2(str1);
        if (getBit(hash2) == 0) {
            return false;
        }

        return true;
    }

    private int getBit(int pos) {
        return filter_len >> pos & 1;
    }

    private void setOne(int pos) {
        filter_len = filter_len | 1 << pos;
    }
}
