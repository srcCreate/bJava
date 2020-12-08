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

    private boolean isExist(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                return true;
            }
        }
        return false;
    }

    private boolean isExist(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    void update(Resume r) {
        if (isExist(r)) {
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(r.uuid)) {
                    storage[i] = r;
                }
            }
        } else System.out.println("ERROR: " + r.uuid + " резюме не найдено в хранилище.");
    }

    void save(Resume r) {
        if (size == 0 || !isExist(r)) {
            for (int i = 0; i < storage.length; i++) {
                if (storage[i] == null) {
                    storage[i] = r;
                    size++;
                    break;
                }
            }
        } else System.out.println("ERROR: " + r.uuid + " резюме уже существует.");
    }

    Resume get(String uuid) {
        if (isExist(uuid)) {
            for (int i = 0; i < size; i++) {
                if (storage[i].toString().equals(uuid)) {
                    return storage[i];
                }
            }
        } else System.out.println("ERROR: " + uuid + " резюме не найдено в хранилище.");
        return null;
    }

    void delete(String uuid) {
        if (isExist(uuid)) {
            for (int i = 0; i < size; i++) {
                if (storage[i].toString().equals(uuid)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                }
            }
        } else System.out.println("ERROR: " + uuid + " резюме не найдено в хранилище.");

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
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
