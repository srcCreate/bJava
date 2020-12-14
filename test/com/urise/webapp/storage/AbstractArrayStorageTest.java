package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {
    private final Storage storage;

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid_1";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final String UUID_2 = "uuid_2";
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final String UUID_3 = "uuid_3";
    private static final Resume RESUME_3 = new Resume(UUID_3);

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test(expected = StorageException.class)
    public void storageOverflow() {
        for (int i = storage.size(); i < 10000; i++) {
            storage.save(new Resume());
        }
        storage.save(new Resume());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        Resume resume = storage.get("uuid_3");
        Assert.assertEquals(resume, storage.get("uuid_3"));
    }

    @Test
    public void save() {
        Resume resume = new Resume("uuid_4");
        storage.save(resume);
        Assert.assertEquals(resume, storage.get("uuid_4"));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete("uuid_2");
        Assert.assertEquals(storage.get("uuid_2"), storage.get("uuid_2"));
    }

    @Test
    public void get() {
        Assert.assertEquals(storage.get("uuid_2"), storage.get("uuid_2"));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void getAll() {
        Resume[] resumes = storage.getAll();
        Assert.assertEquals(3, resumes.length);
        Assert.assertEquals(RESUME_1, resumes[0]);
        Assert.assertEquals(RESUME_2, resumes[1]);
        Assert.assertEquals(RESUME_3, resumes[2]);
    }
}