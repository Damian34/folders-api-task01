package com.demo.folders;

import java.util.List;

interface MultiFolder extends Folder {
    /**
     * ok, since the method returns folders in bulk,
     * then why we need to implement methods from Folder class??
     * it hardly looks like polymorphism,
     * in my opinion easier gonna be flatMap it with recurrence
     *
     * looks here:
     * getName() -> I could do e.g.:
     * folders.stream().map(Folder::getName).collect(Collectors.joining(","));
     * but such name would be pointless since the class looks like package
     *
     * getSize() -> since it have enum like values
     * then how could I determine size of the bulk?
     * in number size case I would summarize folder sizes,
     * but here eventually I could only return highes enum value "in meaning"
     *
     * in conclusion since the MultiFolder class it package then I would simply ignore
     * implementing getName(), getSize() and just use getFolders()
     *
     * I am aware that not implementing them violates the Liskov Substitution Principle,
     * however implementing them is also wrong, since won't use them.
     *
     * The only value of "MultiFolder extends Folder" is possibility to create
     * tree of the Folder objects
     * And yes normal OS folders and files also have tree like structure
     *
     * but here we lack some elements:
     * - interfaces like File besides Folder
     * - getSize() - return String that is difficult to match withing MultiFolder
     * - MultiFolder - at begin I wanted to threat it like Folder of Folders,
     * like normally in OS, but getSize() won't let me
     * - getName() - if MultiFolder was more like Folder of Folders, then here I could set parent name
     * - here is one more thing if I could add File interface then
     * File & Folder should have common parent interface with getSize(), getName() methods
     * or simply create 1 interface distinguished by e.g. single method
     *
     * @return folders
     */
    List<Folder> getFolders();
}
