package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {
    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, Object uuid) {
        mapResume.put((String) uuid, r);
    }

    @Override
    protected boolean isExist(Object uuid) {
        return mapResume.containsKey((String) uuid);
    }

    @Override
    protected void doSave(Resume r, Object uuid) {
        mapResume.put((String) uuid, r);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return mapResume.get((String) uuid);
    }

    @Override
    protected void doDelete(Object uuid) {
        mapResume.remove((String) uuid);
    }

    @Override
    public void clear() {
        mapResume.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(mapResume.values());
    }

    @Override
    public int size() {
        return mapResume.size();
    }
}
