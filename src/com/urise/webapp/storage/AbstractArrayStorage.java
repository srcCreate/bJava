package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        checkForNotExist(r.getUuid());
        doUpdate(r);
    }

    public void save(Resume r) {
        int index = checkForExist(r);
        insertElement(r, index);
        size++;
    }

    public void delete(String uuid) {
        int index = checkForNotExist(uuid);
        fillDeletedElement(index);
        storage[size - 1] = null;
        size--;
    }

    public Resume get(String uuid) {
        int index = checkForNotExist(uuid);
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract void insertElement(Resume r, int index);

    protected abstract void fillDeletedElement(int index);

    protected abstract int getIndex(String uuid);

    @Override
    protected void doUpdate(Resume r) {
        storage[getIndex(r.getUuid())] = r;
    }
}
