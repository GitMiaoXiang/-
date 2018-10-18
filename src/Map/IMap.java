package Map;

/**
 * @Author:上官名鹏
 * @Description:
 * @Date:Create in 2018/10/14 15:57
 * Modified By:
 */
public interface IMap<K, V>{

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V vallue);

    int getSize();

    boolean isEmpty();

}
