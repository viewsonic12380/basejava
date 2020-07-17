package storage;

import exception.StorageException;
import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
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

    @Override
    protected void doUpdate(Resume r, Object index) {
        storage[(Integer)index]=r;
    }

    /**
     * @return array, contains only Resumes in main.java.storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected void doSave(Resume r, Object index) {
        if (size == STORAGE_LIMIT)
            throw new StorageException("Storage overflow", r.getUuid());
        else {
            insertElement(r, (Integer) index);
            size++;
        }
    }

    @Override
    protected void doDelete(Object index) {
        fillDeletedElement((Integer) index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Resume doGet(Object index) {
        return storage[(Integer) index];
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }


    protected abstract void fillDeletedElement(int index);
    protected abstract void insertElement(Resume r, int index);
    protected abstract Integer getSearchKey(String uuid);

//    protected abstract int getIndex(String uuid);

//    public void update(Resume r) {
//        int index = getIndex(r.getUuid());
//        if (index < 0)
//            throw new NonExistStorageException(r.getUuid());
//        else
//            storage[index] = r;
//    }
//
//
//    public void save(Resume r) {
//        int index = getIndex(r.getUuid());
//        if (index >= 0)
//            throw new ExistStorageException(r.getUuid());
//        else if (size == STORAGE_LIMIT)
//            throw new StorageException("Storage overflow", r.getUuid());
//        else {
//            insertElement(r, index);
//            size++;
//        }
//    }


//    public void delete(String uuid) {
//        int index = getIndex(uuid);
//        if (index < 0)
//            throw new NonExistStorageException(uuid);
//        else {
//            fillDeletedElement(index);
//            storage[size - 1] = null;
//            size--;
//        }
//    }

//
//    public Resume get(String uuid) {
//        int index = getIndex(uuid);
//        if (index < 0) {
//            throw new NonExistStorageException(uuid);
//        }
//        return storage[index];
//    }
//
//    @Override
//    protected Object getSearchKey(String uuid) {
//        return null;
//    }
}
