package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Iterator;

public class ListStorage extends AbstractStorage {

    ArrayList<Resume> resumes = new ArrayList<>(AbstractStorage.STORAGE_LIMIT);

    @Override
    public int size() {
        return resumes.size();
    }

    @Override
    public void clear() {
        resumes.clear();
        size = 0;
    }

    @Override
    public void update(Resume r) {
        checkForNotExist(r.getUuid());
        doUpdate(r);
    }

    @Override
    public void save(Resume r) {
        checkForExist(r);
        resumes.add(r);
        size++;
    }

    @Override
    public void delete(String uuid) {
        int index = checkForNotExist(uuid);
        resumes.remove(index);
        size--;
    }

    @Override
    public Resume get(String uuid) {
        int index = checkForNotExist(uuid);
        return resumes.get(index);
    }

    @Override
    public Resume[] getAll() {
        Resume[] result = new Resume[size];
        return resumes.toArray(result);
    }

    protected int getIndex(String uuid) {
        Iterator<Resume> iterator = resumes.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            Resume result = iterator.next();
            if (uuid.equals(result.getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void doUpdate(Resume r) {
        resumes.set(getIndex(r.getUuid()), r);
    }
}
