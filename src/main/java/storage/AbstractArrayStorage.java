package storage;

import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0)
            System.out.println("Resume " + r.getUuid() + " is not found");
        else
            storage[index] = r;
    }

    /**
     * @return array, contains only Resumes in main.java.storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0)
            System.out.println("Resume " + r.getUuid() + " is in main.java.storage.");
        else if (size == STORAGE_LIMIT)
            System.out.println("Resume " + r.getUuid() + " is not saved. Array is full.");
        else {
            insertElement(r, index);
            size++;
        }
    }

    protected abstract void insertElement(Resume r, int index);

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0)
            System.out.println("Resume " + uuid + "is not found");
        else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    protected abstract void fillDeletedElement(int index);

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " is not found");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);
}
