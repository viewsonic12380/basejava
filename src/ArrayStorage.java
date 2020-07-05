/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int current_index_of_null_cell = 0;
    private int size = 0;

    public void clear() {
        if (storage.length != 0) {
            for (int i = 0; i < size; i++)
                storage[i] = null;
        }
        current_index_of_null_cell = 0;
        size = 0;
    }

    public void save(Resume r) {
        storage[current_index_of_null_cell] = r;
        current_index_of_null_cell++;
        size++;
    }

    public Resume get(String uuid) {
//        ArrayList a;
        if (storage.length != 0) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].uuid)) {
                    return storage[i];
                }
            }
            return null;
        } else
            return null;
    }

    public void delete(String uuid) {
        if (storage.length != 0) {
            int i = 0;
            while (i < size) {
                if (storage[i].uuid.equals(uuid)) {
                    storage[i]=storage[size-1];
                    storage[size-1]=null;
                    size--;
                }
                i++;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        if (storage.length != 0) {
            Resume[] part_of_storage = new Resume[size];
            System.arraycopy(storage, 0, part_of_storage, 0, size);
            return part_of_storage;
        } else
            return new Resume[0];
    }

    public int size() {
        return size;
    }
}
