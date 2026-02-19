package com.demo.folders;

/**
 * In conclusion to me, wrapping operating system folders into this interface is not practical,
 * then the interface is not directly usable.
 *
 * OR the domain of the task isn't OS folders,
 * but something different e.g. physical folders in an office??
 * I lack more information about the exact context.
 */
interface Folder {
    /**
     * normally in the OS case I would return folder name or full path to OS folder
     * @return name
     */
    String getName();

    /**
     * according to task, here should be returned only strings: SMALL, MEDIUM, LARGE
     * it itself ask to use enum, however
     * I wouldn't like to change task requirement, so I only gonna validate string nd normalize
     *
     * on other hand mode logical here would be return size in number
     * I was thinking that I could implement logic to find Folder in operating system
     * and I could getName there, but how should I change bajts number into SMALL, MEDIUM, LARGE??
     * yes I can create method with switch or some classes with strategy pattern,
     * but I lack ranges for each value
     *
     * @return size
     */
    String getSize();
}
