package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
//        if (storage.length != 0) {
//            for (int i = 0; i < size; i++)
//                storage[i] = null;
//        }
        Arrays.fill(storage,null);
        size = 0;
    }

    public void update(Resume r, String uuid) {
//        TODO if resume is not null
        int index = getIndex(r.getUuid());
        if (index == -1)
            System.out.println("Resume " + r.getUuid() + " is not found");
        else
            r.setUuid(uuid);
    }

    public void save(Resume r) {
//        TODO if resume is null
        int index = getIndex(r.getUuid());
        if (index == -1) {
            if (size < storage.length) {
                storage[size] = r;
                size++;
            } else
                System.out.println("Resume " + r.getUuid() + " is not saved. Array is full.");
        } else
            System.out.println("Resume " + r.getUuid() + " is in storage.");
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1)
            System.out.println("Resume " + uuid + " is not found");
        else
            return storage[index];
        return null;
    }


    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1)
            System.out.println("Resume " + uuid + "is not found");
        else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }

//            int i = 0;
//            while (i < size) {
//                if (storage[i].getUuid().equals(uuid)) {
//                    storage[i] = storage[size - 1];
//                    storage[size - 1] = null;
//                    size--;
//                }
//                i++;
//            }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
//        if (storage.length != 0) {
//            Resume[] part_of_storage = new Resume[size];
//            System.arraycopy(storage, 0, part_of_storage, 0, size);
//            return part_of_storage;
//        } else
//            return new Resume[0];

        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    protected int getIndex(String uuid) {
//        Resume searchKey=new Resume();
//        searchKey.setUuid(uuid);
//        return Arrays.binarySearch(storage,0,size,searchKey);

        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
