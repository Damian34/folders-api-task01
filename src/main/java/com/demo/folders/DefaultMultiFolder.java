package com.demo.folders;

import java.util.Collections;
import java.util.List;

class DefaultMultiFolder implements MultiFolder {
    private final List<Folder> folders;

    DefaultMultiFolder(List<Folder> folders) {
        this.folders = folders == null ? Collections.emptyList(): folders;
    }

    @Override
    public List<Folder> getFolders() {
        return Collections.unmodifiableList(folders);
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("MultiFolder does not have a single name");
    }

    @Override
    public String getSize() {
        throw new UnsupportedOperationException("MultiFolder does not have a single size");
    }
}
