package storage;

import model.Resume;

public interface Storage {
    void clear();

    void update(Resume r);

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    /**
     * @return array, contains only Resumes in main.java.storage (without null)
     */
    Resume[] getAll();

    int size();


}
