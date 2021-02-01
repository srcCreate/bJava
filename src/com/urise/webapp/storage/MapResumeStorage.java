package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {
    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return mapResume.get(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {
        mapResume.put(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
    }

    @Override
    protected void doSave(Resume r, Resume resume) {
        mapResume.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Resume resume) {
        return resume;
    }

    @Override
    protected void doDelete(Resume resume) {
        mapResume.remove(resume.getUuid());
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
