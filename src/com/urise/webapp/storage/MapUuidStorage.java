package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {
    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, String uuid) {
        mapResume.put(uuid, r);
    }

    @Override
    protected boolean isExist(String uuid) {
        return mapResume.containsKey(uuid);
    }

    @Override
    protected void doSave(Resume r, String uuid) {
        mapResume.put(uuid, r);
    }

    @Override
    protected Resume doGet(String uuid) {
        return mapResume.get(uuid);
    }

    @Override
    protected void doDelete(String uuid) {
        mapResume.remove(uuid);
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
