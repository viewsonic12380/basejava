package storage;

import model.Resume;

import java.util.List;

public class ListStorage extends AbstractStorage{
    private List<Resume> resumeList;

    public ListStorage(List<Resume> resumeList) {
        this.resumeList = resumeList;
    }

    @Override
    public void clear() {
//        resumeList.removeAll();
    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public void save(Resume r) {
        resumeList.add(r);
    }

    @Override
    public void delete(String uuid) {
        resumeList.remove(get(uuid));
    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) resumeList.toArray();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Resume get(String uuid) {
        for (Resume r:resumeList) {
            if (r.getUuid().equals(uuid))
                return r;
        }
        return null;
    }
}
