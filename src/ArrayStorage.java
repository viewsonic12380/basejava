import java.util.ArrayList;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int current_index_of_null_cell = 0;
    int size = 0;

    void clear() {
        if (storage.length != 0) {
            for (int i = 0; i < size; i++)
                storage[i] = null;
        }
        current_index_of_null_cell = 0;
        size = 0;
    }

    void save(Resume r) {
        storage[current_index_of_null_cell] = r;
        current_index_of_null_cell++;
        size++;
    }

    Resume get(String uuid) {
//        ArrayList a;
        int index = -1;
        if (storage.length != 0) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].uuid)) {
                    index = i;
                    break;
                }
            }
            if (index != -1)
                return storage[index];
            else
                return new Resume();
        } else
            return new Resume();
    }

    void delete(String uuid) {
        int index = -1;
        if (storage.length != 0) {
            int i = 0;
            while (i < size) {
                if (storage[i].uuid.equals(uuid)) {
                    index = i;
                    break;
                }
                i++;
            }
            if (index != -1) {
                storage[index] = null;
                Resume[] new_storage = removeNull(storage);
                storage = new_storage;
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if (storage.length != 0) {
            Resume[] part_of_storage = new Resume[size];
            System.arraycopy(storage, 0, part_of_storage, 0, size);
            return part_of_storage;
        } else
            return new Resume[0];
    }

    int size() {
        return size;
    }

    public Resume[] removeNull(Resume[] a) {
        List<Resume> removedNull = new ArrayList<>();
        for (Resume r : a) {
            if (r != null)
                removedNull.add(r);
        }
        return removedNull.toArray(new Resume[0]);
    }
}
