import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        size = 0;
        Arrays.fill(storage, null);
    }

    void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("ERROR: " + r.getUuid() + " резюме не существует.");
        } else {
            storage[index] = r;
        }
    }

    void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("ERROR: " + r.getUuid() + " резюме уже существует.");
        } else if (size == storage.length) {
            System.out.println("ERROR: Storage overflow.");
        } else {
            storage[size] = r;
            size++;
        }
    }

    Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR: " + uuid + " резюме не найдено в хранилище.");
            return null;
        }
        return storage[index];
    }

    void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR: " + uuid + " резюме не найдено в хранилище.");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }


        /*int target = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].toString().equals(uuid)) {
                storage[i] = null;
                size--;
                target = i;
                break;
            }
        }
        Resume[] result = Arrays.copyOfRange(storage, target + 1, storage.length);
        System.arraycopy(result, 0, storage, target, result.length);
        storage[storage.length - 1] = null;*/

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
